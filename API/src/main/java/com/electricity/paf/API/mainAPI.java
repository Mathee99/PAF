package com.electricity.paf.API;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.electricity.paf.Model.Customer;
import com.electricity.paf.Model.Employee;
import com.electricity.paf.Model.Payment;
import com.electricity.paf.Model.PowerDetails;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("API")
public class mainAPI {

	Customer CustomerObj = new Customer();
	Employee EmployeeObj = new Employee();
	Payment PaymentObj = new Payment();
	PowerDetails PowerDetailsObj = new PowerDetails();
	
	@GET
	@Path("/getAllCoustomerInfo")
	@Produces(MediaType.TEXT_PLAIN)
	public String readCustomer() {
		return CustomerObj.readCustomer();
	}
	
	@POST
	@Path("/addCoustomer")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCustomer(@FormParam("cusName") String cusName,			
	 @FormParam("cusAddress") String cusAddress,
	 @FormParam("cusNIC") String cusNIC,
	 @FormParam("cusEmail") String cusEmail,
	 @FormParam("cusPno") String cusPno)
	{
	 String output = CustomerObj.insertCustomer(cusName, cusAddress, cusNIC, cusEmail, cusPno);
	return output;
	}
	
	@PUT
	@Path("/updateCoustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCustomer(String custData)
	{
	//Convert the input string to a JSON object
	 JsonObject cusObject = new JsonParser().parse(custData).getAsJsonObject();
	//Read the values from the JSON object
	 String cusID = cusObject.get("cusID").getAsString();
	 String cusName = cusObject.get("cusName").getAsString();
	 String cusAddress = cusObject.get("cusAddress").getAsString();
	 String cusNIC = cusObject.get("cusNIC").getAsString();
	 String cusEmail = cusObject.get("cusEmail").getAsString();
	 String cusPno = cusObject.get("cusPno").getAsString();
	 String output = CustomerObj.updateCustomer(cusID, cusName, cusAddress, cusNIC, cusEmail, cusPno);
	return output;
	} 
	
	@DELETE
	@Path("/removeCoustomer")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCustomer(@FormParam("custData") String custData)
	{
		
	//Convert the input string to an XML document
	// Document doc = Jsoup.parse(custData, "", Parser.xmlParser());

	//Read the value from the element <ID>
	// String cusID = doc.select("cusID").text();
	 String cusID = custData;

	 String output = CustomerObj.deleteCustomer(cusID);
	return output;
	}
	
	
	@GET
	@Path("/getAllEmployeeInfo")
	@Produces(MediaType.TEXT_HTML)
	public String readEmployee() {
		return EmployeeObj.readEmployee();
	}
	
	@POST
	@Path("/addEmployeeInfo")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertEmployee(@FormParam("empName") String empName,			
	 @FormParam("empAddress") String empAddress,
	 @FormParam("empNIC") String empNIC,
	 @FormParam("empDOB") String empDOB,
	 @FormParam("empContact") String empContact)
	{
	 String output = EmployeeObj.insertEmployee(empName, empAddress, empNIC, empDOB, empContact);
	return output;
	}
	
	@PUT
	@Path("/updateEmployeeInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateEmployee(String empData)
	{
	//Convert the input string to a JSON object
	 JsonObject empObject = new JsonParser().parse(empData).getAsJsonObject();
	//Read the values from the JSON object
	 String empID = empObject.get("empID").getAsString();
	 String empName = empObject.get("empName").getAsString();
	 String empAddress = empObject.get("empAddress").getAsString();
	 String empNIC = empObject.get("empNIC").getAsString();
	 String empDOB = empObject.get("empDOB").getAsString();
	 String empContact = empObject.get("empContact").getAsString();
	 String output = EmployeeObj.updateEmployee(empID, empName, empAddress, empNIC, empDOB, empContact);
	return output;
	} 
	
	@DELETE
	@Path("/removeEmployeeInfo")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployee( @FormParam("empData") String empData)
	{
	//Convert the input string to an XML document
	 //Document doc = Jsoup.parse(empData, "", Parser.xmlParser());

	//Read the value from the element <ID>
	 String empID = empData;
	 String output = EmployeeObj.deleteEmployee(empID);
	return output;
	}
	
	@GET
	@Path("/getAllPaymentInfo")
	@Produces(MediaType.TEXT_HTML)
	public String readPayment() {
		return PaymentObj.readPayment();
	}

	@POST
	@Path("/addPaymentInfo")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayment(@FormParam("pAccNo") String pAccNo, 
			@FormParam("pCus") String pCus,
			@FormParam("pDate") String pDate,
			@FormParam("pAmount") String pAmount) {
		String output = PaymentObj.insertPayment(pAccNo,pCus, pDate, pAmount);
		return output;
	}
	
	@PUT
	@Path("/updatePaymentInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String updatePayment(String paymentData) {
		// Convert the input string to a JSON object
		JsonObject PayObject = new JsonParser().parse(paymentData).getAsJsonObject();

		// Read the values from the JSON object
		String pID = PayObject.get("pID").getAsString();
		String pAccNo = PayObject.get("pAccNo").getAsString();
		String pCus = PayObject.get("pCus").getAsString();
		String pDate = PayObject.get("pDate").getAsString();
		String pAmount = PayObject.get("pAmount").getAsString();
		
		String output = PaymentObj.updatePayment(pID, pAccNo, pCus, pDate, pAmount);
		return output;
	}
	
	@DELETE
	@Path("/removePaymentInfo")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayment(@FormParam("paymentData") String paymentData) {
		// Convert the input string to an XML document
		//Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser());

		// Read the value from the element
		String pID = paymentData;
		String output = PaymentObj.deletePayment(pID);
		return output;
	}
	
	
	@GET
	@Path("/getAllPowerDetails")
	@Produces(MediaType.TEXT_HTML)
	public String readPowerDetails() {
		return PowerDetailsObj.readPowerDetails();
	}
	
	@POST
	@Path("/addPowerDetailsInfo")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPowerDetails(@FormParam("pdCusName") String pdCusName,			
	 @FormParam("pdAccNo") String pdAccNo,
	 @FormParam("psUnit") String psUnit,
	 @FormParam("pdDate") String pdDate,
	 @FormParam("pdPay") String pdPay)
	{
	 String output = PowerDetailsObj.insertPowerDetails(pdCusName, pdAccNo, psUnit, pdDate, pdPay);
	return output;
	}
	
	@PUT
	@Path("/updatePowerDetailsInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePowerDetails(String powerData)
	{
	//Convert the input string to a JSON object
	 JsonObject powerObject = new JsonParser().parse(powerData).getAsJsonObject();
	//Read the values from the JSON object
	 String pdID = powerObject.get("pdID").getAsString();
	 String pdCusName = powerObject.get("pdCusName").getAsString();
	 String pdAccNo = powerObject.get("pdAccNo").getAsString();
	 String psUnit = powerObject.get("psUnit").getAsString();
	 String pdDate = powerObject.get("pdDate").getAsString();
	 String pdPay = powerObject.get("pdPay").getAsString();
	 String output = PowerDetailsObj.updatePowerDetails(pdID, pdCusName, pdAccNo, psUnit, pdDate, pdPay);
	return output;
	} 
	
	@DELETE 
	@Path("/removePowerDetails")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePowerDetails(@FormParam("powerData") String powerData)
	{
	//Convert the input string to an XML document
	// Document doc = Jsoup.parse(powerData, "", Parser.xmlParser());

	//Read the value from the element <ID>
	 String pdID = powerData;
	 String output = PowerDetailsObj.deletePowerDetails(pdID);
	return output;
	}
	
}
