package bridge;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public void printBridgeSizeMsg() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public int checkBridgeSize(String input) {
        try {
            int bridgeSize = Integer.parseInt(input);
            if (bridgeSize < 3 || bridgeSize > 20) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
            return bridgeSize;
        } catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public int readBridgeSize() {
        printBridgeSizeMsg();
        int bridgeSize = checkBridgeSize(Console.readLine());
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
}
