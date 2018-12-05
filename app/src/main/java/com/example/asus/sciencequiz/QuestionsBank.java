package com.example.asus.sciencequiz;

/**
 * Created by Asus on 1/12/2018.
 */

public class QuestionsBank {

    private String mQuestions[] = {
            "What is its chemical formula of water?",
            "Where in the body is most of the iron located?",
            "The symbol Ag stands for which element?",
            "Which of these elements isn't a noble gas?",
            "In a solution of saltwater, salt is the:"
    };

    private String mChoices[][] = {
            {"H2O", "H2", "H2O2"},
            {"Your skin", "Your blood", "Your brain"},
            {"Gold", "Magnesium","Silver"},
            {"Helium", "Argon", "Clorine"},
            {"Solute", "Sol", "Solvent"}
    };



    private String mAnswer[] = {"H2O", "Your blood", "Silver" , "Clorine" , "Solute"};

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getAnswer(int a){
        String answer = mAnswer[a];
        return answer;
    }

    public int getLength() {
        return mQuestions.length;
    }
}
