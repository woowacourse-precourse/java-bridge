package bridge.message;

public enum GameMessage {
    GAME_START("다리 건너기 게임을 시작합니다."),
    ENTER_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    ENTER_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ENTER_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_GAME_RESULT("최종 게임 결과"),
    IS_GAME_SUCCESS("게임 성공 여부: "),
    TOTAL_TRY("총 시도한 횟수: ");

    public final String msg;

    GameMessage(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
