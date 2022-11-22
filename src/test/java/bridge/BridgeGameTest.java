package bridge;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridgeGame = new BridgeGame(List.of("U", "D", "D", "D", "U"));
    }

    @DisplayName("한칸 이동 성공 테스트")
    @Test
    void 한칸이동_성공_테스트() {
        assertEquals(List.of("O","[ O ]","[   ]"),bridgeGame.move("U"));
        assertEquals(List.of("O","[ O |   ]","[   | O ]"),bridgeGame.move("D"));
        assertEquals(List.of("O","[ O |   |   ]","[   | O | O ]"),bridgeGame.move("D"));
        assertEquals(List.of("O","[ O |   |   |   ]","[   | O | O | O ]"),bridgeGame.move("D"));
        assertEquals(List.of("O","[ O |   |   |   | O ]","[   | O | O | O |   ]"),bridgeGame.move("U"));
    }

    @DisplayName("한칸 이동 실패 테스트")
    @ParameterizedTest()
    @MethodSource("generateData")
    void 한칸이동_실패_테스트(List<String> param) {
        assertEquals(param.subList(1,4),bridgeGame.move(param.get(0)));
    }

    static Stream<List<String>> generateData() {
        return Stream.of(
            List.of("D","X", "[   ]","[ X ]"),
            List.of("D","X", "[   ]","[ X ]")
        );
    }

    @DisplayName("한칸 이동 성공_실패 테스트")
    @Test
    void 한칸이동_성공_실패_테스트() {
        assertEquals(List.of("O","[ O ]","[   ]"),bridgeGame.move("U"));
        assertEquals(List.of("O","[ O |   ]","[   | O ]"),bridgeGame.move("D"));
        assertEquals(List.of("O","[ O |   |   ]","[   | O | O ]"),bridgeGame.move("D"));
        assertEquals(List.of("O","[ O |   |   |   ]","[   | O | O | O ]"),bridgeGame.move("D"));
        assertEquals(List.of("X","[ O |   |   |   |   ]","[   | O | O | O | X ]"),bridgeGame.move("D"));
    }
}