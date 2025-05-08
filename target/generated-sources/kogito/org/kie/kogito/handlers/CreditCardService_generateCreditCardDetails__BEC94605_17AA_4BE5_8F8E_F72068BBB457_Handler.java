package org.kie.kogito.handlers;

import org.kie.kogito.internal.process.workitem.WorkItemExecutionException;

@jakarta.enterprise.context.ApplicationScoped()
public class CreditCardService_generateCreditCardDetails__BEC94605_17AA_4BE5_8F8E_F72068BBB457_Handler extends org.kie.kogito.process.workitems.impl.DefaultKogitoWorkItemHandler {

    org.acme.cc_approval.service.CreditCardService service;

    public CreditCardService_generateCreditCardDetails__BEC94605_17AA_4BE5_8F8E_F72068BBB457_Handler() {
        this(new org.acme.cc_approval.service.CreditCardService());
    }

    @jakarta.inject.Inject()
    public CreditCardService_generateCreditCardDetails__BEC94605_17AA_4BE5_8F8E_F72068BBB457_Handler(org.acme.cc_approval.service.CreditCardService service) {
        this.service = service;
    }

    public java.util.Optional<org.kie.kogito.internal.process.workitem.WorkItemTransition> activateWorkItemHandler(org.kie.kogito.internal.process.workitem.KogitoWorkItemManager workItemManager, org.kie.kogito.internal.process.workitem.KogitoWorkItemHandler workItemHandler, org.kie.kogito.internal.process.workitem.KogitoWorkItem workItem, org.kie.kogito.internal.process.workitem.WorkItemTransition transition) {
        java.util.Map<java.lang.String, java.lang.Object> result;
        result = java.util.Collections.singletonMap("creditCard", service.generateCreditCardDetails((org.acme.cc_approval.model.Applicant) workItem.getParameter("applicant")));
        return java.util.Optional.of(this.workItemLifeCycle.newTransition("complete", workItem.getPhaseStatus(), result));
    }

    public java.util.Optional<org.kie.kogito.internal.process.workitem.WorkItemTransition> abortWorkItemHandler(org.kie.kogito.internal.process.workitem.KogitoWorkItemManager workItemManager, org.kie.kogito.internal.process.workitem.KogitoWorkItemHandler workItemHandler, org.kie.kogito.internal.process.workitem.KogitoWorkItem workItem, org.kie.kogito.internal.process.workitem.WorkItemTransition transition) {
        return java.util.Optional.empty();
    }

    public String getName() {
        return "org.acme.cc_approval.service.CreditCardService_generateCreditCardDetails__BEC94605_17AA_4BE5_8F8E_F72068BBB457_Handler";
    }
}
