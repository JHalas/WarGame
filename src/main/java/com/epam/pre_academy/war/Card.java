package com.epam.pre_academy.war;

/**
 * @author Jakub Hałas
 */

public record Card(Integer value)implements Comparable<Card> {



    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public int compareTo(Card o) {
        return o.value.compareTo(value);
    }
}
