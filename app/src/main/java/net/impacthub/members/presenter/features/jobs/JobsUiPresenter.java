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

package net.impacthub.members.presenter.features.jobs;

import net.impacthub.members.mapper.jobs.JobsMapper;
import net.impacthub.members.model.vo.jobs.JobVO;
import net.impacthub.members.model.features.jobs.JobsResponse;
import net.impacthub.members.presenter.base.UiPresenter;
import net.impacthub.members.usecase.base.UseCaseGenerator;
import net.impacthub.members.usecase.features.jobs.JobsUseCase;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * @author Filippo Ash
 * @version 1.0
 * @date 8/9/2017.
 */

public class JobsUiPresenter extends UiPresenter<JobsUiContract> {

    private final UseCaseGenerator<Single<JobsResponse>> mJobsUseCase = new JobsUseCase();

    public JobsUiPresenter(JobsUiContract uiContract) {
        super(uiContract);
    }

    public void getJobs() {
        getUi().onChangeStatus(true);
        Single<List<JobVO>> jobsSingle = mJobsUseCase.getUseCase()
                .map(new Function<JobsResponse, List<JobVO>>() {
                    @Override
                    public List<JobVO> apply(@NonNull JobsResponse jobsResponse) throws Exception {
                        return new JobsMapper().map(jobsResponse);
                    }
                });
        subscribeWith(jobsSingle, new DisposableSingleObserver<List<JobVO>>() {
            @Override
            public void onSuccess(@NonNull List<JobVO> jobVOs) {
                getUi().onLoadJobs(jobVOs);
                getUi().onChangeStatus(false);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                getUi().onError(e);
                getUi().onChangeStatus(false);
            }
        });
    }
}
