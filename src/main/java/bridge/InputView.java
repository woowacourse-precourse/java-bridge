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
        System.out.print("다리의 길이를 입력해주세요.");
        int bridgeInput = Integer.parseInt(Console.readLine());

        //다리 길이를 return
        return bridgeInput;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.print("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String userInput = Console.readLine();
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
