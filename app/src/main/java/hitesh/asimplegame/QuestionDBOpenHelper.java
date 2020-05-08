package hitesh.asimplegame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuestionDBOpenHelper extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 10;

    private static final String DATABASE_NAME = "mathsone";

    private static final String TABLE_EASY = "easy";
    private static final String TABLE_MEDIUM = "medium";
    private static final String TABLE_HARD = "hard";
    private static final String TABLE_PRACTICE = "practice";
    private static final String TABLE_CHALLENGE = "challenge";

    private static final String TABLE_RANKINGINFORMATION = "rankingInformation";

    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c
    private static final String KEY_CHALLENGESCORE = "score";

    private static final int entireNumberOfQuestions = 21;
    private static final int limitlessNumberOfQuestions = 999;

    QuestionRandom[] numberOfQuestions = new QuestionRandom[entireNumberOfQuestions];
    QuestionRandom[] numberOfLimitlessQuestions = new QuestionRandom[limitlessNumberOfQuestions];

    private SQLiteDatabase database;

    public QuestionDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        database = db;
        String sql1 = "CREATE TABLE IF NOT EXISTS " + TABLE_EASY + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";

        db.execSQL(sql1);

        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_MEDIUM + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";

        db.execSQL(sql2);

        String sql3 = "CREATE TABLE IF NOT EXISTS " + TABLE_HARD + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";

        db.execSQL(sql3);

        String sql4 = "CREATE TABLE IF NOT EXISTS " + TABLE_PRACTICE + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";

        db.execSQL(sql4);

        String sql5 = "CREATE TABLE IF NOT EXISTS " + TABLE_CHALLENGE + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";

        db.execSQL(sql5);

        String sql6 = "CREATE TABLE IF NOT EXISTS " + TABLE_RANKINGINFORMATION + " ( "
                + KEY_CHALLENGESCORE + " INTEGER " + ")";

        db.execSQL(sql6);


        addEasyQuestion();
        addMediumQuestion();
        addHardQuestion();
        addPracticeQuestion();
        addChallengeQuestion();
        addRankingInformation();
    }

    void addEasyQuestion() {

        for (int i = 0; i < entireNumberOfQuestions; i++) {
            numberOfQuestions[i] = new QuestionRandom(1);
            addEasyQuestion(numberOfQuestions[i]);
        }
    }

    void addMediumQuestion() {

        for (int i = 0; i < entireNumberOfQuestions; i++) {
            numberOfQuestions[i] = new QuestionRandom(2);
            addMediumQuestion(numberOfQuestions[i]);
        }
    }

    void addHardQuestion() {

        for (int i = 0; i < entireNumberOfQuestions; i++) {
            numberOfQuestions[i] = new QuestionRandom(3);
            addHardQuestion(numberOfQuestions[i]);
        }
    }

    void addPracticeQuestion() {

        for (int i = 0; i < limitlessNumberOfQuestions; i++) {
            numberOfLimitlessQuestions[i] = new QuestionRandom(4);
            addPracticeQuestion(numberOfLimitlessQuestions[i]);
        }
    }

    void addChallengeQuestion() {

        for (int i = 0; i < limitlessNumberOfQuestions; i++) {
            numberOfLimitlessQuestions[i] = new QuestionRandom(4);
            addChallengeQuestion(numberOfLimitlessQuestions[i]);
        }
    }

    void addRankingInformation() {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EASY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDIUM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HARD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRACTICE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHALLENGE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int newV, int OldV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EASY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDIUM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HARD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRACTICE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHALLENGE);
        onCreate(db);
    }

    public static void setRandomDB() {
        if (DATABASE_VERSION <= 9) {
            DATABASE_VERSION = 10;
        } else {
            DATABASE_VERSION = 9;
        }
    }

    public void addEasyQuestion(Question easy) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, easy.getQUESTION());
        values.put(KEY_ANSWER, easy.getANSWER());
        values.put(KEY_OPTA, easy.getOPTA());
        values.put(KEY_OPTB, easy.getOPTB());
        values.put(KEY_OPTC, easy.getOPTC());

        database.insert(TABLE_EASY, null, values);
    }

    public void addMediumQuestion(Question medium) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, medium.getQUESTION());
        values.put(KEY_ANSWER, medium.getANSWER());
        values.put(KEY_OPTA, medium.getOPTA());
        values.put(KEY_OPTB, medium.getOPTB());
        values.put(KEY_OPTC, medium.getOPTC());

        database.insert(TABLE_MEDIUM, null, values);
    }

    public void addHardQuestion(Question hard) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, hard.getQUESTION());
        values.put(KEY_ANSWER, hard.getANSWER());
        values.put(KEY_OPTA, hard.getOPTA());
        values.put(KEY_OPTB, hard.getOPTB());
        values.put(KEY_OPTC, hard.getOPTC());

        database.insert(TABLE_HARD, null, values);
    }

    public void addPracticeQuestion(Question practice) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, practice.getQUESTION());
        values.put(KEY_ANSWER, practice.getANSWER());
        values.put(KEY_OPTA, practice.getOPTA());
        values.put(KEY_OPTB, practice.getOPTB());
        values.put(KEY_OPTC, practice.getOPTC());

        database.insert(TABLE_PRACTICE, null, values);
    }

    public void addChallengeQuestion(Question challenge) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, challenge.getQUESTION());
        values.put(KEY_ANSWER, challenge.getANSWER());
        values.put(KEY_OPTA, challenge.getOPTA());
        values.put(KEY_OPTB, challenge.getOPTB());
        values.put(KEY_OPTC, challenge.getOPTC());

        database.insert(TABLE_CHALLENGE, null, values);
    }

    public void addRankingInformation(RankingInformation rankingInformation) {
        ContentValues values = new ContentValues();
        values.put(KEY_CHALLENGESCORE, rankingInformation.getChallengeScore());

        database.insert(TABLE_RANKINGINFORMATION, null, values);
    }


    public List<Question> getAllEasyQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EASY;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public List<Question> getAllMediumQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MEDIUM;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public List<Question> getAllHardQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_HARD;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public List<Question> getAllPracticeQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRACTICE;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public List<Question> getAllChallengeQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CHALLENGE;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }


    public List<RankingInformation> getChallengeRanking() {
        List<RankingInformation> challengeScoreList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_RANKINGINFORMATION + " ORDER BY " + KEY_CHALLENGESCORE + " DESC";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                RankingInformation rankingInformation = new RankingInformation();

                rankingInformation.setChallengeScore(cursor.getInt(0));

                challengeScoreList.add(rankingInformation);
            } while (cursor.moveToNext());
        }
        return challengeScoreList;
    }

    public String getKeyChallengescore() {
        return KEY_CHALLENGESCORE;
    }

    public String getTableRankinginformation() {
        return TABLE_RANKINGINFORMATION;
    }
}
