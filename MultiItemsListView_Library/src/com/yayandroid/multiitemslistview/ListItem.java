package com.yayandroid.multiitemslistview;

/**
 * @author Yahya BAYRAMOGLU
 */

import com.yayandroid.multiitemslistview.MultiItemsListView.RowTypes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListItem {

	private RowTypes rowType;
	private Object data;
	private int layoutId;

	public ListItem(int layoutId) {
		this.layoutId = layoutId;
	}

	public ListItem(RowTypes type, int layoutId) {
		this.layoutId = layoutId;
		this.rowType = type;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public int getLayoutId() {
		return layoutId;
	}

	public RowTypes getRowType() {
		return rowType;
	}

	public int getViewType() {
		if (rowType != null)
			return ((Enum<?>) rowType).ordinal();
		else
			return '\0';
	}

	// This method needs to be override
	public View getView(LayoutInflater inflater, ViewGroup parent, View convertView) {
		return convertView;
	}

}
