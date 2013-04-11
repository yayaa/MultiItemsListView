package com.yayandroid.multiitemslistview;

/**
 * @author Yahya BAYRAMOÐLU
 */

import java.util.ArrayList; 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class MultiItemsListAdapter extends ArrayAdapter<ListItem> {
	
	private int rowTypeCount = 1;
	private ArrayList<ListItem> items;
	private LayoutInflater inflater;

	public MultiItemsListAdapter(Context context, ArrayList<ListItem> objects) {
		super(context, '\0', objects);
		this.items = objects;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	} 
	
	public void setRowTypeCount(int count) {
		this.rowTypeCount = count;
	}
	
	@Override
    public int getViewTypeCount() {
        return rowTypeCount;
    }

	@Override
	public int getItemViewType(int position) {
		int type = items.get(position).getViewType();
		if (type != '\0')
			return type;
		else
			return super.getItemViewType(position);
	}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return items.get(position).getView(inflater, parent, convertView);
    }


}
