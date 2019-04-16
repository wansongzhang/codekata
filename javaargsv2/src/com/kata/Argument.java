package com.kata;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sloanzhang on 2019/4/16.
 */
public  class Argument<T>  {
    private T value;
    public Argument(T t) {
        this.value=t;
    }

    public T getValue(){
        return value;
    }

    public Argument copyAndAssignValue(String t) {
        String type=this.value.getClass().getSimpleName();
        switch (type){
            case "Integer":
                return new Argument(Integer.parseInt(t));
            case "String":
                return new Argument(t);
            case "ArrayList":
                return getArrayArg(t);
            default:return new Argument(t);
        }
    }

    Argument getArrayArg(String t) {
        String[] valueArray=t.trim().split("\\,");
        String type=((ArrayList)this.value).get(0).getClass().getSimpleName();
        switch (type){
            case "Integer":
                return new Argument(getIntArrayFromStringArray(valueArray));
            case "String":
                return new Argument(new ArrayList<String>(Arrays.asList(valueArray)));
            default:return new Argument(t);
        }
    }


    ArrayList<Integer> getIntArrayFromStringArray(String[] valueArray){
        ArrayList<Integer> intArray=new ArrayList<Integer>();
        for(String str:valueArray){
            intArray.add(Integer.parseInt(str));

        }
        return intArray;
    }
}
