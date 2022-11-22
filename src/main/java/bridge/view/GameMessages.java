package bridge.view;

public enum GameMessages {
    START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    DECIDE_BRIDGE_LENGTH_MESSAGE("다리의 길이를 입력해주세요."),
    CHOOSE_DIRECTION_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRIAL_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    END_MESSAGE("최종 게임 결과"),
    GAME_SUCCESS_MESSAGE("게임 성공 여부: "),
    RETRIAL_NUMBERS_MESSAGE("총 시도한 횟수: ");

    private String message;

    GameMessages(String message) {
        this.message = message;
    }

    public void println() {
        System.out.println(this.message);
    }

    public void print() {
        System.out.print(this.message);
    }
}
