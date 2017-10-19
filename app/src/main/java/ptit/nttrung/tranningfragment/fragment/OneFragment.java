package ptit.nttrung.tranningfragment.fragment;


import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ptit.nttrung.tranningfragment.R;
import ptit.nttrung.tranningfragment.callback.OnListViewItemClickListener;



/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment implements AdapterView.OnItemClickListener{

    public static final int[] COLOURS = {
            Color.parseColor("#F44336"),
            Color.parseColor("#FF9800"),
            Color.parseColor("#FFEB3B"),
            Color.parseColor("#4CAF50"),
            Color.parseColor("#2196F3"),
            Color.parseColor("#3F51B5"),
            Color.parseColor("#9C27B0")
    };

    public static final String[] COL_NAMES = {
            "Đỏ",
            "Cam",
            "Vàng",
            "Lục",
            "Lam",
            "Chàm",
            "Tím"
    };

    private OnListViewItemClickListener mListener;

    public OneFragment() {
    }

    public static OneFragment newInstance(){
        return new OneFragment();
    }

    public static OneFragment newInstance(Uri param1, int param2, ArrayList<String> param3) {
        OneFragment fragment = new OneFragment();
//        Bundle args = new Bundle();
//
//        args.putInt("Int", param2);
//        args.putStringArrayList("StringArrayList", param3);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnListViewItemClickListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_one, container, false);
        ListView lv = (ListView) contentView.findViewById(R.id.listView);

        lv.setOnItemClickListener(this);
        ColorAdapter a = new ColorAdapter();
        lv.setAdapter(a);
        return contentView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        mListener.onItemClick(position);
    }

}
