package ploy.vehicle;

public class LifeTest {

    // 三个方式让对象有资格被回收
    public static void main(String[] args) {
        // 变量m在go函数结束后就会死亡。
        first();

        // 当m指向一个新的对象时
        second();

        // 当m指向
        third();
    }

    
    public static void first(){
        go();
    }

    public static void second(){
        Mini m = new Mini();
        m = new Mini();
    }

    static void third(){
        Mini m = new Mini();
        m = null;
    }

    static void go(){
        Mini m = new Mini();
    }

    
}
