package inner;

public class MyOuter {

    private int x;

    /** 
     * 在内部类的外层部分实例化内部类的对象
     */

    MyInner inner = new MyInner();
    
    public void go(){
        inner.go();
        System.out.println(x);
    }

    class MyInner {

        void go() {
            x = 20;
            System.out.println("innner method go run");
        }
    }
}
