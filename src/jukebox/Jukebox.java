package jukebox;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jukebox {
    public static void main(String[] args) {
        List<SongV2> aa = MockSongs.getSongV2();
        aa.forEach((a)->{
            System.out.println(a.getTitle() + "--" + a.hashCode()+ "--" + a);
        });
        System.out.println("Compare to HashSetCopy");
        Set<SongV2> songs = new HashSet<>(aa);
        songs.forEach((a)->{
            System.out.println(a.getTitle() + "---" + a.hashCode()+ "---" + a);
        });

        System.out.println("");
        List<SongV3> bb = MockSongs.getSongV3();
        bb.forEach((a)->{
            System.out.println(a.getTitle() + "--" + a.hashCode()+"--"+a);
        });
        System.out.println("Compare to HashSetCopy");

        Set<SongV3> songList = new HashSet<>(bb);
        songList.forEach((a)->{
            System.out.println(a.getTitle() + "---" + a.hashCode()+"---"+a);
        });


        Jukebox j = new Jukebox();
        Jukebox k = j;
        Jukebox l = new Jukebox();
        // hashcode 是对一个堆中的对象计算，生成一个数字。
        // equals方法通过==判断，换句话说就是测试两个引用是否指向堆中的同一个对象。
        /**
         *  不同的对象可以会计算出同一个hashcode，但是同一个对象计算出的hashcode 一定是一样的。
         *  通过了equals测试的，其hashcode相同。
         *  hashcode相同，equals测试可能不通过,参考五百个学生，必然有两个同学的生日是同一天。
         *  HashSet在判断两个对象重复时，是先判断hashcode,再测试equal方法。
         */
        System.out.println(j.hashCode());
        System.out.println(k.hashCode());
        System.out.println(j==k);
        System.out.println(l.hashCode());
    }
}
