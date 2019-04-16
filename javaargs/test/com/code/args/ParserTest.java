package com.code.args;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by sloanzhang on 2019/4/15.
 */
public class ParserTest {




    @Test
    public void testCanPaserDefaultBoolValue() throws ArgumentException {

        String schema="t:bool:false";
        String commandLine="";
        Parser arg=new Parser(schema,commandLine);
        boolean defaultTBoolValue=false;
        boolean tValue = arg.getValue("t");
        Assert.assertEquals("testCanPaserDefaultBoolValue t:bool:false",defaultTBoolValue,tValue);

    }



    @Test
    public void testCanPaserUnknownDefaultBoolValue() throws ArgumentException {
        String schema="t:bool:false";
        String commandLine="";
        Parser arg=new Parser(schema,commandLine);
        Object xValue = arg.getValue("x");
        Assert.assertNull(xValue);
    }


    @Test
    public void testCanPaserBoolValue()throws ArgumentException{
        String schema="t:bool:false";
        String commandLine="-t";
        Parser arg=new Parser(schema,commandLine);
        boolean defaultTBoolValue=true;
        boolean tValue = arg.getValue("t");
        Assert.assertEquals("testCanPaserDefaultBoolValue t:bool:false",defaultTBoolValue,tValue);
    }

    @Test
    public void testCanPaserIntValue()throws ArgumentException{
        String schema="t:bool:false;p:int:80";
        String commandLine="-p 8080";
        Parser arg=new Parser(schema,commandLine);
        int dExpectedValue=8080;
        int dValue = arg.getValue("p");
        Assert.assertEquals("testCanPaserIntValue p 8080", dExpectedValue, dValue);
    }

    @Test
    public void testCanPaserIntDefaultValue()throws ArgumentException{

        String schema="t:bool:false;p:int:80";
        String commandLine="-g 132";
        Parser arg=new Parser(schema,commandLine);
        int dExpectedValue=80;
        int dValue = arg.getValue("p");
        Assert.assertEquals("testCanPaserIntDefaultValue p int 80",dExpectedValue,dValue);
    }

    @Test
    public void testCanPaserIntArrayValue()throws ArgumentException{
        String schema="t:bool:false";
        String commandLine="-d 9,3";
        Parser arg=new Parser(schema,commandLine);
        Integer[] dExpectedValue={9,3};
        ArrayList<Integer> dValue = arg.getValue("d");
        Assert.assertNotNull("testCanPaserIntArrayValue not null",dValue);
        Assert.assertArrayEquals("testCanPaserIntArrayValue expected 9,3", dExpectedValue, dValue.toArray(new Integer[dExpectedValue.length]));
    }

    @Test
    public void testCanPaserStringArrayValue()throws ArgumentException{
        String schema="t:bool:false";
        String commandLine="-g this,is";
        Parser arg=new Parser(schema,commandLine);
        String[] dExpectedValue={"this","is"};
        ArrayList<String> dValue = arg.getValue("g");
        Assert.assertNotNull("testCanPaserStringArrayValue not null", dValue);
        Assert.assertArrayEquals("testCanPaserStringArrayValue expected this ", dExpectedValue, dValue.toArray(new String[dExpectedValue.length]));
    }

}
