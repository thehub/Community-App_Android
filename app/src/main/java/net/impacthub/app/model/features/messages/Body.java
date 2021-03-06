
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

package net.impacthub.app.model.features.messages;

public class Body {

    private String text;
    private String[] messageSegments;
    private boolean isRichText;

    public String getText() {
        return text;
    }

    public String[] getMessageSegments() {
        return messageSegments;
    }

    public boolean isRichText() {
        return isRichText;
    }

    @Override
    public String toString() {
        return "Body [text = " + text + ", messageSegments = " + messageSegments + ", isRichText = " + isRichText + "]";
    }
}
