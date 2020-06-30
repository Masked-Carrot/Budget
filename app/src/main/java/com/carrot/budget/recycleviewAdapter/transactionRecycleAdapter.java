package com.carrot.budget.recycleviewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carrot.budget.R;
import com.carrot.budget.database.MonthDetailsDAO;
import com.carrot.budget.database.MonthDetailsEntity;
import com.carrot.budget.database.Repository;
import com.carrot.budget.database.YearDetailsEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class transactionRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<MonthDetailsEntity> list = new ArrayList<>();
    private static Repository repository;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.transaction_recylce_layout , parent , false);
        return new RecyclerView.ViewHolder(v) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageView icon = holder.itemView.findViewById(R.id.transaction_recycle_image);
        TextView cat = holder.itemView.findViewById(R.id.transaction_recycle_cat);
        TextView amt = holder.itemView.findViewById(R.id.transaction_recycle_amt);
        String value = Double.toString(list.get(position).getAmount());
        System.out.println(list.get(position).getType2()+"===============================");
        if(list.get(position).getType1() == 1){
            switch (list.get(position).getType2()){
                case 0:
                    icon.setImageResource(R.drawable.ic_cat_income);
                    cat.setText("income");
                    break;
                case 1:
                    icon.setImageResource(R.drawable.ic_cat_gift2);
                    cat.setText("gift");
                    break;
                case 3:
                    icon.setImageResource(R.drawable.ic_cat_miscell2);
                    cat.setText("miscellaneous" );
                    break;
            }
        }
        if(list.get(position).getType1() == 2) {
            switch (list.get(position).getType2()) {
                case 0:
                    icon.setImageResource(R.drawable.ic_cat_food);
                    cat.setText("food");
                    break;
                case 1:
                    cat.setText("education");
                    icon.setImageResource(R.drawable.ic_cat_education);
                    break;
                case 2:
                    cat.setText("clothes");
                    icon.setImageResource(R.drawable.ic_cat_clothes);
                    break;
                case 3:
                    cat.setText("shopping");
                    icon.setImageResource(R.drawable.ic_cat_shopping);
                    break;
                case 4:
                    cat.setText("entertainment");
                    icon.setImageResource(R.drawable.ic_cat_entertainment);
                    break;
                case 5:
                    cat.setText("beauty");
                    icon.setImageResource(R.drawable.ic_cat_beauty);
                    break;
                case 6:
                    cat.setText("health");
                    icon.setImageResource(R.drawable.ic_cat_health);
                    break;
                case 7:
                    cat.setText("sports");
                    icon.setImageResource(R.drawable.ic_cat_sports);
                    break;
                case 8:
                    cat.setText("car");
                    icon.setImageResource(R.drawable.ic_cat_car);
                    break;
                case 9:
                    cat.setText("maintaince");
                    icon.setImageResource(R.drawable.ic_cat_maintaince);
                    break;
                case 10:
                    cat.setText("travel");
                    icon.setImageResource(R.drawable.ic_cat_travel);
                    break;
                case 11:
                    cat.setText("gift");
                    icon.setImageResource(R.drawable.ic_cat_gift);
                    break;
                case 12:
                    cat.setText("personal");
                    icon.setImageResource(R.drawable.ic_cat_personal);
                    break;
                case 13:
                    cat.setText("loan");
                    icon.setImageResource(R.drawable.ic_cat_loan);
                    cat.setText("Loan");
                    break;
                case 14:
                    cat.setText("miscellaneous");
                    icon.setImageResource(R.drawable.ic_cat_miscell);
                    break;
            }
        }
        amt.setText(value);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setTransaction(List<MonthDetailsEntity> list){
        this.list = list;
        notifyDataSetChanged();
    }


}
