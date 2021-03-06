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

package net.impacthub.app.presenter.features.notifcations;

import net.impacthub.app.model.vo.groups.GroupVO;
import net.impacthub.app.model.vo.members.MemberVO;
import net.impacthub.app.model.vo.notifications.NotificationVO;
import net.impacthub.app.model.vo.projects.ProjectVO;
import net.impacthub.app.presenter.features.error.ErrorHandlerUiContract;

import java.util.List;

/**
 * @author Filippo Ash
 * @version 1.0
 * @date 8/4/2017.
 */

public interface NotificationsUiContract extends ErrorHandlerUiContract {

    void onLoadNotifications(List<NotificationVO> notificationDTOList, int unreadNotificationCount);

    void onLoadMember(MemberVO memberVO);

    void onLoadGroup(GroupVO groupVO);

    void onLoadProject(ProjectVO projectVO);

    void onDecrementNotificationCount();
}
