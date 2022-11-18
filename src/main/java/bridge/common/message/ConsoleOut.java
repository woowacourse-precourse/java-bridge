package bridge.common.message;

public enum ConsoleOut {

    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LENGTH_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_MOVING_POSITION_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_RESTART_Q_AND_A_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_FINAL_RESULT_MESSAGE("최종 게임 결과"),
    LOOSING_GAME_MESSAGE("게임 성공 여부: 실패"),
    WINNING_GAME_MESSAGE("게임 성공 여부: 성공"),
    GAME_NUMBER_OF_ATTEMPTS("총 시도한 횟수: ");

    private String message;
    ConsoleOut(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(this.message);
    }

    public String currentMessage() {
        return this.message;
    }
}
