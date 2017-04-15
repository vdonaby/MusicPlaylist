package com.msse.web.resource

import org.openqa.selenium.chrome.ChromeDriver


waiting {
    timeout = 2
}

environments {

    // run via “./gradlew chromeTest”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome
            {
        driver = { new ChromeDriver() }
    }

    //baseUrl = "http://localhost:${port}"
}



