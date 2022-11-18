package bridge.constant;

public enum GuideMessage {
    GAME_STARTING_GUIDE("다리 건너기 게임을 시작합니다.\n" +
            "다리는 위쪽과 아래쪽으로 구별되며 왼쪽에서 오른쪽으로 건너갑니다.\n" +
            "위쪽과 아래쪽 중에서 하나의 칸만 이동이 가능합니다.\n"),
    BRIDGE_LENGTH_ENTERING_GUIDE("다리의 길이를 입력해주세요.\n" +
            "다리의 길이는 3 이상 20 이하입니다."),
    MOVEMENT_ENTERING_GUIDE("이동할 칸을 선택하세요. (위: U, 아래: D)"),
    RETRY_ENTERING_GUIDE("게임을 다시 시도할지 여부를 입력하세요. (재시도: R, 종료: Q)");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
