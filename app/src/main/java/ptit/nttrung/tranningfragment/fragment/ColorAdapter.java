package ptit.nttrung.tranningfragment.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by TrungNguyen on 10/2/2017.
 */

class ColorAdapter extends BaseAdapter {

    public ColorAdapter() { }

    public int getCount() {
        return OneFragment.COL_NAMES.length;
    }

    public Object getItem(int position) {
        return OneFragment.COLOURS[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView text = (TextView) convertView;
        text.setText(OneFragment.COL_NAMES[position]);
        text.setTextColor(OneFragment.COLOURS[position]);
        return convertView;
    }

}