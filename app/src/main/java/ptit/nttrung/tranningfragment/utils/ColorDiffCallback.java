package ptit.nttrung.tranningfragment.utils;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Created by TrungNguyen on 4/2/2018.
 */

public class ColorDiffCallback extends DiffUtil.Callback {

    private List<Color> oldColorList;
    private List<Color> newColorList;

    public ColorDiffCallback(List<Color> oldColorList, List<Color> newColorList) {
        this.oldColorList = oldColorList;
        this.newColorList = newColorList;
    }

    @Override
    public int getOldListSize() {
        return oldColorList.size();
    }

    @Override
    public int getNewListSize() {
        return newColorList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Color currentItem = oldColorList.get(oldItemPosition);
        Color nextItem = newColorList.get(newItemPosition);

        return currentItem.position == nextItem.position;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Color currentItem = oldColorList.get(oldItemPosition);
        Color nextItem = newColorList.get(newItemPosition);

        return false;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
