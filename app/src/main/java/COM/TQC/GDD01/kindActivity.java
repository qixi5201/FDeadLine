package COM.TQC.GDD01;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class kindActivity extends AppCompatActivity {
    public static boolean bIfDebug = false;
    public static String TAG = "HIPPO_DEBUG";

    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;
    protected RecyclerView mRecyclerView;
    protected HippoCustomRecyclerViewAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected ArrayList<Food> mDataset = new ArrayList<>();
    protected LayoutManagerType mCurrentLayoutManagerType;
    private Button b,b2;
    private Intent intent;

    private enum LayoutManagerType
    {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kind_main);
        intent = this.getIntent();

        initDataset();
        initRecycleView(savedInstanceState);
        b=(Button)findViewById(R.id.button7);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kindActivity.this.finish();
            }
        });
        b2=(Button)findViewById(R.id.button8);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(kindActivity.this,kind1Activity.class);
                startActivity(intent1);
            }
        });

    }

    private void initDataset()
    {
        mDataset = new ArrayList<Food>();
        for (int i=0 ; i < DATASET_COUNT; i++)
        {
            Food food = new Food();
            if(i % 2 ==0){
                food.setmName("螃蟹");
                food.setmThumbnial(R.drawable.clab);

            }else{
                food.setmName("魚");
                food.setmThumbnial(R.drawable.fish);

            }
            mDataset.add(food);
        }
    }
    private void initRecycleView(Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(kindActivity.this);
        //  動態載入自定義之 HippoCustomRecyclerViewAdapter 物件mAdapter，包含自訂UI text_row_item.xml。
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        if (savedInstanceState != null)
        {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState.getSerializable(Constants.EXTRA_KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);
        mAdapter = new HippoCustomRecyclerViewAdapter(kindActivity.this, mDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putSerializable(Constants.EXTRA_KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(outState);
    }

    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType)
    {
        int scrollPosition = 0;
        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null)
        {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType)
        {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(kindActivity.this, SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(kindActivity.this);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(kindActivity.this);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }
}





