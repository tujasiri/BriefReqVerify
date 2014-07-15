package com.sample;

import com.sample.BriefVerify;
import com.sample.MyWorkItemHandler;

import org.jbpm.workflow.instance.WorkflowRuntimeException;
import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.ProcessRuntime;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

/**
 * This is a sample file to test a process.
 */
public class ProcessTest extends JbpmJUnitBaseTestCase {

	@Test
	public void testProcess()  {
		//RuntimeManager manager = createRuntimeManager("sample.bpmn");
	/*	
	
		RuntimeManager manager = createRuntimeManager("briefverify2.bpmn");
		
		RuntimeEngine engine = getRuntimeEngine(null);
		KieSession ksession = engine.getKieSession();
	*/

	KieHelper kieHelper = new KieHelper();

  	KieBase kbase = kieHelper.addResource(ResourceFactory
				.newClassPathResource("briefverify2.bpmn"))
				.build();

	KieSession ksession = kbase.newKieSession();

KieRuntimeLogger logger = KieServices.Factory.get().getLoggers()
  .newThreadedFileLogger(ksession, "src/main/resources/mylogfile", 1000);
// do something with the ksession here






		
		
			//TestWorkItemHandler testHandler = getTestWorkItemHandler();
		
		try{
			ksession.getWorkItemManager().registerWorkItemHandler("Service Task",  new MyWorkItemHandler());

  			//ksession.getWorkItemManager().registerWorkItemHandler("Hello", testHandler);
		}
		catch (Exception ex){
				System.err.println("WorkitemHandler==>"+ex.toString());
		}
		System.out.println("before process instance start");
		
		
		System.out.println("Session ID ==>"+ksession.getId());
		
		try{
			ProcessInstance processInstance = ksession.startProcess("com.sample.bpmn.ServiceProcess");
		}
			
		catch(WorkflowRuntimeException e){
			System.err.println("processInstance Exception ==>"+e.toString());
			
		}
/*
		WorkItem wi = testHandler.getWorkItem();

System.out.println("workitem info.name==>"+wi.getName());
System.out.println("workitem info.id==>"+wi.getId());
System.out.println("workitem info.state==>"+wi.getState());
*/
		//System.out.println("Process state=="+processInstance.getState());
		
		//ProcessInstance processInstance = ksession.startProcess("ServiceProcess");
		
		System.out.println("process instance started");
		
		
		//ProcessInstance processInstance = ksession.startProcess("com.sample.bpmn.briefreqverify");
		
		// check whether the process instance has completed successfully:w
		
	/*	
		assertProcessInstanceCompleted(processInstance.getId(), ksession);
		assertNodeTriggered(processInstance.getId(), "Hello");
		*/
		
		
		/*		
		manager.disposeRuntimeEngine(engine);
		manager.close();
		*/
		ksession.dispose();
		logger.close();
		
		System.out.println("reached the end...");
	}



}
