package com.epam.pre_academy.war;
import com.epam.pre_academy.war.json.JsonService;
import com.epam.pre_academy.war.json.JsonUtils;
import com.epam.pre_academy.war.output.DetectedScenarioOutput;
import com.epam.pre_academy.war.output.EndGameOutPut;
import com.epam.pre_academy.war.output.StartGameOutput;

import java.nio.file.Path;
import java.util.Collections;

/**
 * @author Jakub Hałas
 */

class War implements Game {


    private final Players playerList ;
    private final Table table ;
    private final EndGameOutPut endGameOutPut ;
    private final Battle battle;
    private final Path scenarioPath ;


    War(JsonService jsonService, Path scenarioPath) {
        this.playerList = jsonService.parse();
        this.scenarioPath = scenarioPath;
        this.table = new Table();
        this.battle = new Battle(new StartGameOutput(playerList), table, playerList, scenarioPath);
        this.endGameOutPut = new EndGameOutPut(playerList );
    }

    public static void main(String[] args) throws IllegalNumberOfPlayersException {

        JsonUtils jsonUtils = new JsonUtils();
        Scenario scenario = new Scenario();
        DetectedScenarioOutput detectedScenarioOutput = new DetectedScenarioOutput(scenario);
        detectedScenarioOutput.printDetectedScenarioFiles();
        for (Path scenariooopath : scenario.allScenarioInResource()) {
            War war = new War(new JsonService(scenariooopath , scenario), scenariooopath);
            if(war.playerList == null) {
                continue;
            }
            war.start();
        }


    }

    @Override
    public void start() throws IllegalNumberOfPlayersException {
        if( 2 > playerList.players().size() || playerList.players().size() > 5) {
            throw new IllegalNumberOfPlayersException("Invalid number of players") ;
        }
        int roundLimiter = playerList.getNumberOFCards() * 10;
        int rundCounter = 0;
        while (playerList.players().size() != 1) {
            if (rundCounter == roundLimiter) {
                Collections.sort(playerList.players());
                if (playerList.players().get(0).getHighestCardInHand() == playerList.getHighestCardInGame()) {

                    System.out.println(Scenario.getScenarioName(scenarioPath.getFileName()));
                    System.out.printf("Stopping the game due to %d battles without resolution." +
                                      " Winner is the owner of the highest card AND" +
                                      " the owner of the greatest amount of cards: %s%n", rundCounter, playerList.players().get(0).name());
                }
                return;
            }
            battle.start();
            rundCounter++;
        }
        endGameOutPut.getOutput(table, playerList.players().get(0), scenarioPath);

    }


}
