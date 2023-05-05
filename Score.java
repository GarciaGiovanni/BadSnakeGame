public class Score {

    private String score;
    private int points;

    public Score() {
        score = points + "";
    }

    public void increment() {
        points++;
        score = points + "";
    }

    public String getScore() {
        return score;
    }

}
