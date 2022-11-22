package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame(new InputView());

    @Test
    @ValueSource(ints = {0,1,2,3})
    @ParameterizedTest
    void isCorrectStep_동작_true_테스트(int input){
        assertThat(bridgeGame.isCorrectStep(getTrueInput(input), List.of("U","D","U","D")))
                .isEqualTo(true);
    }
    List<String> getTrueInput(int i){
        List<List<String>> inputs = new ArrayList<>(
                List.of(
                        List.of("U")
                        , List.of("U","D")
                        , List.of("U","D","U")
                        , List.of("U","D","U","D")
                )
        );
        return inputs.get(i);
    }

    @Test
    @ValueSource(ints = {0,1,2,3})
    @ParameterizedTest
    void isCorrectStep_동작_false_테스트(int input){
        assertThat(bridgeGame.isCorrectStep(getFalseInput(input), List.of("U","D","U","D")))
                .isEqualTo(false);
    }
    List<String> getFalseInput(int i){
        List<List<String>> inputs = new ArrayList<>(
                List.of(
                        List.of("D")
                        , List.of("U","U")
                        , List.of("U","D","D")
                        , List.of("U","D","U","U")
                )
        );
        return inputs.get(i);
    }
}
