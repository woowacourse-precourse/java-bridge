package bridge.type;

public enum LangType {
    HELLO_WORLD("안녕 세계 %s"),
    THROW_UNKNOWN_BRIDGE_TYPE("알 수 없는 브리지 타입이 입력되었어요."),
    THROW_WRONG_COMMAND("잘못된 명령어를 입력했어요. 사용 가능한 명령어는 다음과 같아요.\n%s");

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
