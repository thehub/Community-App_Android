/*
 * Copyright (c) 2017 Lightful. All Rights Reserved.
 *
 * Save to the extent permitted by law, you may not use, copy, modify,
 * distribute or create derivative works of this material or any part
 * of it without the prior written consent of Lightful.
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 */

package net.impacthub.app.ui.features.home.projects.binders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.impacthub.app.R;
import net.impacthub.app.model.pojo.FilterableString;
import net.impacthub.app.model.pojo.ListItemType;
import net.impacthub.app.model.vo.objectives.ObjectiveVO;
import net.impacthub.app.ui.base.BaseListAdapter;
import net.impacthub.app.ui.common.RecyclerViewHolder;

/**
 * @author Filippo Ash
 * @version 1.0
 * @date 8/16/2017.
 */

class ProjectObjectivesListAdapter extends BaseListAdapter<RecyclerView.ViewHolder, ListItemType> {

    ProjectObjectivesListAdapter(LayoutInflater inflater) {
        super(inflater);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getItemType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case 0:
                viewHolder = new TitleViewHolder(getLayoutInflater().inflate(R.layout.item_layout_info_title, parent, false));
                break;
            default:
                viewHolder = new ObjectiveViewHolder(getLayoutInflater().inflate(R.layout.item_layout_objective, parent, false));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object model = getItem(position).getModel();
        switch (getItemViewType(position)) {
            case 0:
                FilterableString title = (FilterableString) model;
                ((TitleViewHolder) holder).bindViewsWith(title.getValue());
                break;
            case 1:
                ((ObjectiveViewHolder) holder).bindViewsWith((ObjectiveVO) model);
                break;
        }
    }

    private class TitleViewHolder extends RecyclerViewHolder<String> {

        final TextView title;

        TitleViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.text_info_title);
            int padding = itemView.getResources().getDimensionPixelOffset(R.dimen.default_content_large_gap);
            itemView.setPadding(padding, padding, padding, padding);
        }

        @Override
        protected void bindViewsWith(String itemData) {
            title.setText(itemData);
        }
    }

    private class ObjectiveViewHolder extends RecyclerViewHolder<ObjectiveVO>{

        final TextView objectiveCount;
        final TextView title;
        final TextView summary;
        final View lineCounter;

        ObjectiveViewHolder(View itemView) {
            super(itemView);
            objectiveCount = (TextView) itemView.findViewById(R.id.text_objective_count);
            title = (TextView) itemView.findViewById(R.id.text_objective_title);
            summary = (TextView) itemView.findViewById(R.id.text_objective_summary);
            lineCounter = itemView.findViewById(R.id.line_objective_counter);
        }

        @Override
        protected void bindViewsWith(ObjectiveVO itemData) {
            objectiveCount.setText(String.valueOf(itemData.mCount));
            title.setText(String.valueOf(itemData.mTitle));
            summary.setText(String.valueOf(itemData.mSummary));
            lineCounter.setVisibility(itemData.mHideLastTimeLine ? View.GONE : View.VISIBLE);
        }
    }
}
