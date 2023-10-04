package beatbox;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BeatBox {
    private ArrayList<JCheckBox> checkBoxList;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;

    public static void main(String[] args) {
        new BeatBox().build();
    }

    String[] instrumentNames = { "Bass Drum", "Closed Hi-Hat",
            "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
            "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
            "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
            "Open Hi Conga" };
    int[] instruments = { 35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63 };

    private void build() {
        JFrame frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("start");
        start.addActionListener(e -> buildTrackAndStart());
        buttonBox.add(start);

        JButton stop = new JButton("stop");
        stop.addActionListener(e -> sequencer.stop());
        buttonBox.add(stop);

        JButton upTempo = new JButton("upTempo");
        upTempo.addActionListener(e -> changeTempo(1.03f));
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("downTempo");
        downTempo.addActionListener(e -> changeTempo(0.97f));
        buttonBox.add(downTempo);

        JButton serializelt = new JButton("serializelt");
        serializelt.addActionListener(e -> writeFile());
        buttonBox.add(serializelt);

        JButton restore = new JButton("restore");
        restore.addActionListener(e -> restore());
        buttonBox.add(restore);
        

        JButton cleanAll = new JButton("cleanAll");
        cleanAll.addActionListener(e->{
            checkBoxList.forEach(box->box.setSelected(false));
        });
        buttonBox.add(cleanAll);

        Box nameBox = new Box(BoxLayout.Y_AXIS);

        for (String instrumentName : instrumentNames) {
            JLabel instrumentLabel = new JLabel(instrumentName);
            instrumentLabel.setBorder(BorderFactory.createEmptyBorder(4, 1, 4, 1));
            nameBox.add(instrumentLabel);
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        frame.getContentPane().add(background);

        GridLayout gridLayout = new GridLayout(16, 16);
        gridLayout.setHgap(2);
        gridLayout.setVgap(1);

        JPanel mainPanel = new JPanel(gridLayout);
        background.add(BorderLayout.CENTER, mainPanel);
        checkBoxList = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();
        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);

    }

    private void restore() {
        System.out.println("write");
        boolean[] checkBoxState = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("CheckBox.ser"))) {
            checkBoxState = (boolean[]) is.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 256; i++) {
            checkBoxList.get(i).setSelected(checkBoxState[i]);
        }
        sequencer.stop();
        buildTrackAndStart();
        
    }

    private void writeFile() {
        System.out.println("write");
        boolean[] checkBoxState = new boolean[256];
        for (int i = 0; i < 256; i++) {
            JCheckBox checkBox = checkBoxList.get(i);
            if(checkBox.isSelected()){
                checkBoxState[i] = true;
            }
        }
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("CheckBox.ser"))) {
            os.writeObject(checkBoxState);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeTempo(float f) {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor(tempoFactor * f);
    }

    private void buildTrackAndStart() {
        int[] trackList;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {
            trackList = new int[16];
            int key = instruments[i];
            for (int j = 0; j < 16; j++) {
                JCheckBox checkBox = checkBoxList.get(j + i * 16);
                if(checkBox.isSelected()){
                    trackList[j] = key;
                }else{
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList);
            track.add(makeEvent(ShortMessage.CONTROL_CHANGE,1,127,0,16));
        }
        track.add(makeEvent(ShortMessage.PROGRAM_CHANGE, 9, 1, 0, 15));

        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.setTempoInBPM(120);
            sequencer.start();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick) {
        MidiEvent midiEvent = null;
        try {
            ShortMessage msg = new ShortMessage(cmd, chnl, one, two);
            midiEvent = new MidiEvent(msg, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return midiEvent;
    }

    private void makeTracks(int[] list){
        for (int i = 0; i < 16; i++) {
            int key = list[i];
            if(key != 0){
                track.add(makeEvent(ShortMessage.NOTE_ON, 9, key, 100, i));
                track.add(makeEvent(ShortMessage.NOTE_OFF, 9, key, 100, i + 1));
            }
        }
    }

}
