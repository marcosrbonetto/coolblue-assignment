package com.assignments.francisco.coolblueassignment.domain.interactors;

import com.assignments.francisco.coolblueassignment.data.api.Filter;
import com.assignments.francisco.coolblueassignment.data.api.FindingApiClientImpl;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by fran on 22/01/18.
 */

public class GetProducts {

    private FindingApiClientImpl findingApiClientImpl;

    @Inject
    public GetProducts(FindingApiClientImpl findingApiClientImpl) {
        this.findingApiClientImpl = findingApiClientImpl;
    }

    public void execute(ArrayList<Filter> filters){

    }

    public void execute(){
        findingApiClientImpl.getProducts();
    }
}
