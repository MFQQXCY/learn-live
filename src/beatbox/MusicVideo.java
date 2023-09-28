package beatbox;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JFrame;

public class MusicVideo {

    private MyDrawPanel panel;

    public static void main(String[] args) {
        new MusicVideo().go();
    }
    
    public static MidiEvent makeEvent(int command,int channel, int one, int two, int tick){
        MidiEvent event = null;

        try {
            ShortMessage msg = new ShortMessage(command, channel, one, two);
            event = new MidiEvent(msg, tick);

        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }

        return event;
    }

    public void gui(){
        JFrame frame = new JFrame("My First Music video");
        panel = new MyDrawPanel();
        frame.setContentPane(panel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public void go() {
        gui();
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(panel,eventsIWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();
            for (int i = 5; i < 61; i+=4) {
                track.add(makeEvent(ShortMessage.NOTE_ON, 1, i, 100, i));
                track.add(makeEvent(ShortMessage.CONTROL_CHANGE, 1, 127, 0, i));
                track.add(makeEvent(ShortMessage.NOTE_OFF, 1, i, 100, i+2));
            }
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
