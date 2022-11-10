package com.global;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String... args) throws FileNotFoundException {
        if (args.length > 0) {
            File file = new File(args[0]);
            String words = ReadFile.usingBufferedReader(file);
            List<String> listOfWords = new ArrayList<>(Arrays.asList(words.split(System.lineSeparator())));
            Proccessor process = new Proccessor();
            System.out.println(process.findAllAnagrams(listOfWords));
        } else {
            System.out.println("Please enter 1 file at a time");
        }
    }

}
