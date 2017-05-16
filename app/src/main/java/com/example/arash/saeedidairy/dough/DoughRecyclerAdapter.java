package com.example.arash.saeedidairy.dough;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arash.saeedidairy.ProductPages.MilkPages.DoughCheesFat;
import com.example.arash.saeedidairy.ProductPages.MilkPages.DoughFullFat;
import com.example.arash.saeedidairy.ProductPages.MilkPages.DoughLawFat;
import com.example.arash.saeedidairy.R;

import java.util.List;

/**
 * Created by Arash on 5/15/2017.
 */

public class DoughRecyclerAdapter extends RecyclerView.Adapter<DoughRecyclerAdapter.DoughViewHolder>{
    private Context context;
    List<Dough>doughs;

    public DoughRecyclerAdapter(Context context , List<Dough>list){
        this.doughs=list;
        this.context=context;

    }


    @Override
    public DoughViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View DoughView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dough_item,parent,false);

        return new DoughViewHolder(DoughView);
    }

    @Override
    public void onBindViewHolder(DoughViewHolder holder, final int position) {
        Dough dough = doughs.get(position);
        holder.dough_image_item.setImageResource(dough.image);
        holder.dough_name_item.setText(dough.name);
        holder.liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==0){
                    Intent dlaw = new Intent(view.getContext(), DoughLawFat.class);
                    view.getContext().startActivity(dlaw);
                }else if (position==1){
                    Intent dchees = new Intent(view.getContext(), DoughCheesFat.class);
                    view.getContext().startActivity(dchees);
                }else if (position==2){
                    Intent dfull = new Intent(view.getContext(), DoughFullFat.class);
                    view.getContext().startActivity(dfull);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return doughs.size();
    }

    public class DoughViewHolder extends RecyclerView.ViewHolder {
        TextView dough_name_item;
        ImageView dough_image_item;
        LinearLayout liner;


        public DoughViewHolder(View itemView) {
            super(itemView);

            dough_name_item=(TextView)itemView.findViewById(R.id.dough_name_item);
            dough_image_item=(ImageView)itemView.findViewById(R.id.dough_image_item);
            liner=(LinearLayout)itemView.findViewById(R.id.liner);
        }
    }

}
