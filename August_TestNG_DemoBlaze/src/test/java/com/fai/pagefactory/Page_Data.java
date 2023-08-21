package com.fai.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fai.basepackage.BaseClass;

public class Page_Data extends BaseClass{
	
	public Page_Data() {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id ="login2")
	public WebElement Login;
	
	@FindBy(id = "loginusername")
	public WebElement U_Name;
	
	@FindBy(id = "loginpassword")
	public WebElement password;
	
	@FindBy(xpath = "//button[text()='Log in']")
	public WebElement Loginbtn;
	
	//@FindBy(xpath ="//a[@class= 'list-group-item'][2]")
	//public WebElement Phones;
	
	@FindBy(xpath ="//a[text()='Laptops']")
	public WebElement Laptops; 
	
	@FindBy(xpath = "//a[text()='Sony vaio i7']")
	public WebElement Sonyi7;
	
	@FindBy(id ="next2")
	public WebElement nextpg;
	
	@FindBy(xpath = "//a[text()='MacBook air']")
	public WebElement MacBook;
	
	@FindBy(xpath = "//a[text()='Add to cart']")
	public WebElement addtocart;
	
	@FindBy(xpath = "//a[text()='Cart']")
	public WebElement Cart_Click;
	
	@FindBy(xpath = "//button[text()='Place Order']")
	public WebElement Place_Order;
	
	@FindBy(xpath ="//a[@class= 'list-group-item'][4]")
	public WebElement Monitors;
	
	
	@FindBy(id = "name")
	public WebElement name_Place_Order;
	
	@FindBy (id = "country")
	public WebElement Country;
	
	@FindBy(id = "city")
	public WebElement City;
	
	@FindBy(id = "card")
	public WebElement CC_Card;
	
	@FindBy(id = "month")
	public WebElement Month;
	
	@FindBy(id = "year")
	public WebElement Year;
	
	@FindBy(xpath = "//button[text()='Purchase']")
	public WebElement Purchase;
	
	@FindBy(xpath = "//button[text()='OK']")
	public WebElement okbtn;
	
	@FindBy(xpath = "//a[text()='Welcome anandhakrishnan']") //For Validation(Assertion)
	public WebElement welcome_user_name;
	
	
	@FindBy(xpath = "//a[text()='Amazon Science']")
	public WebElement Amazon_Science;
	
	@FindBy(xpath = "//a[text()='Amazon Web Services']")
	public WebElement aws;
	
	@FindBy(xpath = "//a[text()='Careers']")
	public WebElement career;
	
	@FindBy(xpath="//input[@type='search']")
	public WebElement SearchBar;
	
	@FindBy(xpath= "//a[text()='Deals']")
	public WebElement Deals;
	
	@FindBy(xpath="//a[text()='All Departments']")
	public WebElement All_Department;
	
	@FindBy (xpath = "//a[text()='Electronics']")
	public WebElement Electronics;
	
	@FindBy(xpath= "//span[text()='Wearable tech']")
	public WebElement Wearable;
		
}
