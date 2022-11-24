package view.output;

public enum OutputMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    END_MESSAGE("\n최종 게임 결과\n"),
    SUCCESS_OR_FAIL("\n게임 성공 여부: "),
    TOTAL_NUMBER("\n총 시도한 횟수: ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.print(message);
    };
}