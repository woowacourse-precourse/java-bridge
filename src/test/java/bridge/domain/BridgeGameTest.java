package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeGameTest {
    @Test
    void 올바른_이동_테스트() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        String[] inputs = {"U", "D", "D"};
        List<Boolean> result = new ArrayList<>();
        List<Boolean> testResult = List.of(true, true, true);
        for (String input : inputs) {
            Boolean move = bridgeGame.move(input);
            result.add(move);
        }
        assertThat(result).isEqualTo(testResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "u"})
    void 올바르지_않은_이동_예외_테스트(String input) {
        //given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        //then
        assertThatThrownBy(() -> bridgeGame.move(input)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "u"})
    void 올바르지_않은_커맨드_예외_테스트(String input) {
        //given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        //then
        assertThatThrownBy(() -> bridgeGame.retry(input)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {50, 51, 52})
    void 올바르지_않은_커맨드_예외_테스트(int tryNumbers) {
        //given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        //when
        for (int time = 1; time < tryNumbers; time++) {
            bridgeGame.retry("R");
        }
        //then
        int tryTimes = bridgeGame.getTryNumber();
        assertThat(tryTimes).isEqualTo(tryNumbers);
    }

}
