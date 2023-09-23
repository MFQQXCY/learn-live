package beatbox;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMusicCmdLine {
    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("try the instrument and note args");
        }else{
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            new MiniMusicCmdLine().play(instrument,note);
        }
        
    }

    private void play(int instrument, int note) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track t = seq.createTrack();

            ShortMessage msg = new ShortMessage();
            msg.setMessage(ShortMessage.PROGRAM_CHANGE, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(msg, 3);
            t.add(changeInstrument);

            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(ShortMessage.NOTE_ON, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(msg1, 1);
            t.add(noteOn);

            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(ShortMessage.NOTE_OFF, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(msg2, 16);
            t.add(noteOff);

            sequencer.setSequence(seq);
            sequencer.start();


        } catch (MidiUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
