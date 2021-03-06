package net.impacthub.app.model.callback;

/**
 * @author Filippo Ash
 * @version 1.0
 * @date 8/1/2017.
 */

public interface OnListItemClickListener<T> {

    void onItemClick(int viewId, T model, int position);
}
