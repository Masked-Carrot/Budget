package com.carrot.budget.recycleviewAdapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.carrot.budget.R;

import java.util.ArrayList;

public class AddRecycleAdapter2 extends RecyclerView.Adapter<AddRecycleAdapter2.Myviewholder> {



    private ImageView img;
    private TextView textView;
    onCatClick onCatClick;
    private ArrayList<AddRecycleThings> list = new ArrayList<>();
    public AddRecycleAdapter2(onCatClick onCatClick){
        list.add(new AddRecycleThings(R.drawable.ic_cat_income , "income"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_gift2 , "gifts"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_miscell2 , "miscellaneous"));
        this.onCatClick = onCatClick;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.add_recycle_layout , parent , false);
        return new Myviewholder(v , onCatClick);
    }



    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        holder.textView.setText(list.get(position).getName());
        holder.img.setImageResource(list.get(position).getIcon());
        holder.cardView.setCardBackgroundColor(Color.parseColor("#ffffff"));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView img;
        TextView textView;
        onCatClick onCatClick;
        CardView cardView;
        int size;
        public Myviewholder(@NonNull View itemView , onCatClick onCatClick) {
            super(itemView);
            img = itemView.findViewById(R.id.recycle_layout_image);
            textView  = itemView.findViewById(R.id.recycle_layout_text);
            this.onCatClick = onCatClick;
            itemView.setOnClickListener(this);
            cardView = itemView.findViewById(R.id.recycle_layout_card);
            this.size = size;
        }

        @Override
        public void onClick(View v) {
            onCatClick.onCatClicked(getAdapterPosition());
            System.out.println("clicked" + getAdapterPosition());
            cardView.setCardBackgroundColor(Color.parseColor("#e0e0e0"));


        }
    }
    public interface onCatClick{
        void onCatClicked(int position);
    }
}