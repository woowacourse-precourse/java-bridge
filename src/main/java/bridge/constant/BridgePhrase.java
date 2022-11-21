package bridge.constant;

public enum BridgePhrase {
    START_GAME_PHRASE("다리 건너기 게임을 시작합니다.\n"),

    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVE("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    GAME_RESULT("최종 게임 결과"),
    GAME_SUCCESS("게임 성공 여부: 성공"),
    GAME_FAIL("게임 성공 여부: 실패"),
    GAME_TRY_COUNT("총 시도한 횟수: %d"),

    ERROR_BRIDGE_GENERATION("[ERROR] Wrong Bridge validated."),

    ERROR_PARSER_BLANK("[ERROR] Blank String is not allowed."),
    ERROR_PARSER_NULL("[ERROR] Null String is not allowed."),
    ERROR_PARSER_BRIDGE_SIZE("[ERROR] Bridge size must be numeric."),
    ERROR_PARSER_MOVE("[ERROR] Move must be alphabetic."),
    ERROR_PARSER_GAME_COMMAND("[ERROR] Game Command must be alphabetic."),

    ERROR_DOMAIN_BRIDE_SIZE("[ERROR] Bridge size must be between 3 and 20."),
    ERROR_DOMAIN_MOVE("[ERROR] Move must be U or D"),
    ERROR_DOMAIN_GAME_COMMAND("[ERROR] Game Command must be R or Q.");

    private final String message;

    BridgePhrase(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
