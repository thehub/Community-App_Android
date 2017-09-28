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

package net.impacthub.app.model.pojo;

import java.util.List;
import java.util.Map;

/**
 * @author Filippo Ash
 * @version 1.0
 * @date 9/25/2017.
 */

public class FilterableString implements Searchable {

    private final String mValue;

    public FilterableString(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }

    @Override
    public boolean isSearchable(String query) {
        return false;
    }

    @Override
    public boolean isFilterable(Map<String, List<String>> filters) {
        return false;
    }
}
