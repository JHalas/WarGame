package com.epam.pre_academy.war;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * @author Jakub Hałas
 */

@Test
public class CardTest {

    public void shouldCreateCardWithProperValueWhenConstructorIsCalled() {
        //given
        Integer value = 3;
        //when
        Card card = new Card(value);
        //then
        Assert.assertEquals(value, card.value());
    }

}