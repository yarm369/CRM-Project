package swingViews;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import beans.CRMBean;
import beans.OpportunitiesBean;
import views.OpportunitiesTCRMView;

public class OpportunitiesSwingView extends SwingView implements OpportunitiesTCRMView {

	private static final long serialVersionUID = 1L;

	protected class ClientForComboBox {

		private long id;
		private String description;

		protected long getId() {
			return id;
		}

		protected ClientForComboBox(long id, String description) {
			this.id = id;
			this.description = description;
		}

		protected String getDescription() {
			return description;
		}
		protected void setId(long id) {
			this.id = id;
		}
		protected void setDescription(String description) {
			this.description = description;
		}
		
		// toString() called by JComboBox to obtain display text for item
		public String toString() {
			return description;
		}
		
	}

	private JTextField textId;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textStartDate;
	private JComboBox<ClientForComboBox> comboBoxClient;
	private JComboBox comboBoxStatus;
	private String [] cmbMessagesStatus = {"None", "Not Started", "In Progress", "Completed", "Waiting on someone else","Defferred"};
	private JTextField textDescriptionInfo;
	private JTextField textamountOfDollars;
	private JTextField textPredictedClosingDate;

	private JLabel idLblError;
	private JLabel firstNameLblError;
	private JLabel lastNameLblError;
	private JLabel startDateLblError;
	private JLabel clientLblError;
	private JLabel descripitionInfoLblError;
	private JLabel amountOfDollarsLblError;
	private JLabel predictedClosingDateLblError;
	private JLabel statusLblError;

	/**
	 * Create the frame.
	 */
	public OpportunitiesSwingView() {
		super();
		setTitle("Opportunities");

		JScrollPane centerScrollPane = new JScrollPane();
		centerScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		centerScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		setCenterPanel(centerScrollPane);

		JPanel centerGrid = new JPanel();
		centerScrollPane.setViewportView(centerGrid);
		GridBagLayout gbl_centerGrid = new GridBagLayout();
		gbl_centerGrid.columnWidths = new int[]{100, 475, 0};
		gbl_centerGrid.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_centerGrid.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_centerGrid.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,Double.MIN_VALUE};
		centerGrid.setLayout(gbl_centerGrid);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		centerGrid.add(lblId, gbc_lblId);

		textId = new JTextField();
		textId.setEditable(false);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.insets = new Insets(0, 0, 5, 0);
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 0;
		centerGrid.add(textId, gbc_txtId);
		textId.setColumns(10);

		idLblError = new JLabel("New label");
		idLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		idLblError.setForeground(Color.RED);
		GridBagConstraints gbc_IdLblError = new GridBagConstraints();
		gbc_IdLblError.anchor = GridBagConstraints.WEST;
		gbc_IdLblError.insets = new Insets(0, 0, 5, 0);
		gbc_IdLblError.gridx = 1;
		gbc_IdLblError.gridy = 1;
		centerGrid.add(idLblError, gbc_IdLblError);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 2;
		centerGrid.add(lblFirstName, gbc_lblFirstName);

		textFirstName = new JTextField();
		textFirstName.setEditable(false);
		textFirstName.setToolTipText("Sample: John");
		GridBagConstraints gbc_txtFirstname = new GridBagConstraints();
		gbc_txtFirstname.insets = new Insets(0, 0, 5, 0);
		gbc_txtFirstname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstname.gridx = 1;
		gbc_txtFirstname.gridy = 2;
		centerGrid.add(textFirstName, gbc_txtFirstname);
		textFirstName.setColumns(10);

		firstNameLblError = new JLabel("New label");
		firstNameLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		firstNameLblError.setForeground(Color.RED);
		GridBagConstraints gbc_firstNameLblbError = new GridBagConstraints();
		gbc_firstNameLblbError.anchor = GridBagConstraints.WEST;
		gbc_firstNameLblbError.insets = new Insets(0, 0, 5, 0);
		gbc_firstNameLblbError.gridx = 1;
		gbc_firstNameLblbError.gridy = 3;
		centerGrid.add(firstNameLblError, gbc_firstNameLblbError);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.EAST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 4;
		centerGrid.add(lblLastName, gbc_lblLastName);

