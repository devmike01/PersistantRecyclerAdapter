# PersistantRecyclerAdapter
PersistantRecyclerAdapter is a simple, lite weight android library that persists data across fragment or activity recretion

<h2>How To Use PersistantRecyclerAdapter</h2>
<b>1.</b> Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
<b> 2.</b> Add Dependecy

  	dependencies {
	        compile 'com.github.devmike01:PersistantRecyclerAdapter:-SNAPSHOT'
	}


<h2>PersistantRecyclerAdapter Example</h2>
Create a class in your project and extends PersistentRecyclerAdapter<Percelable, RecyclerView.ViewHolder>
Like this

Extends parcelable in your model class. For example:

Now everything is set. Ititialize your RecyclerView as you'd normally do in your Activity/Fragment class, and implement the reycler layout like the code sippet below:

<h3>For GridLayoutManager</h3>

<h3>For LinearLayoutManager</h3>

To prevent the recyclerview from showing duplicate items, always clear your list data when you don't longer need it again. Also, If you have any issue implementing this library, simply open use the issue section, I'd respond as soon as possible. 
