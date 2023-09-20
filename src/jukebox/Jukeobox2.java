package jukebox;

import java.util.Collections;
import java.util.List;

public class Jukeobox2 {
    public void go(){
        List<SongV2> songList = MockSongs.getSongV2();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
        
    }

    public static void main(String[] args) {
        Jukeobox2 j = new Jukeobox2();
        j.go();
    }


    
}
