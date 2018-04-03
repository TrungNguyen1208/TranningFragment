package ptit.nttrung.tranningfragment.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ptit.nttrung.tranningfragment.R;
import ptit.nttrung.tranningfragment.callback.OnListViewItemClickListener;
import ptit.nttrung.tranningfragment.utils.ColorAdapter2;
import ptit.nttrung.tranningfragment.utils.EndlessRecyclerViewScrollListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {

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

    public static int position = 0;
    private List<ptit.nttrung.tranningfragment.utils.Color> colorList = new ArrayList<>();
    private ColorAdapter2 adapter2;
    private OnListViewItemClickListener mListener;

    public OneFragment() {
    }

    public static OneFragment newInstance() {
        return new OneFragment();
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
        RecyclerView recyclerView = (RecyclerView) contentView.findViewById(R.id.recycler_view);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.btnCreate);

        this.colorList.addAll(initListColor());
        this.adapter2 = new ColorAdapter2(getContext(), colorList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter2);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OneFragment.this.colorList.addAll(initListColor());
                List<ptit.nttrung.tranningfragment.utils.Color> temp = new ArrayList<>();
                temp.addAll(colorList);

//                OneFragment.this.adapter2.update2(temp);
                OneFragment.this.adapter2.updateColorListItem(temp);
            }
        });

        EndlessRecyclerViewScrollListener endlessRecyclerViewScrollListener
                = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public int getFooterViewType(int defaultNoFooterViewType) {
                return R.layout.item_footer;
            }

            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                Log.e("TAG", String.valueOf(page));
                OneFragment.this.colorList.addAll(initListColor());
                List<ptit.nttrung.tranningfragment.utils.Color> temp = new ArrayList<>();
                temp.addAll(colorList);

//                OneFragment.this.adapter2.update2(temp);
                OneFragment.this.adapter2.updateColorListItem(temp);
            }
        };
        recyclerView.addOnScrollListener(endlessRecyclerViewScrollListener);
        return contentView;
    }

    private List<ptit.nttrung.tranningfragment.utils.Color> initListColor() {
        List<ptit.nttrung.tranningfragment.utils.Color> colors = new ArrayList<>();
        for (int i = 0; i < COLOURS.length; i++) {
            ptit.nttrung.tranningfragment.utils.Color color = new ptit.nttrung.tranningfragment.utils.Color();
            color.position = position++;
            color.name = COL_NAMES[i];
            color.htmlColor = COLOURS[i];

            colors.add(color);
        }
        return colors;
    }
}
