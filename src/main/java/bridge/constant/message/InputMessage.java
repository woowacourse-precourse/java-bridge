package bridge.constant.message;

public enum InputMessage {

    START("다리 건너기 게임을 시작합니다.")
    , BRIDGE_LENGTH("다리의 길이를 입력해주세요.")
    , SELECT_MOVE("이동할 칸을 선택해주세요. (위: %s, 아래: %s)\n")
    , PLAY_CONTROL("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)\n")
    ;

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
