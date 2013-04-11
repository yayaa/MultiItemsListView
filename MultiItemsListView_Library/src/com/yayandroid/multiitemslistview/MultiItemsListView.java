package com.yayandroid.multiitemslistview;

/**
 * @author Yahya BAYRAMOÐLU
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MultiItemsListView extends ListView {
	
	/**
	 * Interface to set a custom type enumeration
	 * 
	 * @author y.bayramoglu
	 *
	 */
	public interface RowTypes {
	}

	/**
	 * Private listener to deliver item info including type
	 */
	private MultiItemsClickListener onMultiItemsClickListener;

	/**
	 * Interface to handle onItemClick for different type items
	 * 
	 * @author y.bayramoglu
	 *
	 */
	public interface MultiItemsClickListener {
		public void onMultiItemsClick(AdapterView<?> parent, View view,
				int position, long id, RowTypes type);
	} 

	public MultiItemsListView(Context context) {
		super(context);
		Configure();
	}

	public MultiItemsListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		Configure();
	}

	public MultiItemsListView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		Configure();
	}

	private void Configure() {
		
		setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				if (getOnMultiItemsClickListener() != null && getAdapter() != null)
					getOnMultiItemsClickListener().onMultiItemsClick(
							parent, view, position, id,
							GetTypeForPosition(position));
			}

		});
	}
	
	/**
	 * Get given item's type as in enumeration
	 * 
	 * @param position
	 * @return RowTypes: current item's type
	 */
	private RowTypes GetTypeForPosition(int position) { 
		return ((ListItem) getAdapter().getItem(position)).getRowType();
	}

	public MultiItemsClickListener getOnMultiItemsClickListener() {
		return onMultiItemsClickListener;
	}

	public void setOnMultiItemsClickListener(
			MultiItemsClickListener onItemClickListener) {
		this.onMultiItemsClickListener = onItemClickListener;
	}

}
