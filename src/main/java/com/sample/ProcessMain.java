package com.sample;

import org.jbpm.process.workitem.rest.RESTWorkItemHandler;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;


public class ProcessMain {

	
	public static void main(String args[]){
		KieServices ks=KieServices.Factory.get();
		//KieServices ks =KieServices.Factory.get();
		KieContainer kContainer=ks.getKieClasspathContainer();
		KieBase kbase=kContainer.getKieBase("kbase");
		KieSession ksession=kbase.newKieSession();
		ClassLoader classLoader = ProcessMain.class.getClass().getClassLoader();
		ksession.getWorkItemManager().registerWorkItemHandler("Rest", new RESTWorkItemHandler());
		
		//ProcessInstance pi=ksession.startProcess("RestSample2");
		
		ProcessInstance pi=ksession.startProcess("defaultPackage.New_Process");
		ksession.fireAllRules();
		//ksession.abortProcessInstance(arg0);

		
	}
}
