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

public class AddRecycleAdapter extends RecyclerView.Adapter<AddRecycleAdapter.Myviewholder> {



    private ImageView img;
    private TextView textView;
    onCatClick2 onCatClick2;
    private ArrayList<AddRecycleThings> list = new ArrayList<>();
    public AddRecycleAdapter(onCatClick2 onCatClick2){
        list.add(new AddRecycleThings(R.drawable.ic_cat_food , "food"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_education , "education"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_clothes , "cloths"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_shopping , "shopping"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_entertainment , "entertainment"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_beauty , "beauty"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_health , "health"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_sports , "sports"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_car , "car"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_maintaince , "maintenance"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_travel , "travel"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_gift , "gifts"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_personal , "personal"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_loan , "loan"));
        list.add(new AddRecycleThings(R.drawable.ic_cat_entertainment , "miscellaneous"));
        this.onCatClick2 = onCatClick2;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.add_recycle_layout , parent , false);
        return new Myviewholder(v , onCatClick2 , list.size());
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
        onCatClick2 onCatClick2;
        CardView cardView;
        int size;
        public Myviewholder(@NonNull View itemView , onCatClick2 onCatClick , int size) {
            super(itemView);
            img = itemView.findViewById(R.id.recycle_layout_image);
            textView  = itemView.findViewById(R.id.recycle_layout_text);
            this.onCatClick2 = onCatClick2;
            itemView.setOnClickListener(this);
            cardView = itemView.findViewById(R.id.recycle_layout_card);
            this.size = size;
        }

        @Override
        public void onClick(View v) {
            onCatClick2.onCatClicked2(getAdapterPosition());
            System.out.println("clicked" + getAdapterPosition());
            cardView.setCardBackgroundColor(Color.parseColor("#e0e0e0"));


        }
    }
    public interface onCatClick2{
        void onCatClicked2(int position);
    }
}
