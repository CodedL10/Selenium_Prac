package SeleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.CharMatcher;

public class selprac {
	
	private static String itemweight;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/KIIT/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/#/practice-project");
		driver.findElement(By.id("name")).sendKeys("Liza");
		driver.findElement(By.id("email")).sendKeys("lipsa.mishra@highradius.com");
		driver.findElement(By.id("form-submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Automation Practise - 1')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class=\"search-keyword\"] ")).sendKeys("Brocolli");
		// driver.findElement(By.xpath("//[@class=\"search-button\"]")).click();
		Thread.sleep(5000);
		String itemp = driver.findElement(By.xpath("//p[@class = \"product-price\"]")).getText();
		
		driver.findElement(By.xpath("//a[@class = \"increment\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class = \"product-action\"]")).click();
		WebElement Itemname = driver.findElement(By.xpath("//h4[@class=\"product-name\"]"));
		String x = Itemname.getText();
		String Itemn = x.contains(" ") ? x.split(" ")[0] : x;
		
		itemweight = CharMatcher.inRange('0', '9').or(CharMatcher.anyOf("/")).retainFrom(x);
		String itemq = driver.findElement(By.xpath("//input[@class = \"quantity\"]")).getAttribute("value");
		
		String total = String.valueOf(Integer.parseInt(itemq) * Integer.parseInt(itemp));
		System.out.println("Item Name "+Itemn);
		System.out.println("Item weight "+itemweight);		
		System.out.println("item quantity "+itemq);
		System.out.println("Price of item "+ itemp);
		System.out.println(total);
		driver.findElement(By.xpath("//a[@class = \"cart-icon\"]")).click();
		String cartname =driver.findElement(By.xpath("//header/div[1]/div[3]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/p[1]")).getText();
		System.out.println(cartname);
		String cartquantity =driver.findElement(By.xpath("//header/div[1]/div[3]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[2]/p[1]")).getText();
		System.out.println(cartquantity);
		String cartamount =driver.findElement(By.xpath("//header/div[1]/div[3]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[2]/p[2]")).getText();
		System.out.println(cartamount);
		if(cartamount.compareTo(total)==0 && cartname.compareTo(x)==0)
		{
			System.out.println("Matched");
		}
		else
		{ System.out.println("Error");}
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		Thread.sleep(5000);		
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		Thread.sleep(5000);	
		Select drpCountry = new Select(driver.findElement(By.xpath("//select")));
		drpCountry.selectByValue("India");
		driver.findElement(By.xpath("//input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		String t= driver.findElement(By.xpath("//span[contains(text(),'Thank you')]")).getText();
		String u= t.substring(31, 50);		
		if(u.contentEquals("placed successfully"))
		{
			System.out.println("Validated");
		}
		else {System.out.println("Not Validated");}
		
		
}
}
