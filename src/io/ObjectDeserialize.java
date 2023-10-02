package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectDeserialize {
    
    public static void main(String[] args) throws Exception{
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("foo.ser"));
        Foo f = (Foo)oi.readObject();
        System.out.println(f);
    }
}
