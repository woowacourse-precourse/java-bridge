package bridge.view.constants;

/**
 * 최종 결과를 표현하는 키워드를 저장하고 값에 따라 변환해주는 상수 클래스
 */
public enum ResultKeyword implements Keyword {

    SUCCESS("성공", true),
    FAIL("실패", false);

    private final String key;
    private final boolean value;

    ResultKeyword(String key, boolean value) {
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

    public static String convertValueByKey(boolean hasSucceed) {
        if (hasSucceed) {
            return SUCCESS.getKey();
        }
        return FAIL.getKey();
    }
}
