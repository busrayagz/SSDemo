package com.SS.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/cucumber-report.html", //html report
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/SS/step_definitions",
        dryRun = false,
        tags = "@student"
)

public class CukesRunner {
}
