package loopz.showme;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import loopz.showme.adapter.SearchListAdapter;
import loopz.showme.bean.Grocery;

public class SearchableActivity extends Activity {

    private SearchView searchBar;
    private TextView empty;
    private ListView resultList;
    private SearchListAdapter adapter;
    private Context context;

    private final String ITEM = "ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_search_result);

        initView();

        resultList.setOnItemClickListener(new ListView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(context, ItemInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(ITEM, (Grocery) adapter.getItem(position));
                intent.putExtras(bundle);

                startActivity(intent);
            }

        });

        // Get the intent, verify the action and get the query
        handleIntent(getIntent());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    private void initView() {
        searchBar  = (SearchView) findViewById(R.id.searchBar);
        resultList = (ListView)   findViewById(R.id.search_result_list);
        empty      = (TextView)   findViewById(R.id.empty_list);
        adapter    = new SearchListAdapter(this);
        resultList.setAdapter(adapter);
        resultList.setEmptyView(empty);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            searchBar.setQuery(query, false);
            Log.d("loopz", "query= " + query);
            doSearch(query);
        }
    }

    private void doSearch(String query) {
        // call async task to do search
    }
}
