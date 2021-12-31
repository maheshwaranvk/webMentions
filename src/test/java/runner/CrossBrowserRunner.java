package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature/crossBrowser.feature",glue="step",monochrome=true, publish = true)
public class CrossBrowserRunner extends AbstractTestNGCucumberTests{

}
