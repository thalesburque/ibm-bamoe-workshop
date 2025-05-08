/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.example;

import java.util.HashMap;
import java.util.Map;
import org.kie.kogito.MapOutput;
import org.kie.kogito.UserTask;
import org.kie.kogito.UserTaskParam.ParamType;
import org.kie.kogito.UserTaskParam;

@UserTask(taskName = "Generate CC Details", processName = "ApplicantApproval")
public class ApplicantApproval__BEC94605_17AA_4BE5_8F8E_F72068BBB457_TaskOutput implements MapOutput {

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("creditCard", this.creditCard);
        return params;
    }

    public static ApplicantApproval__BEC94605_17AA_4BE5_8F8E_F72068BBB457_TaskOutput fromMap(Map<String, Object> params) {
        com.example.ApplicantApproval__BEC94605_17AA_4BE5_8F8E_F72068BBB457_TaskOutput result = new ApplicantApproval__BEC94605_17AA_4BE5_8F8E_F72068BBB457_TaskOutput();
        result.creditCard = (org.acme.cc_approval.model.CreditCard) params.get("creditCard");
        return result;
    }

    @UserTaskParam(value = ParamType.OUTPUT)
    private org.acme.cc_approval.model.CreditCard creditCard;

    public org.acme.cc_approval.model.CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(org.acme.cc_approval.model.CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
//Task output for user task 'Generate CC Details' in process 'ApplicantApproval'
