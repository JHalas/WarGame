package com.epam.pre_academy.war;

import com.epam.pre_academy.war.output.StartGameOutput;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakub Hałas
 */

class Battle {


    private final StartGameOutput startGameOutput;
    private final Table table;
    private final Players playerList;
    private final Clash clash;
    private final DuelsValidator duelsValidator;
    private final Duels duels;
    private final Path scenarioPath;


    Battle(StartGameOutput startGameOutput, Table table, Players playerList, Path scenarioPath) {
        this.startGameOutput = startGameOutput;
        this.table = table;
        this.playerList = playerList;
        this.scenarioPath = scenarioPath;
        this.clash = new Clash() ;
        this.duelsValidator = new DuelsValidator();
        this.duels = new Duels();
    }

    public Player start() {
        Player winner;
        startGameOutput.getOutput(scenarioPath);
        var cardsOnTableFromPlayers = table.cardsOnTableFromPlayers(playerList.players());
        List<Card> cardToWin = new ArrayList<>(cardsOnTableFromPlayers.values());
        var duelList = clash.getPlayerWithWinnerCard(cardsOnTableFromPlayers);
        if (duelsValidator.isDuel(duelList)) {
            winner = duels.startDuels(duelList);
            winner.drawWinnerCard(cardToWin);
        } else {
            winner = duelList.get(0);
            winner.drawWinnerCard(cardToWin);
        }
        playerList.players().removeIf(player -> player.cardsInHand().size() == 0);
        return winner;
    }
}
