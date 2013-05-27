package loopz.showme;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ItemInfoActivity extends Activity {
    private BaseAdapter mAdapter;
    private ImageView itemImage;
    private ListView comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

        initView();
        setUp();

        getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void initView() {
        itemImage = (ImageView) findViewById(R.id.item_image);
        comments  = (ListView)  findViewById(R.id.comments);
    }

    private void setUp() {
        comments.setAdapter(mAdapter);
    }
}
