package bridge;

import static bridge.Utils.Constant.MatchResult.CORRECT;
import static bridge.Utils.Constant.MatchResult.INCORRECT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.Domain.BridgeMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMapTest {

    BridgeMap bridgeMap;

    @BeforeEach
    void before() {
        bridgeMap = new BridgeMap();
    }

    @AfterEach
    void after() {
        bridgeMap.clear();
    }

    @DisplayName("한 개의 일치한 결과를 넣었을 때 제대로 출력되는지 확인한다.")
    @Test
    void addMapTestByCorrectMoving() {
        bridgeMap.add("U", CORRECT.toString());
        assertThat(bridgeMap.toString())
                .contains(
                        "[ O ]",
                        "[   ]"
                );
    }

    @DisplayName("한 개의 불일치한 결과를 넣었을 때 제대로 출력되는지 확인한다.")
    @Test
    void addMapTestByIncorrectMoving() {
        bridgeMap.add("D", INCORRECT.toString());
        assertThat(bridgeMap.toString())
                .contains(
                        "[   ]",
                        "[ X ]"
                );
    }

    @DisplayName("한 개의 일치한 결과와 한 개의 불일치한 결과를 넣었을 때 제대로 출력되는지 확인한다.")
    @Test
    void addMapTestByOneCorrectAndOneIncorrect() {
        bridgeMap.add("U", CORRECT.toString());
        bridgeMap.add("D", INCORRECT.toString());
        assertThat(bridgeMap.toString())
                .contains(
                        "[ O |   ]",
                        "[   | X ]"
                );
    }

    @DisplayName("여러 개의 일치한 결과를 넣었을 때 제대로 출력되는지 확인한다.")
    @Test
    void addMapTestByManyCorrectMoving() {
        bridgeMap.add("U", CORRECT.toString());
        bridgeMap.add("D", CORRECT.toString());
        bridgeMap.add("D", CORRECT.toString());
        bridgeMap.add("U", CORRECT.toString());
        assertThat(bridgeMap.toString())
                .contains(
                        "[ O |   |   | O ]",
                        "[   | O | O |   ]"
                );
    }
}
