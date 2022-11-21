package bridge;

import bridge.enums.Command;
import bridge.enums.Move;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput = Console.readLine();
        return convertBridgeSize(userInput);
    }

    public int convertBridgeSize(String userInput) {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(userInput.strip());
            System.out.println(bridgeSize); // output = 25
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자를 입력해주세요.");
        }

        if (bridgeSize <3 || bridgeSize>20)
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Move readMoving() {
        String userInput = Console.readLine();
        return convertMoving(userInput);
    }

    public Move convertMoving(String userInput) {
        userInput = userInput.replace("\n", "").strip();
        System.out.println(userInput);
        Move result = Move.check(userInput);
        if(result == null)
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 (위: U, 아래: D)의 값이어야 합니다.");
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        String userInput = Console.readLine();
        return convertGameCommand(userInput);
    }

    public Command convertGameCommand(String userInput) {
        userInput = userInput.replace("\n", "").strip();
        Command result = Command.check(userInput);
        if(result == null)
            throw new IllegalArgumentException("[ERROR] 재시도 여부는 (재시도: R, 종료: Q)의 값이어야 합니다.");
        return result;
    }

}

