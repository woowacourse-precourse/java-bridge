package bridge;

public enum Lang {
    HELLO_WORLD("안녕 세계 %s"),
    WRONG_COMMAND("잘못된 명령어를 입력했어요. 사용 가능한 명령어는 다음과 같아요.\n%s"),
    INPUT_NUMBER("숫자를 입력해 주세요."),
    INPUT_NUMBER_IN_RANGE("%d ~ %d 사이의 숫자를 입력해주세요."),
    SLAB_TYPE_IS_UNKNOWN("SlabType 이 Unknown 이에요."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    SELECT_SLAB("이동할 칸을 선택해주세요. (위: %s, 아래: %s)"),
    SELECT_RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)"),
    ERROR_OCCUR_WHILE_SAVE_DATA("데이터를 저장하던 중 오류가 발생했어요."),
    GAME_RESULT("최종 게임 결과"),
    IS_GAME_PASS("게임 성공 여부: %s"),
    GAME_IS_PASS("성공"),
    GAME_IS_FAIL("실패"),
    TOTAL_ATTEMPT("총 시도 횟수: %d");

    private final String message;

    Lang(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

    public static String format(Lang lang, Object ...args) {
        return String.format(lang.message, args);
    }

    public static String get(Lang lang) {
        return lang.toString();
    }

}
