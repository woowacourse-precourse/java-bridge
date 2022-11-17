package bridge;

import static bridge.constant.BridgeMatch.CAN_MOVE;
import static bridge.constant.BridgeMatch.CAN_NOT_MOVE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RefereeTest {

    @ParameterizedTest
    @ValueSource(ints = {0})
    void compareByU(int count) {
        // given
        List<String> bridge = List.of("U", "D", "D");
        String player = "U";
        Referee referee = new Referee();

        // when
        String result = referee.compare(bridge, player, count);

        // then
        assertThat(result).isEqualTo(CAN_MOVE.getSymbol());
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    void compareByD(int count) {
        // given
        List<String> bridge = List.of("U", "D", "D");
        String player = "D";
        Referee referee = new Referee();

        // when
        String result = referee.compare(bridge, player, count);

        // then
        assertThat(result).isEqualTo(CAN_MOVE.getSymbol());
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void compareByNotMatch(int count) {
        // given
        List<String> bridge = List.of("U", "D", "D");
        String player = "D";
        Referee referee = new Referee();

        // when
        String result = referee.compare(bridge, player, count);

        // then
        assertThat(result).isEqualTo(CAN_NOT_MOVE.getSymbol());
    }
}