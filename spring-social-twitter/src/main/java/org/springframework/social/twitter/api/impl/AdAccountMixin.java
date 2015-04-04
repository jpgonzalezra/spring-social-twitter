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

import java.time.LocalDateTime;
import java.util.TimeZone;

import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.social.twitter.api.AdAccount;
import org.springframework.social.twitter.api.ContentApprovalStatus;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Mixin class for adding Jackson annotations to {@link AdAccount}.
 * @author Hudson Mendes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class AdAccountMixin extends TwitterObjectMixin {
	
	@JsonCreator
	AdAccountMixin(
			@JsonProperty("id") String id, 
			@JsonProperty("name") String name, 
			@JsonProperty("salt") String salt, 
			@JsonProperty("timezone") TimeZone timeZone, 
			@JsonProperty("timezone_switch_at") String timeZoneSwitchAt,
			@JsonProperty("created_at") String createdAt,
			@JsonProperty("updated_at") @JsonDeserialize(using=LocalDateTimeDeserializer.class) LocalDateTime updatedAt,
			@JsonProperty("approval_status") ContentApprovalStatus approvalStatus,
			@JsonProperty("deleted") Boolean deleted) {}
	
}