package bridge;

import bridge.domain.bridgegame.GameMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static bridge.BridgeMaker.LOWER_BRIDGE;
import static bridge.BridgeMaker.UPPER_BRIDGE;

public class GameMapTest {
    private GameMap gameMap;
    @BeforeEach
    void setUp() {
        HashMap<String, List<String>> initMap = new HashMap<>();
        initMap.put(UPPER_BRIDGE, new ArrayList<>());
        initMap.put(LOWER_BRIDGE, new ArrayList<>());

        gameMap = GameMap.from(initMap);
    }

    @DisplayName("사용자의 이동 결과에 따라 게임 맵 추가")
    @Test
    void addMapElement() {
        gameMap.addGameResult(UPPER_BRIDGE, true);
        gameMap.addGameResult(LOWER_BRIDGE, false);
        assertThat(gameMap.toString()).contains("[ O |   ]", "[   | X ]");
    }
}
