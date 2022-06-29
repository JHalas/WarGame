package com.epam.pre_academy.war;

import java.util.*;

/**
 * @author Jakub Hałas
 */

public record Player(String name, Deque<Card> cardsInHand)  implements Comparable<Player>{


    public Card playCard() {
        Card card = cardsInHand.peekFirst();
        cardsInHand.removeFirst();
        return card;
    }

    Card getFirstCard() {
        return cardsInHand.getFirst();
    }

    public Integer getNumberOfPlayerCards() {
        return cardsInHand.size();
    }

    void drawWinnerCard(Collection<Card> cards) {
        for (Card card : cards) {
            cardsInHand.addLast(card);
        }
    }

    @Override
    public String toString() {
        return name + " cardsInHand=" + cardsInHand ;
    }

    @Override
    public int compareTo(Player o) {
        return o.getNumberOfPlayerCards().compareTo(getNumberOfPlayerCards());
    }

    public Integer getHighestCardInHand() {
        List<Card> playerCards = new ArrayList<>(cardsInHand);
        Collections.sort(playerCards);
        return playerCards.get(0).value();
    }
}
