package bridge.views;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class DefaultView {

    private static final String MSG_LINE_SEPARATOR = "";

    protected DefaultView(){
    }

    protected String input(){
        try {
            return Console.readLine();
        } catch (NoSuchElementException e){
            throw new IllegalArgumentException(
                    "입력값이 있는 입력을 해야 합니다."
            );
        }
    }

    protected void output(String message){
        System.out.println(message);
    }

    protected void printLineSeparator() {
        output(MSG_LINE_SEPARATOR);
    }
}
