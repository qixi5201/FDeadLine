package COM.TQC.GDD01;

import android.app.AlertDialog;
import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myView extends RecyclerView.Adapter<myView.ViewHolder>
{
    private static Context mContext;
    private ArrayList<Deal> mDataSet = new ArrayList<Deal>();

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView textView,textview2,textview3,textview4;
        private final ImageView imageView;
        private final Button btn;
        public ViewHolder(View view)
        {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String pos=view.getTag().toString();
                    String msg="XX市XX區XX街XXX巷";
                    Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
                }
            });
            textView = (TextView) view.findViewById(R.id.text_row_item_textView1);
            textview2 = (TextView) view.findViewById(R.id.text_row_item_textView2);
            textview3 = (TextView) view.findViewById(R.id.text_row_item_textView3);
            textview4 = (TextView) view.findViewById(R.id.text_row_item_textView4);
            imageView = (ImageView) view.findViewById(R.id.text_row_item_imageView1);
            btn=view.findViewById(R.id.buy);

        }

    }

    // Constructor
    public myView(Context context, ArrayList<Deal> mDataSet)
    {
        this.mContext = context;
        this.mDataSet = mDataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_row_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position)
    {
        viewHolder.itemView.setTag(position+"");
        Deal deal =mDataSet.get(position);
        viewHolder.textView.setText(deal.getName());
        viewHolder.textview2.setText(deal.getPrice());
        viewHolder.textview3.setText(deal.getDistance());
        viewHolder.textview4.setText(deal.getTime());
        viewHolder.imageView.setImageResource(deal.getThumbnail());
        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),Bill.class);
                Bundle bundle =new Bundle();
                bundle.putString("price",viewHolder.textview2.getText()+"");
                bundle.putString("goods",viewHolder.textView.getText()+"");
                intent.putExtra("data",bundle);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mDataSet.size();
    }
}
