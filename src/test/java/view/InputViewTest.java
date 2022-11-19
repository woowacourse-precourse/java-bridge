package view;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Validation;

class InputViewTest {
    InputView inputView = new InputView(new Validation());

    @Nested
    class BridgeLengthInputTest extends NsTest {
        @ParameterizedTest
        @ValueSource(strings = {"a,2,3", "b,1,10"})
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
        void U_or_D를_건널칸으로_입력값을때까지_입력받는지_테스트(String input) {
            run(input.split(","));
        }

        @Override
        public void runMain() {
            inputView.readMoving();
        }
    }
}
