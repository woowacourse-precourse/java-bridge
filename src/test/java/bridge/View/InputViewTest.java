package bridge.View;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.AssertInput.assertInputByMockingTest;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @DisplayName("다리길이 입력 실패 케이스 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {")", "ㅁ", "a", "0", "2", "21"})
    void 다리길이_입력_실패케이스_테스트(String params) {
        assertInputByMockingTest(()->{
                assertThrows(IllegalArgumentException.class,()->inputView.readBridgeSize());
        },params);
    }

    @DisplayName("다리길이 입력 성공 케이스 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"3","5","20"})
    void 다리길이_입력_성공케이스_테스트(String params) {
        assertInputByMockingTest(()->{
            assertDoesNotThrow(()->inputView.readBridgeSize());
        },params);
    }
}