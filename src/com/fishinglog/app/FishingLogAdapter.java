package com.fishinglog.app;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FishingLogAdapter extends ArrayAdapter<FishingLogModel> {

	private ArrayList items;
	private LayoutInflater inflater;

	public FishingLogAdapter(Context context, int textViewResourceId, ArrayList items) {
		super(context, textViewResourceId, items);
		this.items = items;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// ビューを受け取る
		View view = convertView;

		if (view == null) {
			// 受け取ったビューがnullなら新しくビューを生成
			view = inflater.inflate(R.layout.fishinglog_row, null);
			// 背景画像をセットする

		}
		// 表示すべきデータの取得

		FishingLogModel item = (FishingLogModel)items.get(position);
		if (item != null) {
			TextView screenName = (TextView)view.findViewById(R.id.toptext);
			screenName.setTypeface(Typeface.DEFAULT_BOLD);

			// スクリーンネームをビューにセット
			TextView text = (TextView)view.findViewById(R.id.bottomtext);
			if (screenName != null) {
				screenName.setText(item.getDate());
			}

			// テキストをビューにセット
			if (text != null) {
				text.setText(item.getComment());
			}
		}
		return view;
	}

}
