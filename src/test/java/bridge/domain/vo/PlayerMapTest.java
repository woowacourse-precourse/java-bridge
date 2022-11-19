package bridge.domain.vo;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerMapTest {


    @ParameterizedTest(name = "[{index}] input {0} {1}")
    @CsvSource(value = {"U, true, O,' '", "D, true,' ',O", "U, false,X,' '", "D, false,' ',X"})
    void Normal_Test(String place, boolean value, String firstResult, String secondResult) {
        PlayerMap playerMap = new PlayerMap();
        playerMap.addResult(place, value);
        List<List> estimatedResult = List.of(List.of(firstResult), List.of(secondResult));
        Assertions.assertThat(playerMap.getPlayerMap()).isEqualTo(estimatedResult);
    }

    @ParameterizedTest(name = "[{index}] input {0} {1}")
    @CsvSource(value = {"U, false", "D, false"})
    void checkContainsX_Test(String place, boolean value) {
        PlayerMap playerMap = new PlayerMap();
        playerMap.addResult(place, value);

        Assertions.assertThat(playerMap.checkContainsX()).isEqualTo(true);
    }
}