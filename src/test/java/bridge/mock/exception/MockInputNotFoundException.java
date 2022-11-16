package bridge.mock.exception;

public class MockInputNotFoundException extends RuntimeException {
    public MockInputNotFoundException() {
        super("모킹 클래스에서 사용할 입력값이 존재하지 않습니다.");
    }
}
