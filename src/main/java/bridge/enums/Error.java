package bridge.enums;

import static bridge.condition.IsNumberInRangeCond.*;

public enum Error {
    OUT_OF_RANGE("[ERROR] 다리 길이는 " + LOWER_BOUND + "부터 " + UPPER_BOUND + " 사이의 숫자여야 합니다."),
    NOT_GAME_ACTION("[ERROR] 위로 이동은 U, 아래로 이동은 D를 입력하세요."),
    NOT_SYSTEM_ACTION("[ERROR] 종료는 Q, 재시작은 R을 입력하세요.");

    private String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
