package bridge.View;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요";
    private static final String CHOOSE_BRIDGE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_RESTART_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String BRIDGE_SIZE_OUT_OF_BOUND_ERROR = "[ERROR] 다리 길이는 3이상 20이하의 숫자만 가능합니다.";
    private static final String NOT_INTEGER_ERROR = "[ERROR] 숫자만 입력할 수 있습니다.";
    private static final String BRIDGE_CHOOSE_OUT_OF_BOUND_ERROR = "[ERROR] U와 D 중 하나만 입력할 수 있습니다.";
    private static final String GAME_COMMAND_OUT_OF_BOUND_ERROR = "[ERROR] R과 Q 중 하나만 입력할 수 있습니다.";

    private InputView() {

    }
}