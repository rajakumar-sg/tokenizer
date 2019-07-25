package com.prive;

import java.util.HashMap;
import java.util.Map;

public class Randomizer {
    char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    char[] nums = "0123456789".toCharArray();

    private Map<String, String> random = new HashMap<>();

    public String randomize(String data) {
        String ramdomData = random.get(data);
        if (ramdomData == null) {
            random.put(data, (ramdomData = generateRandom(data)));
        }

        return ramdomData;
    }

    private String generateRandom(String data) {
        char[] input = data.toCharArray();
        char[] result = new char[input.length];

        for (int i = 0; i < input.length; i++) {
            if (Character.isAlphabetic(input[i])) {
                result[i] = pickARandomChar();
            } else if (Character.isDigit(input[i])) {
                result[i] = pickARandomDigit();
            } else {
                result[i] = input[i];
            }
        }

        return new String(result);
    }

    private char pickARandomDigit() {
        return nums[(int) (Math.random() * nums.length)];
    }

    private char pickARandomChar() {
        return chars[(int) (Math.random() * nums.length)];
    }
}
