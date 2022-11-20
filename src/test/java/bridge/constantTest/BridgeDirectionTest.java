package bridge.constantTest;

import bridge.constant.BridgeDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeDirectionTest {

    @ParameterizedTest
    @DisplayName("숫자로 생성된 다리가 0과 1이 아닌 경우 NoSuchElementException 에러를 출력한다.")
    @ValueSource(ints = {2, 3, 10, -1})
    public void checkWrongBridgeState(int bridgeState){
        assertThatThrownBy(()-> BridgeDirection.findByNumberBridgeDirection(bridgeState)).isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @DisplayName("0과 1이 D와 U로 잘 변환되는지 확인한다.")
    @CsvSource(value = {"0: D", "1: U"},delimiter = ':')
    public void checkProperBridgeState(int bridgeStateNumber, String bridgeState){
        assertThat(BridgeDirection.transformToWordDirection(bridgeStateNumber)).isEqualTo(bridgeState);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForFindByWordBridgeDirection")
    @DisplayName("문자인 다리 상태를 이용하여 해당하는 BridgeDirection 객체를 반환하는지 확인한다.")
    void findByWordBridgeDirection_ShouldReturnMatchedBridgeDirection(String input, BridgeDirection expected) {
        assertEquals(expected, BridgeDirection.findByWordBridgeDirection(input));
    }

    private static Stream<Arguments> provideStringsForFindByWordBridgeDirection() {
        return Stream.of(
                Arguments.of("D", BridgeDirection.DOWN),
                Arguments.of("U", BridgeDirection.UP)
        );
    }

}
