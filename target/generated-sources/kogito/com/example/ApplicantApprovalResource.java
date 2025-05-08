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

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Response.Status;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jbpm.util.JsonSchemaUtil;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;
import org.kie.kogito.process.ProcessService;
import org.kie.kogito.process.workitem.TaskModel;
import org.kie.kogito.auth.IdentityProviderFactory;
import org.kie.kogito.auth.SecurityPolicy;

@Path("/ApplicantApproval")
@org.eclipse.microprofile.openapi.annotations.tags.Tag(name = "ApplicantApproval")
@jakarta.enterprise.context.ApplicationScoped()
public class ApplicantApprovalResource {

    @jakarta.inject.Inject()
    @jakarta.inject.Named("ApplicantApproval")
    Process<ApplicantApprovalModel> process;

    @Inject
    ProcessService processService;

    @Inject
    IdentityProviderFactory identityProviderFactory;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public Response createResource_ApplicantApproval(@Context HttpHeaders httpHeaders, @Context UriInfo uriInfo, @QueryParam("businessKey") @DefaultValue("") String businessKey, @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() ApplicantApprovalModelInput resource) {
        ProcessInstance<ApplicantApprovalModel> pi = processService.createProcessInstance(process, businessKey, Optional.ofNullable(resource).orElse(new ApplicantApprovalModelInput()).toModel(), httpHeaders.getRequestHeaders(), httpHeaders.getHeaderString("X-KOGITO-StartFromNode"), null, httpHeaders.getHeaderString("X-KOGITO-ReferenceId"), null);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(pi.id()).build()).entity(pi.checkError().variables().toModel()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public List<ApplicantApprovalModelOutput> getResources_ApplicantApproval() {
        return processService.getProcessInstanceOutput(process);
    }

    @GET
    @Path("schema")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public Map<String, Object> getResourceSchema_ApplicantApproval() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput getResource_ApplicantApproval(@PathParam("id") String id) {
        return processService.findById(process, id).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput deleteResource_ApplicantApproval(@PathParam("id") final String id) {
        return processService.delete(process, id).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput updateModel_ApplicantApproval(@PathParam("id") String id, @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() ApplicantApprovalModelInput resource) {
        return processService.update(process, id, resource.toModel()).orElseThrow(NotFoundException::new);
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput updateModelPartial_ApplicantApproval(@PathParam("id") String id, @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() ApplicantApprovalModelInput resource) {
        return processService.updatePartial(process, id, resource.toModel()).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public List<TaskModel> getTasks_ApplicantApproval(@PathParam("id") String id, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getWorkItems(process, id, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups))).orElseThrow(NotFoundException::new).stream().map(com.example.ApplicantApproval_TaskModelFactory::from).collect(Collectors.toList());
    }

    @POST
    @Path("/{id}/reviewApplication/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput completeTask_reviewApplication_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("complete") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskOutput model) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/reviewApplication/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskOutput saveTask_reviewApplication_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskOutput model) {
        return processService.setWorkItemOutput(process, id, taskId, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model, com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskOutput::fromMap).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/reviewApplication/{taskId}/phases/{phase}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput taskTransition_reviewApplication_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("phase") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskOutput model) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/reviewApplication/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskModel getWorkItem_reviewApplication_0(@PathParam("id") String id, @PathParam("taskId") String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getWorkItem(process, id, taskId, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), com.example.ApplicantApproval__0E4E0059_9BEF_425D_8B08_94A994224BC5_TaskModel::from).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/reviewApplication/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput abortTask_reviewApplication_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("abort") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), null).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("reviewApplication/schema")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public Map<String, Object> getSchema_reviewApplication_0() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id(), "reviewApplication");
    }

    @GET
    @Path("/{id}/reviewApplication/{taskId}/schema")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public Map<String, Object> getSchemaAndPhases_reviewApplication_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getWorkItemSchemaAndPhases(process, id, taskId, "reviewApplication", SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)));
    }

    @POST
    @Path("/{id}/Generate_CC_Details/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput completeTask_Generate_CC_Details_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("complete") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.ApplicantApproval__BEC94605_17AA_4BE5_8F8E_F72068BBB457_TaskOutput model) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Generate_CC_Details/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public com.example.ApplicantApproval__BEC94605_17AA_4BE5_8F8E_F72068BBB457_TaskOutput saveTask_Generate_CC_Details_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.ApplicantApproval__BEC94605_17AA_4BE5_8F8E_F72068BBB457_TaskOutput model) {
        return processService.setWorkItemOutput(process, id, taskId, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model, com.example.ApplicantApproval__BEC94605_17AA_4BE5_8F8E_F72068BBB457_TaskOutput::fromMap).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/Generate_CC_Details/{taskId}/phases/{phase}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput taskTransition_Generate_CC_Details_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("phase") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.ApplicantApproval__BEC94605_17AA_4BE5_8F8E_F72068BBB457_TaskOutput model) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Generate_CC_Details/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public com.example.ApplicantApproval__BEC94605_17AA_4BE5_8F8E_F72068BBB457_TaskModel getWorkItem_Generate_CC_Details_1(@PathParam("id") String id, @PathParam("taskId") String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getWorkItem(process, id, taskId, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), com.example.ApplicantApproval__BEC94605_17AA_4BE5_8F8E_F72068BBB457_TaskModel::from).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Generate_CC_Details/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput abortTask_Generate_CC_Details_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("abort") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), null).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("Generate_CC_Details/schema")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public Map<String, Object> getSchema_Generate_CC_Details_1() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id(), "Generate_CC_Details");
    }

    @GET
    @Path("/{id}/Generate_CC_Details/{taskId}/schema")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public Map<String, Object> getSchemaAndPhases_Generate_CC_Details_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getWorkItemSchemaAndPhases(process, id, taskId, "Generate_CC_Details", SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)));
    }
}
