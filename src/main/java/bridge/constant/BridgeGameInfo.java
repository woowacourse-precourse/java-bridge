package bridge.constant;

import bridge.model.BridgeGame;

public enum BridgeGameInfo {
    START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    SELECT_UP_DOWN("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("최종 게임 결과"),
    SUCCESS_FAILURE("게임 성공 여부: "),
    TOTAL_TRY("총 시도한 횟수: ");

    public final String message;
    BridgeGameInfo(String message) {
        this.message = message;
    }
}

