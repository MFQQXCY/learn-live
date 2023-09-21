package beatbox;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MusicTest1 {
    public static void main(String[] args) {
        new MusicTest1().play();
    }

    private void play() {
        try (Sequencer sequencer = MidiSystem.getSequencer()) {
        } catch (MidiUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("success");
    }
}
