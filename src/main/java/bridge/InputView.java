package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String numberPattern = "^[0-9]+$";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");

        String input = Console.readLine();
        int bridgeSize = sizeValidate(input);

        return bridgeSize;
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

    public int sizeValidate(String number){
        if(!(Pattern.matches(numberPattern, number))){
            throw new IllegalArgumentException("[ERROR] 다리의 길이가 숫자 형식이 아닙니다.");
        }
        int result = Integer.parseInt(number);
        if(result < 3 || result > 20){
            throw new IllegalArgumentException("[ERROR] 다리의 길이가 범위를 벗어납니다. (3 ~ 20)");
        }
        return result;
    }
}