		textLastName = new JTextField();
		textLastName.setEditable(false);
		textLastName.setToolTipText("Sample: Doe");
		GridBagConstraints gbc_textLastName = new GridBagConstraints();
		gbc_textLastName.insets = new Insets(0, 0, 5, 0);
		gbc_textLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLastName.gridx = 1;
		gbc_textLastName.gridy = 4;
		centerGrid.add(textLastName, gbc_textLastName);
		textLastName.setColumns(10);

		lastNameLblError = new JLabel("New label");
		lastNameLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lastNameLblError.setForeground(Color.RED);
		GridBagConstraints gbc_lastNameLblError = new GridBagConstraints();
		gbc_lastNameLblError.anchor = GridBagConstraints.WEST;
		gbc_lastNameLblError.insets = new Insets(0, 0, 5, 0);
		gbc_lastNameLblError.gridx = 1;
		gbc_lastNameLblError.gridy = 5;
		centerGrid.add(lastNameLblError, gbc_lastNameLblError);

		JLabel lblStartDate = new JLabel("Start Date");
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.anchor = GridBagConstraints.EAST;
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate.gridx = 0;
		gbc_lblStartDate.gridy = 6;
		centerGrid.add(lblStartDate, gbc_lblStartDate);

		textStartDate = new JTextField();
		textStartDate.setEditable(false);
		textStartDate.setToolTipText("MM/DD/YYYY");
		GridBagConstraints gbc_textStartDate = new GridBagConstraints();
		gbc_textStartDate.insets = new Insets(0, 0, 5, 0);
		gbc_textStartDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textStartDate.gridx = 1;
		gbc_textStartDate.gridy = 6;
		centerGrid.add(textStartDate, gbc_textStartDate);
		textStartDate.setColumns(10);

		startDateLblError = new JLabel("New label");
		startDateLblError.setForeground(Color.RED);
		startDateLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_startDateLblError = new GridBagConstraints();
		gbc_startDateLblError.anchor = GridBagConstraints.WEST;
		gbc_startDateLblError.insets = new Insets(0, 0, 5, 0);
		gbc_startDateLblError.gridx = 1;
		gbc_startDateLblError.gridy = 7;
		centerGrid.add(startDateLblError, gbc_startDateLblError);

		JLabel lblClient = new JLabel("Client");
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.anchor = GridBagConstraints.EAST;
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 0;
		gbc_lblClient.gridy = 8;
		centerGrid.add(lblClient, gbc_lblClient);

		comboBoxClient = new JComboBox<ClientForComboBox>();
		comboBoxClient.setEditable(false);
		comboBoxClient.setEnabled(false);
		GridBagConstraints gbc_comboBoxClient = new GridBagConstraints();
		gbc_comboBoxClient.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxClient.gridx = 1;
		gbc_comboBoxClient.gridy = 8;
		centerGrid.add(comboBoxClient, gbc_comboBoxClient);

		clientLblError = new JLabel("New label");
		clientLblError.setForeground(Color.RED);
		clientLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_clientLblError = new GridBagConstraints();
		gbc_clientLblError.anchor = GridBagConstraints.WEST;
		gbc_clientLblError.insets = new Insets(0, 0, 5, 0);
		gbc_clientLblError.gridx = 1;
		gbc_clientLblError.gridy = 9;
		centerGrid.add(clientLblError, gbc_clientLblError);

		JLabel lblDescriptionInfo = new JLabel("Description");
		GridBagConstraints gbc_lblDescriptionInfo = new GridBagConstraints();
		gbc_lblDescriptionInfo.anchor = GridBagConstraints.EAST;
		gbc_lblDescriptionInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescriptionInfo.gridx = 0;
		gbc_lblDescriptionInfo.gridy = 10;
		centerGrid.add(lblDescriptionInfo, gbc_lblDescriptionInfo);

