package com.epam.pre_academy.war;

import com.epam.pre_academy.war.output.Output;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jakub Hałas
 */

public class Table implements Output {

    private final Map<Player, Card> cardsOnTable = new LinkedHashMap<>();


    public Map<Player, Card> cardsOnTableFromPlayers(List<Player> players) {
        cardsOnTable.clear();
        for (Player player : players) {
            System.out.println(player.name() + " played: " + player.getFirstCard().value());
            cardsOnTable.put(player, player.playCard());
        }
        System.out.print(separator);
        return cardsOnTable;
    }


    public Integer getNumberOfPayedPlayers() {
        return cardsOnTable.size();
    }


}
