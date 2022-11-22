package view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Validation;

class InputViewTest {
    InputView inputView = new InputView(new Validation());

    @Nested
    class BridgeLengthInputTest extends NsTest {
        @ParameterizedTest
        @ValueSource(strings = {"3000000000,-1,a,2,3", "b,1,10"})
        void 성공적인_다리의_길이_입력값을_받을때까지_입력받는지_테스트(String input) {
            run(input.split(","));
        }

        @Override
        public void runMain() {
            inputView.readBridgeSize();
        }
    }

    @Nested
    class MovingNextInputTest extends NsTest {
        @ParameterizedTest
        @ValueSource(strings = {"u,d,UU,U ,U"})
        void U_또는_D를_입력받을때까지_입력받는지_테스트(String input) {
            run(input.split(","));
        }

        @Override
        public void runMain() {
            inputView.readMoving();
        }
    }

    @Nested
    class CommandInputTest extends NsTest {
        @ParameterizedTest
        @ValueSource(strings = {"r,q,RR,R ,R"})
        void R_또는_Q를_입력받을때까지_입력받는지_테스트(String input) {
            run(input.split(","));
        }

        @Override
        public void runMain() {
            inputView.readGameCommand();
        }
    }
}
