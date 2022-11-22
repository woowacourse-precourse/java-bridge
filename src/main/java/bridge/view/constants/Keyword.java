package bridge.view.constants;

/**
 * key, value 값을 가지는 키워드의 상수 클래스에 대한 인터페이스
 */
public interface Keyword {

    String getKey();
    <T> T getValue();
}
