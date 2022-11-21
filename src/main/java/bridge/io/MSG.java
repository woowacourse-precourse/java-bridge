package bridge.io;

public enum MSG {

    INPUT_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_GAME("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    OUTPUT_GAME_RESULT("\n최종 게임 결과"),
    OUTPUT_PASS_FAIL("게임 성공 여부: "),
    OUTPUT_TOTAL_TRY_COUNT("총 시도한 횟수: "),

    ERR_001("[ERROR] 다리의 길이는 3이상 20이하 숫자만 입력 가능합니다."),
    ERR_002("[ERROR] 이동할 칸은 U/D 중 하나를 입력해 주세요."),
    ERR_003("[ERROR] 게임 재시작 여부는 R/Q 중 하나를 입력해 주세요.");

    public final String message;

    MSG(String msg) {
        this.message = msg;
    }
}
