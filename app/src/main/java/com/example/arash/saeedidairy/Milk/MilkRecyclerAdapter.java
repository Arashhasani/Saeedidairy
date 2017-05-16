package com.example.arash.saeedidairy.Milk;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arash.saeedidairy.ProductPages.MilkPages.MilkCheesFat;
import com.example.arash.saeedidairy.ProductPages.MilkPages.MilkFullFat;
import com.example.arash.saeedidairy.ProductPages.MilkPages.MilkLowFat;
import com.example.arash.saeedidairy.R;

import java.util.List;

/**
 * Created by Arash on 5/15/2017.
 */

public class MilkRecyclerAdapter extends RecyclerView.Adapter<MilkRecyclerAdapter.MilkViewHolder>{
    private Context context;
    List<Milk>milks;

    public MilkRecyclerAdapter(Context context , List<Milk>list){
        this.milks=list;
        this.context=context;

    }


    @Override
    public MilkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View DoughView = LayoutInflater.from(parent.getContext()).inflate(R.layout.milk_item,parent,false);

        return new MilkViewHolder(DoughView);
    }

    @Override
    public void onBindViewHolder(MilkViewHolder holder, final int position) {
        Milk dough = milks.get(position);
        holder.milk_image_item.setImageResource(dough.image);
        holder.milk_name_item.setText(dough.name);
        holder.liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==0){
                    Intent mlaw = new Intent(view.getContext() , MilkLowFat.class);
                    view.getContext().startActivity(mlaw);

                }else if (position==1){
                    Intent mchees = new Intent(view.getContext() , MilkCheesFat.class);
                    view.getContext().startActivity(mchees);

                }else if (position==2){
                    Intent mfull = new Intent(view.getContext() , MilkFullFat.class);
                    view.getContext().startActivity(mfull);

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return milks.size();
    }

    public class MilkViewHolder extends RecyclerView.ViewHolder {
        TextView milk_name_item;
        ImageView milk_image_item;
        LinearLayout liner;


        public MilkViewHolder(View itemView) {
            super(itemView);

            milk_name_item=(TextView)itemView.findViewById(R.id.milk_name_item);
            milk_image_item=(ImageView)itemView.findViewById(R.id.milk_image_item);
            liner=(LinearLayout)itemView.findViewById(R.id.liner);
        }
    }

}
