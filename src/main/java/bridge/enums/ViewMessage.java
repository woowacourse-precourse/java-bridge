package bridge.enums;

public enum ViewMessage {
    INPUT_START_GAME("다리 건너기 게임을 시작합니다.\n"),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_UP_DOWN("\n이동할 칸을 선택해주세요. (위: " + Key.U.getValue() + ", 아래: " + Key.D.getValue() + ")"),
    INPUT_RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + Key.R.getValue() + ", 종료: " + Key.Q.getValue() + ")"),
    OUTPUT_PRINT_FINAL_MAP("\n최종 게임 결과\n{0}\n{1}"),
    OUTPUT_PRINT_FINAL_RESULT("\n게임 성공 여부: {0}\n총 시도한 횟수: {1}");


    private final String value;

    ViewMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
