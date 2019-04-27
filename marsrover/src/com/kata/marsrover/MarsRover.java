package com.kata.marsrover;

import com.kata.marsrover.exception.ActionException;
import com.kata.marsrover.exception.MapException;
import com.kata.marsrover.exception.PositionException;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class MarsRover {
  private MarsMap marsMap;


  public String readInput(String inputStr) throws MapException, ActionException, PositionException {
    String []lineArray=getLineArray(inputStr);
    readMapInfo(lineArray[0]);
    StringBuilder sBuffer=new StringBuilder();
    for(int i=1;i<lineArray.length;i=i+2){
      sBuffer.append(sendCarWaitResult(lineArray[i],lineArray[i+1])).append("\r\n");
    }
    return sBuffer.toString();
  }

  private String[] getLineArray(String inputStr) {
    return inputStr.trim().split("\n");
  }

  void readMapInfo(String mapStr) throws MapException {
    this.marsMap=new MarsMap(mapStr);
  }

  String sendCarWaitResult(String posStr, String cmdStr) throws PositionException, ActionException {
    return new Car(posStr,marsMap).rover(cmdStr);
  }
}
