package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadAFile {
    public static void main(String[] args) {
        try {
            File myFile = new File("/Users/moon/Downloads/quiz.txt");
            BufferedReader reader = new BufferedReader(new FileReader(myFile));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            System.out.println("====USING STREAM AND I/O====");
            Files.lines(Path.of("/Users/moon/Downloads/quiz.txt"))
                    .forEach(str -> System.out.println(str));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
