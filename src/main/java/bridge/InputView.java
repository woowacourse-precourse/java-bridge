package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public Error error = new Error();

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String answer = Console.readLine();

        Error.validateNumber(answer);
        Error.validateNumberRange(3, 20, Integer.parseInt(answer));

        return Integer.parseInt(answer);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String answer = Console.readLine();
        if(answer.equals("u")) {answer = "U";}
        if(answer.equals("d")) {answer = "D";}
        Error.validateBridgeAnswer(answer);
        return answer;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String answer = Console.readLine();
        if(answer.equals("r")) {answer="R";}
        if(answer.equals("q")) {answer="Q";}
        Error.validateCommend(answer);
        return answer;
    }
}
