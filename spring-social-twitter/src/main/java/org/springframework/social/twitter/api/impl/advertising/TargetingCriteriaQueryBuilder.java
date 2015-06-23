/*
 * Copyright 2014 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.twitter.api.impl.advertising;

import org.springframework.social.twitter.api.advertising.TargetingCriteria;
import org.springframework.social.twitter.api.advertising.TargetingCriteriaQuery;
import org.springframework.social.twitter.api.advertising.TargetingCriteriaSorting;
import org.springframework.util.MultiValueMap;

/**
 * Facilitates the creation of the query that will be
 * used to filter results from the {@link TargetingCriteria} endpoint.
 * 
 * @author Hudson Mendes
 */
public class TargetingCriteriaQueryBuilder
        extends AbstractTwitterQueryForSortableEntityBuilder<TargetingCriteriaQuery, TargetingCriteriaSorting>
        implements TargetingCriteriaQuery {

    private String lineItemId;

    @Override
    public TargetingCriteriaQuery withLineItem(String lineItemId) {
        this.lineItemId = lineItemId;
        return this;
    }

    @Override
    protected void makeParameters(MultiValueMap<String, String> map) {
        appendParameter(map, "line_item_id", this.lineItemId);
    }

}
