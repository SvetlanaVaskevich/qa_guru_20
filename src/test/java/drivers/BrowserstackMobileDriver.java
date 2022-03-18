package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Credentials;
import config.CredentialsConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl(){
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities caps) {

        // Set your access credentials
        caps.setCapability("browserstack.user", Credentials.config.user());
        caps.setCapability("browserstack.key", Credentials.config.key());

        // Set URL of the application under test
        //caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        caps.setCapability("app", "bs://ad92be6e7749cd6962074a49757ca155899967a3");


        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        return new AndroidDriver(getBrowserstackUrl(),caps);
    }
}


