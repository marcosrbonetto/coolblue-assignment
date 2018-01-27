package com.assignments.francisco.coolblueassignment.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Condition model class for ebay products response.
 *
 * @author Francisco Visintini
 */
@Root(name = "condition", strict = false)
public class Condition {

    @Element(name = "conditionDisplayName", required = false)
    private String conditionDisplayName;

    @Element(name = "conditionId", required = false)
    private String conditionId;

    public String getConditionDisplayName() {
        return conditionDisplayName;
    }

    public void setConditionDisplayName(String conditionDisplayName) {
        this.conditionDisplayName = conditionDisplayName;
    }

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }
}
