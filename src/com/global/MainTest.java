package com.global;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
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

    @Test
    public void Should_Return_Anagrams_For_Example1() throws FileNotFoundException {
        String words = ReadFile.usingBufferedReader(new File(example1.getAbsolutePath()));
        List<String> listOfWords = new ArrayList<>(Arrays.asList(words.split(System.lineSeparator())));
        assertEquals(3, proccessor.findAllAnagrams(listOfWords).size());
    }

    @Test
    public void Should_Return_Anagrams_For_Example2() throws FileNotFoundException {
        String words = ReadFile.usingBufferedReader(new File(example2.getAbsolutePath()));
        List<String> listOfWords = new ArrayList<>(Arrays.asList(words.split(System.lineSeparator())));
        assertEquals(156467, proccessor.findAllAnagrams(listOfWords).size());
    }

    @Test
    public void Should_Return_Null_For_Empty_File() throws FileNotFoundException {
        String words = ReadFile.usingBufferedReader(new File(emptyFile.getAbsolutePath()));
        assertEquals(0, words.length());
    }

}
