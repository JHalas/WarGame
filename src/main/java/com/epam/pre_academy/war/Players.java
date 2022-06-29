package com.epam.pre_academy.war;

import java.util.List;

/**
 * @author Jakub Hałas
 */

public record Players(List<Player> players) {


    public Integer getNumberOFCards() {
        int numberOfCards = 0;
        for (Player player : players) {
            numberOfCards += player.getNumberOfPlayerCards();
        }
        return numberOfCards;
    }

    public  Integer getHighestCardInGame() {
        return players.stream()
                .map(Player::getHighestCardInHand)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
