package com.example;

public class Judgement {

    public String judge(int score) throws IllegalArgumentException {
        if (score < 0 || 100 < score) {
            throw new IllegalArgumentException("正常な得点ではありません。");
        }
        return 80 <= score ? "合格" : "不合格";
    }

    public boolean isValid(int score) {
        if (score < 0 || 100 < score) {
            return false;
        }
        return true;
    }
}