package view;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Validation;

class InputViewTest extends NsTest {
    InputView inputView = new InputView(new Validation());

    @DisplayName("정상적인_값을_입력할_때까지_입력받는지_확인한다.")
    @ParameterizedTest
    @MethodSource("returnStringToUntilSuccessInput")
    void untilSuccessInput(String input) {
        run(input.split(","));
    }

    /**
     *   Stream<String[]>을 반환하고
     *   String[]으로 인자를 받으면
     *   배열에서 첫 번째 원소만 쓰고 에러(ParameterResolutionException)가 난다.
     */
    static Stream<Arguments> returnStringToUntilSuccessInput() {
        return Stream.of(
                arguments(new String("a,2,3")),
                arguments(new String("b,1,20"))
        );
    }

    @Override
    public void runMain() {
        inputView.readBridgeSize();
    }
}
