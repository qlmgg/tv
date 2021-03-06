package com.iptv.rocky.tcl;

import java.util.ArrayList;

import com.iptv.common.data.PortalLiveType;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class LiveTypeAdapter extends BaseAdapter {

	private Context mContext;
	private ArrayList<PortalLiveType> mDatas;
	
	public LiveTypeAdapter(Context context, ArrayList<PortalLiveType> datas) {
		this.mContext = context;
		this.mDatas = datas;
	}
	
	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LiveTypeItemData holder = null;
		if (convertView == null) {
			holder = new LiveTypeItemData();
			convertView = holder.getView(mContext);
			convertView.setTag(holder);
		} else {
			holder = (LiveTypeItemData)convertView.getTag();
			holder.destroy();
		}
		PortalLiveType data = mDatas.get(position);
		holder.initView(data);
		
		return convertView;
	}
	
}
