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
package org.springframework.social.twitter.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.twitter.api.AdAccount;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Typed list of advertising accounts. This helps Jackson know what type to deserialize list content into.
 * @author Hudson Mendes
 */
@JsonIgnoreProperties(ignoreUnknown=true)
class AdAccountList {
	private final List<AdAccount> list;

	@JsonCreator
	public AdAccountList(@JsonProperty("data") List<AdAccount> list) {
		this.list = new ArrayList<AdAccount>(list);
	}

	@JsonIgnore
	public List<AdAccount> getList() {
		return this.list;
	}
	
}
