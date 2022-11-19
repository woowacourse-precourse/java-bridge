package bridge.utils.constant;

public enum Phrase {
    PHRASE_START_GAME("다리 건너기 게임을 시작합니다."),
    PHRASE_INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    PHRASE_WHERE_TO_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    PHRASE_RESTART_THE_GAME("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    PHRASE_RESULT_OF_THE_GAME("최종 게임 결과"),
    PHRASE_GAME_SUCCESS("게임 성공 여부: 성공"),
    PHRASE_GAME_FAILED("게임 성공 여부: 실패"),
    PHRASE_GAME_ATTEMPT("총 시도한 횟수: ");

    private final String phrase;

    Phrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
