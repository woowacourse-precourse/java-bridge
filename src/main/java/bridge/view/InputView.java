package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static bridge.view.InputViewString.*;

public class InputView {
    public void startMessage(){
        System.out.println(START_MESSAGE);
    }

    private static void checkEmpty(String input){
        if (input == null || input.isBlank()){
            throw new IllegalArgumentException(EMPTY_INPUT.toString());
        }
    }
}
