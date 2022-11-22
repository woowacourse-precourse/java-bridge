package bridge;

public enum printOutput {

    START_GAME("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    SELECT_BRIDGE_UP_DOWN("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RESTART_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    IS_SUCCESS_SUCCESS("게임 성공 여부: 성공"),
    IS_SUCCESS_FAIL("게임 성공 여부: 실패"),
    ALL_TRY("총 시도한 횟수: "),
    ;
    private final String gameOutput;

    public String getGameOutput() {
        return gameOutput;
    }

    printOutput(String gameOutput) {
        this.gameOutput = gameOutput;
    }
}
