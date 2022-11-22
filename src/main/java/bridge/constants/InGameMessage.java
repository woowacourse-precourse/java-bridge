package bridge.constants;

public enum InGameMessage {

    BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    START("다리 건너기 게임을 시작합니다."),
    SPACE_TO_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    WHETHER_TO_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_GAME_RESULT("최종 게임 결과"),
    WHETHER_GAME_IS_SUCCESSFUL("게임 성공 여부: "),
    TOTAL_TRY_COUNT("총 시도한 횟수: ");

    private final String message;

    InGameMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
