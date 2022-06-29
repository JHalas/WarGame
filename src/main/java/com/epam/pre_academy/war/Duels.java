package com.epam.pre_academy.war;

import com.epam.pre_academy.war.output.Output;


import java.util.List;
import java.util.Random;

/**
 * @author Jakub Hałas
 */

class Duels implements Output {

    private  Random RANDOM = new Random();

    Player startDuels(List<Player> battleList) {
        System.out.println("Duel between players will be decided by a coin toss.");
        Player winnerPlayer = battleList.get(RANDOM.nextInt(battleList.size()));
        System.out.printf("Toosing.. %s has won!\n"+separator,winnerPlayer.name() );
        return winnerPlayer ;
    }
}