package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

public class InputView {

    private final String INIT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String SELECT_BLOCK_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        System.out.println(INIT_BRIDGE_SIZE_MESSAGE);
        return parseInt(readLine());
    }

    public String readMoving() {
        System.out.println(SELECT_BLOCK_MESSAGE);
        return readLine();
    }

    public String readGameCommand() {
        System.out.println(RETRY_MESSAGE);
        return readLine();
    }
}
