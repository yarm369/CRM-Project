package controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.InvalidFormFieldData;
import models.CRMModel;
import swingViews.SwingView;
import views.ClientTCRMView;
import views.ContactTCRMView;

public class ClientControllerTheLastHope extends ClientController {

	public ClientControllerTheLastHope(SwingView view, CRMModel model) {
		super(view, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validateCompany(){
		String wordPattern="[A-Za-z0-9\\s?]+";
		ClientTCRMView view = (ClientTCRMView) getView();
		String companyName = view.getTextCompany().trim().toLowerCase();
		
		//Checks if the field is empty
		if (companyName.length() == 0) {
			addValidationError("Company", "Empty Company. Required Field.");
		}
		
		//Validates if the input satisfy the regular expression for a company name
		else if (!companyName.matches(wordPattern)) {
			addValidationError("Company", "Invalid entry");
		}
		
		//If the input is correct, capitalize the first word
		if(companyName.matches(wordPattern)) {
			companyName = Character.toUpperCase(companyName.charAt(0)) + companyName.substring(1);
			view.setTextCompany(companyName);
		}
	}
	
	@Override
	public void validateTelephone()  {
		ClientTCRMView view = (ClientTCRMView) getView();
		String phoneNum = view.getTextTelephone().trim();	
		String telregex = "1? ?\\(?[2-9][0-9]{2}\\)?-? ?[0-9]{3}-? ?[0-9]{4}";

		
		//Checks if the field is empty
		if (phoneNum.length() == 0) 
			addValidationError("Telephone", "Empty Telephone. Required Field.");
		
		//Validates if the input satisfy the regular expression for a telephone number
		else if(!phoneNum.matches(telregex)) {
			addValidationError("Telephone", "Invalid entry.");
		}
		
		if(phoneNum.matches(telregex)) {
			String number="";
			Matcher match = Pattern.compile("[0-9]").matcher(phoneNum);
			for(int i=0 ; i<=11 ; i++) {
				if(match.find()) {
					number+=match.group();
				}
			}
			
			if(number.length()==11) {
				number = "(" +number.substring(1, 4) +") "+number.substring(4, 7)+ "-"+ number.substring(7);
			}
			else 
				number = "(" +number.substring(0, 3) +") "+number.substring(3, 6)+ "-"+ number.substring(6);
			view.setTextTelephone(number);
			
		}
		
	}
	
	@Override
	public void validateEmail() {
		ClientTCRMView view = (ClientTCRMView) getView();
		String emailRegex = "[A-Za-z0-9._]+@[A-Za-z0-9]+.[A-Za-z]{2,4}";
		
		//Checks if the field is empty
		if (view.getTextEmail().trim().length() == 0) 
			addValidationError("Email", "Empty Email. Required Field.");
	
		//Validates if the input satisfy the regular expression for a email address
		else if(!view.getTextEmail().matches(emailRegex))
			addValidationError("Email", "Invalid entry.");
		
		//If the input is correct, puts the entire email in lower case letters.
		if(view.getTextEmail().matches(emailRegex)) {
			view.setTextEmail(view.getTextEmail().trim().toLowerCase());
		}
			
	}
	
	@Override
	public void validateWebsite() {
		ClientTCRMView view = (ClientTCRMView) getView();
		String website = view.getTextWebsite().trim().toLowerCase();
		String webPattern = "((https://)||(http://))?[w]{3}.[a-z0-9]+.[a-z]{2,4}";	
		
		//Checks if the field is empty
		if (website.length() == 0) 
			addValidationError("Website", "Empty Website. Required Field.");
		
		//Validates if the input satisfy the regular expression for a Website
		else if(!website.matches(webPattern))
			addValidationError("Website", "Invalid entry.");
		
		//If the input is correct, if it contains http or https eliminates them
		if(website.matches(webPattern)) {
			if(website.contains("https://")) {
				website = website.substring(8);
			}
			else if(website.contains("http://")) {
				website = website.substring(website.lastIndexOf(7));
			}
			view.setTextWebsite(website);
		}
		
		
	}
	
	@Override
	public void validateFacebook()  {
		ClientTCRMView view = (ClientTCRMView) getView();
		
		String facebookPattern = "(https://)?([w]{3}.)?facebook.com/[A-Z0-9.]{5,}";		
		Pattern FBregex = Pattern.compile(facebookPattern , Pattern.CASE_INSENSITIVE);
		Matcher match= FBregex.matcher(view.getTextFacebook());
		
		//Checks if the field is empty
		if (view.getTextFacebook().trim().length() == 0) 
			addValidationError("Facebook", "Empty Facebook. Required Field.");
		
		//Validates if the input satisfy the regular expression for a Facebook address
		else if(!match.matches())
			addValidationError("Facebook", "Not a proper Facebook URL");
		
		//puts input to standard fb URL starting with facebook.com
		if(match.matches()) {
			String fbAddress = view.getTextFacebook().toLowerCase();
			view.setTextFacebook(fbAddress.substring(fbAddress.indexOf("facebook")));
		}
	}
	
	
		
}
