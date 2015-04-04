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

import java.net.URI;

import org.springframework.social.support.URIBuilder;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Builds API URIs and provide them to operations implementing
 * {@link AbstractTwitterOperations} for both the Standard API
 * and for the Twitter AdCampaign API. 
 *  
 * @author Hudson Mendes
 */
class TwitterApiUriBuilder {
	private static final String STANDARD_API_URL_BASE = "https://api.twitter.com/1.1/";
	private static final String AD_CAMPAIGN_API_URL_BASE = "https://ads-api.twitter.com/0/";
	
	private final MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
	private String resource;
	private String baseLocation = STANDARD_API_URL_BASE;
	
	public TwitterApiUriBuilder forStandardApi() { this.baseLocation = STANDARD_API_URL_BASE; return this; }
	public TwitterApiUriBuilder forAdCampaignsApi() { this.baseLocation = AD_CAMPAIGN_API_URL_BASE; return this; }
	
	public TwitterApiUriBuilder withResource(String resource) { this.resource = resource; return this; }
	public TwitterApiUriBuilder withResource(TwitterApiUriAdvertisingResource resource) { this.resource = resource.getValue(); return this; }
	public TwitterApiUriBuilder withArgument(String argument, Object value) { this.parameters.add(argument, value.toString()); return this; }
	public TwitterApiUriBuilder withArgument(MultiValueMap<String, String> arguments) { this.parameters.putAll(arguments); return this; }
	
	public URI build() {
		this.assertRequirements();
		return URIBuilder
				.fromUri(makeFullyQualifiedResourcePath())
				.queryParams(this.parameters)
				.build();
	}
	
	private void assertRequirements() {
		Assert.notNull(this.resource, "You have to provide a 'resource' in order to build the Uri.");
	}
	
	private String makeFullyQualifiedResourcePath() {
		return trimUriPart(this.baseLocation) + "/" + trimUriPart(this.resource); 
	}
	
	private String trimUriPart(String part) {
		return part.replaceAll("[/]+$", "");
	}
}
