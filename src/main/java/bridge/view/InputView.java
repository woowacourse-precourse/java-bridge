package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.util.message.GameMessage.*;
import static bridge.util.message.ErrorMessage.*;
import static bridge.view.OutputView.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        showMessage(START_MESSAGE.getMessage());
        String bridgeSize = input();
        exceptionBridgeSize(bridgeSize);

        return 0;
    }

    private void exceptionBridgeSize(String size){

        //예외 범위 입력시
        if(size.length()<3||size.length()>20){
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }

        //숫자 이외에 문자 입력시
        for(int i=0;i<size.length();i++){
            if('1'>size.charAt(i)||size.charAt(i)>'9'){
                throw new IllegalArgumentException(INPUT_NUMERIC.getMessage());
            }
        }

    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    public static String input(){
        return Console.readLine();
    }
}
