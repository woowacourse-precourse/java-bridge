package bridge.constants;

public enum ViewMessage {
    START("다리 건너기 게임을 시작합니다."),
    SET_LENGTH("다리의 길이를 입력해주세요."),
    SET_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    SET_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    private String description;
    ViewMessage(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
}
