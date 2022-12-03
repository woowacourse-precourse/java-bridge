package bridge.view;

public enum InputViewString {
    BRIDGE_SIZE_MESSAGE("다리의 길이를 입력해주세요."),
    BLANK_TO_MOVE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_OR_END_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    NO_NUMBER_INPUT("[ERROR] 숫자만 입력해주세요."),
    NO_ALPHABET_INPUT("[ERROR] 알파벳만 입력해주세요."),
    EMPTY_INPUT("[ERROR] 값이 비어있습니다. 값을 입력해주세요.");

    private final String content;

    InputViewString(String content){
        this.content = content;
    }

    @Override
    public String toString(){
        return content;
    }

}
