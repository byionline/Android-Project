package com.krajnish.quizomenia.Qom.Logical.Quiz;



import java.util.ArrayList;
import java.util.List;


public class Quiz1 {
    private int numRounds;
    private int level;
    private int right;
    private int wrong;
    private int round;

    private List<Question1> questions = new ArrayList<>();

    /**
     *
     * @return the right
     */
    public int getRight(){
        return right;
    }

    /**
     *
     * @param right
     */
    public void setRight(int right){this.right = right;}

    /**
     *
     * @return the wrong
     */
    public int getWrong(){
        return wrong;
    }

    /**
     *
     * @param wrong
     */
    public void setWrong(int wrong){this.wrong = wrong;}

    /**
     *
     * @return the round
     */
    public int getRound(){
        return round;
    }

    /**
     *
     * @param round
     */
    public void setRound(int round) {this.round = round;}

    /**
     *
     * @return level
     */
    public int getLevel(){
        return level;
    }

    /**
     *
     * @param level
     */
    public void setLevel(int level) {this.level = level;}

    /**
     *
     * @param q the question to add
     */
    public void addQuestions(Question1 q) {this.questions.add(q);}

    /**
     *
     * @return the questions
     */
    public List<Question1> getQuestions(){return questions;}

    /**
     *
     * @param questions to set
     */
    public void setQuestions(List<Question1> questions) {this.questions = questions;}

    /**
     *
     * @return next question
     */
    public Question1 getNextquestion(){
        //get the next question
        Question1 next = questions.get(this.getRound());
        //Update the round number to the next round
        this.setRound(this.getRound() + 1);
        return next;
    }

    /**
     * method to increment the number of right answers
     */
    public void incrementRightAnswers(){right++;}
    /**
     * method to increment the number of wrong answers
     */
    public void incrementWrongAnswers(){wrong++;}

    /**
     *
     * @return the numRounds
     */
    public int getNumRounds(){return numRounds;}

    /**
     *
     * @param numRounds
     */
    public void setNumRounds(int numRounds)
    {this.numRounds = numRounds;}

    /**
     * method to check if the quiz is over
     * @return boolean
     */
    public boolean isQuizOver(){return (getRound() >= getNumRounds());}
}
