package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bridge.BridgeFactory;
import global.config.AppConfig;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {
    private BridgeFactory bridgeFactory;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        bridgeFactory = appConfig.bridgeFactory();
    }

    @Test
    void createBridge() {
        assertThat(new Bridge(List.of("U", "D,", "D"))).isEqualTo(new Bridge(List.of("U", "D,", "D")));
    }

    @DisplayName("가야하는 순서와, 유저 선택이 주어졌을 때 갈수있는 곳이 일치하면 true를 반환한다.")
    @ParameterizedTest(name = "bridge [U | D | D]  step : {0}, pick : {1}")
    @CsvSource({"U, U", "D, UD", "D, UDD"})
    void canGo(String userPick, String step) {
        assertTrue(new Bridge(List.of("U", "D", "D")).canGoOrNot(List.of(step.split("")), userPick));
    }

    @DisplayName("가야하는 순서와, 유저 선택이 주어졌을 때 갈수있는 곳이 일치하지 않으면 false를 반환한다.")
    @ParameterizedTest(name = "bridge [U | D | D]  step : {0}, pick : {1}")
    @CsvSource({"D, U", "U, UD", "U, UDD"})
    void canNotGo(String userPick, String step) {

        assertFalse(new Bridge(List.of("U", "D", "D")).canGoOrNot(List.of(step.split("")), userPick));
    }

    @DisplayName("다리를 건넜다면 true를 반환한다.")
    @ParameterizedTest(name = "bridge [U | D | D]  step : {0}, pick : {1}")
    @CsvSource({"4, UDDD", "10, UDUDUUDDUD", "20, UDUUUUDDDDDDDUUDUUDU"})
    void isCrossing(int finalStep, String bridge) {
        assertTrue(new Bridge(List.of(bridge.split(""))).isCrossing(finalStep));
    }

    @DisplayName("다리를 건너지 않았다면 false를 반환한다.")
    @ParameterizedTest(name = "bridge [U | D | D]  step : {0}, pick : {1}")
    @CsvSource({"3, UDDD", "5, UDUDUUDDUD", "4, UDUUUUDDDDDDDUUDUUDU"})
    void isNotCrossing(int finalStep, String bridge) {
        assertFalse(new Bridge(List.of(bridge.split(""))).isCrossing(finalStep));
    }
}