package bridge.output;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.constant.Direction;
import bridge.domain.Result;
import bridge.util.OutputConverter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OutputConverterTest {

    private static List<Direction> toDirectionList(List<String> direction) {
        return direction.stream()
                .map(Direction::from)
                .collect(Collectors.toUnmodifiableList());
    }

    private static Stream<Arguments> providePlayerDirectionsAndAnswer() {
        return Stream.of(
                Arguments.of(
                        List.of("U", "U", "U", "D", "D", "D"),
                        List.of("   OOO", "OOO   ")
                ),
                Arguments.of(
                        List.of("D", "D", "D", "U", "U", "U"),
                        List.of("XXX   ", "   XXX")
                ),
                Arguments.of(
                        List.of("U", "U", "D", "U", "D", "D"),
                        List.of("  X OO", "OO X  ")
                )
        );
    }

    @ParameterizedTest
    @DisplayName("출력을 위한 변환이 정상적으로 실행되었는지 확인한다.")
    @MethodSource("providePlayerDirectionsAndAnswer")
    public void resultToStrings(List<String> playerDirections, List<String> answer) throws Exception {
        //given
        Result result = new Result();
        List<String> bridgeDirection = List.of("U", "U", "U", "D", "D", "D");
        Bridge bridge = new Bridge(bridgeDirection);
        int UPSIDE_VALUE = Direction.UPSIDE.ordinal();
        int DOWNSIDE_VALUE = Direction.DOWNSIDE.ordinal();

        //when
        for (Direction playerDirection : toDirectionList(playerDirections)) {
            result.update(bridge, playerDirection);
        }
        List<String> convertedResult = OutputConverter.resultToStrings(result.getMoveStatuses());

        //then
        assertThat(convertedResult.get(UPSIDE_VALUE)).isEqualTo(answer.get(UPSIDE_VALUE));
        assertThat(convertedResult.get(DOWNSIDE_VALUE)).isEqualTo(answer.get(DOWNSIDE_VALUE));
    }
}
