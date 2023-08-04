package com.nautotest.appium;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ConnectAppAppiumTest {

    private AndroidDriver driver;

    // Uncomment this string APP, in order to download the
    //private String APP = "https://github.com/lucaspaisnauto/AppiumTestAPK/releases/download/test_1.0.0/fleet-app-production-debug.apk";
    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        /**
         * When 'espresso' is selected as driver we should allowTestPackages. That way we
         * can test our debug apps and also provide the APP to be downloaded and installed everytime
         */
        //capabilities.setCapability("automationName", "espresso");
        //capabilities.setCapability("appium:allowTestPackages", "true");
        //capabilities.setCapability("app", APP);
        capabilities.setCapability("appPackage", "com.nauto.connectapp");
        capabilities.setCapability("appActivity", "com.nauto.connectapp.ui.login.LoginActivity");

        /**
         * This capability allows us to use testTag names without the fully qualified package name
         */
        capabilities.setCapability("appium:disableIdLocatorAutocompletion",true);


        /**
         * Next we find some libraries needed to be specified for running the espresso driver.
         */
        /*
        capabilities.setCapability("appium:espressoBuildConfig",
                "{\"toolsVersions\": {\"composeVersion\": \"1.1.0-alpha04\", \"compileSdk\":\"31\", \"kotlin\":\"1.5.30\", \"gradle\":\"7.3.3\",\"androidGradlePlugin\":\"7.1.0\",\"kotlin\":\"1.7.0\"}}");
        */

//{   "additionalAndroidTestDependencies": [     "androidx.core:core:1.5.0",     "androidx.activity:activity:1.2.0-beta01"   ],   "additionalAppDependencies": [     "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.0"  ] }
        //capabilities.setCapability("appium:forceEspressoRebuild", true);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void appiumLoginTest() throws InterruptedException {
        Thread.sleep(10000);
        WebElement emailInputText = driver.findElementByXPath("//*[@resource-id='Email_input']");
        emailInputText.click();
        emailInputText.sendKeys("nauto-mobile-test-manager-1@nauto.com");

        WebElement passInputText = driver.findElementByXPath("//*[@resource-id='Password_input']");
        passInputText.click();
        passInputText.sendKeys("Nauto2022");

        WebElement signInButton = driver.findElementByXPath("//*[@text='Sign in']");

        signInButton.click();
        Thread.sleep(15000);
    }
}