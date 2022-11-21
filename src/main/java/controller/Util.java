package controller;

import camp.nextstep.edu.missionutils.Console;
import view.ErrorMessage;

public class Util {
    public int inputSize(){
        int size = Integer.parseInt(inputValue());
        return size;
    }

    public String inputMoving(){
        String moving = inputValue();
        return moving;
    }

    private String inputValue(){
        String value = Console.readLine();
        return value;
    }

    public static void validateSize(int size){
        if(size < 3 || size >20)
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR.getErrorMessage());
    }

    public static void validateMoving(String moving){
        if(!moving.equals("U") || !moving.equals("D"))
            throw new IllegalArgumentException(ErrorMessage.MOVING_ERROR.getErrorMessage());
    }

}
