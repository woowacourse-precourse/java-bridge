package controller;

import camp.nextstep.edu.missionutils.Console;
import view.ErrorMessage;

public class Util {

    public static String inputValue(){
        String value = Console.readLine();
        return value;
    }

    public static void validateSize(int size){
        if(size < 3 || size >20)
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR.getErrorMessage());
    }

}
