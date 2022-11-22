package bridge.View;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        return readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMove() {
        return readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        return readLine();
    }


    private static String readLine() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}
