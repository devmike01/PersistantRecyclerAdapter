package com.jadebyte.devmike.persistantrecycleradapter.library;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by DevMike on 4/12/2018.
 */

public abstract class PersistentRecyclerAdapter<T extends Parcelable, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements Parcelable {

    private Parcelable[] data;
    private List<T> list;
    private PersistentRecyclerAdapter recyclerView;

    public void setData(Parcelable[] data) {
        this.data = data;
    }

    public Parcelable[] getItemData() {
        return data;
    }


    protected PersistentRecyclerAdapter(List<T> parcelableList) {
        this.list = parcelableList;
    }


    public abstract void onBindViewHolder(@NonNull VH holder, int position, T data);


    public final Creator<PersistentRecyclerAdapter> CREATOR = new Creator<PersistentRecyclerAdapter>() {
        @Override
        public PersistentRecyclerAdapter createFromParcel(Parcel in) {
            PersistentRecyclerAdapter recyclerView = PersistentRecyclerAdapter.this;
            recyclerView.data = in.readParcelableArray(PersistentRecyclerAdapter.this.getClass().getClassLoader());
            return recyclerView;
        }

        @Override
        public PersistentRecyclerAdapter[] newArray(int size) {
            return new PersistentRecyclerAdapter[size];
        }
    };


    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        T data = list.get(position);
        setData(list.toArray(new Parcelable[]{}));
        onBindViewHolder(holder, position, data);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelableArray(this.data, 0);
    }

    public LinearLayoutManager getLinearLayoutManager(Context context){
        return new LinearLayoutManager(context);
    }

    public GridLayoutManager getGridLayoutManager(Context context, int spanCount){
        return new GridLayoutManager(context, spanCount);
    }

    public StaggeredGridLayoutManager getStaggeredGridLayout(int spanCount, int orientation){
        return new StaggeredGridLayoutManager(spanCount, orientation);
    }

    public class LinearLayoutManager extends android.support.v7.widget.LinearLayoutManager {

        public LinearLayoutManager(Context context) {
            super(context);
        }


        @Override
        public Parcelable onSaveInstanceState() {
            return PersistentRecyclerAdapter.this;
        }


        @Override
        public void onRestoreInstanceState(Parcelable parcelable) {
            if (parcelable != null) {
                for (Parcelable items : ((PersistentRecyclerAdapter) parcelable).getItemData()) {
                    Collection<T> col = new ArrayList<>();
                    T repo1 = (T) items;
                    col.add(repo1);
                    list.addAll(col);
                }
            }
        }

    }


    public class GridLayoutManager extends android.support.v7.widget.GridLayoutManager {


        public GridLayoutManager(Context context, int spanCount) {
            super(context, spanCount);
        }

        @Override
        public Parcelable onSaveInstanceState() {
            return PersistentRecyclerAdapter.this;
        }


        @Override
        public void onRestoreInstanceState(Parcelable parcelable) {
            if (parcelable != null) {
                for (Parcelable items : ((PersistentRecyclerAdapter) parcelable).getItemData()) {
                    Collection<T> col = new ArrayList<>();
                    T repo1 = (T) items;
                    col.add(repo1);
                    list.addAll(col);
                }
            }
        }

    }


    public class StaggeredGridLayoutManager extends android.support.v7.widget.StaggeredGridLayoutManager {


        public StaggeredGridLayoutManager(int spanCount, int orientation) {
            super(spanCount, orientation);
        }

        @Override
        public Parcelable onSaveInstanceState() {
            return PersistentRecyclerAdapter.this;
        }


        @Override
        public void onRestoreInstanceState(Parcelable parcelable) {
            if (parcelable != null) {
                for (Parcelable items : ((PersistentRecyclerAdapter) parcelable).getItemData()) {
                    Collection<T> col = new ArrayList<>();
                    T repo1 = (T) items;
                    col.add(repo1);
                    list.addAll(col);
                }
            }
        }

    }

}
