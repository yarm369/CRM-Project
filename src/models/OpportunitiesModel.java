package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import beans.CRMBean;
import beans.OpportunitiesBean;

public class OpportunitiesModel extends CRMModel {

	private static String OPPORTUNITIES_FILE = "data/opportunities.tsv";

	public OpportunitiesModel() {
		super();
	}
	
	@Override
	public void doInit() {
		super.doInit();
		ArrayList<CRMBean> beans = parseBeansFromFile(OPPORTUNITIES_FILE);
		this.setList(beans);
		this.setIndex(0);
	}

	@Override
	public void doAdd() {
		long id = 1;
		if (this.getCount() > 0) {
			id = ((OpportunitiesBean) this.getBean(this.getCount()-1)).getId() + 1;
		}
		this.getAllBeans().add(new OpportunitiesBean(id));
		this.setIndex(this.getCount() - 1);  // New record becomes the current one
	}

	@Override
	public void doSave() {
		super.doSave();
		saveBeansToFile(OPPORTUNITIES_FILE);
	}

	public ArrayList<CRMBean> parseBeansFromFile(String filename) {
		File inputFile = new File(filename);
		try {
			ArrayList<CRMBean> opportunitiesBeans = new ArrayList<CRMBean>();
			Scanner inputScanner = new Scanner(inputFile);
			inputScanner.nextLine();  // Ignore header line
			int count = 0;
			inputScanner.useDelimiter("[\t\n]");
			while (inputScanner.hasNextLine()) {
				String ID = inputScanner.next();
				int id = Integer.parseInt(ID);
				OpportunitiesBean newBean = new OpportunitiesBean(id);
				String firstName = inputScanner.next();
				newBean.setFirstName(firstName);
				String lastName = inputScanner.next();
				newBean.setLastName(lastName);
				String startDate = inputScanner.next();
				newBean.setStartDate(startDate);
				String client = inputScanner.next();
				int clientId = Integer.parseInt(client);
				newBean.setClient(clientId);
				String descriptionInfo = inputScanner.next();
				newBean.setDescriptionInfo(descriptionInfo);
				String amountOfDollars = inputScanner.next();
				newBean.setAmountOfDollars(amountOfDollars);
				String predictedClosingDate = inputScanner.next();
				newBean.setPredictedClosingDate(predictedClosingDate);
				String status = inputScanner.next();
				newBean.setStatus(status);
				inputScanner.nextLine();  // Skip over anything left in line
				opportunitiesBeans.add(newBean);
				count++;
			}
			inputScanner.close();
			return opportunitiesBeans;
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Input file not Found");
		}
	}
	
	public String beanToFileLine(CRMBean bean) {

		String result = "";
		OpportunitiesBean cb = (OpportunitiesBean) bean;
		result += cb.getId();
		result += '\t';
		result += cb.getFirstName();
		result += '\t';
		result += cb.getLastName();
		result += '\t';
		result += cb.getStartDate();
		result += '\t';
		if (cb.getClient() < 0) {
			result += "-1";
		}
		else {
			result += ""+cb.getClient();
		}
		result += '\t';
		result += cb.getDescriptionInfo();
		result += '\t';
		result += cb.getAmountOfDollars();
		result += '\t';
		result += cb.getPredictedClosingDate();
		result += '\t';
		result += cb.getStatus();
		return result;
		
	}

	public void saveBeansToFile(String filename) {
		
		ArrayList<CRMBean> opportunitiesBeans = getAllBeans();
		File outputFile = new File(filename);
		try {
			PrintWriter out = new PrintWriter(outputFile);
			// Print Header Line
			out.println("TinyCRM Opportunities data file");
			for (CRMBean bean : opportunitiesBeans) {
				out.println(beanToFileLine(bean));
			}
			out.close();
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Output file not Found");
		}
	}

}
