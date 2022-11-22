package bridge.view;// @ author ninaaano

public enum Message {
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_STATUS("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    GAME_RESULT("최종 게임 결과"),
    OUTPUT_SUCCESS_OR_NOT("게임 성공 여부: "),
    OUTPUT_NUMBER_OF_ATTEMPTS("총 시도한 횟수: "),
    OUTPUT_SUCCESS("성공"),
    OUTPUT_NOT("실패");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
