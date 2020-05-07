package hitesh.asimplegame;

public class RankingInformation {
    private int ranking;
//    private String email;
    private int challengeScore;

    private int id;

    public RankingInformation() {
//        email = " ";
        challengeScore = 0;
    }

    public RankingInformation(String player, int challengeScore) {
//        this.email = player;
        this.challengeScore = challengeScore;
    }


    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String player) {
//        this.email = player;
//    }

    public int getChallengeScore() {
        return challengeScore;
    }

    public void setChallengeScore(int challengeScore) {
        this.challengeScore = challengeScore;
    }
}
