package jukebox;

import java.util.Comparator;
import java.util.List;

public class Jukebox3 {

    public static void main(String[] args) {
        new Jukebox3().go();
    }

    private void go() {
        List<SongV2> songList = MockSongs.getSongV2();
        songList.sort(new ArtistCompare());
        System.out.println(songList);

        /**
         * 使用lambda,利用编译器可以推断的方式
         * 1.List的sort方法是接收一个Comparator类型的，
         * 2.编译器是知道使用哪个方法签名的。
         * 
         */
        songList.sort((one,two)->one.getTitle().compareTo(two.getTitle()));
        System.out.println(songList);

        /**
         * 关于Comparator接口中，无需实现equal方法的解释：
         * 接口中的equal方法定义与Object中的定义一模一样，因此，当一个实现类创建后，就会自带这个equal方法的实现。
         * 因此只需要实现Comparator中另一个接口方法就行。
         * java API中的一些接口会重新声明Object方法来附加javadoc注释。
         */

    }
}

class ArtistCompare implements Comparator<SongV2> {

    @Override
    public int compare(SongV2 o1, SongV2 o2) {
        int result = o1.getArtist().compareTo(o2.getArtist());
        if (result == 0) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
        return result;
    }

}
