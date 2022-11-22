package bridge.domainTest.constantTest;
import bridge.domain.constant.CrossedState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


import static org.assertj.core.api.Assertions.assertThat;

public class CrossedStateTest {
    @ParameterizedTest
    @MethodSource("provideStringsForFindByCrossedStateInstance")
    @DisplayName("다리 건넌 상태에 따른 객체를 반환하는지 확인한다.")
    public void findCrossingStateInstanceByCrossingState(boolean crossedState, CrossedState instance){
        assertThat(CrossedState.findByCrossingResult(crossedState)).isEqualTo(instance);
    }
    private static Stream<Arguments> provideStringsForFindByCrossedStateInstance() {
        return Stream.of(
                Arguments.of(true, CrossedState.POSSIBLE),
                Arguments.of(false, CrossedState.IMPOSSIBLE)
        );
    }
    @ParameterizedTest
    @DisplayName("다리 건넌 상태에 따른 기호를 반환하는지 확인한다.")
    @CsvSource(value = {"true:  O ", "false:  X "}, delimiter = ':')
    public void findByCrossingState(boolean crossedState, String transformResult){
        assertThat(CrossedState.transform(crossedState)).isEqualTo(transformResult);
    }
}
