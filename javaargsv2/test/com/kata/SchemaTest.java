package com.kata;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by sloanzhang on 2019/4/16.
 */
public class SchemaTest {

    @Test
    public void testParserSchemaBoolValue() throws SchemaException {
        String str="l:bool:true";
        Schema schema=new Schema();
        schema.parserSchemaFromString(str);
        Assert.assertEquals(true,schema.getSchemaArgument("l").getValue());

    }

    @Test
    public void testParserSchemaIntValue() throws SchemaException {
        String str="p:int:80";
        Schema schema=new Schema();
        schema.parserSchemaFromString(str);
        Assert.assertEquals(80,schema.getSchemaArgument("p").getValue());
    }

    @Test
    public void testParserSchemaStringValue() throws SchemaException {
        String str="s:string:str";
        Schema schema=new Schema();
        schema.parserSchemaFromString(str);
        Assert.assertEquals("str",schema.getSchemaArgument("s").getValue());
    }

    @Test
    public void testParserSchemaStringArrayValue() throws SchemaException {
        String str="g:string[]:default";
        Schema schema=new Schema();
        schema.parserSchemaFromString(str);
        ArrayList<String> array = new ArrayList<String>();
        array.add("default");
        Assert.assertEquals(array,schema.getSchemaArgument("g").getValue());
    }


    @Test
    public void testParserSchemaIntArrayValue() throws SchemaException {
        String str="d:int[]:1";
        Schema schema=new Schema();
        schema.parserSchemaFromString(str);
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        Assert.assertEquals(array,schema.getSchemaArgument("d").getValue());
    }


    @Test
    public void testParserMoreSchemaValue() throws SchemaException {
        String str="l:bool:true p:int:80  s:string:str g:string[]:default d:int[]:1";
        Schema schema=new Schema();
        schema.parserSchemaFromString(str);
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        Assert.assertEquals(array, schema.getSchemaArgument("d").getValue());

        ArrayList<String> arrayStr = new ArrayList<String>();
        arrayStr.add("default");
        Assert.assertEquals(arrayStr, schema.getSchemaArgument("g").getValue());

        Assert.assertEquals("str", schema.getSchemaArgument("s").getValue());

        Assert.assertEquals(80, schema.getSchemaArgument("p").getValue());
        Assert.assertEquals(true,schema.getSchemaArgument("l").getValue());
    }


    @Test
    public void testParserErrorSchemaValue(){
        String str="l:bool";
        Schema schema=new Schema();
        try {
            schema.parserSchemaFromString(str);
            Assert.assertFalse("testParserErrorSchemaValue", true);
        } catch (SchemaException e) {
            Assert.assertFalse("testParserErrorSchemaValue", false);
        }
    }

    @Test
    public void testParserUnknownTypeSchemaValue() throws SchemaException {
        String str="x:mytype:unknownstr";
        Schema schema=new Schema();
        schema.parserSchemaFromString(str);
        Assert.assertEquals("unknownstr", schema.getSchemaArgument("x").getValue());
    }

}
