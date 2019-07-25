package com.prive;

import java.util.HashMap;
import java.util.Map;

public class Randomizer {
    private final char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final char[] nums = "0123456789".toCharArray();

    private Map<String, String> scrabledTokens = new HashMap<>();

    public String randomize(String token) {
        String scrambledToken = scrabledTokens.get(token);
        if (scrambledToken == null) {
            scrabledTokens.put(token, (scrambledToken = scramble(token)));
        }

        return scrambledToken;
    }

    private String scramble(String token) {
        char[] input = token.toCharArray();
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
