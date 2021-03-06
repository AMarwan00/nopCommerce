package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase 
{
	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="small-searchterms")
	WebElement searchTextBox ; 

	@FindBy(xpath="//*[@id=\"small-search-box-form\"]/button")
	WebElement searchBtn ; 

	@FindBy(id="ui-id-1")
	List<WebElement> ProductList ; 

	@FindBy(xpath="//*[@id=\"ui-id-5\"]/span")
	WebElement productTitle; 

	public void ProductSearch(String productName) 
	{
		setTextElementText(searchTextBox, productName);
		clickButton(searchBtn);
	}

	public void OpenProductDetailsPage() 
	{

		clickButton(productTitle);
	}

	public void ProductSearchUsingAutoSuggest(String searchTxt) 
	{
		setTextElementText(searchTextBox, searchTxt);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ProductList.get(0).click();
	}

}
