package view;

public enum PrintMessage {

    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_LENGTH_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_MOVING_FLOOR_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RESTART_STATUS_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_MESSAGE("최종 게임 결과"),
    NEW_LINE("");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
