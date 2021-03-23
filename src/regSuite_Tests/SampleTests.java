package regSuite_Tests;

import java.util.logging.Logger;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import regSuite_BaseSuite.BaseSuite;
import regSuite_PageObjects.HomePage;

public class SampleTests extends BaseSuite {
	HomePage homepage;
	static Logger log = Logger.getLogger(SampleTests.class.getName());

	
	@Test(priority=2)
	@Parameters("BookName")
	public void searchABook(String bookName) throws Exception{
		log.info("Search a Book Testcase");
		homepage = new HomePage(getWebDriver());
		homepage.searchBook(bookName);
		homepage.assertSearchTitle();
	}

}
