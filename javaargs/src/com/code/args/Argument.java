package com.code.args;

import java.util.ArrayList;
import java.util.IdentityHashMap;

/**
 * Created by sloanzhang on 2019/4/15.
 */
public class Argument<T>{
    private T value;

    public Argument(T t){
        this.value=t;
    }

    public T getValue(){
        return value;
    }


    public  Argument copyAndAssignValue(String t){
        String type=value.getClass().getSimpleName();
        switch(type) {
            case "Integer":
                return new Argument(Integer.parseInt(t));
            case "Boolean":
                return new Argument(t == null ? true : false);
            case "String":
                return new Argument(t);
            case "ArrayList":
                return getArrayValue(t);
            default:
                return new Argument(t);
        }
    }
    private Argument getArrayValue(String t){
        String type=((ArrayList)value).get(0).getClass().getSimpleName();
        switch(type) {
            case "Integer":
                return new Argument(getIntArrayFromString(t));
            case "String":
                return new Argument(getStrArrayFromString(t));
            default:
                return new Argument(t);
        }
    }


    private ArrayList<Integer>  getIntArrayFromString(String str){
        ArrayList<Integer> arrayInt=new ArrayList<Integer>();

        if(str!=null){
            String[] tmp = str.split("\\,");
            for(int i=0;tmp!=null&&i<tmp.length;i++){
                arrayInt.add(Integer.parseInt(tmp[i].trim()));
            }
        }
        return arrayInt;
    }

    private ArrayList<String>  getStrArrayFromString(String str){
        ArrayList<String> arrayStr=new ArrayList<String>();
        if(str!=null){
            String[] tmp = str.split("\\,");
            for(int i=0;tmp!=null&&i<tmp.length;i++){
                arrayStr.add(tmp[i].trim());
            }
        }
        return arrayStr;
    }

}
