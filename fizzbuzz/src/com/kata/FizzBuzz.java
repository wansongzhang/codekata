package com.kata;

/**
 * Created by sloanzhang on 2019/4/22.
 */
public class FizzBuzz {
    public String gameString(int num) {
        if(num >100) return "game over";
        if(checkFizzBuzz(num)) return "fizzbuzz";
        if(checkFizz(num))
            return "fizz";
        if(checkBuzz(num)) return "buzz";

        return num+"";
    }

    private boolean checkFizz(int num){
        return ((num>0&&num%3==0)||num%10==3||num/10==3)?true:false;
    }

    private boolean checkBuzz(int num){
        return ((num>0&&num%5==0)||num%10==5||num/10==5)?true:false;
    }

    private boolean checkFizzBuzz(int num){
        return (num>0&&num%3==0&&num%5==0)?true:false;
    }


    public String get1to100GameString(){
        StringBuffer sBuffer=new StringBuffer();
        for(int i=0;i<100;i++){
            sBuffer.append(gameString(i)).append(" ");
        }
        return sBuffer.toString();
    }
}
