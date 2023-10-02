package io;

import java.io.FileWriter;

public class WriteAFile {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("Foo.txt");
            fileWriter.write("hello foo!");
            fileWriter.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
