package bridge.mock.exception;

public class MockInputNotFoundException extends RuntimeException {

    public static final String MOCK_INPUT_NOT_FOUND_MESSAGE = "모킹 클래스에서 사용할 입력값이 존재하지 않습니다.";

    public MockInputNotFoundException() {
        super(MOCK_INPUT_NOT_FOUND_MESSAGE);
    }
}
