package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature/login1.feature" , glue="step" , monochrome=true)
public class RunText1 extends AbstractTestNGCucumberTests{


}
