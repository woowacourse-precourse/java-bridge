package bridge.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.bridge.Bridge;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    @Nested
    @DisplayName("브릿지 사이즈 입력테스트")
    class ReadBridgeSizeTest extends NsTest {

        InputView inputView;

        @BeforeEach
        public void setUp() {
            inputView = new InputView();
        }

        @DisplayName("유효하지 않은 길이로 입력이 들어올 경우 예외를 던진다.")
        @ParameterizedTest
        @ValueSource(strings = {"2", "21", "0", "30"})
        public void throwExceptionWhenInvalidBridgeSize(String bridgeSize) {
            String exceptionMessage = "다리 길이는 " + Bridge.MIN_SIZE + "부터 " + Bridge.MAX_SIZE + " 사이의 숫자여야 합니다.";
            assertSimpleTest(() -> {
                run(bridgeSize, "3");
                assertThat(
                        output().contains(exceptionMessage)
                );
            });
        }

        @Override
        protected void runMain() {
            inputView.readBridgeSize();
        }
    }
}