		textDescriptionInfo = new JTextField();
		textDescriptionInfo.setEditable(false);
		textDescriptionInfo.setToolTipText("Sample Description");
		GridBagConstraints gbc_textTelephoe = new GridBagConstraints();
		gbc_textTelephoe.insets = new Insets(0, 0, 5, 0);
		gbc_textTelephoe.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelephoe.gridx = 1;
		gbc_textTelephoe.gridy = 10;
		centerGrid.add(textDescriptionInfo, gbc_textTelephoe);
		textDescriptionInfo.setColumns(10);

		descripitionInfoLblError = new JLabel("New label");
		descripitionInfoLblError.setForeground(Color.RED);
		descripitionInfoLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_descriptionInfoLblError = new GridBagConstraints();
		gbc_descriptionInfoLblError.anchor = GridBagConstraints.WEST;
		gbc_descriptionInfoLblError.insets = new Insets(0, 0, 5, 0);
		gbc_descriptionInfoLblError.gridx = 1;
		gbc_descriptionInfoLblError.gridy = 11;
		centerGrid.add(descripitionInfoLblError, gbc_descriptionInfoLblError);

		JLabel lblamountOfDollars = new JLabel("Amount");
		GridBagConstraints gbc_lblamountOfDollars = new GridBagConstraints();
		gbc_lblamountOfDollars.anchor = GridBagConstraints.EAST;
		gbc_lblamountOfDollars.insets = new Insets(0, 0, 5, 5);
		gbc_lblamountOfDollars.gridx = 0;
		gbc_lblamountOfDollars.gridy = 12;
		centerGrid.add(lblamountOfDollars, gbc_lblamountOfDollars);

		textamountOfDollars = new JTextField();
		textamountOfDollars.setEditable(false);
		textamountOfDollars.setToolTipText("Sample of Amount $123.45");
		GridBagConstraints gbc_textamountOfDollars = new GridBagConstraints();
		gbc_textamountOfDollars.insets = new Insets(0, 0, 5, 0);
		gbc_textamountOfDollars.fill = GridBagConstraints.HORIZONTAL;
		gbc_textamountOfDollars.gridx = 1;
		gbc_textamountOfDollars.gridy = 12;
		centerGrid.add(textamountOfDollars, gbc_textamountOfDollars);
		textamountOfDollars.setColumns(10);

		amountOfDollarsLblError = new JLabel("New label");
		amountOfDollarsLblError.setForeground(Color.RED);
		amountOfDollarsLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_amountOfDollarsLblError = new GridBagConstraints();
		gbc_amountOfDollarsLblError.anchor = GridBagConstraints.WEST;
		gbc_amountOfDollarsLblError.insets = new Insets(0, 0, 5, 0);
		gbc_amountOfDollarsLblError.gridx = 1;
		gbc_amountOfDollarsLblError.gridy = 13;
		centerGrid.add(amountOfDollarsLblError, gbc_amountOfDollarsLblError);
		
		JLabel lblPredictedClosingDate = new JLabel("Predicted Closing Date");
		GridBagConstraints gbc_lblPredictedClosingDate = new GridBagConstraints();
		gbc_lblPredictedClosingDate.anchor = GridBagConstraints.EAST;
		gbc_lblPredictedClosingDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblPredictedClosingDate.gridx = 0;
		gbc_lblPredictedClosingDate.gridy = 14;
		centerGrid.add(lblPredictedClosingDate, gbc_lblPredictedClosingDate);

		textPredictedClosingDate = new JTextField();
		textPredictedClosingDate.setEditable(false);
		textPredictedClosingDate.setToolTipText("MM/DD/YYYY");
		GridBagConstraints gbc_textPredictedClosingDate = new GridBagConstraints();
		gbc_textPredictedClosingDate.insets = new Insets(0, 0, 5, 0);
		gbc_textPredictedClosingDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPredictedClosingDate.gridx = 1;
		gbc_textPredictedClosingDate.gridy = 14;
		centerGrid.add(textPredictedClosingDate, gbc_textPredictedClosingDate);
		textPredictedClosingDate.setColumns(10);

