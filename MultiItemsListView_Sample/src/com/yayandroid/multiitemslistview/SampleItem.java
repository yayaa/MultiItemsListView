package com.yayandroid.multiitemslistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yayandroid.multiitemslistview.MultiItemsListView.RowTypes;

public class SampleItem extends ListItem {

	/**
	 * This method is needed to set single type list item 
	 * No need to do anything here
	 */
	public SampleItem(int layoutId) {
		super(layoutId); 
	}

	/**
	 * This method is needed to set multi type list items 
	 * No need to do anything here
	 */
	public SampleItem(RowTypes type, int layoutId) {
		super(type, layoutId); 
	}

	@Override
	public View getView(LayoutInflater inflater, ViewGroup parent, View convertView) {

		if(convertView == null)
			convertView = inflater.inflate(getLayoutId(), parent, false); 
		
		/** Handle with data here up to layout */
		if (getData() != null && convertView != null) {
			DataItem item = (DataItem) getData();
			TextView tv1, tv2, tv3;
			
			switch (getLayoutId()) {
			case R.layout.sample_item1:
				tv1 = (TextView) convertView.findViewById(R.id.text1);
				tv1.setText(item.data1);

				tv2 = (TextView) convertView.findViewById(R.id.text2);
				tv2.setText(item.data2);
				break;
			case R.layout.sample_item2:
				tv1 = (TextView) convertView.findViewById(R.id.text1);
				tv1.setText(item.data1);
				break;
			case R.layout.sample_item3:
				tv1 = (TextView) convertView.findViewById(R.id.text1);
				tv1.setText(item.data1);
				
				tv2 = (TextView) convertView.findViewById(R.id.text2);
				tv2.setText(item.data2);
				
				tv3 = (TextView) convertView.findViewById(R.id.text3);
				tv3.setText(item.data3);
				break;
			}
			
		}
		
		return convertView;
		
	}

}
