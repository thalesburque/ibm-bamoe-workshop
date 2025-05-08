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

import org.kie.kogito.usertask.model.Attachment;
import org.kie.kogito.usertask.model.AttachmentInfo;
import org.kie.kogito.usertask.model.Comment;
import org.kie.kogito.process.workitem.TaskModel;

public class ApplicantApproval_TaskModelFactory {

    public static TaskModel from(org.kie.kogito.process.WorkItem workItem) {
        switch(workItem.getNodeId().toExternalFormat()) {
            case "_BEC94605-17AA-4BE5-8F8E-F72068BBB457":
                return ApplicantApproval__BEC94605_17AA_4BE5_8F8E_F72068BBB457_TaskModel.from(workItem);
            case "_0E4E0059-9BEF-425D-8B08-94A994224BC5":
                return ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskModel.from(workItem);
            default:
                throw new IllegalArgumentException("Invalid task name for work item " + workItem);
        }
    }
}
