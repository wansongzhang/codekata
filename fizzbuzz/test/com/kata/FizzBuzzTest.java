package com.kata;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sloanzhang on 2019/4/22.
 */
public class FizzBuzzTest {

    @Test
    public void testGive1Return1(){
        int num=1;
        String gameStr=new FizzBuzz().gameString(num);
        Assert.assertEquals("1",gameStr);
    }

    @Test
    public void testGive3ReturnFizz(){
        int num=3;
        String gameStr=new FizzBuzz().gameString(num);
        Assert.assertEquals("fizz",gameStr);
    }

    @Test
    public void testGive6ReturnFizz(){
        int num=6;
        String gameStr=new FizzBuzz().gameString(num);
        Assert.assertEquals("fizz",gameStr);
    }

    @Test
    public void testGive5ReturnBuzz(){
        int num=5;
        String gameStr=new FizzBuzz().gameString(num);
        Assert.assertEquals("buzz",gameStr);
    }

    @Test
    public void testGive10ReturnBuzz(){
        int num=10;
        String gameStr=new FizzBuzz().gameString(num);
        Assert.assertEquals("buzz",gameStr);
    }

    @Test
    public void testGive15ReturnFizzBuzz(){
        int num=15;
        String gameStr=new FizzBuzz().gameString(num);
        Assert.assertEquals("fizzbuzz",gameStr);
    }

    @Test
    public void testGive13ReturnFizz(){
        int num=13;
        String gameStr=new FizzBuzz().gameString(num);
        Assert.assertEquals("fizz",gameStr);
    }

    @Test
    public void testGive31ReturnFizz(){
        int num=31;
        String gameStr=new FizzBuzz().gameString(num);
        Assert.assertEquals("fizz",gameStr);
    }

    @Test
    public void testGive51ReturnBuzz(){
        int num=52;
        String gameStr=new FizzBuzz().gameString(num);
        Assert.assertEquals("buzz",gameStr);
    }

    @Test
    public void testGet1to100Strig(){
        String targetString="0 1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz fizz 14 fizzbuzz 16 17 fizz 19 buzz fizz 22 fizz fizz buzz 26 fizz 28 29 fizzbuzz fizz fizz fizz fizz fizz fizz fizz fizz fizz buzz 41 fizz fizz 44 fizzbuzz 46 47 fizz 49 buzz fizz buzz fizz fizz buzz buzz fizz buzz buzz fizzbuzz 61 62 fizz 64 buzz fizz 67 68 fizz buzz 71 fizz fizz 74 fizzbuzz 76 77 fizz 79 buzz fizz 82 fizz fizz buzz 86 fizz 88 89 fizzbuzz 91 92 fizz 94 buzz fizz 97 98 fizz ";
        String gameStr=new FizzBuzz().get1to100GameString();
        Assert.assertEquals(targetString,gameStr);
    }

}
