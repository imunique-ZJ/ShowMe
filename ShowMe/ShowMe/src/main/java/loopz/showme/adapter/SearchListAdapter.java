package loopz.showme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import loopz.showme.R;
import loopz.showme.bean.Grocery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chihzhe on 2013/5/22.
 */
public class SearchListAdapter extends BaseAdapter {
    private List<Grocery> dataList = new ArrayList<Grocery>();
    private LayoutInflater layoutInflater;

    public SearchListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
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
