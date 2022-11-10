package com.global;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

/**
 * @author Roshni Das
 * @created 05/11/2022
 * @project AnagramSolver
 */
public class MainTest {
    private static File example1;
    private static File example2;
    private static File emptyFile;
    Proccessor proccessor = new Proccessor();

    @Before
    public void files() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        System.out.println(this.getClass().getName());
        example1 = new File(Objects.requireNonNull(classLoader.getResource("example1.txt")).getFile());
        example2 = new File(Objects.requireNonNull(classLoader.getResource("example2.txt")).getFile());
        emptyFile = new File(Objects.requireNonNull(classLoader.getResource("emptyFile.txt")).getFile());
    }

    private static String usingBufferedReader(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    @Test
    public void Should_Return_Anagram_Example1() {
        String words = usingBufferedReader(example1.getAbsolutePath());
        List<String> listOfWords = new ArrayList<>(Arrays.asList(words.split(System.lineSeparator())));
        assertEquals(3, proccessor.findAllAnagrams(listOfWords).size());
    }

    @Test
    public void Should_Return_Anagram_Example2() {
        String words = usingBufferedReader(example2.getAbsolutePath());
        List<String> listOfWords = new ArrayList<>(Arrays.asList(words.split(System.lineSeparator())));
        assertEquals(156467, proccessor.findAllAnagrams(listOfWords).size());
    }

    @Test
    public void Should_Return_Null_For_Empty_File() {
        String words = usingBufferedReader(emptyFile.getAbsolutePath());
        assertEquals(0, words.length());
    }

}
