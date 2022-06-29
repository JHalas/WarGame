package com.epam.pre_academy.war.output;

import com.epam.pre_academy.war.Player;
import com.epam.pre_academy.war.Players;
import com.epam.pre_academy.war.Scenario;
import com.epam.pre_academy.war.Table;

import java.nio.file.Path;

/**
 * @author Jakub Hałas
 */

public class EndGameOutPut implements Output {


    Players players;
    Scenario scenario;

    public EndGameOutPut(Players players) {
        this.players = players;
        this.scenario = new Scenario() ;
    }


    public void getOutput(Table table , Player winner , Path scenarioo) {
        System.out.print(separator);
        System.out.println(scenario.getScenarioName(scenarioo.getFileName()));
        System.out.printf("WAR, %d players, ? deck, %s WON with %s/%s cards %n"+separator
                , table.getNumberOfPayedPlayers()
                , winner.name()
                , winner.getNumberOfPlayerCards()
                , players.getNumberOFCards());
    }
}
