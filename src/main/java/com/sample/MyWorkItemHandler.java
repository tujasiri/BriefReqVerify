//package defaultPackage;
package com.sample;

import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;


public class MyWorkItemHandler implements WorkItemHandler{
	

    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        System.out.println("GOOD BYE WORLD");
        manager.completeWorkItem(workItem.getId(), null);
    }

     public void abortWorkItem (WorkItem workItem, WorkItemManager manager) {
        // Nothing
	System.out.println("Hell0 there...Aborting...");
    	 
    }
}