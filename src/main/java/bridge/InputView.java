package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Locale;

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

        if (isWrongValue(input,1)){
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String selectedDir = Console.readLine().toUpperCase();
        if (isWrongValue(selectedDir,2)){
            return readMoving();
        }
        return selectedDir;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요 (재시도: R,종료: Q)");
        String selectedResult = Console.readLine().toUpperCase();
        if (isWrongValue(selectedResult,3)){
            return readGameCommand();
        }
        return selectedResult;
    }

    /**
     *
     * 유효값 검사 후 예외처리
     */
    public boolean isWrongValue (String input, int num) {
        try {
            Validate.check(input,num);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }
}
