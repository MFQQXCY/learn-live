package beatbox;

import javax.sound.midi.*;


public class MusicTest1 {
    public static void main(String[] args) {
        new MusicTest1().play();
    }

    private void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track t = seq.createTrack();

            ShortMessage msg1 = new ShortMessage();
            // (message type, channel, note to play, veocity)
            msg1.setMessage(ShortMessage.NOTE_ON, 1, 20, 100);
            MidiEvent noteOn = new MidiEvent(msg1, 3);
            t.add(noteOn);

            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(ShortMessage.NOTE_OFF, 1, 20, 100);
            MidiEvent noteOff = new MidiEvent(msg2, 1);
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
        System.out.println("success");
        
    }
}
