package com.example;

import com.example.ApplicantApprovalModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@jakarta.enterprise.context.ApplicationScoped()
@jakarta.inject.Named("ApplicantApproval")
@io.quarkus.runtime.Startup()
public class ApplicantApprovalProcess extends org.kie.kogito.process.impl.AbstractProcess<com.example.ApplicantApprovalModel> {

    public ApplicantApprovalProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory) {
        this(app, correlations, factory, new org.kie.kogito.handlers.CreditCardService_generateCreditCardDetails__BEC94605_17AA_4BE5_8F8E_F72068BBB457_Handler());
    }

    @jakarta.inject.Inject()
    public ApplicantApprovalProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory, org.kie.kogito.handlers.CreditCardService_generateCreditCardDetails__BEC94605_17AA_4BE5_8F8E_F72068BBB457_Handler creditCardService_generateCreditCardDetails__BEC94605_17AA_4BE5_8F8E_F72068BBB457_Handler) {
        super(app, java.util.Arrays.asList(creditCardService_generateCreditCardDetails__BEC94605_17AA_4BE5_8F8E_F72068BBB457_Handler), correlations, factory);
        activate();
    }

    public ApplicantApprovalProcess() {
    }

    @Override()
    public com.example.ApplicantApprovalProcessInstance createInstance(com.example.ApplicantApprovalModel value) {
        return new com.example.ApplicantApprovalProcessInstance(this, value, this.createProcessRuntime());
    }

    public com.example.ApplicantApprovalProcessInstance createInstance(java.lang.String businessKey, com.example.ApplicantApprovalModel value) {
        return new com.example.ApplicantApprovalProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public com.example.ApplicantApprovalProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, com.example.ApplicantApprovalModel value) {
        return new com.example.ApplicantApprovalProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public com.example.ApplicantApprovalModel createModel() {
        return new com.example.ApplicantApprovalModel();
    }

    public com.example.ApplicantApprovalProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((com.example.ApplicantApprovalModel) value);
    }

    public com.example.ApplicantApprovalProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (com.example.ApplicantApprovalModel) value);
    }

    public com.example.ApplicantApprovalProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.ApplicantApprovalProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public com.example.ApplicantApprovalProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.ApplicantApprovalProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("ApplicantApproval", true);
        factory.variable("approval", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("customTags", "output", "approval", "approval", "ItemSubjectRef", "_approvalItem"));
        factory.variable("applicant", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(org.acme.cc_approval.model.Applicant.class), java.util.Map.of("customTags", "input", "ItemSubjectRef", "_applicantItem", "applicant", "applicant"));
        factory.variable("creditCard", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(org.acme.cc_approval.model.CreditCard.class), java.util.Map.of("customTags", "output", "creditCard", "creditCard", "ItemSubjectRef", "_creditCardItem"));
        factory.name("ApplicantApproval");
        factory.packageName("com.example");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("jbpm.enable.multi.con", null);
        factory.metaData("jbpm.transactions.enable", "true");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.JoinFactory<?> joinNode_22FBF219_0F89_4064_8E15_A7E5F6B4C60D = factory.joinNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_22FBF219-0F89-4064-8E15-A7E5F6B4C60D"));
        joinNode_22FBF219_0F89_4064_8E15_A7E5F6B4C60D.name("Join");
        joinNode_22FBF219_0F89_4064_8E15_A7E5F6B4C60D.type(2);
        joinNode_22FBF219_0F89_4064_8E15_A7E5F6B4C60D.metaData("UniqueId", "_22FBF219-0F89-4064-8E15-A7E5F6B4C60D");
        joinNode_22FBF219_0F89_4064_8E15_A7E5F6B4C60D.metaData("x", 1241);
        joinNode_22FBF219_0F89_4064_8E15_A7E5F6B4C60D.metaData("width", 56);
        joinNode_22FBF219_0F89_4064_8E15_A7E5F6B4C60D.metaData("y", 660);
        joinNode_22FBF219_0F89_4064_8E15_A7E5F6B4C60D.metaData("height", 56);
        joinNode_22FBF219_0F89_4064_8E15_A7E5F6B4C60D.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882 = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_21C4F7E9-E664-43D2-A8F0-236E02068882"));
        splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882.name("Split");
        splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882.type(2);
        splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882.metaData("UniqueId", "_21C4F7E9-E664-43D2-A8F0-236E02068882");
        splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882.metaData("x", 1241);
        splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882.metaData("width", 56);
        splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882.metaData("y", 456);
        splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882.metaData("Default", null);
        splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882.metaData("height", 56);
        splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_EA9F9D17-E27D-4B97-A265-E32E99D5081A"), "_22F9220B-D2D2-4915-96BD-55563755D5F2", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String approval = (java.lang.String) kcontext.getVariable("approval");
            return approval.toLowerCase().equals("rejected");
        }, 0, false);
        splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_22FBF219-0F89-4064-8E15-A7E5F6B4C60D"), "_12A96230-B5DC-4BBF-B14D-CB3578B26BE3", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String approval = (java.lang.String) kcontext.getVariable("approval");
            return approval.toLowerCase().equals("approved");
        }, 0, false);
        splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882.done();
        splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_EA9F9D17-E27D-4B97-A265-E32E99D5081A"), "_22F9220B-D2D2-4915-96BD-55563755D5F2", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String approval = (java.lang.String) kcontext.getVariable("approval");
            return approval.toLowerCase().equals("rejected");
        }, 0, false);
        splitNode_21C4F7E9_E664_43D2_A8F0_236E02068882.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_22FBF219-0F89-4064-8E15-A7E5F6B4C60D"), "_12A96230-B5DC-4BBF-B14D-CB3578B26BE3", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String approval = (java.lang.String) kcontext.getVariable("approval");
            return approval.toLowerCase().equals("approved");
        }, 0, false);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_EA9F9D17_E27D_4B97_A265_E32E99D5081A = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_EA9F9D17-E27D-4B97-A265-E32E99D5081A"));
        endNode_EA9F9D17_E27D_4B97_A265_E32E99D5081A.name("End");
        endNode_EA9F9D17_E27D_4B97_A265_E32E99D5081A.terminate(false);
        endNode_EA9F9D17_E27D_4B97_A265_E32E99D5081A.metaData("UniqueId", "_EA9F9D17-E27D-4B97-A265-E32E99D5081A");
        endNode_EA9F9D17_E27D_4B97_A265_E32E99D5081A.metaData("x", 1482);
        endNode_EA9F9D17_E27D_4B97_A265_E32E99D5081A.metaData("width", 56);
        endNode_EA9F9D17_E27D_4B97_A265_E32E99D5081A.metaData("y", 456);
        endNode_EA9F9D17_E27D_4B97_A265_E32E99D5081A.metaData("height", 56);
        endNode_EA9F9D17_E27D_4B97_A265_E32E99D5081A.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5 = factory.humanTaskNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0E4E0059-9BEF-425D-8B08-94A994224BC5"));
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.name("Review Application");
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.workParameter("ActorId", "jdoe,mscott");
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.workParameter("NodeName", "Review Application");
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.workParameter("Skippable", "false");
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.workParameter("TaskName", "reviewApplication");
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.workParameter("UNIQUE_TASK_ID", "_0E4E0059-9BEF-425D-8B08-94A994224BC5");
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_0E4E0059-9BEF-425D-8B08-94A994224BC5_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("13ae515e-1b9b-4183-ae5e-6ff9c6324a4c", "EXPRESSION (reviewApplication)", "java.lang.Object", "reviewApplication"), new org.jbpm.workflow.core.impl.DataDefinition("_0E4E0059-9BEF-425D-8B08-94A994224BC5_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("applicant", "applicant", "org.acme.cc_approval.model.Applicant", null)), new org.jbpm.workflow.core.impl.DataDefinition("_0E4E0059-9BEF-425D-8B08-94A994224BC5_applicantInputX", "applicant", "org.acme.cc_approval.model.Applicant", null), null, null));
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_0E4E0059-9BEF-425D-8B08-94A994224BC5_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("9f7ab1f0-1ef4-4ce5-92ab-ba31945100c4", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_0E4E0059-9BEF-425D-8B08-94A994224BC5_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_0E4E0059-9BEF-425D-8B08-94A994224BC5_approvalOutputX", "approval", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("approval", "approval", "java.lang.String", null), null, null));
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.done();
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.metaData("UniqueId", "_0E4E0059-9BEF-425D-8B08-94A994224BC5");
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.metaData("elementname", "Review Application");
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.metaData("x", 964);
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.metaData("width", 154);
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.metaData("y", 433);
        humanTaskNode_0E4E0059_9BEF_425D_8B08_94A994224BC5.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_4F778F3E_5BF6_4697_873A_79D6ABC9EFBE = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4F778F3E-5BF6-4697-873A-79D6ABC9EFBE"));
        endNode_4F778F3E_5BF6_4697_873A_79D6ABC9EFBE.name("End");
        endNode_4F778F3E_5BF6_4697_873A_79D6ABC9EFBE.terminate(false);
        endNode_4F778F3E_5BF6_4697_873A_79D6ABC9EFBE.metaData("UniqueId", "_4F778F3E-5BF6-4697-873A-79D6ABC9EFBE");
        endNode_4F778F3E_5BF6_4697_873A_79D6ABC9EFBE.metaData("x", 787);
        endNode_4F778F3E_5BF6_4697_873A_79D6ABC9EFBE.metaData("width", 56);
        endNode_4F778F3E_5BF6_4697_873A_79D6ABC9EFBE.metaData("y", 856);
        endNode_4F778F3E_5BF6_4697_873A_79D6ABC9EFBE.metaData("height", 56);
        endNode_4F778F3E_5BF6_4697_873A_79D6ABC9EFBE.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638 = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_AD64646B-4A6A-4FC7-BF6A-8CC83FF97638"));
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.name("Split");
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.type(2);
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.metaData("UniqueId", "_AD64646B-4A6A-4FC7-BF6A-8CC83FF97638");
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.metaData("x", 786);
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.metaData("width", 56);
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.metaData("y", 661);
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.metaData("Default", null);
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.metaData("height", 56);
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4F778F3E-5BF6-4697-873A-79D6ABC9EFBE"), "_CEA2C29B-63C9-4D9B-9609-2291787277AF", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String approval = (java.lang.String) kcontext.getVariable("approval");
            return approval.toLowerCase().equals("rejected");
        }, 0, false);
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0E4E0059-9BEF-425D-8B08-94A994224BC5"), "_3DB58BC0-EAED-4836-A469-3285C1FA041E", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String approval = (java.lang.String) kcontext.getVariable("approval");
            return approval.toLowerCase().equals("manual");
        }, 0, false);
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_22FBF219-0F89-4064-8E15-A7E5F6B4C60D"), "_89CFE54F-9F37-48CD-B2F9-9511D1858F45", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String approval = (java.lang.String) kcontext.getVariable("approval");
            return approval.toLowerCase().equals("approved");
        }, 0, false);
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.done();
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4F778F3E-5BF6-4697-873A-79D6ABC9EFBE"), "_CEA2C29B-63C9-4D9B-9609-2291787277AF", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String approval = (java.lang.String) kcontext.getVariable("approval");
            return approval.toLowerCase().equals("rejected");
        }, 0, false);
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0E4E0059-9BEF-425D-8B08-94A994224BC5"), "_3DB58BC0-EAED-4836-A469-3285C1FA041E", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String approval = (java.lang.String) kcontext.getVariable("approval");
            return approval.toLowerCase().equals("manual");
        }, 0, false);
        splitNode_AD64646B_4A6A_4FC7_BF6A_8CC83FF97638.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_22FBF219-0F89-4064-8E15-A7E5F6B4C60D"), "_89CFE54F-9F37-48CD-B2F9-9511D1858F45", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String approval = (java.lang.String) kcontext.getVariable("approval");
            return approval.toLowerCase().equals("approved");
        }, 0, false);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_DA9DF6E7-E6AE-457B-9B61-DE88FB3E9D4D"));
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.name("Approved");
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.terminate(false);
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.metaData("UniqueId", "_DA9DF6E7-E6AE-457B-9B61-DE88FB3E9D4D");
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.metaData("elementname", "Approved");
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.metaData("x", 1723);
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.metaData("width", 56);
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.metaData("y", 661);
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.metaData("height", 56);
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457 = factory.workItemNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_BEC94605-17AA-4BE5-8F8E-F72068BBB457"));
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.name("Generate CC Details");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.workName("org.acme.cc_approval.service.CreditCardService_generateCreditCardDetails__BEC94605_17AA_4BE5_8F8E_F72068BBB457_Handler");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.workParameter("Interface", "org.acme.cc_approval.service.CreditCardService");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.workParameter("NodeName", "Generate CC Details");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.workParameter("Operation", "generateCreditCardDetails");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.workParameter("UNIQUE_TASK_ID", "_BEC94605-17AA-4BE5-8F8E-F72068BBB457");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.workParameter("implementation", "Java");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.workParameter("interfaceImplementationRef", "org.acme.cc_approval.service.CreditCardService");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.workParameter("operationImplementationRef", "generateCreditCardDetails");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("applicant", "applicant", "org.acme.cc_approval.model.Applicant", null)), new org.jbpm.workflow.core.impl.DataDefinition("_BEC94605-17AA-4BE5-8F8E-F72068BBB457_applicantInputX", "applicant", "org.acme.cc_approval.model.Applicant", null), null, null));
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_BEC94605-17AA-4BE5-8F8E-F72068BBB457_creditCardOutputX", "creditCard", "org.acme.cc_approval.model.CreditCard", null)), new org.jbpm.workflow.core.impl.DataDefinition("creditCard", "creditCard", "org.acme.cc_approval.model.CreditCard", null), null, null));
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.done();
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("UniqueId", "_BEC94605-17AA-4BE5-8F8E-F72068BBB457");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("Implementation", "Java");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("elementname", "Generate CC Details");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("Type", "Service Task");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("OperationRef", "_BEC94605-17AA-4BE5-8F8E-F72068BBB457_ServiceOperation");
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("x", 1433);
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("width", 154);
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("y", 638);
        workItemNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.RuleSetNodeFactory<?> ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A = factory.ruleSetNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F6716F5D-2B5A-4F61-93C8-2D42209F874A"));
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.name("Is Eligible");
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.decision("https://kie.org/dmn/_639D6115-E08E-439D-8D29-45750C32DB28", "Credit Card Eligibility Validation", null, () -> {
            return app.get(org.kie.kogito.decision.DecisionModels.class).getDecisionModel("https://kie.org/dmn/_639D6115-E08E-439D-8D29-45750C32DB28", "Credit Card Eligibility Validation");
        });
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_F6716F5D-2B5A-4F61-93C8-2D42209F874A_fileNameInputX", "fileName", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("d135764f-f284-4baf-9a0b-fcf0b13f3625", "EXPRESSION (CreditCardEligibility.dmn)", "java.lang.Object", "CreditCardEligibility.dmn"), new org.jbpm.workflow.core.impl.DataDefinition("_F6716F5D-2B5A-4F61-93C8-2D42209F874A_fileNameInputX", "fileName", "java.lang.String", null))), null));
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_F6716F5D-2B5A-4F61-93C8-2D42209F874A_namespaceInputX", "namespace", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("690f8892-9b7b-4d20-b018-2b73d164d944", "EXPRESSION (https://kie.org/dmn/_639D6115-E08E-439D-8D29-45750C32DB28)", "java.lang.Object", "https://kie.org/dmn/_639D6115-E08E-439D-8D29-45750C32DB28"), new org.jbpm.workflow.core.impl.DataDefinition("_F6716F5D-2B5A-4F61-93C8-2D42209F874A_namespaceInputX", "namespace", "java.lang.String", null))), null));
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_F6716F5D-2B5A-4F61-93C8-2D42209F874A_modelInputX", "model", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("0e0b3c13-a6c1-4a50-9638-5b26a5bb94c2", "EXPRESSION (Credit Card Eligibility Validation)", "java.lang.Object", "Credit Card Eligibility Validation"), new org.jbpm.workflow.core.impl.DataDefinition("_F6716F5D-2B5A-4F61-93C8-2D42209F874A_modelInputX", "model", "java.lang.String", null))), null));
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("applicant", "applicant", "org.acme.cc_approval.model.Applicant", null)), new org.jbpm.workflow.core.impl.DataDefinition("_F6716F5D-2B5A-4F61-93C8-2D42209F874A_ApplicantInputX", "Applicant", "org.acme.cc_approval.model.Applicant", null), null, null));
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_F6716F5D-2B5A-4F61-93C8-2D42209F874A_IsEligibleOutputX", "IsEligible", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("approval", "approval", "java.lang.String", null), null, null));
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.metaData("UniqueId", "_F6716F5D-2B5A-4F61-93C8-2D42209F874A");
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.metaData("elementname", "Is Eligible");
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.metaData("x", 501);
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.metaData("width", 154);
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.metaData("y", 638);
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.metaData("height", 102);
        ruleSetNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173 = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_50B329DB-59A7-4B5D-BA57-9C27C7021173"));
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.name("Log application received");
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("UniqueId", "_50B329DB-59A7-4B5D-BA57-9C27C7021173");
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("elementname", "Log application received");
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("NodeType", "ScriptTask");
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("x", 267);
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("width", 154);
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("y", 638);
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("height", 102);
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.action(kcontext -> {
            System.out.println("Process started for: ");
        });
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6 = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_2F9DBBF0-37A2-42F8-894D-AF497FC494B6"));
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.name("Start");
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.interrupting(true);
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.metaData("UniqueId", "_2F9DBBF0-37A2-42F8-894D-AF497FC494B6");
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.metaData("EventType", "none");
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.metaData("x", 131);
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.metaData("width", 56);
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.metaData("y", 661);
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.metaData("height", 56);
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.done();
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_21C4F7E9-E664-43D2-A8F0-236E02068882"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_22FBF219-0F89-4064-8E15-A7E5F6B4C60D"), "_12A96230-B5DC-4BBF-B14D-CB3578B26BE3");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_AD64646B-4A6A-4FC7-BF6A-8CC83FF97638"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_22FBF219-0F89-4064-8E15-A7E5F6B4C60D"), "_89CFE54F-9F37-48CD-B2F9-9511D1858F45");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0E4E0059-9BEF-425D-8B08-94A994224BC5"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_21C4F7E9-E664-43D2-A8F0-236E02068882"), "_1E11ABB3-5937-400D-91BE-B413E5B886E5");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_21C4F7E9-E664-43D2-A8F0-236E02068882"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_EA9F9D17-E27D-4B97-A265-E32E99D5081A"), "_22F9220B-D2D2-4915-96BD-55563755D5F2");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_AD64646B-4A6A-4FC7-BF6A-8CC83FF97638"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0E4E0059-9BEF-425D-8B08-94A994224BC5"), "_3DB58BC0-EAED-4836-A469-3285C1FA041E");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_AD64646B-4A6A-4FC7-BF6A-8CC83FF97638"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4F778F3E-5BF6-4697-873A-79D6ABC9EFBE"), "_CEA2C29B-63C9-4D9B-9609-2291787277AF");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F6716F5D-2B5A-4F61-93C8-2D42209F874A"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_AD64646B-4A6A-4FC7-BF6A-8CC83FF97638"), "_17433920-3E97-4B51-A758-1585B552624C");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_BEC94605-17AA-4BE5-8F8E-F72068BBB457"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_DA9DF6E7-E6AE-457B-9B61-DE88FB3E9D4D"), "_D0C118E6-C8CB-49D5-9CFA-A944F83A1B91");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_22FBF219-0F89-4064-8E15-A7E5F6B4C60D"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_BEC94605-17AA-4BE5-8F8E-F72068BBB457"), "_41BD02EF-BCC2-4447-B147-EAB10E4EE590");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_50B329DB-59A7-4B5D-BA57-9C27C7021173"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F6716F5D-2B5A-4F61-93C8-2D42209F874A"), "_228DC407-38B6-4639-8AB3-FDC40C5E357A");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_2F9DBBF0-37A2-42F8-894D-AF497FC494B6"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_50B329DB-59A7-4B5D-BA57-9C27C7021173"), "_841F3056-50C5-4390-8715-78A245ACB44A");
        factory.validate();
        return factory.getProcess();
    }
}
