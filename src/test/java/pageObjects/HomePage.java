package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	WebElement dashboardlabel;
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement clkicon;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logoutlnk;
	
	
	public boolean isDashboardPageExists()
	{
		boolean b=dashboardlabel.isDisplayed();
		return b;
		
	}
	public void ClkOnLogout()
	{
		clkicon.click();
		Actions act=new Actions(driver);
		act.moveToElement(logoutlnk).click().build().perform();
	}
	
	
		
	
}
