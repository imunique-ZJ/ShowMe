package loopz.showme;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;
import loopz.showme.adapter.SearchListAdapter;

public class SearchableActivity extends Activity {

    private SearchView searchBar;
    private SearchListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        initView();

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
        searchBar = (SearchView) findViewById(R.id.searchBar);
        adapter = new SearchListAdapter(this);
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
