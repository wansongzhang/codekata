package com.code.args;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Created by sloanzhang on 2019/4/15.
 */
public class ParserTest {
    @Test
    public void testCanParserDefaultBoolValue() throws ArgumentException {
        String schema="t:bool:false;p:int:80;s:string:teststring;d:int[]:{};g:string[]:{}";
        String commandLine="";
        Parser arg=new Parser(schema,commandLine);
        boolean defaultTBoolValue=false;
        boolean tValue = arg.getValue("t");
        Assert.assertEquals("testCanParserDefaultBoolValue t:bool:false",defaultTBoolValue,tValue);
    }
    @Test
    public void testCanParserUnknownDefaultBoolValue(){
        String schema="t:bool:false;p:int:80;s:string:teststring;d:int[]:{};g:string[]:{}";
        String commandLine="";
        Parser arg=new Parser(schema,commandLine);
        Object xValue = null;
        try {
            xValue = arg.getValue("x");
            Assert.assertTrue("testCanParserUnknownDefaultBoolValue x",false);
        } catch (ArgumentException e) {
            Assert.assertTrue("testCanParserUnknownDefaultBoolValue x",true);
        }
    }
    @Test
    public void testCanParserBoolValue()throws ArgumentException{
        String schema="t:bool:false;p:int:80;s:string:teststring;d:int[]:{};g:string[]:{}";
        String commandLine="-t";
        Parser arg=new Parser(schema,commandLine);
        boolean defaultTBoolValue=true;
        boolean tValue = arg.getValue("t");
        Assert.assertEquals("testCanParserBoolValue t:bool:false",defaultTBoolValue,tValue);
    }
    @Test
    public void testCanParserIntValue()throws ArgumentException{
        String schema="t:bool:false;p:int:80;s:string:teststring;d:int[]:{};g:string[]:{}";
        String commandLine="-p 8080";
        Parser arg=new Parser(schema,commandLine);
        int dExpectedValue=8080;
        int dValue = arg.getValue("p");
        Assert.assertEquals("testCanParserIntValue p 8080", dExpectedValue, dValue);
    }

    @Test
    public void testCanParserIntDefaultValue()throws ArgumentException{
        String schema="t:bool:false;p:int:80;s:string:teststring;d:int[]:{};g:string[]:{}";
        String commandLine="-g 132";
        Parser arg=new Parser(schema,commandLine);
        int dExpectedValue=80;
        int dValue = arg.getValue("p");
        Assert.assertEquals("testCanParserIntDefaultValue p int 80",dExpectedValue,dValue);
    }
    @Test
    public void testCanParserIntArrayValue()throws ArgumentException{
        String schema="t:bool:false;p:int:80;s:string:teststring;d:int[]:{};g:string[]:{}";
        String commandLine="-d 9,3";
        Parser arg=new Parser(schema,commandLine);
        Integer[] dExpectedValue={9,3};
        ArrayList<Integer> dValue = arg.getValue("d");
        Assert.assertNotNull("testCanParserIntArrayValue not null",dValue);
        Assert.assertArrayEquals("testCanParserIntArrayValue expected 9,3", dExpectedValue, dValue.toArray(new Integer[dExpectedValue.length]));
    }
    @Test
    public void testCanParserStringArrayValue()throws ArgumentException{
        String schema="t:bool:false;p:int:80;s:string:teststring;d:int[]:{};g:string[]:{}";
        String commandLine="-g this,is";
        Parser arg=new Parser(schema,commandLine);
        String[] dExpectedValue={"this","is"};
        ArrayList<String> dValue = arg.getValue("g");
        Assert.assertNotNull("testCanParserStringArrayValue not null", dValue);
        Assert.assertArrayEquals("testCanParserStringArrayValue expected this ", dExpectedValue, dValue.toArray(new String[dExpectedValue.length]));
    }

}
