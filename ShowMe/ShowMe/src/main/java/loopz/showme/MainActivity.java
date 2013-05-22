package loopz.showme;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class MainActivity extends Activity {

    private SearchView searchView;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setUpSearch();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void initView() {
        searchView = (SearchView) findViewById(R.id.searchBar);
        searchView.setSubmitButtonEnabled(true);
        btnSearch  = (Button) findViewById(R.id.searchBtn);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSearch();
            }
        });
    }

    private void setUpSearch() {
        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(
                new ComponentName(this, SearchableActivity.class)
        ));
    }

    private void doSearch() {
        Intent intent = new Intent(this, SearchableActivity.class);
        intent.setAction(Intent.ACTION_SEARCH);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(SearchManager.QUERY, searchView.getQuery().toString());
        startActivity(intent);
    }
    
}
