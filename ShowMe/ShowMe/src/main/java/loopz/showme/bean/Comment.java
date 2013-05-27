package loopz.showme.bean;

/**
 * Created by chihzhe on 2013/5/26.
 */
public class Comment {
    private long id;
    private String comment;
    private int score;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
