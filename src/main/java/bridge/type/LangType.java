package bridge.type;

public enum LangType {
    HELLO_WORLD("안녕 세계 %s"),
    WRONG_COMMAND("잘못된 명령어를 입력했어요. 사용 가능한 명령어는 다음과 같아요.\n%s"),
    SLAB_TYPE_IS_UNKNOWN("SlabType 이 알 수 없음 이에요.");

    private final String message;

    LangType(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

    public static String format(LangType lang, Object ...args) {
        return String.format(lang.message, args);
    }

    public static String get(LangType lang) {
        return lang.toString();
    }
}
