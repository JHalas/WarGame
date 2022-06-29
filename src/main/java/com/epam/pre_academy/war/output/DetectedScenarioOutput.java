package com.epam.pre_academy.war.output;

import com.epam.pre_academy.war.Scenario;

/**
 * @author Jakub Hałas
 */

public class DetectedScenarioOutput implements Output{

    Scenario scenario ;

    public DetectedScenarioOutput(Scenario scenario) {
        this.scenario = scenario;
    }

   public  void printDetectedScenarioFiles() {
        System.out.printf("Found %d scenario files: %n%s %n%s %n%s %n%n%nExecuting in given order.%n" + separator
                ,scenario.allScenarioInResource().size()
                ,scenario.allScenarioInResource().get(0).getFileName()
                ,scenario.allScenarioInResource().get(1).getFileName()
                ,scenario.allScenarioInResource().get(2).getFileName());
    }
}
