package org.nullpointer4j.mpm.ti;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {
        "classpath:features/create/create_project.feature",
    },
    plugin = {
        "pretty",
        "html:target/cucumber"
    })
public class CreateProjectTest {
}
