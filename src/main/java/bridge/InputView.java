package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    static final String READ_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    static final String READ_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: u, 아래: D)";

    // 다리 길이 입력 받고 Integer 캐스팅 후 변환
    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE_MESSAGE);

        return Integer.parseInt(readLine());
    }


    // 사용자가 이동할 칸을 입력 받고 반환
    public String readMoving() {
        String direction;

        System.out.println(READ_MOVING_MESSAGE);
        direction = readLine();

        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
