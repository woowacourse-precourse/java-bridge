package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    private void validateBridgeSize (String input) {
        String regex = "^[0-9]+$";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (!matcher.matches()){
            throw new IllegalArgumentException();
        }
        int bridgeLength = Integer.parseInt(input);
        if (bridgeLength < 3 || bridgeLength > 20){
            throw new IllegalArgumentException();
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
}
