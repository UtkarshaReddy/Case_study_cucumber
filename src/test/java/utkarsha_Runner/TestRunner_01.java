package utkarsha_Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber .class)
@CucumberOptions(features="Features_01",glue="mystepDef",
plugin={"html:target/cucumber-htmlreport.html"})
public class TestRunner_01 {

}