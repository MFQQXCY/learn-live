package jukebox;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Jukebox4 {
    public void go(){
        List<SongV3> songList = MockSongs.getSongV3();
        // 这种情况，需要使SongV3实现Comparable接口
        // Set<SongV3>  songSet = new TreeSet<>(songList);


        // 原顺序
        Set<SongV3>  songSetNoSort = new TreeSet<>((a,b)->1);
        songSetNoSort.addAll(songList);
        System.out.println(songSetNoSort);

        // 按照title排序
        Set<SongV3>  songSet = new TreeSet<>((a,b)->a.getTitle().compareTo(b.getTitle()));
        songSet.addAll(songList);
        System.out.println(songSet);
            
    }


    public static void main(String[] args) {
        new Jukebox4().go();
    }
}
