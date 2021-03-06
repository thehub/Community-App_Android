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

package net.impacthub.app.usecase.features.members;

import net.impacthub.app.model.features.members.MembersResponse;
import net.impacthub.app.usecase.base.BaseUseCaseGenerator;

import java.util.concurrent.Callable;

import io.reactivex.Single;

/**
 * @author Filippo Ash
 * @version 1.0
 * @date 11/15/2017.
 */

public class GetMembersByContactIdsUseCase extends BaseUseCaseGenerator<Single<MembersResponse>, MembersResponse> {

    private final String mContactIds;

    public GetMembersByContactIdsUseCase(String contactIds) {
        mContactIds = contactIds;
    }

    @Override
    public Single<MembersResponse> getUseCase() {
        return Single.fromCallable(new Callable<MembersResponse>() {
            @Override
            public MembersResponse call() throws Exception {
                return getApiCall().getResponse(getSoqlRequestFactory().createContactMemberListRequest(mContactIds), MembersResponse.class);
            }
        });
    }
}
