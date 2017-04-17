package com.msse.web.resource

import org.openqa.selenium.chrome.ChromeDriver

reportsDir = 'build/test-reports'

waiting {
    timeout = 2
}

environments {

    // run via “./gradlew test”

    chrome
            {
        driver = { new ChromeDriver() }
    }

    browser.setBaseUrl("http://localhost:${port}")
}



