package regSuite_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import regSuite_BaseSuite.BaseSuite;
import regSuits_Utils.DriverActions;

public class AmazonMusicPage extends BaseSuite{
	WebDriver driver;
	
	String AmazonMusicMenuItem = "//a[@class='hmenu-item']/div[text()='Amazon Prime Music']";
	String AmazonMusicSubMenuItem = "//div[@id='hmenu-content']/ul[7]/li[3]/a";
	String APMImage = "//img[@alt='Digital Music']";
	
	@FindBy(id="nav-hamburger-menu")
    WebElement  Menu;
	
	@FindBy(xpath="//a[@class='hmenu-item']/div[text()='Amazon Prime Music']")
	WebElement AmazonMusic;
	
	@FindBy(xpath="//div[@id='hmenu-content']/ul[7]/li[3]/a")
	WebElement AmazonMusicSubMenu;
	
	@FindBy(xpath="//img[@alt='Digital Music']")
	WebElement PrimeMusicImage;
	
	public AmazonMusicPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void NavigateToPrimeMusicImage() throws InterruptedException
    {
		DriverActions.clickElementBy(Menu);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AmazonMusicMenuItem)));
		DriverActions.clickElementBy(AmazonMusic);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AmazonMusicSubMenuItem)));
		DriverActions.clickElementBy(AmazonMusicSubMenu);
	}	
	
	public void assertPrimeMusicImage() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(APMImage)));
		Assert.assertTrue(DriverActions.isElementVisible(PrimeMusicImage));
	}
}



