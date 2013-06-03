package loopz.showme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import loopz.showme.R;
import loopz.showme.bean.Comment;
import loopz.showme.bean.Grocery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chihzhe on 2013/5/22.
 */
public class SearchListAdapter extends BaseAdapter {
    private List<Grocery> dataList = new ArrayList<Grocery>();
    private Context context;
    private LayoutInflater layoutInflater;

    public SearchListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        addTestData();
    }

    private void addTestData() {
        List<Comment> comments = new ArrayList<Comment>();
        Comment c = new Comment();
        c.setId(0);
        c.setComment("good good eat!");
        c.setScore(1);
        comments.add(c);

        c = new Comment();
        c.setId(1);
        c.setComment("awsome!");
        c.setScore(1);
        comments.add(c);

        c = new Comment();
        c.setId(2);
        c.setComment("wtf");
        c.setScore(-1);
        comments.add(c);

        Grocery grocery = new Grocery();
        grocery.setId(0);
        grocery.setItemName("luke");
        grocery.setManufacturer("浩克製造");
        grocery.setDescription("感覺不錯");
        grocery.setScoreDown(10);
        grocery.setScoreUp(100);
        grocery.setComments(comments);
        dataList.add(grocery);

        grocery = new Grocery();
        grocery.setId(1);
        grocery.setItemName("浩文哥");
        grocery.setScoreDown(5);
        grocery.setScoreUp(999);
        grocery.setComments(comments);
        dataList.add(grocery);

        grocery = new Grocery();
        grocery.setId(2);
        grocery.setItemName("浩文糕");
        grocery.setManufacturer("浩克製造");
        grocery.setDescription("感覺不錯");
        grocery.setScoreDown(5);
        grocery.setScoreUp(999);
        grocery.setComments(comments);
        dataList.add(grocery);

        grocery = new Grocery();
        grocery.setId(3);
        grocery.setItemName("option");
        grocery.setManufacturer("阿普森科技");
        grocery.setDescription("感覺很不錯");
        grocery.setScoreDown(10);
        grocery.setScoreUp(100);
        grocery.setComments(comments);
        dataList.add(grocery);

        grocery = new Grocery();
        grocery.setId(4);
        grocery.setItemName("WeiDe");
        grocery.setScoreDown(10);
        grocery.setScoreUp(100);
        dataList.add(grocery);

        grocery = new Grocery();
        grocery.setId(5);
        grocery.setItemName("偉德糕");
        grocery.setManufacturer("阿普森科技");
        grocery.setDescription("感覺很不錯");
        grocery.setScoreDown(5);
        grocery.setScoreUp(999);
        grocery.setComments(comments);
        dataList.add(grocery);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return dataList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        SearchResultViewHolder holder;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.list_search_result, null);

            holder = new SearchResultViewHolder();
            holder.itemId    = (TextView) view.findViewById(R.id.item_id);
            holder.itemName  = (TextView) view.findViewById(R.id.item_name);
            holder.scoreUp   = (TextView) view.findViewById(R.id.score_up);
            holder.scoreDown = (TextView) view.findViewById(R.id.score_down);

            view.setTag(holder);
        } else {
            holder = (SearchResultViewHolder) view.getTag();
        }

        Grocery grocery = dataList.get(i);
        holder.itemId.setText(String.valueOf(grocery.getId()));
        holder.itemName.setText(grocery.getItemName());
        holder.scoreUp.setText(String.valueOf(grocery.getScoreUp()));
        holder.scoreDown.setText(String.valueOf(grocery.getScoreDown()));

        return view;
    }

    private class SearchResultViewHolder {
        public TextView itemId;
        public TextView itemName;
        public TextView scoreUp;
        public TextView scoreDown;
    }
}
