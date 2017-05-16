package com.example.arash.saeedidairy.Cheese;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arash.saeedidairy.ProductPages.MilkPages.CheeseCheesFat;
import com.example.arash.saeedidairy.ProductPages.MilkPages.CheeseFullFat;
import com.example.arash.saeedidairy.ProductPages.MilkPages.CheeseLawFat;
import com.example.arash.saeedidairy.ProductPages.MilkPages.MilkCheesFat;
import com.example.arash.saeedidairy.ProductPages.MilkPages.MilkFullFat;
import com.example.arash.saeedidairy.ProductPages.MilkPages.MilkLowFat;
import com.example.arash.saeedidairy.R;

import java.util.List;

/**
 * Created by Arash on 4/18/2017.
 */

public class CheeseRecyclerAdapter extends RecyclerView.Adapter<CheeseRecyclerAdapter.cheeseVhiewHolder>{


    private  Context context;
    List<Cheese>cheeseList;
    public CheeseRecyclerAdapter(Context context , List<Cheese>list){

        this.cheeseList=list;
        this.context=context;

    }
    @Override
    public cheeseVhiewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View Cheese_View= LayoutInflater.from(parent.getContext()).inflate(R.layout.cheese_item,parent,false);
        return new cheeseVhiewHolder(Cheese_View);
    }

    @Override
    public void onBindViewHolder(cheeseVhiewHolder holder, final int position) {
        Cheese cheese = cheeseList.get(position);
        holder.cheese_image_item.setImageResource(cheese.image);
        holder.cheese_name_item.setText(cheese.name);
        holder.liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (position==0){
//                    Intent intent = new Intent(context , CheeseLawFat.class);
//                    context.startActivity(intent);
//
//                }else if (position==1){
//                    Intent intent = new Intent(context , CheeseCheesFat.class);
//                    context.startActivity(intent);
//
//                }else if (position==2){
//                    Intent intent = new Intent(context , CheeseFullFat.class);
//                    context.startActivity(intent);
//
//                }

                if(position==0){
                    Intent claw = new Intent(view.getContext() , CheeseLawFat.class);
                    view.getContext().startActivity(claw);
                }else if (position==1){
                    Intent cchees = new Intent(view.getContext() , CheeseCheesFat.class);
                    view.getContext().startActivity(cchees);

                }else if (position==2){
                    Intent cfull = new Intent(view.getContext() , CheeseFullFat.class);
                    view.getContext().startActivity(cfull);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return cheeseList.size();
    }

    public class cheeseVhiewHolder extends RecyclerView.ViewHolder {
        TextView cheese_name_item;
        ImageView cheese_image_item;
        LinearLayout liner;
        public cheeseVhiewHolder(View itemView) {
            super(itemView);
            cheese_name_item=(TextView)itemView.findViewById(R.id.cheese_name_item);
            cheese_image_item=(ImageView)itemView.findViewById(R.id.cheese_image_item);
            liner=(LinearLayout)itemView.findViewById(R.id.liner);
        }
    }
}
