package com.yayandroid.multiitemslistview;

/**
 * @author Yahya BAYRAMOGLU
 */

import java.util.ArrayList; 

import com.yayandroid.multiitemslistview.MultiItemsListView.MultiItemsClickListener;
import com.yayandroid.multiitemslistview.MultiItemsListView.RowTypes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

	private MultiItemsListView list;
	private MultiItemsListAdapter adapter;

	/**
	 * Enumeration to specify row types:
	 * Just give some types so that you could recognize the item 
	 * 	# Must implement RowTypes!
	 * 
	 * @author y.bayramoglu
	 * 
	 */
	public enum ItemTypes implements RowTypes {
		TYPE1, TYPE2, TYPE3
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		list = (MultiItemsListView) findViewById(R.id.list);
		CreateAdapter(1);

		// set an itemClickListener
		list.setOnMultiItemsClickListener(new MultiItemsClickListener() {
			@Override
			public void onMultiItemsClick(AdapterView<?> parent, View view,
					int position, long id, RowTypes type) {

				if (type != null)
					Toast.makeText(
							getApplicationContext(),
							"Type: " + type.toString() + ", Position: "
									+ position, Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(),
							"Position: " + position, Toast.LENGTH_SHORT).show();

			} 
		});
	}
	
	/** Sample method to create adapter and set its necessary methods */
	private void CreateAdapter(int count) {
		
		// create adapter
		if(count == 1) { 
			adapter = new MultiItemsListAdapter(this, GetSampleItemsForSingle());
		} else {
			adapter = new MultiItemsListAdapter(this, GetSampleItemsForMulti());
		}
		
		// set its typeCount, this is a MUST
		adapter.setRowTypeCount(count);
		
		// and set it to listView
		list.setAdapter(adapter);
		
	}
	
	/** Sample method to show how to arrange items for one type list item */
	public ArrayList<ListItem> GetSampleItemsForSingle() {
		ArrayList<ListItem> items = new ArrayList<ListItem>();

		for (int i = 0; i < 100; i++) {
			String value = "simpleItem " + i;
			SampleItem item = new SampleItem(R.layout.sample_item3);
			item.setData(new DataItem(value, value, value));
			items.add(item);
		}

		return items;
	}

	/** Sample method to show how to arrange multi type items */
	public ArrayList<ListItem> GetSampleItemsForMulti() {
		ArrayList<ListItem> items = new ArrayList<ListItem>();

		for (int i = 0; i < 100; i++) {
			String value = "multiItem " + i;
			SampleItem item = null;
			if (i % 3 == 0) {
				item = new SampleItem(ItemTypes.TYPE1, R.layout.sample_item1);
				item.setData(new DataItem(value, value));
			} else if (i % 5 == 0) {
				item = new SampleItem(ItemTypes.TYPE3, R.layout.sample_item3);
				item.setData(new DataItem(value, value, value));
			} else {
				item = new SampleItem(ItemTypes.TYPE2, R.layout.sample_item2);
				item.setData(new DataItem(value));
			}

			items.add(item);
		}

		return items;
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("MultiType");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getTitle().toString().equals("MultiType")) { 
			item.setTitle("Single");
			CreateAdapter(ItemTypes.values().length); 
		} else { 
			item.setTitle("MultiType"); 
			CreateAdapter(1); 
		}
		return true;
	}

}
