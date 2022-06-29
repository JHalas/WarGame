package com.epam.pre_academy.war;




import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author Jakub Hałas
 */
@Test
public class DuelsValidatorTest {

    public void ShouldReturnTrueWhenMethodIsDuelIsCalled() {
        //given
        Deque<Card> cards = new LinkedList<>();
        cards.add(new Card(2));
        List<Player> playerWithWinnerCards = new LinkedList<>();
        Player player1 = new Player("Player1" , cards);
        Player player2 = new Player("Player2" , cards);
        playerWithWinnerCards.add(player1);
        playerWithWinnerCards.add(player2);
        //when
        DuelsValidator duelsValidator = new DuelsValidator();
        //then
        assertTrue(duelsValidator.isDuel(playerWithWinnerCards));
    }

}