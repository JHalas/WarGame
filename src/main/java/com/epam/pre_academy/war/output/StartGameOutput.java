package com.epam.pre_academy.war.output;

import com.epam.pre_academy.war.Players;
import com.epam.pre_academy.war.Scenario;

import java.nio.file.Path;

/**
 * @author Jakub Hałas
 */

public class StartGameOutput implements Output {

    Players playerList   ;
    Scenario scenario ;

    public StartGameOutput(Players playerList) {
        this.playerList = playerList;
        this.scenario  = new Scenario();
    }

    public void getOutput(Path scenarioPath) {
        System.out.println(scenario.getScenarioName(scenarioPath.getFileName()));
        System.out.printf("WAR, %d players, ? deck, %d cards %n", playerList.players().size(), playerList.getNumberOFCards()  );
    }


}