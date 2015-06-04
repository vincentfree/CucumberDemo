package com.atos.cucumberdemo.step;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Vincent Free on 23-3-2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/",
        plugin = {"html:target/cukes"})
public class Run_Cucumber {

}
