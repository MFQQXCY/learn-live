package jukebox;

import java.util.Collections;
import java.util.List;

public class Jukebox1 {
    public void go(){
        List<String> songs = MockSongs.getSongStrings();
        System.out.println(songs);
        Collections.sort(songs);
        System.out.println(songs);
        
    }

    public static void main(String[] args) {
        Jukebox1 j = new Jukebox1();
        j.go();
    }

}
