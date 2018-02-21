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
import javax.swing.border.LineBorder;

import beans.CRMBean;
import beans.ContactBean;
import views.ContactTCRMView;

public class ContactSwingView extends SwingView implements ContactTCRMView {

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
	private JTextField textCompany;
	private JComboBox<ClientForComboBox> comboBoxClient;
	private JTextField textTelephone;
	private JTextField textEmail;
	private JTextField textFacebook;

	private JLabel idLblError;
	private JLabel firstNameLblError;
	private JLabel lastNameLblError;
	private JLabel companyLblError;
	private JLabel clientLblError;
	private JLabel telephoneLblError;
	private JLabel emailLblError;
	private JLabel facebookLblError;

	/**
	 * Create the frame.
	 */
	public ContactSwingView() {
		super();
		setTitle("Contacts");

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

		JLabel lblCompany = new JLabel("Company");
		GridBagConstraints gbc_lblCompany = new GridBagConstraints();
		gbc_lblCompany.anchor = GridBagConstraints.EAST;
		gbc_lblCompany.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompany.gridx = 0;
		gbc_lblCompany.gridy = 6;
		centerGrid.add(lblCompany, gbc_lblCompany);

		textCompany = new JTextField();
		textCompany.setEditable(false);
		GridBagConstraints gbc_textCompany = new GridBagConstraints();
		gbc_textCompany.insets = new Insets(0, 0, 5, 0);
		gbc_textCompany.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCompany.gridx = 1;
		gbc_textCompany.gridy = 6;
		centerGrid.add(textCompany, gbc_textCompany);
		textCompany.setColumns(10);

		companyLblError = new JLabel("New label");
		companyLblError.setForeground(Color.RED);
		companyLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_companyLblError = new GridBagConstraints();
		gbc_companyLblError.anchor = GridBagConstraints.WEST;
		gbc_companyLblError.insets = new Insets(0, 0, 5, 0);
		gbc_companyLblError.gridx = 1;
		gbc_companyLblError.gridy = 7;
		centerGrid.add(companyLblError, gbc_companyLblError);

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
		//comboBoxClient.setColumns(10);

		JLabel lblTelephone = new JLabel("Telephone");
		GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
		gbc_lblTelephone.anchor = GridBagConstraints.EAST;
		gbc_lblTelephone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephone.gridx = 0;
		gbc_lblTelephone.gridy = 10;
		centerGrid.add(lblTelephone, gbc_lblTelephone);

		textTelephone = new JTextField();
		textTelephone.setEditable(false);
		textTelephone.setToolTipText("(xxx) xxx-xxxx");
		GridBagConstraints gbc_textTelephoe = new GridBagConstraints();
		gbc_textTelephoe.insets = new Insets(0, 0, 5, 0);
		gbc_textTelephoe.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelephoe.gridx = 1;
		gbc_textTelephoe.gridy = 10;
		centerGrid.add(textTelephone, gbc_textTelephoe);
		textTelephone.setColumns(10);

		telephoneLblError = new JLabel("New label");
		telephoneLblError.setForeground(Color.RED);
		telephoneLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_telephoneLblError = new GridBagConstraints();
		gbc_telephoneLblError.anchor = GridBagConstraints.WEST;
		gbc_telephoneLblError.insets = new Insets(0, 0, 5, 0);
		gbc_telephoneLblError.gridx = 1;
		gbc_telephoneLblError.gridy = 11;
		centerGrid.add(telephoneLblError, gbc_telephoneLblError);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 12;
		centerGrid.add(lblEmail, gbc_lblEmail);

		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setToolTipText("JohnDoe@gmail.com");
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 12;
		centerGrid.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);

		emailLblError = new JLabel("New label");
		emailLblError.setForeground(Color.RED);
		emailLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_emailLblError = new GridBagConstraints();
		gbc_emailLblError.anchor = GridBagConstraints.WEST;
		gbc_emailLblError.insets = new Insets(0, 0, 5, 0);
		gbc_emailLblError.gridx = 1;
		gbc_emailLblError.gridy = 13;
		centerGrid.add(emailLblError, gbc_emailLblError);

		JLabel lblFacebook = new JLabel("Facebook");
		GridBagConstraints gbc_lblFacebook = new GridBagConstraints();
		gbc_lblFacebook.anchor = GridBagConstraints.EAST;
		gbc_lblFacebook.insets = new Insets(0, 0, 5, 5);
		gbc_lblFacebook.gridx = 0;
		gbc_lblFacebook.gridy = 14;
		centerGrid.add(lblFacebook, gbc_lblFacebook);

		textFacebook = new JTextField();
		textFacebook.setEditable(false);
		GridBagConstraints gbc_textFacebook = new GridBagConstraints();
		gbc_textFacebook.insets = new Insets(0, 0, 5, 0);
		gbc_textFacebook.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFacebook.gridx = 1;
		gbc_textFacebook.gridy = 14;
		centerGrid.add(textFacebook, gbc_textFacebook);
		textFacebook.setColumns(10);

		facebookLblError = new JLabel("New label");
		facebookLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		facebookLblError.setForeground(Color.RED);
		GridBagConstraints gbc_facebookLblbError = new GridBagConstraints();
		gbc_facebookLblbError.anchor = GridBagConstraints.WEST;
		gbc_facebookLblbError.insets = new Insets(0, 0, 5, 0);
		gbc_facebookLblbError.gridx = 1;
		gbc_facebookLblbError.gridy = 15;
		centerGrid.add(facebookLblError, gbc_facebookLblbError);

