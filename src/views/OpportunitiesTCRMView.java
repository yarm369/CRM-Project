package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import beans.CRMBean;

public interface OpportunitiesTCRMView extends TCRMView {

	String getTextId();
	String getTextFirstName();
	String getTextLastName();
	String getTextStartDate();
	String getTextPredictedClosingDate();
	String getTextDescriptionInfo();
	String getTextAmountOfDollars();
	
	void setTextId(String textId);
	void setTextFirstName(String textFirstName);
	void setTextLastName(String textLastName);
	void setTextStartDate(String textStartDate);
	void setTextPredictedClosingDate(String textPredictedClosingDate);
	void setTextDescriptionInfo(String textTelephoe);
	void setTextAmountOfDollars(String textamountOfDollars);

	// TODO: Verify MVC compliance of these methods
	int getSelectedClientIndex();
	void setSelectedClientIndex(int index);
	void setSelectClientItems(ArrayList<CRMBean> list);
	void setSelectClientListener(ActionListener listener);
	
	String getErrorFirstName();
	String getErrorLasttName();
	String getErrorStartDate();
	String getErrorPredictedClosingDate();
	String getErrorDescriptionInfo();
	String getErrorAmountOfDollars();
	
	void setErrorFirstName(String errorFirstName);
	void setErrorLastName(String errorLastName);
	void setErrorStartDate(String errorStartDate);
	void setErrorPredictedClosingDate(String errorPredictedClosingDate);
	void setErrorDescriptionInfo(String errorDescriptionInfo);
	void setErrorAmountOfDollars(String erroramountOfDollars);
}