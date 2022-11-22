package bridge;

enum OutputGameMessage {
    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    RANGE_INPUT_MESSAGE("다리의 길이를 입력해주세요."),
    MOVE_INPUT_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_INPUT_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String outputMessage;

    OutputGameMessage(final String outputMessage) {
        this.outputMessage = outputMessage;
    }

    /**
     * 메시지를 출력합니다.
     */
    public void printMessage() {
        System.out.println(outputMessage);
    }
}
