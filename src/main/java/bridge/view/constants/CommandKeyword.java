package bridge.view.constants;

/**
 * 재시도/종료를 결정하는 명령 키워드를 저장하는 상수 클래스
 */
public enum CommandKeyword implements Keyword {

    RETRY("R", true),
    QUIT("Q", false);

    private final String key;
    private final boolean value;

    CommandKeyword(String key, boolean value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Boolean getValue() {
        return value;
    }
}
