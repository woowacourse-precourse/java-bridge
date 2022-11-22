package bridge;

import java.util.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final Exception exception = new Exception();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = readLine();
        int length_bridge;
        try {
            length_bridge = Integer.parseInt(input);
        }catch (NumberFormatException  e){
            throw new IllegalArgumentException("[ERROR] 정수가 아닙니다.");
        }
        if (length_bridge<3 &&length_bridge>20){
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자를 입력하세요");
        }
        return length_bridge;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String Moving = readLine();
        if (Moving != "U" || Moving != "D"){
            throw new IllegalArgumentException("[ERROR] 대문자 U 또는 D를 입력하세요");
        }


        return Moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Command.REGAME_MESSAGE);
        String retry = readLine();
        retryInput(retry);
        return retry;

    }

    public void retryInput(String retry) {
        exception.checkAlphabet(retry);
        exception.checkRetryInput(retry);
    }
}
