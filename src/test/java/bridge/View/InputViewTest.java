package bridge.View;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.AssertInput.assertInputByMockingTest;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @DisplayName("다리길이 입력 실패 케이스 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {")", "ㅁ", "a", "0", "2", "21"})
    void 다리길이_입력_실패케이스_테스트(String bridge_size_input) {
        assertInputByMockingTest(()->{
                assertThrows(IllegalArgumentException.class,()->inputView.readBridgeSize());
        },bridge_size_input);
    }

    @DisplayName("다리길이 입력 성공 케이스 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"3","5","20"})
    void 다리길이_입력_성공케이스_테스트(String bridge_size_input) {
        assertInputByMockingTest(()->{
            assertEquals(inputView.readBridgeSize(),Integer.parseInt(bridge_size_input));
        },bridge_size_input);
    }


    @DisplayName("이동방향 입력 성공 케이스 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"U","D","U","D"})
    void 이동방향_입력_성공케이스_테스트(String moving_direction) {
        assertInputByMockingTest(()->{
            assertEquals(inputView.readMoving(),moving_direction);
        },moving_direction);
    }

    @DisplayName("이동방향 입력 실패 케이스 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"UD","DU","u","d","마","1","#"})
    void 이동방향_입력_실패케이스_테스트(String moving_direction) {
        assertInputByMockingTest(()->{
            assertThrows(IllegalArgumentException.class, () -> inputView.readMoving());
        },moving_direction);
    }
}