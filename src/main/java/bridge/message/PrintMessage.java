package bridge.message;

public enum PrintMessage {
    START_BRIDGE_GAME("다리 건너기 게임을 시작합니다.\n"),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_RESULT("최종 게임 결과"),
    MATCH_RESULT_SUCCESS("게임 성공 여부: 성공"),
    MATCH_RESULT_FAILED("게임 성공 여부: 실패");

    private String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
