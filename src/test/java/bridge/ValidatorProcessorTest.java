package bridge;

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
        List<String> valueSource = List.of("1", "2", "3", "4", "5", "6");
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
        List<String> valueSource = List.of("ㅇ", "₩", "#", "ㅋ", "ㅠ", "/");
        validatorProcessor = new ValidatorProcessorImpl();
        return valueSource.stream()
                .map(UnNumber -> DynamicTest.dynamicTest("실패케이스: 올바르지 못한 입력값", () -> {
                                    assertThatThrownBy(()-> validatorProcessor.validateBridgeSizeInput(UnNumber))
                                            .isInstanceOf(IllegalArgumentException.class)
                                            .hasMessageContaining("잘못된 입력값 입니다.");
                                }
                        )
                );
    }
}
