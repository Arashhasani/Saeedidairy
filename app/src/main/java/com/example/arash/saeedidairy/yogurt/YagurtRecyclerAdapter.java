package com.example.arash.saeedidairy.yogurt;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arash.saeedidairy.ProductPages.MilkPages.YagurtCheesFat;
import com.example.arash.saeedidairy.ProductPages.MilkPages.YagurtFullFat;
import com.example.arash.saeedidairy.ProductPages.MilkPages.YagurtLawFat;
import com.example.arash.saeedidairy.R;

import java.util.List;

/**
 * Created by Arash on 5/15/2017.
 */

public class YagurtRecyclerAdapter extends RecyclerView.Adapter<YagurtRecyclerAdapter.YagurtViewHolder>{
    private Context context;
    List<Yogurt>yogurts;

    public YagurtRecyclerAdapter(Context context , List<Yogurt>list){
        this.yogurts=list;
        this.context=context;

    }


    @Override
    public YagurtViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View YagurtView = LayoutInflater.from(parent.getContext()).inflate(R.layout.yogurt_item,parent,false);

        return new YagurtViewHolder(YagurtView);
    }

    @Override
    public void onBindViewHolder(YagurtViewHolder holder, final int position) {
        Yogurt dough = yogurts.get(position);
        holder.yogurt_image_item.setImageResource(dough.image);
        holder.yogurt_name_item.setText(dough.name);
        holder.liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==0){
                    Intent ylaw = new Intent(view.getContext(), YagurtLawFat.class);
                    view.getContext().startActivity(ylaw);

                }else if (position==1){
                    Intent ychees = new Intent(view.getContext(), YagurtCheesFat.class);
                    view.getContext().startActivity(ychees);

                }else if (position==2){
                    Intent yfull = new Intent(view.getContext(), YagurtFullFat.class);
                    view.getContext().startActivity(yfull);

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return yogurts.size();
    }

    public class YagurtViewHolder extends RecyclerView.ViewHolder {
        TextView yogurt_name_item;
        ImageView yogurt_image_item;
        LinearLayout liner;


        public YagurtViewHolder(View itemView) {
            super(itemView);

            yogurt_name_item=(TextView)itemView.findViewById(R.id.yogurt_name_item);
            yogurt_image_item=(ImageView)itemView.findViewById(R.id.yogurt_image_item);
            liner=(LinearLayout)itemView.findViewById(R.id.liner);
        }
    }

}