		predictedClosingDateLblError = new JLabel("");
		predictedClosingDateLblError.setForeground(Color.RED);
		predictedClosingDateLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_predictedClosingDateLblError = new GridBagConstraints();
		gbc_predictedClosingDateLblError.anchor = GridBagConstraints.WEST;
		gbc_predictedClosingDateLblError.insets = new Insets(0, 0, 5, 0);
		gbc_predictedClosingDateLblError.gridx = 1;
		gbc_predictedClosingDateLblError.gridy = 15;
		centerGrid.add(predictedClosingDateLblError, gbc_predictedClosingDateLblError);

		JLabel lblStatus = new JLabel("Status");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.EAST;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 16;
		centerGrid.add(lblStatus, gbc_lblStatus);	

		comboBoxStatus = new JComboBox(cmbMessagesStatus);
		comboBoxStatus.setEditable(false);
		comboBoxStatus.setEnabled(false);
		GridBagConstraints gbc_comboBoxStatus = new GridBagConstraints();
		gbc_comboBoxStatus.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxStatus.gridx = 1;
		gbc_comboBoxStatus.gridy = 16;
		centerGrid.add(comboBoxStatus, gbc_comboBoxStatus);

		statusLblError = new JLabel("New label");
		statusLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		statusLblError.setForeground(Color.RED);
		GridBagConstraints gbc_statusLblbError = new GridBagConstraints();
		gbc_statusLblbError.anchor = GridBagConstraints.WEST;
		gbc_statusLblbError.insets = new Insets(0, 0, 5, 0);
		gbc_statusLblbError.gridx = 1;
		gbc_statusLblbError.gridy = 17;
		centerGrid.add(statusLblError, gbc_statusLblbError);

