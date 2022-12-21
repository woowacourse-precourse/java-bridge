package message;

public enum GameMessage {
    START_GAME("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    MOVE_COMMAND("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    SUCCESS_MESSAGE("성공"),
    FAIL_MESSAGE("실패"),


    FINAL_RESULT("최종 게임 결과"),
    GAME_RESULT("게임 성공 여부: "),
    GAME_ROUND("총 시도한 횟수: ");

    private String status;

    GameMessage(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
