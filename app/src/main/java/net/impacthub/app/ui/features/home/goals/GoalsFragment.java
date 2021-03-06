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

package net.impacthub.app.ui.features.home.goals;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import net.impacthub.app.R;
import net.impacthub.app.model.callback.OnListItemClickListener;
import net.impacthub.app.model.vo.goals.GoalVO;
import net.impacthub.app.presenter.features.goals.GoalsUiPresenter;
import net.impacthub.app.presenter.features.goals.GoalsUiContract;
import net.impacthub.app.ui.base.BaseChildFragment;
import net.impacthub.app.ui.common.LinearItemsMarginDecorator;

import java.util.List;

import butterknife.BindView;

/**
 * @author Filippo Ash
 * @version 1.0
 * @date 03/08/2017.
 */

public class GoalsFragment extends BaseChildFragment<GoalsUiPresenter> implements OnListItemClickListener<GoalVO>, GoalsUiContract {

    @BindView(R.id.list_items) protected RecyclerView mGoalsList;

    private GoalsListAdapter mAdapter;

    public static GoalsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        GoalsFragment fragment = new GoalsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected GoalsUiPresenter onCreatePresenter() {
        return new GoalsUiPresenter(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_list_with_back;
    }

    @Override
    protected void bindView(View rootView) {
        super.bindView(rootView);

        setUpToolbar(R.string.label_goals);
        mGoalsList.setHasFixedSize(true);
        Context context = getContext();
        mAdapter = new GoalsListAdapter(LayoutInflater.from(context));
        mAdapter.setItemClickListener(this);
        int offset = getResources().getDimensionPixelOffset(R.dimen.default_content_normal_gap);
        mGoalsList.setLayoutManager(new LinearLayoutManager(context));
        mGoalsList.addItemDecoration(new LinearItemsMarginDecorator(offset));
        mGoalsList.setAdapter(mAdapter);

        getPresenter().getGoals();
    }

    @Override
    public void onItemClick(int viewId, GoalVO model, int position) {
        addChildFragment(GoalDetailFragment.newInstance(model), "FRAG_GOAL_DETAIL");
    }

    @Override
    public void onLoadGoals(List<GoalVO> goals) {
        mAdapter.setItems(goals);
    }
}
