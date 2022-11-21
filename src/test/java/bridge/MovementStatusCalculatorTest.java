package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MovementStatusCalculatorTest {

    private static MovementStatusCalculator movementStatusCalculator;

    @BeforeAll
    public static void init() {
        movementStatusCalculator = new MovementStatusCalculator();
    }

    @DisplayName("다리 정보와 사용자 입력을 누적 비교하여 요약 정보를 생성")
    @ParameterizedTest
    @MethodSource("parameterProviderForMovementStatusResult")
    public void createMovementStatusResult(String movement_command, Deque<MovementStatusForm> expect) {
        BridgeMaker bridgeMaker = new BridgeMaker(
                new BridgeRawNumberGenerator(List.of(0, 1, 1, 0))
        );
        List<String> bridge = bridgeMaker.makeBridge(4);

        assertThat(
                movementStatusCalculator.saveMovementStatus(movement_command, bridge)
        ).isEqualTo(expect);
    }

    private static Stream<Arguments> parameterProviderForMovementStatusResult() {
        return Stream.of(Arguments.arguments("D", new LinkedList<>(List.of(MovementStatusForm.DOWN_O)))
                ,Arguments.arguments("U", new LinkedList<>(List.of(MovementStatusForm.DOWN_O, MovementStatusForm.UP_O)))
                ,Arguments.arguments("D"
                        , new LinkedList<>(List.of(MovementStatusForm.DOWN_O
                                , MovementStatusForm.UP_O
                                , MovementStatusForm.DOWM_X)))
                ,Arguments.arguments("U", new LinkedList<>(List.of(MovementStatusForm.DOWN_O
                        , MovementStatusForm.UP_O
                        , MovementStatusForm.DOWM_X
                        , MovementStatusForm.UP_X)))
        );
    }
}