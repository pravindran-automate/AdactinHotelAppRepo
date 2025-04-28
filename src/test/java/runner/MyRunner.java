package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",
				 glue={"stepdefintions"},tags = "not @ignore",
				 plugin = {"pretty", "html:target/cucumber-reports.html"} // Output format
				 )	

public class MyRunner {

}


 