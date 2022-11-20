package bridge;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeLength = 0;
        System.out.println("다리의 길이를 입력해주세요.");
        bridgeLength = Integer.parseInt(Console.readLine());
        System.out.println(bridgeLength);
        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moveBridge = "";
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        moveBridge = Console.readLine();
        System.out.println(moveBridge);
        return moveBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = "";
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        gameCommand = Console.readLine();
        System.out.println(gameCommand);
        return gameCommand;
    }
}
