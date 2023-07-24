package COM.TQC.GDD01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HippoCustomRecyclerViewAdapter extends RecyclerView.Adapter<HippoCustomRecyclerViewAdapter.ViewHolder>
{
    public static boolean bIfDebug = true;
    public static String TAG = "HIPPO_DEBUG";
    private static Context mContext;
    private ArrayList<Food> mDataSet = new ArrayList<Food>();

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView textView;
        private final ImageView imageView;

        public ViewHolder(View view)
        {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String pos = view.getTag().toString();
                    String msg = String.format("你點選的是%s個東西",pos);
                    Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
                }
            });

            textView = (TextView) view.findViewById(R.id.text_row_item_textView1);
            imageView = (ImageView) view.findViewById(R.id.text_row_item_imageView1);
        }

        public TextView getTextView()
        {
            return textView;
        }

        public ImageView getImageView()
        {
            return imageView;
        }
    }

    // Constructor
    public HippoCustomRecyclerViewAdapter(Context context, ArrayList<Food> mDataSet)
    {
        this.mContext = context;
        this.mDataSet = mDataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_row, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        viewHolder.itemView.setTag(""+position);
        Food food = mDataSet.get(position);
        viewHolder.textView.setText(food.getmName());
        viewHolder.imageView.setImageResource(food.getmThumbnial());
    }

    @Override
    public int getItemCount()
    {
        return mDataSet.size();
    }
}