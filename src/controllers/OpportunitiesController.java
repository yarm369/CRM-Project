package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.InvalidFormFieldData;
import main.CRMMain;
import models.CRMModel;
import models.ClientModel;
import swingViews.OpportunitiesSwingView;
import swingViews.SwingView;
import views.OpportunitiesTCRMView;

public class OpportunitiesController extends CRMController {

	public OpportunitiesController(SwingView opportunitiesView, CRMModel opportunitiesModel, CRMModel clientModel) {
		super(opportunitiesView, opportunitiesModel);

		OpportunitiesSwingView cv = (OpportunitiesSwingView) opportunitiesView;
		ClientModel clientModel2 = (ClientModel) clientModel;

		cv.setSelectClientItems(clientModel2.getAllBeans());
		cv.clearFieldErrors();
		cv.setSelectClientListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Client Combo Box Selected");
			}
		});
	}

	public void doInit() {
		super.doInit();
		refreshDropdowns();
	}
	
	public void doLeft() {
		System.out.println("OpportunitiesController.doLeft()");
		super.doLeft();
	}

	public void doRight() {
		System.out.println("OpportunitiesController.doRight()");
		super.doRight();
	}

	public void doEdit() {
		System.out.println("OpportunitiesController.doRight()");
		refreshDropdowns();
		super.doEdit();
	}

	public void doAdd() {
		System.out.println("OpportunitiesController.doAdd()");
		refreshDropdowns();
		super.doAdd();
	}

	public void doDelete() {
		System.out.println("OpportunitiesController.doDelete()");
		super.doDelete();
	}

	public void doSave() {
		System.out.println("OpportunitiesController.doSave()");
		super.doSave();
	}

	public void doSelectClient() {
		this.refreshView();
	}

	public void validateForm() throws InvalidFormFieldData {
		getValidationErrors().clear();
		validateFirstName();
		validateLastName();
		validateStartDate();
		validateDescriptionInfo();
		validateAmountOfDollars();
		validatePredictedClosingDate();
		if (getValidationErrors().size() > 0)
			throw new InvalidFormFieldData ("Invalid Form");
	}

	public void validateFirstName() throws InvalidFormFieldData {
		OpportunitiesTCRMView view = (OpportunitiesTCRMView) getView();
		String wordPattern="[A-Za-z]+\\s?";
		String name = view.getTextFirstName().trim().toLowerCase();
		
		//Checks if the field is empty
		if (name.length() == 0) 
			addValidationError("FirstName", "Empty First Name. Required Field.");
		
		//Validates if the input satisfy the regular expression for a name
		else  if (!name.matches(wordPattern)) 
			addValidationError("FirstName", "Invalid entry.");
		
		//If the input is correct, capitalize the first letter.
		if(name.matches(wordPattern)){
			name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
			view.setTextFirstName(name);
		}
	}
	
	public void validateLastName() throws InvalidFormFieldData {
		OpportunitiesTCRMView view = (OpportunitiesTCRMView) getView();
		String lastName = view.getTextLastName().toLowerCase();
		//One or two Last names accepted
		String wordPattern="([A-Za-z]+\\s?){1,2}";
		
		//Checks if the field is empty
		if (lastName.trim().length() == 0) 
			addValidationError("LastName", "Empty Last Name. Required Field.");
		
		//Validates if the input satisfy the regular expression for a last name
		if(!lastName.matches(wordPattern)) 
			addValidationError("LastName", "Invalid entry.");
		
		//Starts last name with upper Case	
		if(view.getTextLastName().matches(wordPattern)) {
			int spacePos = lastName.indexOf(" ");
			
			if(lastName.contains(" ")) 
				lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1,spacePos) + " " + Character.toUpperCase(lastName.charAt(spacePos+1)) + lastName.substring(spacePos+2);
			else 
				lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1);
			
			view.setTextLastName(lastName);
		}
	}	
	
	public void validateStartDate() throws InvalidFormFieldData {
		OpportunitiesTCRMView view = (OpportunitiesTCRMView) getView();
		String dateRegex = "(0[1-9]|1[0-2])/(0[1-9]|1[0-9]|2[0-9]|3[0-1])/[0-9]{4}";
		
		//Checks if the field is empty
		if (view.getTextStartDate().trim().length() == 0) {
			addValidationError("Start Date", "Empty Start Date. Required Field.");
		}
		//Validates if the input satisfy the regular expression for a date
		else if(!view.getTextStartDate().trim().matches(dateRegex)) {
			addValidationError("Start Date", "Invalid entry. Example mm/dd/yyyy ");
		}
		
	}	
	public void validateDescriptionInfo() throws InvalidFormFieldData {
		OpportunitiesTCRMView view = (OpportunitiesTCRMView) getView();
		String wordPattern="[A-Za-z0-9\\s?]+.?";
		String description = view.getTextDescriptionInfo().trim();
		//Checks if the field is empty
		if (view.getTextDescriptionInfo().trim().length() == 0) {
			addValidationError("Description", "Empty Description. Required Field.");
		}
		//Validates if the input satisfy the regular expression for a description
		else if(!description.matches(wordPattern)) {
			addValidationError("Description", "Invalid entry. Only letters and numbers allow.");
		}
		//Capitalize the first letter of the description
		if(description.matches(wordPattern)) {
			description = Character.toUpperCase(description.charAt(0)) + description.substring(1);
			view.setTextDescriptionInfo(description);
		}
		
		
		
	}
	public void validateAmountOfDollars() throws InvalidFormFieldData {
		OpportunitiesTCRMView view = (OpportunitiesTCRMView) getView();
		String amountRegex = "\\$?[0-9]+(.[0-9]{2})?";
		String amount = view.getTextAmountOfDollars().trim();
		
		//Checks if the field is empty
		if (amount.length() == 0) 
			addValidationError("Amount", "Empty Amount. Required Field.");
		
		//Validates if the input satisfy the regular expression for a amount
		else if(!amount.matches(amountRegex))
			addValidationError("Amount", "Invalid entry. Example: $21.67 ");
		
		//Puts the amount in the form of $00.00 
		if(amount.matches(amountRegex)) {
			if(amount.contains("$") && !amount.contains(".") ) 
				amount +=  ".00";
			else if(!amount.contains("$")&& amount.contains(".")) 
				amount = "$" + amount;
			else if(!amount.contains("$") && !amount.contains("."))
				amount = "$" + amount + ".00";
	
			view.setTextAmountOfDollars(amount);
		}
	}
	
	public void validatePredictedClosingDate()throws InvalidFormFieldData {
		OpportunitiesTCRMView view = (OpportunitiesTCRMView) getView();
		String closingDate = view.getTextPredictedClosingDate().trim();
		String dateRegex = "(0[1-9]|1[0-2])/(0[1-9]|1[0-9]|2[0-9]|3[0-1])/[0-9]{4}";
		String startDate = view.getTextStartDate().trim();
		
		//Checks if the field is empty
		if (closingDate.length() == 0) 
			addValidationError("Predicted Closing Date", "Empty Predicted Closing Date. Required Field.");
		
		//Validates if the input satisfy the regular expression for a amount
		else if(!closingDate.matches(dateRegex))
			addValidationError("Predicted Closing Date", "Invalid entry. Example: mm/dd/yyyy");
		
		if(closingDate.matches(dateRegex) && startDate.matches(dateRegex)) {
	
			
			//sets the dates with only numbers, removes "/"
		
			String numStartingDate = startDate.substring(0,2) + startDate.substring(3,5) + startDate.substring(6);
			String numClosingDate = closingDate.substring(0,2) + closingDate.substring(3,5) + closingDate.substring(6);
				
				
			//Checks if the closing day is is first then the starting date
			if(Integer.parseInt(numClosingDate) < Integer.parseInt(numStartingDate)) {
				addValidationError("Predicted Closing Date", "Error. Closing date can't occur before starting date.");
			}
			
		}
		
		
	}

	public void refreshDropdowns() {
		OpportunitiesTCRMView cv = (OpportunitiesTCRMView) getView();
		cv.setSelectClientItems(CRMMain.clientModel.getAllBeans());
	}

	protected void refreshView() {
		super.refreshView();
		String errorString;
		OpportunitiesSwingView cv = (OpportunitiesSwingView) getView();
		cv.clearFieldErrors();
		Map<String, String> validationErrors = getValidationErrors();
		if (validationErrors.size() > 0) {
			errorString = "Fields in red are invalid";
			if (validationErrors.containsKey("FirstName")) { cv.setErrorFirstName(validationErrors.get("FirstName")); }
			if (validationErrors.containsKey("LastName"))  { cv.setErrorLastName(validationErrors.get("LastName")); }
			if (validationErrors.containsKey("Start Date"))   { cv.setErrorStartDate(validationErrors.get("Start Date")); }
			if (validationErrors.containsKey("Description")) { cv.setErrorDescriptionInfo(validationErrors.get("Description")); }
			if (validationErrors.containsKey("Amount")) 	   { cv.setErrorAmountOfDollars(validationErrors.get("Amount")); }
			if (validationErrors.containsKey("Predicted Closing Date")) {cv.setErrorPredictedClosingDate(validationErrors.get("Predicted Closing Date"));}
			cv.setMessagesText(errorString);
		}
	}

}

