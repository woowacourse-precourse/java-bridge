package enumCollections;

public enum GuideMessage {
    START("다리 건너기 게임을 시작합니다."),
    GET_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    GET_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GET_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("게임 성공 여부: %s\n"),
    GAME_TRIAL("총 시도한 횟수: %s\n"),
    RESULT_PRINT("최종 게임 결과");

    private String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public static String get(GuideMessage situation) {
        return situation.message;
    }
}
