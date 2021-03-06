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

package net.impacthub.app.mapper.messages;

import net.impacthub.app.model.vo.messages.MessageVO;
import net.impacthub.app.model.features.messages.Body;
import net.impacthub.app.model.features.messages.Conversations;
import net.impacthub.app.model.features.messages.MessageResponse;
import net.impacthub.app.model.features.messages.LatestMessage;
import net.impacthub.app.model.features.messages.Photo;
import net.impacthub.app.model.features.messages.Recipients;
import net.impacthub.app.utilities.DateUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Filippo Ash
 * @version 1.0
 * @date 8/9/2017.
 */

public class MessagesMapper {

    public List<MessageVO> map(MessageResponse response, String userId) {
        List<MessageVO> conversationDTOs = new LinkedList<>();
        if (response != null) {
            Conversations[] conversations = response.getConversations();
            if (conversations != null) {
                for (Conversations conversation : conversations) {
                    if (conversation != null) {
                        MessageVO conversationDTO = new MessageVO();
                        conversationDTO.mConversationId = conversation.getId();
                        Boolean read = Boolean.valueOf(conversation.getRead());
                        conversationDTO.mIsRead = read != null ? read : true;
                        LatestMessage latestMessage = conversation.getLatestMessage();
                        if (latestMessage != null) {
                            conversationDTO.mDate = DateUtils.getElapsedDateTime(latestMessage.getSentDate());
                            Body body = latestMessage.getBody();
                            if (body != null) {
                                conversationDTO.mText = body.getText();
                            }
                            Recipients[] recipients = latestMessage.getRecipients();
                            if (recipients != null) {
                                for (int i = 0; i < recipients.length; i++) {
                                    Recipients recipient = recipients[i];
                                    if (recipient != null) {
                                        String recipientId = recipient.getId();
                                        if (recipientId != null && !recipientId.equals(userId)) {
                                            conversationDTO.mDisplayName = recipient.getDisplayName();
                                            conversationDTO.mRecipientUserId = recipientId;
                                            Photo photo = recipient.getPhoto();
                                            if (photo != null) {
                                                conversationDTO.mImageURL = photo.getSmallPhotoUrl();
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        conversationDTOs.add(conversationDTO);
                    }
                }
            }
        }
        return conversationDTOs;
    }
}
