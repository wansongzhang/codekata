package com.kata;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sloanzhang on 2019/4/16.
 */
public class Schema {
    private String schemaDesc;
    private HashMap<String, Argument> schemaMap=new HashMap<String,Argument>();

    public Schema(String schemaStr) throws SchemaException {
        parserSchemaFromString(schemaStr);
        this.schemaDesc=schemaStr;
    }
    public String toString(){
        return schemaDesc;
    }
    public Schema() {
    }


    public void parserSchemaFromString(String str) throws SchemaException {
        String[] array=paserSchemaArrayFromStr(str);
        for(String schemaValue:array){
            parserSingleSchema(schemaValue);
        }
    }

    String[] paserSchemaArrayFromStr(String str) {
        return str.trim().split(" ");
    }


    void parserSingleSchema(String str) throws SchemaException {
        if(str==null||str.isEmpty())return;
        String [] tmpArray=paserSingleSchema(str);
        if(tmpArray.length!=3) throw new SchemaException(str);
        String flag=tmpArray[0];
        String type=tmpArray[1];
        String valueStr=tmpArray[2];
        Argument arg=getRigthArgument(type,valueStr);
        schemaMap.put(flag,arg);
    }

    Argument getRigthArgument(String type, String valueStr) {
        switch(type){
            case "bool":return new Argument(Boolean.parseBoolean(valueStr));
            case "int":return new Argument(Integer.parseInt(valueStr));
            case "string":return new Argument(valueStr);
            case "string[]":{
                ArrayList<String> array = new ArrayList<String>();
                array.add(valueStr);
                return new Argument<ArrayList<String>>(array);
            }
            case "int[]":{
                ArrayList<Integer> array = new ArrayList<Integer>();
                array.add(Integer.parseInt(valueStr));
                return new Argument<ArrayList<Integer>>(array);
            }
            default: return new Argument(valueStr);
        }

    }

    String [] paserSingleSchema(String str) {
        return str.trim().split("\\:");
    }

    boolean checkFlagInSchema(String flag) {
        return schemaMap.get(flag) == null ? false : true;
    }

    Argument getSchemaArgument(String flag) {
        return schemaMap.get(flag);
    }

    <T> T getSchemaArgumentValue(String flag) {
        return (T)schemaMap.get(flag).getValue();
    }
}
