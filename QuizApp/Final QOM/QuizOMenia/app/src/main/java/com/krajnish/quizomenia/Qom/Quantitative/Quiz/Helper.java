package com.krajnish.quizomenia.Qom.Quantitative.Quiz;

/**
 * Created by RACE on 11/8/2015.
 */
public class Helper {



    /**
     * Calculate the percentage result based on the number correct and number of questions
     *
     * @param numCorrect - number of questions right
     * @param numRounds  - total number of questions
     * @return int percentage correct
     */
    private static int calculatePercentage(int numCorrect, int numRounds) {
        double frac = (double) numCorrect / (double) numRounds;
        int percentage = (int) (frac * 100);
        return percentage;
    }
}


