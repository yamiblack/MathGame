package hitesh.asimplegame;

public class RankingInformation {
    private int ranking;
    private int challengeScore;

    public RankingInformation() {
        challengeScore = 0;
    }

    public RankingInformation(String player, int challengeScore) {
        this.challengeScore = challengeScore;
    }


    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getChallengeScore() {
        return challengeScore;
    }

//    public int getChallengeScore(int i) { return }

    public void setChallengeScore(int challengeScore) {
        this.challengeScore = challengeScore;
    }
}
