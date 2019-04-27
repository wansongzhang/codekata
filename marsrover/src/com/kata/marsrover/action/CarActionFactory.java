package com.kata.marsrover.action;

import com.kata.marsrover.exception.ActionException;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class CarActionFactory {

  public static CarAction getCarAction(char action) throws ActionException {
    switch (action) {
      case 'M':
        return new CarMAction();
      case 'L':
        return new CarLAction();
      case 'R':
        return new CarRAction();
      default:
        throw new ActionException("unknown action "+action);
    }
  }
}
