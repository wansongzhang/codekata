package com.kata;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by sloanzhang on 2019/4/25.
 */
public class FizzBuzzTest2  {
    @Test
    public void testGive1Return_1(){
        Assert.assertEquals("1", new Game().getString(1));
    }


    @Test
    public void testGive3ReturnFizz(){
        Assert.assertEquals("fizz",new Game().getString(3));
    }


    @Test
    public void testGive5ReturnBuzz(){
        Assert.assertEquals("buzz",new Game().getString(5));
    }


    @Test
    public void testGive6ReturnFizz(){
        Assert.assertEquals("fizz",new Game().getString(6));
    }

    @Test
    public void testGive10ReturnFizz(){
        Assert.assertEquals("buzz",new Game().getString(10));
    }

    @Test
    public void testGive15RetrunFizzBuzz(){
        Assert.assertEquals("fizzbuzz",new Game().getString(15));
    }

    @Test
    public void testGive13RetrunFizz(){
        Assert.assertEquals("fizz",new Game().getString(13));
    }

    @Test
    public void testGive31RetrunFizz(){
        Assert.assertEquals("fizz",new Game().getString(31));
    }

    @Test
    public void testGive52RetrunFizz(){
        Assert.assertEquals("buzz",new Game().getString(52));
    }

    @Test
    public void testGive51RetrunFizz(){
        Assert.assertEquals("fizzbuzz",new Game().getString(51));
    }


    @Test
    public void testPrint1to100String(){
        String destString="1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz fizz 14 fizzbuzz 16 17 fizz 19 buzz fizz 22 fizz fizz buzz 26 fizz 28 29 fizzbuzz fizz fizz fizz fizz fizzbuzz fizz fizz fizz fizz buzz 41 fizz fizz 44 fizzbuzz 46 47 fizz 49 buzz fizzbuzz buzz fizzbuzz fizzbuzz buzz buzz fizzbuzz buzz buzz fizzbuzz 61 62 fizz 64 buzz fizz 67 68 fizz buzz 71 fizz fizz 74 fizzbuzz 76 77 fizz 79 buzz fizz 82 fizz fizz buzz 86 fizz 88 89 fizzbuzz 91 92 fizz 94 buzz fizz 97 98 fizz ";
        Assert.assertEquals(destString,new Game().print1to100GameString());
    }
}
