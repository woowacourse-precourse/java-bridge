package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    private BridgeGame bridgeGame;
    private List<List<String>> results;
    private List<List<String>> expected;

    @BeforeEach
    public void setup() {
        List<String> answer = List.of("U", "U", "D");
        bridgeGame = new BridgeGame(answer);
        Result result = bridgeGame.getResult();

        results = result.getResults();
        expected = new ArrayList<>();

        expected.add(new ArrayList<>());
        expected.add(new ArrayList<>());
    }

    @DisplayName("사용자가 선택한 칸 이동")
    @ParameterizedTest(name = "{displayName} => {0}, {1}, {2}")
    @CsvSource({"U,O,' '", "D,' ',X"})
    public void move(String place, String upSide, String downSide) {
        expected.get(0).add(upSide);
        expected.get(1).add(downSide);

        bridgeGame.move(place);

        assertThat(results).isEqualTo(expected);
    }

    @DisplayName("재시도한 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @CsvSource({"U", "D"})
    public void retry(String place) {
        int tryCount = 2;
        bridgeGame.move(place);
        bridgeGame.retry();

        assertThat(results).isEqualTo(expected);
        assertThat(bridgeGame.getCount()).isEqualTo(tryCount);
    }
}