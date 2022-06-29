package com.epam.pre_academy.war.json;

import com.epam.pre_academy.war.Players;

import java.io.FileNotFoundException;

/**
 * @author Jakub Hałas
 */

public interface Parser {

     Players parse() throws FileNotFoundException;
}
