package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectWrite {
    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();
        foo.height = 12;
        foo.weight = 13;
        // 只有实例变量真正指定到一个别的类时，才会抛出异常。
        // foo.duck = new Duck();

        FileOutputStream f = new FileOutputStream("foo.ser");
        ObjectOutputStream os = new ObjectOutputStream(f);
        os.writeObject(foo);
        os.close();
    }
}
