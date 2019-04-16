package com.kata;

import java.util.HashMap;

/**
 * Created by sloanzhang on 2019/4/16.
 */
public class Parser {
    private Schema schema;
    private HashMap<String, Argument> argValidateMap=new HashMap<String, Argument>();

    public Parser(String schemaStr, String cmdLine) throws  ArgumentException,SchemaException{
        parserSchema(schemaStr);
        parserCmdline(cmdLine);
    }

    public Parser() {
    }

    void parserCmdline(String cmdLine) {
        String[] argArray = parserCmdlineToArray(cmdLine);
        for (String argStr : argArray) {
            parserArgValue(argStr);
        }
    }

    void parserArgValue(String argStr) {
        String[] valueArray = argStr.trim().split(" ");
        if (valueArray != null && valueArray.length > 0) {
            String flag = valueArray[0];
            Argument arg = getRightTypeArgument(flag,valueArray.length>1?valueArray[1]:null);
            if (schema.checkFlagInSchema(flag))
                argValidateMap.put(flag, arg);
        }
    }

    Argument getRightTypeArgument(String flag,String value){
        if(value==null) return new Argument(true);
        Argument defaultArg = schema.getSchemaArgument(flag);
        return defaultArg!=null?defaultArg.copyAndAssignValue(value):null;
    }



    String[] parserCmdlineToArray(String cmdLine) {
        return cmdLine.trim().split("\\-");
    }

    void parserSchema(String schemaStr) throws SchemaException{
        schema=new Schema(schemaStr);
    }

    public <T> T parserArgument(String flag) throws ArgumentException {

        if (!schema.checkFlagInSchema(flag)) {
            throw new ArgumentException("got unknown flag:" + flag+",please follow schema as: \n"+schema.toString());
        }
        return checkFlagInCmdValueMap(flag)?getCmdLocalArgumentValue(flag):(T)schema.getSchemaArgumentValue(flag);
    }

    <T>T getCmdLocalArgumentValue(String flag){
        return (T)argValidateMap.get(flag).getValue();
    }

    boolean checkFlagInCmdValueMap(String flag) {
        return argValidateMap.get(flag) == null ? false : true;
    }


}
