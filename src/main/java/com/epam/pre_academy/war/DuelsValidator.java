package com.epam.pre_academy.war;

import java.util.List;

/**
 * @author Jakub Hałas
 */

class DuelsValidator {

    public boolean isDuel(List<Player> playerWithWinnerCard) {
        return playerWithWinnerCard.size()> 1 ;

    }

}