		this.setMessagesText("No Opportunities in the CRM");

	}

	public String getTextId()        { return textId.getText(); }
	public String getTextFirstName() { return textFirstName.getText(); }
	public String getTextLastName()  { return textLastName.getText(); }
	public String getTextStartDate()   { return textStartDate.getText(); }
	public String getTextPredictedClosingDate() {return textPredictedClosingDate.getText();}
	public String getTextDescriptionInfo() { return textDescriptionInfo.getText(); }
	public String getTextAmountOfDollars()     { return textamountOfDollars.getText(); }

	public void setTextId(String textId)               { this.textId.setText(textId); }
	public void setTextFirstName(String textFirstName) { this.textFirstName.setText(textFirstName); }
	public void setTextLastName(String textLastName)   { this.textLastName.setText(textLastName); }
	public void setTextStartDate(String textStartDate)     { this.textStartDate.setText(textStartDate); }
	public void setTextPredictedClosingDate(String textPredictedClosingDate) {this.textPredictedClosingDate.setText(textPredictedClosingDate);}
	public void setTextDescriptionInfo(String textTelephoe)  { this.textDescriptionInfo.setText(textTelephoe); }
	public void setTextAmountOfDollars(String textamountOfDollars)         { this.textamountOfDollars.setText(textamountOfDollars); }

	public int getSelectedClientIndex() {
		return comboBoxClient.getSelectedIndex();
	}

	public void setSelectedClientIndex(int index) {
		if (index >= 0 && index <= comboBoxClient.getItemCount()) {
			comboBoxClient.setEnabled(false);
			comboBoxClient.setSelectedIndex(index);
			comboBoxClient.setEnabled(true);
		}
	}

	public void setSelectClientItems(ArrayList<CRMBean> list) {
		comboBoxClient.removeAllItems();
		for (CRMBean item : list) {
			comboBoxClient.addItem(new ClientForComboBox(item.getId(), item.getDescription()));
		}
	}

	public void setSelectClientListener(ActionListener listener) {
		comboBoxClient.addActionListener(listener);
	}
	

	public String getErrorFirstName() { return firstNameLblError.getText(); }
	public String getErrorLasttName() { return lastNameLblError.getText(); }
	public String getErrorStartDate()   { return startDateLblError.getText(); }
	public String getErrorPredictedClosingDate() {return predictedClosingDateLblError.getText();}
	public String getErrorDescriptionInfo() { return descripitionInfoLblError.getText(); }
	public String getErrorAmountOfDollars()     { return amountOfDollarsLblError.getText(); }

	public void setErrorFirstName(String errorFirstName) { firstNameLblError.setText(errorFirstName); }
	public void setErrorLastName(String errorLastName)   { lastNameLblError.setText(errorLastName); }
	public void setErrorStartDate(String errorStartDate)     { startDateLblError.setText(errorStartDate); }
	public void setErrorPredictedClosingDate(String errorPredictedClosingDate) {predictedClosingDateLblError.setText(errorPredictedClosingDate);}
	public void setErrorDescriptionInfo(String errorDescriptionInfo) { descripitionInfoLblError.setText(errorDescriptionInfo); }
	public void setErrorAmountOfDollars(String erroramountOfDollars)         { amountOfDollarsLblError.setText(erroramountOfDollars); }

	public void beanToForm(CRMBean bean) {
		OpportunitiesBean cb = (OpportunitiesBean) bean;
		this.setTextId(""+cb.getId());
		this.setTextFirstName(cb.getFirstName());
		this.setTextLastName(cb.getLastName());
		this.setTextStartDate(cb.getStartDate());
		this.setTextPredictedClosingDate(cb.getPredictedClosingDate());
		for (int i=0; i < comboBoxClient.getItemCount(); i++) {
			ClientForComboBox item = comboBoxClient.getItemAt(i);
			if (item.getId() == cb.getId()) {
				this.setSelectedClientIndex(i);
			}
		}
		this.setTextDescriptionInfo(cb.getDescriptionInfo());
		this.setTextAmountOfDollars(cb.getAmountOfDollars());
	}

	public void formToBean(CRMBean bean) {
		OpportunitiesBean cb = (OpportunitiesBean) bean;
		cb.setFirstName(textFirstName.getText());
		cb.setLastName(textLastName.getText());
		cb.setStartDate(textStartDate.getText());
		cb.setClient(((ClientForComboBox) comboBoxClient.getSelectedItem()).getId());
		cb.setDescriptionInfo(textDescriptionInfo.getText());
		cb.setAmountOfDollars(textamountOfDollars.getText());
		cb.setPredictedClosingDate(textPredictedClosingDate.getText());
		cb.setStatus((String)comboBoxStatus.getSelectedItem());
	}

	public void enableEditMode() { 
		super.enableEditMode();
		textFirstName.setEditable(true);
		textLastName.setEditable(true);
		textStartDate.setEditable(true);
		comboBoxClient.setEnabled(true);
		textDescriptionInfo.setEditable(true);
		textamountOfDollars.setEditable(true);
		textPredictedClosingDate.setEditable(true);
		comboBoxStatus.setEnabled(true);
	}
	public void disableEditMode() {
		super.disableEditMode();
		textId.setEditable(false);
		textFirstName.setEditable(false);
		textLastName.setEditable(false);
		textStartDate.setEditable(false);
		comboBoxClient.setEnabled(false);
		textDescriptionInfo.setEditable(false);
		textamountOfDollars.setEditable(false);
		textPredictedClosingDate.setEditable(false);
		comboBoxStatus.setEnabled(false);
	}

	public void clearForm() {
		textId.setText("");
		textFirstName.setText("");
		textLastName.setText("");
		textStartDate.setText("");
		if (comboBoxClient.getItemCount() > 0) { comboBoxClient.setSelectedIndex(0); }
		textDescriptionInfo.setText("");
		textamountOfDollars.setText("");
		textPredictedClosingDate.setText("");
		if (comboBoxStatus.getItemCount() > 0) { comboBoxStatus.setSelectedIndex(0); }
		clearFieldErrors();
	}

	public void clearFieldErrors() {
		idLblError.setText("");
		firstNameLblError.setText("");
		lastNameLblError.setText("");
		startDateLblError.setText("");
		clientLblError.setText("");
		descripitionInfoLblError.setText("");
		amountOfDollarsLblError.setText("");
		predictedClosingDateLblError.setText("");
		statusLblError.setText("");
	}
}
