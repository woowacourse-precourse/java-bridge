package bridge;

import bridge.enummodel.CommandEnum;
import bridge.processor.ValidatorProcessor;
import bridge.processor.ValidatorProcessorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorProcessorTest {

    private ValidatorProcessor validatorProcessor;


    @TestFactory
    @DisplayName("validateBridgeSizeInput Success Test")
    Stream<DynamicTest> validateBridgeSizeInputSuccess() {
        List<String> valueSource = List.of("3", "4", "5", "6", "7", "8");
        validatorProcessor = new ValidatorProcessorImpl();
        return valueSource.stream()
                .map(number -> DynamicTest.dynamicTest("성공케이스: 올바른 입력값", () -> {
                            Integer result = validatorProcessor.validateBridgeSizeInput(number);
                            assertThat(result).isEqualTo(Integer.valueOf(number));
                        })
                );
    }

    @TestFactory
    @DisplayName("validateBridgeSizeInput Fail Test")
    Stream<DynamicTest> validateBridgeSizeInputFail() {
        List<String> valueSource = List.of("1", "2", "21", "22");
        validatorProcessor = new ValidatorProcessorImpl();
        return valueSource.stream()
                .map(UnNumber -> DynamicTest.dynamicTest("실패케이스: 올바르지 못한 입력값", () -> {
                                    assertThatThrownBy(()-> validatorProcessor.validateBridgeSizeInput(UnNumber))
                                            .isInstanceOf(IllegalArgumentException.class)
                                            .hasMessageContaining("[ERROR]");
                                }
                        )
                );
    }

    @TestFactory
    @DisplayName("validateRetryInput Success Test")
    Stream<DynamicTest> validateRetryInputSuccess() {
        List<String> valueSource = List.of(CommandEnum.RESTART.getValue(), CommandEnum.QUIT.getValue());
        validatorProcessor = new ValidatorProcessorImpl();
        return valueSource.stream()
                .map(retryCommand -> DynamicTest.dynamicTest("성공케이스: 올바른 입력값", () -> {
                    validatorProcessor.validateRetryInput(retryCommand);
                        })
                );
    }

    @TestFactory
    @DisplayName("validateRetryInput Fail Test")
    Stream<DynamicTest> validateRetryInputFail() {
        List<String> valueSource = List.of("K", "J", "U", "D");
        validatorProcessor = new ValidatorProcessorImpl();
        return valueSource.stream()
                .map(NotRetryCommand -> DynamicTest.dynamicTest("실패케이스: 올바르지 못한 입력값", () -> {
                                    assertThatThrownBy(()-> validatorProcessor.validateRetryInput(NotRetryCommand))
                                            .isInstanceOf(IllegalArgumentException.class)
                                            .hasMessageContaining("[ERROR]");
                                }
                        )
                );
    }

    @TestFactory
    @DisplayName("validateCommandInput Success Test")
    Stream<DynamicTest> validateCommandInputSuccess() {
        List<String> valueSource = List.of(CommandEnum.UP.getValue(), CommandEnum.DOWN.getValue());
        validatorProcessor = new ValidatorProcessorImpl();
        return valueSource.stream()
                .map(moveCommand -> DynamicTest.dynamicTest("성공케이스: 올바른 입력값", () -> {
                            validatorProcessor.validateCommandInput(moveCommand);
                        })
                );
    }

    @TestFactory
    @DisplayName("validateCommandInput Fail Test")
    Stream<DynamicTest> validateCommandInputFail() {
        List<String> valueSource = List.of("K", "J", "Q", "R");
        validatorProcessor = new ValidatorProcessorImpl();
        return valueSource.stream()
                .map(NotMoveCommand -> DynamicTest.dynamicTest("실패케이스: 올바르지 못한 입력값", () -> {
                                    assertThatThrownBy(()-> validatorProcessor.validateCommandInput(NotMoveCommand))
                                            .isInstanceOf(IllegalArgumentException.class)
                                            .hasMessageContaining("[ERROR]");
                                }
                        )
                );
    }
}
