package main;

import java.util.HashMap;
import java.util.Map;

import controllers.CRMController;
import controllers.ClientController;
import controllers.ClientControllerTheLastHope;
import controllers.ContactController;
import controllers.ContactControllerTheLastHope;
import controllers.OpportunitiesController;
import models.CRMModel;
import models.ClientModel;
import models.ContactModel;
import models.OpportunitiesModel;
import swingViews.ClientSwingView;
import swingViews.ClientSwingViewTheLastHope;
import swingViews.ContactSwingView;
import swingViews.OpportunitiesSwingView;
import swingViews.SwingView;

public class CRMMain {

	// Create Contacts module MVC objects
	public static SwingView clientView = new ClientSwingViewTheLastHope();
	public static CRMModel clientModel = new ClientModel();
	public static CRMController clientController = new ClientControllerTheLastHope(clientView, clientModel);

	// Create Clients module MVC objects
	public static SwingView contactView = new ContactSwingView();
	public static CRMModel contactModel = new ContactModel();
	
	// Create Opportunities module MVC objects
	public static SwingView  opportunitiesView = new OpportunitiesSwingView();
	public static CRMModel  opportunitiesModel = new OpportunitiesModel();
	
	// Contacts module has relationship with Clients module so we pass the Clients model object to the Contacts controller
	public static CRMController contactController = new ContactControllerTheLastHope(contactView, contactModel, clientModel); 
	
	//Opportunities module has relationship with Clients module so we pass the Clients model object to the Contact controller
	public static CRMController opportunitiesController = new OpportunitiesController(opportunitiesView, opportunitiesModel, clientModel); 
	
	private static String currentModule;
	private static SwingView currentView;

	// mapModuleToView holds the view object for each module
	public static Map<String,SwingView> mapModuleToView = new HashMap<String,SwingView>();
	// mapModuleToIndex holds the index in the module selection combo box for each module
	public static Map<String,Integer> mapModuleToIndex = new HashMap<String,Integer>();

	public static void main (String[] args) {

		contactView.setModuleSelectionItems(new String[] {"Contacts", "Clients", "Opportunities", "Reports"});
		clientView.setModuleSelectionItems(new String[] {"Contacts", "Clients", "Opportunities", "Reports"});
		opportunitiesView.setModuleSelectionItems(new String[] {"Contacts", "Clients", "Opportunities", "Reports"});

		mapModuleToView.put("Contacts", contactView);
		mapModuleToView.put("Clients", clientView);
		mapModuleToView.put("Opportunities", opportunitiesView);

		mapModuleToIndex.put("Contacts", 0);
		mapModuleToIndex.put("Clients", 1);
		mapModuleToIndex.put("Opportunities", 2);
		mapModuleToIndex.put("Reports", 1);
		
		clientController.doInit();
		clientController.setSwitchModuleListener((String s) -> CRMMain.switchToModule(s));

		contactController.doInit();
		contactController.setSwitchModuleListener((String s) -> CRMMain.switchToModule(s));

		opportunitiesController.doInit();
		opportunitiesController.setSwitchModuleListener((String s) -> CRMMain.switchToModule(s));
		
		//contactView.setModuleSelected(mapModuleToIndex.get("Contacts"));
		switchToModule("Contacts"); // Initially open the Contacts module

	}

	public static void switchToModule(String moduleName) {

		if (moduleName.equals(currentModule)) return;
		
		SwingView nextView = mapModuleToView.get(moduleName);
		
		if (nextView != null) {
			
			nextView.setMessagesText("Welcome to TinyCRM: " + moduleName);

			nextView.setVisible(true);
			if (currentView != null) currentView.setVisible(false);
			
			currentModule = moduleName;
			currentView = nextView;
			currentView.setModuleSelected(mapModuleToIndex.get(currentModule));
		}
		else {
			currentView.setModuleSelected(mapModuleToIndex.get(currentModule));
			currentView.setMessagesText(moduleName + " Module Not Available Yet");
		}
	}
}
