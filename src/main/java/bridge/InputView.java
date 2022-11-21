package bridge;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

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
    public void printMovingMsg() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public String checkMoving(String moveDirection) {
        if (!Objects.equals(moveDirection, "U") && !Objects.equals(moveDirection, "D")) {
            throw new IllegalArgumentException("[ERROR] 입력할 수 있는 방향은 U(위) 또는 D(아래) 두가지 입니다.");
        }
        return moveDirection;
    }

    public String readMoving() {
        printMovingMsg();
        String moveDirection = checkMoving(Console.readLine());
        return moveDirection;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
