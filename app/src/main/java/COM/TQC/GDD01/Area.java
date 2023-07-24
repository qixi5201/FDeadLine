package COM.TQC.GDD01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;


public class Area extends AppCompatActivity
{
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 5;
    protected RecyclerView mRecyclerView;
    protected myView mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected ArrayList<Deal> mDataset = new ArrayList<>();
    protected LayoutManagerType mCurrentLayoutManagerType;

    private enum LayoutManagerType
    {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sell);
        initDataset();
        initRecycleView(savedInstanceState);
    }

    private void initDataset()
    {
        mDataset = new ArrayList<Deal>();
        for (int i = 0; i < DATASET_COUNT; i++)
        {
            Deal deal = new Deal();
            deal.setGoods("食物#"+i);
            deal.setPrice("$"+100*(i+1));
            deal.setDistance(0.5*(i+1)+"km");
            deal.setTime(3*(i+1)+"min");
            deal.setThumbnail(R.mipmap.ic_launcher);

            mDataset.add(deal);
        }
    }

    private void initRecycleView(Bundle savedInstanceState)
    {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(Area.this);
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        if (savedInstanceState != null)
        {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState.getSerializable("EXTRA_KEY_LAYOUT_MANAGER");
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        //  動態載入自定義之 HippoCustomRecyclerViewAdapter 物件mAdapter，包含自訂UI text_row_item.xml。
        mAdapter=new myView(Area.this,mDataset);
        mRecyclerView.setAdapter(mAdapter);
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
                mLayoutManager = new GridLayoutManager(Area.this, SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(Area.this);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(Area.this);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }
}
