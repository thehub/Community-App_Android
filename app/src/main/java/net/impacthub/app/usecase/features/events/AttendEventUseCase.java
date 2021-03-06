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

package net.impacthub.app.usecase.features.events;

import net.impacthub.app.usecase.base.BaseUseCaseGenerator;

import org.json.JSONObject;

import java.util.concurrent.Callable;

import io.reactivex.Single;

/**
 * @author Filippo Ash
 * @version 1.0
 * @date 9/1/2017.
 */

public class AttendEventUseCase extends BaseUseCaseGenerator<Single<Object>, Object> {

    private final JSONObject mJsonObject;

    public AttendEventUseCase(JSONObject jsonObject) {
        mJsonObject = jsonObject;
    }

    @Override
    public Single<Object> getUseCase() {
        return Single.fromCallable(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return getApiCall().getResponse(getSoqlRequestFactory().createAttendEventRequest(mJsonObject), Object.class);
            }
        });
    }
}
