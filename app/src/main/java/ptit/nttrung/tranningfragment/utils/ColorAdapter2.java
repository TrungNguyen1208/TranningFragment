package ptit.nttrung.tranningfragment.utils;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ptit.nttrung.tranningfragment.R;

/**
 * Created by TrungNguyen on 4/2/2018.
 */

public class ColorAdapter2 extends RecyclerView.Adapter<ColorAdapter2.ColorViewHolder> {

    private List<Color> list;
    private Context context;

    public ColorAdapter2(Context context, List<Color> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ColorViewHolder(LayoutInflater.from(context).inflate(R.layout.item_color, parent, false));
    }

    @Override
    public void onBindViewHolder(ColorViewHolder holder, int position) {
        holder.textView.setText(list.get(position).name);
        holder.textView.setTextColor(list.get(position).htmlColor);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateColorListItem(List<Color> colors){
        final ColorDiffCallback diffCallback = new ColorDiffCallback(this.list,colors);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback,true);

        this.list.clear();
        this.list.addAll(colors);
        diffResult.dispatchUpdatesTo(this);
    }

    public void update2(List<Color> colors){
        this.list.clear();
        this.list.addAll(colors);

        this.notifyDataSetChanged();
    }

    public class ColorViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ColorViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.blala);
        }
    }
}
