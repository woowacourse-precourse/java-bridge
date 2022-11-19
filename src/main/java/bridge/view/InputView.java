package bridge.view;

import bridge.model.Moving;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView implements Input {

    String moveError = "[ERROR] 이동할 칸은 U나 D로만 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    @Override
    public String readBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    @Override
    public Moving readMoving() {
        while (true) {
            try {
                return getMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Moving getMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputMoving = Console.readLine();
        if (Moving.UP.getValue().equals(inputMoving)) return Moving.UP;
        if (Moving.DOWN.getValue().equals(inputMoving)) return Moving.DOWN;
        throw new IllegalArgumentException(moveError);
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
