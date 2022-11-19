package bridge;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private String inputBridgeSize ="다리의 길이를 입력해주세요.";
    private String replyOrQuite  = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private String moveChoice  = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(inputBridgeSize);
        String inputBridgeSize = Console.readLine();
        return Integer.valueOf(inputBridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(moveChoice);
        String inputMoving = Console.readLine();
        return inputMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(replyOrQuite);
        String inputGameCommand = Console.readLine();
        return inputGameCommand;
    }
}
