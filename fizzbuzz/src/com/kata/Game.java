package com.kata;

/**
 * Created by sloanzhang on 2019/4/25.
 */
public class Game {
    public String getString(int i) {
        if (checkFizzBuzz(i)) return "fizzbuzz";
        if (checkBuzz(i)) return "buzz";
        if (checkFizz(i)) return "fizz";
        return i + "";
    }

    private boolean checkFizz(int i) {
        if (i % 3 == 0 || i % 10 == 3 || i / 10 == 3) return true;
        return false;
    }

    private boolean checkBuzz(int i) {
        if (i % 5 == 0 || i%10==5||i / 10 == 5) return true;
        return false;
    }

    private boolean checkFizzBuzz(int i) {
        if (checkFizz(i) && checkBuzz(i)) return true;
        return false;
    }

    public String print1to100GameString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < 100; i++) {
            sb.append(getString(i)).append(" ");
        }
        return sb.toString();
    }

}
