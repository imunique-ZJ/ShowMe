package loopz.showme;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import loopz.showme.adapter.CommentAdapter;
import loopz.showme.bean.Grocery;

public class ItemInfoActivity extends Activity implements ListView.OnScrollListener {
    private CommentAdapter mAdapter;
    private ImageView itemImage;
    private TextView manufacturerTV;
    private TextView descriptionTV;
    private TextView empty;
    private ListView comments;

    private final String ITEM_ID = "ID";
    private final String ITEM = "ITEM";
    private Grocery grocery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

        Bundle bundle = getIntent().getExtras();
        grocery = (Grocery) bundle.getSerializable(ITEM);

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

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }

    private void initView() {
        itemImage = (ImageView) findViewById(R.id.item_image);
        manufacturerTV = (TextView) findViewById(R.id.manufacturer);
        descriptionTV  = (TextView) findViewById(R.id.description);
        comments  = (ListView)  findViewById(R.id.comments);
        empty     = (TextView)  findViewById(R.id.empty_list);
        mAdapter  = new CommentAdapter(this);
        comments.setAdapter(mAdapter);
        comments.setEmptyView(empty);
    }

    private void setUp() {
        // show image
        // grocery.getImg();
        itemImage.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));

        manufacturerTV.setText(grocery.getManufacturer());
        descriptionTV .setText(grocery.getDescription());

        // show comments
        mAdapter.setDataList(grocery.getComments());
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem + visibleItemCount == totalItemCount) {
            // async task to get data from server
        }
    }
}