		this.setMessagesText("No Contacts in the CRM");

	}

	public String getTextId()        { return textId.getText(); }
	public String getTextFirstName() { return textFirstName.getText(); }
	public String getTextLastName()  { return textLastName.getText(); }
	public String getTextCompany()   { return textCompany.getText(); }
	public String getTextTelephone() { return textTelephone.getText(); }
	public String getTextEmail()     { return textEmail.getText(); }
	public String getTextFacebook()  { return textFacebook.getText(); }

	public void setTextId(String textId)               { this.textId.setText(textId); }
	public void setTextFirstName(String textFirstName) { this.textFirstName.setText(textFirstName); }
	public void setTextLastName(String textLastName)   { this.textLastName.setText(textLastName); }
	public void setTextCompany(String textCompany)     { this.textCompany.setText(textCompany); }
	public void setTextTelephone(String textTelephoe)  { this.textTelephone.setText(textTelephoe); }
	public void setTextEmail(String textEmail)         { this.textEmail.setText(textEmail); }
	public void setTextFacebook(String textFacebook)   { this.textFacebook.setText(textFacebook); }

	public int getSelectedClientIndex() {
		return comboBoxClient.getSelectedIndex();
	}

	public void setSelectedClientIndex(int index) {
		if (index >= 0 && index <= comboBoxClient.getItemCount()) {
			boolean previous = comboBoxClient.isEnabled();
			comboBoxClient.setEnabled(false);
			comboBoxClient.setSelectedIndex(index);
			comboBoxClient.setEnabled(previous);
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
	public String getErrorCompany()   { return companyLblError.getText(); }
	public String getErrorTelephone() { return telephoneLblError.getText(); }
	public String getErrorEmail()     { return emailLblError.getText(); }
	public String getErrorFacebook()  { return facebookLblError.getText(); }

	public void setErrorFirstName(String errorFirstName) { firstNameLblError.setText(errorFirstName); }
	public void setErrorLastName(String errorLastName)   { lastNameLblError.setText(errorLastName); }
	public void setErrorCompany(String errorCompany)     { companyLblError.setText(errorCompany); }
	public void setErrorTelephone(String errorTelephone) { telephoneLblError.setText(errorTelephone); }
	public void setErrorEmail(String errorEmail)         { emailLblError.setText(errorEmail); }
	public void setErrorFacebook(String errorFacebok)    { facebookLblError.setText(errorFacebok); }

	public void beanToForm(CRMBean bean) {
		ContactBean cb = (ContactBean) bean;
		this.setTextId(""+cb.getId());
		this.setTextFirstName(cb.getFirstName());
		this.setTextLastName(cb.getLastName());
		this.setTextCompany(cb.getCompany());
		for (int i=0; i < comboBoxClient.getItemCount(); i++) {
			ClientForComboBox item = comboBoxClient.getItemAt(i);
			if (item.getId() == cb.getId()) {
				this.setSelectedClientIndex(i);
			}
		}
		this.setTextTelephone(cb.getTelephone());
		this.setTextEmail(cb.getEmail());
		this.setTextFacebook(cb.getFacebook());
	}

	public void formToBean(CRMBean bean) {
		ContactBean cb = (ContactBean) bean;
		//cb.setId(Integer.parseInt(textId.getText()));  // Id is never editable
		cb.setFirstName(textFirstName.getText());
		cb.setLastName(textLastName.getText());
		cb.setCompany(textCompany.getText());
		cb.setClient(((ClientForComboBox) comboBoxClient.getSelectedItem()).getId());
		cb.setTelephone(textTelephone.getText());
		cb.setEmail(textEmail.getText());
		cb.setFacebook(textFacebook.getText());
	}

	public void enableEditMode() { 
		super.enableEditMode();
		//textId.setEditable(true);
		textFirstName.setEditable(true);
		textLastName.setEditable(true);
		textCompany.setEditable(true);
		comboBoxClient.setEnabled(true);
		textTelephone.setEditable(true);
		textEmail.setEditable(true);
		textFacebook.setEditable(true);
	}
	public void disableEditMode() {
		super.disableEditMode();
		textId.setEditable(false);
		textFirstName.setEditable(false);
		textLastName.setEditable(false);
		textCompany.setEditable(false);
		comboBoxClient.setEnabled(false);
		//comboBoxClient.setEditable(false);
		textTelephone.setEditable(false);
		textEmail.setEditable(false);
		textFacebook.setEditable(false);
	}

	public void clearForm() {
		textId.setText("");
		textFirstName.setText("");
		textLastName.setText("");
		textCompany.setText("");
		if (comboBoxClient.getItemCount() > 0) { comboBoxClient.setSelectedIndex(0); }
		textTelephone.setText("");
		textEmail.setText("");
		textFacebook.setText("");
		clearFieldErrors();
	}

	public void clearFieldErrors() {
		idLblError.setText("");
		firstNameLblError.setText("");
		lastNameLblError.setText("");
		companyLblError.setText("");
		clientLblError.setText("");
		telephoneLblError.setText("");
		emailLblError.setText("");
		facebookLblError.setText("");
	}


}