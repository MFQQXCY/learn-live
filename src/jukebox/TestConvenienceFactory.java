package jukebox;

import java.util.Collections;
import java.util.List;

public class TestConvenienceFactory {
    public static void main(String[] args) {
        List<String> a = List.of("book", "music");
        // 不可添加
        a.add("book");
        System.out.println(a);
        Collections.sort(a);
        System.out.println(a);
        
    
    }

    public static void test() {
        List<String> usongs = MockSongs.getSongStrings();
        List<String> songs  = Collections.unmodifiableList(usongs);

        // 不可重排序
        Collections.sort(songs);
        //不可修改
        songs.remove(1);
        System.out.println(songs);
    }
}
