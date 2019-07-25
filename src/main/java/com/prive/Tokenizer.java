package com.prive;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Tokenizer {
    private Randomizer randomizer = new Randomizer();

    public static void main(String[] args) throws IOException {
        String inputFile = (args.length > 0) ? args[0] : "data.txt";
        String delimiter = (args.length > 1) ? args[1] : "\\|";
        int column = (args.length > 2) ? Integer.valueOf(args[2]) : 0;

        new Tokenizer().scramble(inputFile, delimiter, column);
    }

    public void scramble(String inputFile, String delimiter, int columnToScramble) throws IOException {
        Files.readAllLines(Paths.get(inputFile), Charset.defaultCharset())
                .stream()
                .map(line -> tokenize(line, delimiter))
                .map(tokenz -> scramble(tokenz, columnToScramble))
                .forEach(a -> System.out.println(Arrays.asList(a)));
    }

    private String[] scramble(String[] tokenz, int columnToScramble) {
        String[] scrambledData = new String[tokenz.length];
        for (int i = 0; i < tokenz.length; i++) {
            if (i == columnToScramble) {
                scrambledData[i] = randomizer.randomize(tokenz[i]);
            } else {
                scrambledData[i] = tokenz[i];
            }
        }

        return scrambledData;
    }

    private String[] tokenize(String line, String delimiter) {
        return line.split(delimiter);
    }
}
