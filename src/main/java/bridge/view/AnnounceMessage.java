package bridge.view;

public enum AnnounceMessage {

    START_GAME("다리 건너기 게임을 시작합니다.\n"),
    SIZE_INPUT("다리의 길이를 입력해주세요."),
    MOVE_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RE_OR_QUIT_INPUT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    WIN_OR_LOSE("게임 성공 여부: %s"),
    TRIES("총 시도한 횟수: %d");

    final String message;

    AnnounceMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
