/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.twitter.api.impl.common.builders;

import org.springframework.social.twitter.api.domain.models.TransferingData;
import org.springframework.util.MultiValueMap;

/**
 * Builder base for all other builders which have the intent of
 * POSTing or PUTting data through an api endpoint, transforming
 * them in to a body Map of values.
 * 
 * @author Hudson Mendes
 */
public abstract class TwitterRequestPostingDataBuilder extends TwitterRequestParametersBuilder implements TransferingData {
	public abstract MultiValueMap<String, Object> toRequestParameters();
}