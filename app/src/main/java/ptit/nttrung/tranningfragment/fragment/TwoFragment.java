package ptit.nttrung.tranningfragment.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import ptit.nttrung.tranningfragment.R;
import ptit.nttrung.tranningfragment.callback.OnActivitySendToFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment implements OnActivitySendToFragment {

    RelativeLayout rl;
    int color;

    public TwoFragment() {
        // Required empty public constructor
    }

    public static TwoFragment newInstance(int color) {
        Bundle args = new Bundle();

        TwoFragment fragment = new TwoFragment();
        args.putInt("color", color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        rl = (RelativeLayout) view.findViewById(R.id.rl_main);
        rl.setBackgroundColor(color);

        Button btnBack = (Button) view.findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OneFragment oneFragment = (OneFragment) getActivity().getSupportFragmentManager()
                        .findFragmentById(R.id.fragment_one);
                TwoFragment twoFragment = (TwoFragment)
                        getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_two);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                if (oneFragment == null) {
                    oneFragment = OneFragment.newInstance();
                    Log.e("TAG","Replace A");
                    transaction.replace(R.id.fragment_one, oneFragment, "Fragment One");
                }else {
                    Log.e("TAG","Show A");
                    transaction.show(oneFragment);
                }

                transaction.remove(twoFragment);
                transaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onSend(int color) {
        Log.e("Two Fragment", color + " aaa");

        this.color = color;
        if (rl != null) rl.setBackgroundColor(color);
        else Log.e("TAG", "null");
    }

}
