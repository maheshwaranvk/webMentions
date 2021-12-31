package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature/login.feature", glue="step" , monochrome=true)
public class RunText extends AbstractTestNGCucumberTests{

}
