package net.impacthub.app.presenter.features.error;

import net.impacthub.app.presenter.base.UiContract;

/**
 * @author Filippo Ash
 * @version 1.0
 * @date 7/26/2017.
 */

public interface ErrorHandlerUiContract extends UiContract {

    void onShowProgressBar(boolean showProgressBar);

    void onError(Throwable throwable);
}
