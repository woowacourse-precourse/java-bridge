package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private String readLine() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = readLine();
        InputVerify.verifyBridgeSize(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String order = readLine();
        InputVerify.verifyOrderMove(order);
        return order;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String order = readLine();
        InputVerify.verifyOrderControl(order);
        return order;
    }
}
