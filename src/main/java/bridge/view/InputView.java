package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static bridge.utils.Exceptions.*;
import static bridge.utils.Messages.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(REQUEST_BRIDGE_LENGTH);
        return stringToInt(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(REQUEST_WHERE_TO_MOVE);
        String input = Console.readLine();
        validateMoveInput(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(REQUEST_RETRY);
        String input = Console.readLine();
        validateGameCommandInput(input);
        return input;
    }

    private static int stringToInt(String input){
        validateInputNone(input);
        try{
            return Integer.parseInt(input);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(USER_INPUT_NOT_INTEGER_EXCEPTION);
        }
    }
    private static void validateInputNone(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException(USER_INPUT_NULL_EXCEPTION);
        }
    }

    private static void validateMoveInput(String input){
        validateInputNone(input);
        String pattern = "^U|D$";
        if(!Pattern.matches(pattern,input)){
            throw new IllegalArgumentException(USER_INPUT_NOT_U_OR_D_EXCEPTION);
        }

    }

    private static void validateGameCommandInput(String input){
        validateInputNone(input);
        String pattern = "^R|Q$";
        if(!Pattern.matches(pattern,input)){
            throw new IllegalArgumentException(USER_INPUT_NOT_R_OR_Q_EXCEPTION);
        }

    }



}
