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

package net.impacthub.app.mapper.notifications;

import android.support.annotation.NonNull;

import net.impacthub.app.model.vo.notifications.NotificationVO;
import net.impacthub.app.model.vo.notifications.NotificationType;
import net.impacthub.app.model.features.notifications.NotificationResponse;
import net.impacthub.app.model.features.notifications.Records;
import net.impacthub.app.model.vo.notifications.NotificationWrapper;
import net.impacthub.app.utilities.DateUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Filippo Ash
 * @version 1.0
 * @date 8/4/2017.
 */

public class NotificationMapper {

    public NotificationWrapper wrapNotifications(NotificationResponse response) {
        int unreadNotificationCount = 0;
        List<NotificationVO> notificationDTOList = new LinkedList<>();
        if (response != null) {
            Records[] records = response.getRecords();
            int length;
            if (records != null && (length = records.length) > 0) {
                for (Records record : records) {
                    Boolean isRead__c = record.getIsRead__c();
                    if (isRead__c != null && !isRead__c) {
                        unreadNotificationCount++;
                    }
                    notificationDTOList.add(mapNotificationVO(record));
                }
            }
        }
        return new NotificationWrapper(notificationDTOList, unreadNotificationCount);
    }

    public List<NotificationVO> map(NotificationResponse response) {
        List<NotificationVO> notificationDTOList = new LinkedList<>();
        if (response != null) {
            Records[] records = response.getRecords();
            int length;
            if (records != null && (length = records.length) > 0) {
                for (int i = 0; i < length; i++) {
                    Records record = records[i];
                    if (record != null) {
                        notificationDTOList.add(mapNotificationVO(record));
                    }
                }
            }
        }
        return notificationDTOList;
    }

    @NonNull
    private NotificationVO mapNotificationVO(Records record) {
        NotificationVO notificationDTO = new NotificationVO();
        notificationDTO.mId = record.getId();
        notificationDTO.mIsRead = record.getIsRead__c();
        notificationDTO.mMessage = record.getMessage__c();
        notificationDTO.mRelatedId = record.getRelatedId__c();
        notificationDTO.mRecipientUserId = record.getFromUserId__c();
        notificationDTO.mDisplayName = record.getName();
        notificationDTO.mProfilePicUrl = record.getProfilePicURL__c();
        notificationDTO.mChatterGroupId = record.getChatterGroupId__c();
        notificationDTO.mCreatedDate = DateUtils.getElapsedDateTime(record.getCreatedDate());
        notificationDTO.mNotificationType = NotificationType.fromString(record.getType__c());
        return notificationDTO;
    }
}
