package com.krajnish.quizomenia.Qom.Logical.Quiz;


import java.util.List;

public class Utility1 {
    public static String capitalise(String s) {
        if (s == null || s.length() == 0) return s;

        String s1 = s.substring(0, 1).toUpperCase() + s.substring(1);
        return s1;
    }

    /**
     * Method to get set of answers for a list of questions
     *
     * @param questions
     * @return
     */
    public static String getAnswers(List<Question1> questions) {
        int question = 1;
        StringBuffer sb = new StringBuffer();

        for (Question1 q : questions) {
            sb.append("Q").append(question).append(") ").append(q.getQuestion()).append("? \n");
            sb.append("Answer: ").append(q.getAnswer()).append("\n\n");
            question++;
        }

        return sb.toString();
    }

}


