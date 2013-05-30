package loopz.showme.bean;

import java.io.Serializable;

/**
 * Created by chihzhe on 2013/5/26.
 */
public class Comment implements Serializable {

    private static final long serialVersionUID = 2L;

    private long id;
    private long itemId;
    private String userName;
    private String comment;
    private int score;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
