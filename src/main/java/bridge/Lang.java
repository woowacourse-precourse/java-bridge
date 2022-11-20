package bridge;

public enum Lang {
    HELLO_WORLD("안녕 세계 %s"),
    WRONG_COMMAND("잘못된 명령어를 입력했어요. 사용 가능한 명령어는 다음과 같아요.\n%s"),
    INPUT_NUMBER("숫자를 입력해 주세요."),
    INPUT_NUMBER_IN_RANGE("%d ~ %d 사이의 숫자를 입력해 주세요."),
    SLAB_TYPE_IS_UNKNOWN("SlabType 이 알 수 없음 이에요.");

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
