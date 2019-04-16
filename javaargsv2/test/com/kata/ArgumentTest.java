package com.kata;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by sloanzhang on 2019/4/16.
 */
public class ArgumentTest {


    @Test
    public void testCopyAndAssignValueWtihInt(){
        Argument arg=new Argument<Integer>(0);
        Argument arg1 = arg.copyAndAssignValue("1");
        Assert.assertEquals(1,arg1.getValue());
    }

    @Test
    public void testCopyAndAssignValueWtihString(){
        Argument arg=new Argument<String>("str");
        Argument arg1 = arg.copyAndAssignValue("str");
        Assert.assertEquals("str",arg1.getValue());
    }

    @Test
    public void testCopyAndAssignValueWtihArrayString(){
        ArrayList<String> arrayStr = new ArrayList<String>();
        arrayStr.add("default");
        Argument arg=new Argument(arrayStr);

        String[] gExpectedValue={"test","string"};
        Argument arg1 = arg.copyAndAssignValue("test,string");
        ArrayList<String> destArray= (ArrayList<String>) arg1.getValue();
        Assert.assertArrayEquals(gExpectedValue, destArray.toArray(new String[gExpectedValue.length]));
    }

    @Test
    public void testCopyAndAssignValueWtihArrayInt(){
        ArrayList<Integer> arrayInt = new ArrayList<Integer>();
        arrayInt.add(0);
        Argument arg=new Argument(arrayInt);

        Integer[] gExpectedValue={1,2};
        Argument arg1 = arg.copyAndAssignValue("1,2");
        ArrayList<Integer> destArray= (ArrayList<Integer>) arg1.getValue();
        Assert.assertArrayEquals(gExpectedValue, destArray.toArray(new Integer[gExpectedValue.length]) );
    }


    @Test
    public void testgetArrayArgWithArrayInt(){
        ArrayList<Integer> arrayInt = new ArrayList<Integer>();
        arrayInt.add(0);
        Argument arg=new Argument(arrayInt);

        Integer[] gExpectedValue={1,2};
        Argument arg1 = arg.getArrayArg("1,2");
        ArrayList<Integer> destArray= (ArrayList<Integer>) arg1.getValue();
        Assert.assertArrayEquals(gExpectedValue, destArray.toArray(new Integer[gExpectedValue.length]) );
    }

    @Test
    public void testgetArrayArgWithArrayString(){
        ArrayList<String> arrayStr = new ArrayList<String>();
        arrayStr.add("default");
        Argument arg=new Argument(arrayStr);

        String[] gExpectedValue={"test","string"};
        Argument arg1 = arg.getArrayArg("test,string");
        ArrayList<String> destArray= (ArrayList<String>) arg1.getValue();
        Assert.assertArrayEquals(gExpectedValue, destArray.toArray(new String[gExpectedValue.length]));
    }



    @Test
    public void testCopyAndAssignValueWtihUnknownType(){
        Argument arg=new Argument<Double>(0.1);
        Argument arg1 = arg.copyAndAssignValue("unknown,Double");
        Assert.assertEquals("unknown,Double",arg1.getValue());
    }

    @Test
    public void testGetArrayArgWtihUnknownType(){
        ArrayList<Double> doubleArray=new ArrayList<Double>();
        doubleArray.add(0.1);
        Argument arg=new Argument<ArrayList<Double>>(doubleArray);
        Argument arg1 = arg.getArrayArg("unknown,Double");
        Assert.assertEquals("unknown,Double",arg1.getValue());
    }
}
