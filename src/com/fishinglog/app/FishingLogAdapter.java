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
		// �r���[���󂯎��
		View view = convertView;

		if (view == null) {
			// �󂯎�����r���[��null�Ȃ�V�����r���[�𐶐�
			view = inflater.inflate(R.layout.fishinglog_row, null);
			// �w�i�摜���Z�b�g����

		}
		// �\�����ׂ��f�[�^�̎擾

		FishingLogModel item = (FishingLogModel)items.get(position);
		if (item != null) {
			TextView screenName = (TextView)view.findViewById(R.id.toptext);
			screenName.setTypeface(Typeface.DEFAULT_BOLD);

			// �X�N���[���l�[�����r���[�ɃZ�b�g
			TextView text = (TextView)view.findViewById(R.id.bottomtext);
			if (screenName != null) {
				screenName.setText(item.getDate());
			}

			// �e�L�X�g���r���[�ɃZ�b�g
			if (text != null) {
				text.setText(item.getComment());
			}
		}
		return view;
	}

}
