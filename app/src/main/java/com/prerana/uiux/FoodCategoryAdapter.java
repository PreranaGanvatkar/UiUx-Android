package com.prerana.uiux;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class FoodCategoryAdapter extends RecyclerView.Adapter<FoodCategoryAdapter.CategoryHolder> {

    List<FoodCategory>data;
    Context context;
    int selectedItemPos=0;
    OnCategoryClickedListner listner;

    public FoodCategoryAdapter(List<FoodCategory> data, Context context, OnCategoryClickedListner onCategoryClickedListner){
        this.data=data;
        this.context=context;
        this.listner=listner;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.category_view_holder,parent,false);
        return new CategoryHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        holder.img.setImageResource(data.get(position).getImage());
        holder.txtName.setText(data.get(position).getName());

        if (position==selectedItemPos){
            holder.txtName.setTextColor(context.getColor(R.color.Red));
            holder.img.setColorFilter(ContextCompat.getColor(context,R.color.Red), PorterDuff.Mode.SRC_IN);
            holder.cardCateogry.setOutlineAmbientShadowColor(context.getColor(R.color.Red));
            holder.cardCateogry.setOutlineSpotShadowColor(context.getColor(R.color.Red));
            holder.cardCateogry.setStrokeWidth(2);
        }
        else {
            holder.cardCateogry.setOutlineAmbientShadowColor(context.getColor(R.color.gray));
            holder.cardCateogry.setOutlineSpotShadowColor(context.getColor(R.color.gray));
            holder.cardCateogry.setStrokeWidth(0);
            holder.img.setColorFilter(ContextCompat.getColor(context,R.color.gray), PorterDuff.Mode.SRC_IN);
            holder.txtName.setTextColor(context.getColor(R.color.gray));
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class CategoryHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView img;
        MaterialCardView cardCateogry;


        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_title);
            img = itemView.findViewById(R.id.img_category);
            cardCateogry = itemView.findViewById(R.id.card_category);
            cardCateogry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedItemPos = getAdapterPosition();
                    if (listner!=null){
                        listner.onCategoryClick(getAdapterPosition());
                    }
                    notifyDataSetChanged();
                }
            });
        }
    }

    public interface OnCategoryClickedListner{
        void onCategoryClick(int position);
    }
}
