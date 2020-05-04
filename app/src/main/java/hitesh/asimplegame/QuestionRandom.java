package hitesh.asimplegame;

public class QuestionRandom extends Question {

    int questionNumber1;
    int questionNumber2;

    int easyMaxNumber1 = 99;
    int easyMaxNumber2 = 9;
    int easyMinNumber = 1;

    int mediumMaxNumber = 999;
    int mediumMinNumber = 95;

    int hardMaxNumber = 9999;
    int hardMinNumber = 915;


    int answerNumber;

    int extraNumber;

    int[] option = new int[4];


    int optionA;
    int optionB;
    int optionC;


    java.util.Random randomNumber = new java.util.Random();

    public QuestionRandom(int difficulty) {

        if (difficulty == 1) {
            questionNumber1 = randomNumber.nextInt(easyMaxNumber1 - easyMinNumber + 1) + easyMinNumber;
            questionNumber2 = randomNumber.nextInt(easyMaxNumber2 - easyMinNumber + 1) + easyMinNumber;
        }

        if (difficulty == 2) {
            questionNumber1 = randomNumber.nextInt(mediumMaxNumber - mediumMinNumber + 1) + mediumMinNumber;
            questionNumber2 = randomNumber.nextInt(easyMaxNumber1 - mediumMinNumber + 1) + mediumMinNumber;
        }

        if (difficulty == 3) {
            questionNumber1 = randomNumber.nextInt(hardMaxNumber - hardMinNumber + 1) + hardMinNumber;
            questionNumber2 = randomNumber.nextInt(mediumMaxNumber - hardMinNumber + 1) + hardMinNumber;
        }


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

