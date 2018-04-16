# PersistantRecyclerAdapter
PersistantRecyclerAdapter is a simple, lite weight android library that persists data across fragment or activity recretion

<h2>How To Use PersistantRecyclerAdapter</h2>
<b>1.</b> Add it in your root build.gradle at the end of repositories:
<pre>
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}</pre>
  
<b> 2.<b> Add Dependecy
  <pre>
  	dependencies {
	        compile 'com.github.devmike01:PersistantRecyclerAdapter:-SNAPSHOT'
	}
  </pre>

<h2>PersistantRecyclerAdapter Example</h2>
Create a class in your project and extends <pre>PersistentRecyclerAdapter<Percelable, RecyclerView.ViewHolder><pre>
Like this

public class SampleAdapter extends PersistentRecyclerAdapter<SampleItems, SampleAdapter.SampleViewHolder> {

    private List<SampleItems> itemsList; //Initialize an empty parcelable list

    //Create constructor with a parcelable list
    public SampleAdapter(List<SampleItems> pList) {
        super(serializedList);
        itemsList = pList; //Get the data parcelable list here
    }

    //Override persistant recyclerview here
    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder holder, int position, SampleItems data) {
        holder.tv.setText(data.getStr()); //Show your data here
    }

  //Implement normal onCreateViewHolder
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


    //Create your viewholder
    public class SampleViewHolder extends RecyclerView.ViewHolder{

        TextView tv;
        public SampleViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.grid_text);
        }
    }
}

Extends parcelable in your model class. For example:

<pre>
public class SampleItems implements Parcelable{

    private String str;

    public SampleItems() {
    }

    public static final Creator<SampleItems> CREATOR = new Creator<SampleItems>() {
        @Override
        public SampleItems createFromParcel(Parcel in) {
            SampleItems items = new SampleItems();
            items.str = in.readString();
            return items;
        }

        @Override
        public SampleItems[] newArray(int size) {
            return new SampleItems[size];
        }
    };

    public void setStr(String s){
        str =s;
    }

    public String getStr(){
        return str;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(str);
    }
}
</pre>

Now everything is set. Ititialize your RecyclerView as you'd normally do in your Activity/Fragment class, and implement the reycler layout like the code sippet below:

<h3>For GridLayoutManager</h3>
<pre>
  //Initialize your recyclerview data
        GridLayoutManager gridLayout = a.getGridLayoutManager(getActivity(), 3);
        gridView.setLayoutManager(gridLayout);
        gridView.setHasFixedSize(true);
        gridView.setAdapter(a);
</pre>
<BR/>
<h3>For LinearLayoutManager</h3>
<pre>
GridLayoutManager gridLayout = a.getGridLayoutManager(getActivity(), 3);
        gridView.setLayoutManager(gridLayout);
        gridView.setHasFixedSize(true);
        gridView.setAdapter(a);
</pre>
To prevent the recyclerview from showing duplicate items, always clear your list data when you don't longer need it again. Also, If you have any issue implementing this library, simply open use the issue section, I'd respond as soon as possible. 
