package bridge;

import bridge.processor.ValidatorProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private BridgeGame bridgeGame;
    private ValidatorProcessor validatorProcessor;

    @TestFactory
    @DisplayName("move Test")
    Stream<DynamicTest> moveTest() {
        validatorProcessor = new TestValidatorProcessor();
        bridgeGame = new BridgeGame(validatorProcessor);

        return Stream.of(
                DynamicTest.dynamicTest("move 를 테스트한다.", () -> {
                            List<String> bridge = List.of("U", "D", "U");
                            List<String> command = List.of("U", "U");
                            List<List<String>> moved = List.of(List.of("O", "X"), List.of(" ", " "));
                            List<List<String>> result = bridgeGame.move(bridge, command);
                            assertThat(result).isEqualTo(moved);
                        }
                ),
                DynamicTest.dynamicTest("모두 일치하는 move 를 테스트한다.", () -> {
                            List<String> bridge = List.of("U", "D", "U");
                            List<String> command = List.of("U", "D", "U");
                            List<List<String>> moved = List.of(List.of("O", " ", "O"), List.of(" ", "O", " "));
                            List<List<String>> result = bridgeGame.move(bridge, command);
                            assertThat(result).isEqualTo(moved);
                        }
                )
        );
    }

    @TestFactory
    @DisplayName("retry Test")
    Stream<DynamicTest> retryTest() {
        validatorProcessor = new TestValidatorProcessor();
        bridgeGame = new BridgeGame(validatorProcessor);

        return Stream.of(
                DynamicTest.dynamicTest("retry 를 테스트한다.", () -> {
                            String command = "R";
                            Boolean result = bridgeGame.retry(command);
                            assertThat(result).isEqualTo(true);
                        }
                ),
                DynamicTest.dynamicTest("retry 를 테스트한다.", () -> {
                            String command = "Q";
                            Boolean result = bridgeGame.retry(command);
                            assertThat(result).isEqualTo(false);
                        }
                )
        );
    }


    private class TestValidatorProcessor implements ValidatorProcessor {
        @Override
        public Integer validateBridgeSizeInput(String input) {
            return null;
        }

        @Override
        public void validateRetryInput(String input) {

        }

        @Override
        public void validateCommandInput(String input) {

        }
    }
}
