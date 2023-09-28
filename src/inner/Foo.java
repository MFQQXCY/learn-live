package inner;

public class Foo {
    public static void main(String[] args) {
        MyOuter outer = new MyOuter();

        MyOuter.MyInner inner = outer.new MyInner();
        // inner.go();
        
        outer.go();

        System.out.println(outer.inner);
        System.out.println(inner);
    }
}
