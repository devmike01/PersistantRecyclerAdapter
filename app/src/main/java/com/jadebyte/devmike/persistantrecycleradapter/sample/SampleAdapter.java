package com.jadebyte.devmike.persistantrecycleradapter.sample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jadebyte.devmike.persistantrecycleradapter.R;
import com.jadebyte.devmike.persistantrecycleradapter.sample.models.SampleItems;
import com.jadebyte.devmike.persistantrecycleradapter.library.PersistentRecyclerAdapter;

import java.util.List;

/**
 * Created by DevMike on 4/13/2018.
 */

public class SampleAdapter extends PersistentRecyclerAdapter<SampleItems, SampleAdapter.SampleViewHolder> {

    private List<SampleItems> itemsList;

    public SampleAdapter(List<SampleItems> serializedList) {
        super(serializedList);
        itemsList = serializedList;
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder holder, int position, SampleItems data) {
        holder.tv.setText(data.getStr());
    }

    @NonNull
    @Override
    public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_items_sample, parent, false);
        return new SampleViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public class SampleViewHolder extends RecyclerView.ViewHolder{

        TextView tv;
        public SampleViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.grid_text);
        }
    }
}
