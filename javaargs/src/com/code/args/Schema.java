package com.code.args;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sloanzhang on 2019/4/15.
 */
public class Schema {
    private HashMap<String, Argument> schemaMap = null;
    private String schemaDesc = null;

    public Schema(String schemaString) {
        schemaMap = new HashMap<String, Argument>();
        this.schemaDesc = schemaString;
        parseSchema(schemaString);
    }

    private void parseSchema(String schemaString) {

        //need to parser from schemaString

        schemaMap.put("t", new Argument<Boolean>(false));
        schemaMap.put("p", new Argument<Integer>(80));
        schemaMap.put("s", new Argument<String>("teststring"));

        ArrayList<Integer> intArray = new ArrayList<Integer>();
        intArray.add(0);
        schemaMap.put("d", new Argument<ArrayList<Integer>>(intArray));
        ArrayList<String> strArray = new ArrayList<String>();
        strArray.add("");
        schemaMap.put("g", new Argument<ArrayList<String>>(strArray));
    }

    public HashMap<String, Argument> getSchemaMap() {
        return schemaMap;
    }




}


