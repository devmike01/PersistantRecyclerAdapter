package com.jadebyte.devmike.persistantrecycleradapter.sample.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DevMike on 4/12/2018.
 */

public class RecyclerItems<T extends Serializable> implements Serializable {

    public RecyclerItems(){}

    public void add(Serializable s){
        List<Serializable> list = new ArrayList<>();
        list.add(s);
    }
}
