package loopz.showme.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chihzhe on 2013/5/22.
 */
public class Grocery {
    private long id;
    private String itemName;
    private int scoreUp;
    private int scoreDown;
    private List<Comment> comments = new ArrayList<Comment>(0);
    private String img;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getScoreUp() {
        return scoreUp;
    }

    public void setScoreUp(int scoreUp) {
        this.scoreUp = scoreUp;
    }

    public int getScoreDown() {
        return scoreDown;
    }

    public void setScoreDown(int scoreDown) {
        this.scoreDown = scoreDown;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
