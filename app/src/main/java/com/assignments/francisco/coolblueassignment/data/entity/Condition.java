package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
 */
@Root(name = "condition", strict = false)
public class Condition {

    @Element(name = "conditionDisplayName", required = false)
    public String conditionDisplayName;
    @Element(name = "conditionId", required = false)
    public String conditionId;
}
