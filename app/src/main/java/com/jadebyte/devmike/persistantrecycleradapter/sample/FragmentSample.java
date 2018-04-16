package com.jadebyte.devmike.persistantrecycleradapter.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jadebyte.devmike.persistantrecycleradapter.R;
import com.jadebyte.devmike.persistantrecycleradapter.models.SampleItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DevMike on 4/13/2018.
 */

public class FragmentSample extends Fragment {

    private List<SampleItems> data = new ArrayList<>();
    private static final String SAVED_POSITION ="SOMESVAEDPOSITIIN";
    private LinearLayoutManager lm;
    private GridLayoutManager gridLayout;

    @Override
    public void onCreate(Bundle savedState){
        super.onCreate(savedState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedState){
        View view = inflater.inflate(R.layout.sample_layout, parent, false);
        //RecyclerView rv = view.findViewById(R.id.recycle);
        RecyclerView gridView = view.findViewById(R.id.recycler_grid);
        final SampleAdapter a = new SampleAdapter(data);

        //Initialize your recyclerview data
        gridLayout = a.getGridLayoutManager(getActivity(), 3);
        gridView.setLayoutManager(gridLayout);
        gridView.setHasFixedSize(true);
        gridView.setAdapter(a);

       if (savedState == null){
           for (int i =0; i <200; i++){
               SampleItems item = new SampleItems();
               item.setStr(String.valueOf(i));
               data.add(item);
               a.notifyDataSetChanged();
           }
       }else{
           gridLayout.scrollToPosition(savedState.getInt(SAVED_POSITION));
       }

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle savedState){
        super.onSaveInstanceState(savedState);
        savedState.putInt(SAVED_POSITION, gridLayout.findFirstCompletelyVisibleItemPosition());
    }
}
