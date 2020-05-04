package hitesh.asimplegame;

import java.util.Random;

import hitesh.asimplegame.Question;

public class MediumRandom extends Question {


    int questionNumber1;
    int questionNumber2;

    int maxNumber1 = 999;
    int maxNumber2 = 99;
    int minNumber = 1;

    int answerNumber;

    int extraNumber;

    int[] option = new int[4];


    int optionA;
    int optionB;
    int optionC;


    Random randomNumber = new Random();

    public MediumRandom() {

        questionNumber1 = randomNumber.nextInt(maxNumber1 - minNumber + 1) + minNumber;
        questionNumber2 = randomNumber.nextInt(maxNumber2 - minNumber + 1) + minNumber;

        answerNumber = questionNumber1 + questionNumber2;

        for (int i = 0; i < 3; i++) {
            option[i] = -1;
        }

        option[3] = -2;

        for (int i = 0; i < 3; i++) {
            extraNumber = randomNumber.nextInt(10);
            option[i] = answerNumber + extraNumber;
        }

        option[randomNumber.nextInt(3)] = answerNumber;

        for (int i = 0; i < 3; i++) {
            if (option[i] == option[i + 1]) {
                option[i] += randomNumber.nextInt(10) + 9;
            }
        }

        if (option[2] == option[0]) {
            option[2] += randomNumber.nextInt(11) + 10;
        }

        optionA = option[0];
        optionB = option[1];
        optionC = option[2];

    }


    @Override
    public String getQUESTION() {
        return String.valueOf(questionNumber1) + "+" + String.valueOf(questionNumber2) + " = ?";
    }

    @Override
    public String getANSWER() {
        return String.valueOf(answerNumber);
    }

    @Override
    public String getOPTA() {
        return String.valueOf(optionA);
    }

    @Override
    public String getOPTB() {
        return String.valueOf(optionB);
    }

    @Override
    public String getOPTC() {
        return String.valueOf(optionC);
    }

}
