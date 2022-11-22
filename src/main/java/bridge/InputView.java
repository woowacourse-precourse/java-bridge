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
        System.out.println("\n다리의 길이를 입려해주세요.");

        int bridgeLength = Integer.parseInt(Console.readLine());
        if(bridgeLength < 3 || bridgeLength > 20){
            throw new IllegalArgumentException("[ERROR] 입력값은 3 이상 20 이하의 숫자만 입력받을수 있습니다.");
        }

        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputChar = Console.readLine();

        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
