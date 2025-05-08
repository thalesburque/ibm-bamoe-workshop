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

import org.kie.kogito.process.workitem.TaskModel;

public class ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskModel implements TaskModel<com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskInput, com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskOutput> {

    private String id;

    private String name;

    private int state;

    private String phase;

    private String phaseStatus;

    private com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskInput parameters;

    private com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskOutput results;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getPhaseStatus() {
        return phaseStatus;
    }

    public void setPhaseStatus(String phaseStatus) {
        this.phaseStatus = phaseStatus;
    }

    public com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskInput getParameters() {
        return parameters;
    }

    public void setParameters(com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskInput parameters) {
        this.parameters = parameters;
    }

    public com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskOutput getResults() {
        return results;
    }

    public void setParams(com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskOutput results) {
        this.results = results;
    }

    public static com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskModel from(org.kie.kogito.process.WorkItem workItem) {
        com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskModel taskModel = new com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskModel();
        taskModel.id = workItem.getId();
        taskModel.name = workItem.getName();
        taskModel.state = workItem.getState();
        taskModel.phaseStatus = workItem.getPhaseStatus();
        taskModel.phase = workItem.getPhase();
        taskModel.parameters = com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskInput.fromMap(workItem.getParameters());
        taskModel.results = com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskOutput.fromMap(workItem.getResults());
        return taskModel;
    }
}
//Task model for user task 'Review Application' in process 'ApplicantApproval'
