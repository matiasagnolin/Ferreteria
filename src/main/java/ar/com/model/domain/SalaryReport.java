package ar.com.model.domain;

import java.io.Serializable;

public class SalaryReport implements Serializable{
	private double basicSalary;
	private double awards;
	private double commission;
	private Empleado employee;
	private String StartDate;
	private String EndDate;
	
	public SalaryReport(){}
	
	public SalaryReport(double basicSalary,double awards,double commission,Empleado employee,String start,String end)
	{
		this.awards=awards;
		this.basicSalary=basicSalary;
		this.employee=employee;
		this.commission=commission;
		this.StartDate=start;
		this.EndDate=end;
	}
	
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getAwards() {
		return awards;
	}
	public void setAwards(double awards) {
		this.awards = awards;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public Empleado getEmployee() {
		return employee;
	}
	public void setEmployee(Empleado employee) {
		this.employee = employee;
	}
	
	
}
