package com.epam.pre_academy.war;

/**
 * @author Jakub Hałas
 */

public class IllegalNumberOfPlayersException extends Throwable {
    public IllegalNumberOfPlayersException(String s) {
        System.err.println(s);
    }
}
