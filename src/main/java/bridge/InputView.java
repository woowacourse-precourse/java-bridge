package bridge;



import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String input = readLine();
        Validator.validatorOnlyNumber(input);
        Validator.validatorRangeNumber(input);

        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readSearch() {
        String readMovingToString = readLine();
        Validator.validatorMoving(readMovingToString);
        return readMovingToString;
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String readGameToString = readLine();
        Validator.validatorRestartOREnd(readGameToString);
        return readGameToString;
    }
}
