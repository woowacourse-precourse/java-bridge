package bridge.view.inputview;

import bridge.mock.MockInputView;
import bridge.system.util.BridgeMessageMaker;
import bridge.system.validation.InputToMovingPointValidator;
import bridge.view.outputview.OutputView;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewProxyTest {
    @Nested
    @DisplayName("InputView에 ExceptionHandling 코드를 씌운 프록시객체 테스트")
    class InputViewExceptionHandlingProxyTest {
        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream captor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(captor));
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        @DisplayName("InputView 프록시 객체의 메소드를 호출하다 예외가 발생하면 일정 포맷에 담긴 메시지를 출력한다.")
        void givenProxyAndInvalidInput_whenRunningMethod_thenPrintsErrorMessage() {
            //given
            InputViewInterface proxy = makeInputViewProxy(List.of("R", "U"));

            //when
            proxy.readMoving();

            //then
            assertThat(captor.toString())
                    .isEqualTo(String.format(OutputView.ERROR_MESSAGE_FORMAT,
                            InputToMovingPointValidator.INVALID_INPUT_VALUE_MESSAGE));
        }

        @Test
        @DisplayName("틀린 값을 받으면 알맞는 입력값이 들어올 때까지 해당 입력값을 다시 받도록 한다.")
        void givenProxyAndInvalidInput_whenRunningMethod_thenRepeatsUntilSuccess() {
            //given
            InputViewInterface proxy = makeInputViewProxy(List.of("40", "1", "R", "1.5", "-5", "8"));

            //when && then
            assertThat(proxy.readBridgeSize()).isEqualTo(8);
        }

        private InputViewInterface makeInputViewProxy(List<String> mockInputs) {
            InputViewInterface target = new MockInputView(mockInputs);
            InvocationHandler invocationHandler
                    = new InputViewExceptionHandlingProxy(target, new OutputView(new BridgeMessageMaker()));
            return (InputViewInterface) Proxy.newProxyInstance(
                    InputViewInterface.class.getClassLoader(),
                    new Class[]{InputViewInterface.class},
                    invocationHandler);
        }
    }
}