package com.epam.pre_academy.war;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Jakub Hałas
 */

 class Clash {


    public List<Player> getPlayerWithWinnerCard(Map<Player, Card> cardsOnTable) {
        List<Card> cards = new LinkedList<>(cardsOnTable.values());
        List<Integer> cardsValue = new LinkedList<>();
        for ( Card card : cards) cardsValue.add(card.value());
        int winnerCard = Collections.max(cardsValue);
        List<Player> playersWithWinnerCard = new LinkedList<>();
        for (Player player : cardsOnTable.keySet()) {
            if (cardsOnTable.get(player).value() == winnerCard) {
                playersWithWinnerCard.add(player);
            }
        }

        return playersWithWinnerCard ;
    }
}
