/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.aliyuncs.fc.request;

import static com.aliyuncs.fc.constants.Const.IF_MATCH_HEADER;

import com.aliyuncs.fc.constants.Const;
import com.aliyuncs.fc.exceptions.ClientException;
import com.aliyuncs.fc.http.HttpRequest;
import com.aliyuncs.fc.response.CreateAliasResponse;
import com.aliyuncs.fc.response.UpdateAliasResponse;
import com.aliyuncs.fc.utils.ParameterHelper;
import com.google.common.base.Strings;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class UpdateAliasRequest extends HttpRequest {

    private final transient String serviceName;
    private final transient String aliasName;
    private transient String ifMatch;

    @SerializedName("versionId")
    private String versionId;
    @SerializedName("description")
    private String description;
    @SerializedName("additionalVersionWeight")
    private Map<String, Float> additionalVersionWeight;

    public UpdateAliasRequest(String serviceName, String aliasName) {
        this.serviceName = serviceName;
        this.aliasName = aliasName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public String getVersionId() {
        return versionId;
    }

    public String getDescription() {
        return description;
    }

    public UpdateAliasRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getIfMatch() {
        return ifMatch;
    }

    public void setIfMatch(String ifMatch) {
        this.ifMatch = ifMatch;
    }

    public Map<String, Float> getAdditionalVersionWeight() {
        return additionalVersionWeight;
    }

    public UpdateAliasRequest setAdditionalVersionWeight(
        Map<String, Float> additionalVersionWeight) {
        this.additionalVersionWeight = additionalVersionWeight;
        return this;
    }

    public byte[] getPayload() {
        return ParameterHelper.ObjectToJson(this).getBytes();
    }

    @Override
    public String getPath() {
        return String
            .format(Const.SINGLE_ALIAS_PATH, Const.API_VERSION, this.serviceName, this.aliasName);
    }

    public Map<String, String> getHeaders() {
        if (this.ifMatch != null && this.ifMatch.length() < 0) {
            headers.put(IF_MATCH_HEADER, this.ifMatch);
        }
        return headers;
    }

    @Override
    public void validate() throws ClientException {
        if (Strings.isNullOrEmpty(serviceName)) {
            throw new ClientException("Service name cannot be blank");
        }
        if (Strings.isNullOrEmpty(aliasName)) {
            throw new ClientException("Alias name cannot be blank");
        }
    }

    public Class<UpdateAliasResponse> getResponseClass() {
        return UpdateAliasResponse.class;
    }
}