package loopz.showme.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import loopz.showme.R;
import loopz.showme.bean.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chihzhe on 2013/5/28.
 */
public class CommentAdapter extends BaseAdapter {

    private List<Comment> dataList = new ArrayList<Comment>(0);

    private Context context;
    private LayoutInflater layoutInflater;

    public void setDataList(List<Comment> comments) {
        dataList = comments;
    }

    public CommentAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
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
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        CommentViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_comments, null);
            holder = new CommentViewHolder();
            holder.userName = (TextView) convertView.findViewById(R.id.user_name);
            holder.comment  = (TextView) convertView.findViewById(R.id.comment);
            holder.score    = (TextView) convertView.findViewById(R.id.score);

            convertView.setTag(holder);
        } else {
            holder = (CommentViewHolder) convertView.getTag();
        }

        Comment comment = dataList.get(i);
        holder.userName.setText(TextUtils.isEmpty(comment.getUserName()) ? "Anonymous User" : comment.getUserName());
        holder.comment .setText(comment.getComment());
        holder.score   .setText(String.valueOf(comment.getScore()));
        if (comment.getScore() >= 0) {
            holder.score.setTextAppearance(context, R.style.ScoreUp);
            holder.score.setBackgroundColor(context.getResources().getColor(android.R.color.holo_red_light));
        } else {
            holder.score.setTextAppearance(context, R.style.ScoreDown);
            holder.score.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));

        }

        return convertView;
    }

    public void addComment(List<Comment> comments) {
        dataList.addAll(comments);
    }

    class CommentViewHolder {
        public TextView userName;
        public TextView comment;
        public TextView score;
    }
}
