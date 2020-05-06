package hitesh.asimplegame;

public class RankingInformation {
    private int ranking;
    private String player;
    private int challengeScore;

    private int id;

    public RankingInformation() {
        id=0;
        ranking = 0;
        player = " ";
        challengeScore = 0;
    }

    public RankingInformation(int ranking, String player, int challengeScore) {
        this.ranking = ranking;
        this.player = player;
        this.challengeScore = challengeScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getChallengeScore() {
        return challengeScore;
    }

    public void setChallengeScore(int challengeScore) {
        this.challengeScore = challengeScore;
    }
}
