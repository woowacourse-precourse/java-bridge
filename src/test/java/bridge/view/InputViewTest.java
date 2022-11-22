package bridge.view;

import static org.assertj.core.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import bridge.domain.bridge.BridgeMove;
import bridge.domain.game.BridgeGameCommand;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.NoSuchElementException;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    
    private static final String ERROR_MESSAGE = "[ERROR]";
    InputView inputView;
    
    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }
    
    @Nested
    class readMovingTest extends NsTest {
        
        @DisplayName("방향 커맨드가 아닌 값을 입력했을 떄 예외를 던진다.")
        @ValueSource(strings = {"A", "UP", "DOWN", "10"})
        @ParameterizedTest
        void readMovingByInvalidInput(String invalidInput) {
            assertSimpleTest(() -> {
                assertSimpleRetryTest(() -> run(invalidInput));
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
        
        @DisplayName("방향 커맨드를 입력 받으면 재입력 시도 없이 진행된다.")
        @EnumSource(BridgeMove.class)
        @ParameterizedTest
        void readMovingByValidInput(BridgeMove bridgeMove) {
            assertSimpleTest(() -> {
                assertSimpleTest(() -> run(bridgeMove.getDirection()));
            });
        }
        
        @Override
        protected void runMain() {
            inputView.readMoving();
        }
    }
    
    @Nested
    class readBridgeSizeTest extends NsTest {
        
        @DisplayName("숫자가 아닌 값을 입력했을 떄 예외를 던진다.")
        @ValueSource(strings = {"A", "숫자", "##!", "231asd"})
        @ParameterizedTest
        void readBridgeSizeByInvalidInput(String invalidInput) {
            assertSimpleTest(() -> {
                assertSimpleRetryTest(() -> run(invalidInput));
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
        
        @DisplayName("숫자 값을 입력 받으면 재입력 시도 없이 진행된다.")
        @ValueSource(ints = {1, 10, 100, 1000})
        @ParameterizedTest
        void readBridgeSizeByValidInput(int bridgeSize) {
            assertSimpleTest(() -> {
                assertSimpleTest(() -> run(String.valueOf(bridgeSize)));
            });
        }
        
        @Override
        protected void runMain() {
            inputView.readBridgeSize();
        }
    }
    
    
    @Nested
    class readGameCommandTest extends NsTest {
        
        @DisplayName("게임 명령이 아닌 값을 입력했을 떄 예외를 던진다.")
        @ValueSource(strings = {"A", "1", "QUIT", "Z"})
        @ParameterizedTest
        void readGameCommandByInvalidInput(String invalidInput) {
            assertSimpleTest(() -> {
                assertSimpleRetryTest(() -> run(invalidInput));
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
        
        @DisplayName("게임 명령 값을 입력 받으면 재입력 시도 없이 진행된다.")
        @EnumSource(BridgeGameCommand.class)
        @ParameterizedTest
        void readGameCommandByValidInput(BridgeGameCommand bridgeGameCommand) {
            assertSimpleTest(() -> {
                assertSimpleTest(() -> run(bridgeGameCommand.getCommand()));
            });
        }
        
        @Override
        protected void runMain() {
            inputView.readGameCommand();
        }
    }
    
    // 재입력을 하지 않은 것의 예외는 무시하기 위한 테스트 메서드
    public static void assertSimpleRetryTest(final ThrowingCallable executable) {
        assertThatThrownBy(executable).isInstanceOf(NoSuchElementException.class);
    }
}
