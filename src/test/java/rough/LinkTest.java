package rough;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.example.com");

        // Get all the links on the page using the Selenium WebDriver
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Create a list to store the inaccessible links
        List<String> inaccessibleLinks = new ArrayList<String>();

        // Iterate through each link and test its accessibility
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            try {
                URL url = new URL(href);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    inaccessibleLinks.add(href);
                }
            } catch (Exception e) {
                inaccessibleLinks.add(href);
            }
        }

        // Print the inaccessible links, if any
        if (inaccessibleLinks.size() > 0) {
            System.out.println("The following links are inaccessible:");
            for (String link : inaccessibleLinks) {
                System.out.println(link);
            }
        } else {
            System.out.println("All links are accessible.");
        }

        // Close the browser
        driver.quit();
    }
}
