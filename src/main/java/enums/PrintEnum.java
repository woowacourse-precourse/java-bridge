package enums;

public enum PrintEnum {
    START_BRIDGE_GAME("다리 건너기 게임을 시작합니다. \n"),
    PLEASE_INPUT_BRDIGE_SIZE ("다리의 길이를 입력해주세요."),
    PLEASE_CHOOSE_MOVE_SPOT ("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    PLEASE_INPUT_RETRY_OR_NOT ( "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    START("[ "),
    DIVIDER(" | "),
    END(" ]"),
    O("O"),
    X("X");

    private final String text;

    PrintEnum(String text){
        this.text = text;
    }

    public String getValue(){
        return this.text;
    }
}
