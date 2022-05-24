
  package com.pageObjects;
  
 import org.openqa.selenium.WebDriver; import
  org.openqa.selenium.WebElement; import
  org.openqa.selenium.support.CacheLookup; import
  org.openqa.selenium.support.FindBy; import
  org.openqa.selenium.support.PageFactory; import org.testng.Assert;

import com.utilities.BaseClass;
  
  
  public class SearchBladePage extends BaseClass{
  
  WebDriver ldriver;
  
  public SearchBladePage(WebDriver rdriver) {
	  this.ldriver = rdriver;
  PageFactory.initElements(rdriver, this); 
  }
  
//*[@id="accordion-element-NitMq"]/div[1]/h3
  @FindBy(xpath = "//span[contains(text(),'Search')]")
    @CacheLookup 
    public WebElement SearchBlade;
  
  @FindBy(xpath = "//button[@class='btn-primary entity-search-button btn']")
    @CacheLookup 
    public WebElement SearchButton;
    
  @FindBy(xpath ="(//span[@class='select2-selection select2-selection--single'])[1]")
    @CacheLookup 
    public WebElement Searches_Editfield;
 
  @FindBy(xpath = "(//span[@class='dropdown-title'])[1]")
    @CacheLookup 
    public WebElement Searches_Header_Panel2;

  @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")
    @CacheLookup 
    public WebElement firstrow;

  @FindBy(xpath ="//select[@class='col-md-12 entity-search-dropdown jquery-select2 select2-hidden-accessible']")
    @CacheLookup 
  public WebElement SelectfromSearchList;
  
  @FindBy(xpath = "(//div[@class='panel-navigator-content'])[3]")
    @CacheLookup 
    public WebElement panel3;
  
  
  
  public void panel1_SearchValidation() { 
	  pauseExecution(10000);
  ClickObj(SearchBlade, "Search Blade"); 
  boolean searchbutton = getElementDiaplay(SearchButton, "Search Button"); 
  pauseExecution(5000); 
  
  if(searchbutton == false) 
  { 
	  ClickObj(SearchBlade, "Search Blade");
 
  } 
  pauseExecution(10000); 
  ClickObj(SearchButton, "Search Button");
  pauseExecution(10000);
  String Searches_Edit_field_text = getElementText(Searches_Editfield, "Searches Edit field text is: " +Searches_Editfield.getText()); 
  pauseExecution(5000); 
  String SearchesHeadertextPanel2 = getElementText(Searches_Header_Panel2,"Searches header text on panel 2 is: " + Searches_Header_Panel2.getText());
  if (SearchesHeadertextPanel2.contains(Searches_Edit_field_text)) {
  Assert.assertTrue(true); 
  } else { 
	  Assert.assertTrue(false); 
  } 
  boolean first_row = getElementDiaplay(firstrow, "First Row");
  
  if (first_row = false) {
  
  selectIndexfromlist(SelectfromSearchList, (1), "Select first entry from Searches dropdown"); 
  pauseExecution(5000);
  ClickObj(SearchButton, "Search Button"); 
  pauseExecution(5000);
  ClickObj(firstrow, "First Row"); 
  } else { 
	  ClickObj(firstrow, "First Row"); }
  pauseExecution(5000);
  
  boolean P3 = getElementDiaplay(panel3, "Panel 3");
  
  if (P3 == true) { 
	  Assert.assertTrue(true); 
  } else { 
	  Assert.assertTrue(false);
  } 
  } 
  } 
  
  
 