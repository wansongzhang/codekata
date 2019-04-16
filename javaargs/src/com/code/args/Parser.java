package com.code.args;

import java.util.HashMap;


public class Parser {
    private HashMap<String, Argument> argumentMap = null;
    private HashMap<String, Argument> defaultSchemaMap = null;

    public Parser(String schemaString, String commandLine) {
        argumentMap = new HashMap<String, Argument>();
        parseSchema(schemaString);
        parseArgument(commandLine);
    }


    private void parseSchema(String schemaString) {
        defaultSchemaMap = new Schema(schemaString).getSchemaMap();
    }


    private void parseArgument(String commandLine) {
        String[] argArray = parseCmdlineToArgsArray(commandLine);
        for (int i = 0; argArray != null && i < argArray.length; i++) {
            parseSingleParaToFlagAndArgument(argArray[i]);

        }
    }

    private void parseSingleParaToFlagAndArgument(String argstr) {
        String[] valueArray = argstr.split(" ");
        if (valueArray != null) {
            String flag = valueArray[0];
            if (checkFlagValidate(flag)) {
                generateFlagValue(flag, valueArray.length > 1 ? valueArray[1] : null);
            }
        }
    }

    private void generateFlagValue(String flag, String flagValue) {
        Argument defaultFalg = defaultSchemaMap.get(flag);
        argumentMap.put(flag, defaultFalg.copyAndAssignValue(flagValue));
    }


    private boolean checkFlagValidate(String flag) {
        return defaultSchemaMap.get(flag) != null ? true : false;
    }

    private String[] parseCmdlineToArgsArray(String commandLine) {
        return commandLine.trim().split("\\-");
    }


    public <T> T getValue(String flag) throws ArgumentException {
        if(!checkFlagValidate(flag)) throw new ArgumentException("unknown  flag  "+flag);
        Argument arg = argumentMap.get(flag);
        if (arg == null) {
            arg = defaultSchemaMap.get(flag);
        }
        return (T) arg.getValue();
    }
}
