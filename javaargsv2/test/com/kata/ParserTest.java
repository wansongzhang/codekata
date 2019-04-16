package com.kata;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by sloanzhang on 2019/4/16.
 */
public class ParserTest {

    String schema="l:bool:false p:int:90  s:string:str g:string[]:default d:int[]:1";

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCanParserBoolDefaultValue()throws Exception{
        String cmdLine="";
        Parser parser=new Parser(schema,cmdLine);
        boolean bValue=(boolean)parser.parserArgument("l");
        Assert.assertFalse("testCanParserBoolDefaultValue", bValue);

    }

    @Test
    public void testCanParserBoolValue()throws Exception{
        String cmdLine="-l ";
        Parser parser=new Parser(schema,cmdLine);
        boolean bExpectedValue=true;
        boolean bValue=(boolean)parser.parserArgument("l");
        Assert.assertEquals("testCanParserBoolValue", bExpectedValue, bValue);
    }

    @Test
    public void testParserIntValue()throws Exception{
        String cmdLine="-p 8080";
        Parser parser=new Parser(schema,cmdLine);
        int pExpectedValue=8080;
        int pValue=parser.parserArgument("p");
        Assert.assertEquals("testParserIntValue", pExpectedValue,pValue);
    }


    @Test
    public void parserArgValue() throws SchemaException {
        String argStr="l";
        Parser parser=new Parser();
        parser.parserSchema(schema);
        parser.parserArgValue(argStr);
        Assert.assertEquals(parser.getCmdLocalArgumentValue("l"),true);
    }

    @Test
    public void testParserCmdline() throws SchemaException {
        String cmdLine="-l";
        Parser parser=new Parser();
        parser.parserSchema(schema);
        parser.parserCmdline(cmdLine);
        Assert.assertEquals(parser.getCmdLocalArgumentValue("l"), true);
    }


    @Test
    public void testGetRightTypeArgument() throws SchemaException {
        String flag="p";
        String value="8080";
        Parser parser=new Parser();
        parser.parserSchema(schema);
        Assert.assertEquals( parser.getRightTypeArgument(flag, value).getValue(),8080);
    }


    @Test
    public void testParserIntDefaultValue()throws Exception{
        String cmdLine="-l";
        Parser parser=new Parser(schema,cmdLine);
        int pExpectedValue=90;
        int pValue=parser.parserArgument("p");
        Assert.assertEquals("testParserIntDefaultValue", pExpectedValue,pValue);
    }

    @Test
    public void testParserStringDefaultValue()throws Exception{
        String cmdLine="-l";
        Parser parser=new Parser(schema,cmdLine);
        String sExpectedValue="str";
        String  sValue=parser.parserArgument("s");
        Assert.assertEquals("testParserStringDefaultValue", sExpectedValue,sValue);
    }

    @Test
    public void testParserStringValue()throws Exception{
        String cmdLine="-s teststring";
        Parser parser=new Parser(schema,cmdLine);
        String sExpectedValue="teststring";
        String  sValue=parser.parserArgument("s");
        Assert.assertEquals("testParserStringValue", sExpectedValue,sValue);
    }

    @Test
    public void testParserStringArrayValue()throws Exception{
        String cmdLine="-g test,string";
        Parser parser=new Parser(schema,cmdLine);
        String[] gExpectedValue={"test","string"};
        ArrayList<String> gValue = parser.parserArgument("g");
        Assert.assertNotNull("testParserStringArrayValue not null", gValue);
        Assert.assertArrayEquals("testParserStringArrayValue ", gExpectedValue, gValue.toArray(new String[gExpectedValue.length]));
    }

    @Test
    public void testParserIntArrayValue()throws Exception{
        String cmdLine="-d 1,2";
        Parser parser=new Parser(schema,cmdLine);
        Integer[] dExpectedValue={1,2};
        ArrayList<Integer> dValue = parser.parserArgument("d");
        Assert.assertNotNull(dValue);
        Assert.assertArrayEquals(dExpectedValue, dValue.toArray(new Integer[dExpectedValue.length]));
    }


    @Test
    public void testParserUnknownArgValue(){
        String cmdLine="-d 1,2";
        try {
            Parser parser=new Parser(schema,cmdLine);
            parser.parserArgument("x");
            Assert.assertTrue("testParserUnknownValue", false);
        } catch (ArgumentException e) {
            Assert.assertTrue("testParserUnknownValue", true);
        } catch (SchemaException e) {
            Assert.assertTrue("testParserUnknownValue", true);
        }
    }


}
