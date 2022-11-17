package bridge.constant;

public enum PrintString {
    INIT_START("다리 건너기 게임을 시작합니다.\n"),
    SET_SIZE("다리의 길이를 입력해주세요."),

    MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)");


    private String printString;

    PrintString(String printString) {
        this.printString=printString;
    }

    public String getPrint() {
        return printString;
    }

}
