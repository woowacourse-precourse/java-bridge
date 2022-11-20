package bridge;

import bridge.domain.bridgegame.GameMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameMapTest {
    @DisplayName("게임 맵 생성")
    @Test
    void generateMapString() {
        GameMap gameMap = GameMap.generateMap(List.of(" ", "O"), List.of("O", " "));
        assertThat(gameMap.toString()).contains("[   | O ]", "[ O |   ]");
    }

    @DisplayName("사용자의 이동 결과에 따라 게임 맵 추가")
    @Test
    void addMapElement() {
        GameMap gameMap = GameMap.generateMap(new ArrayList<>(), new ArrayList<>());
        gameMap.addGameResult("U", true);
        gameMap.addGameResult("D", false);
        assertThat(gameMap.toString()).contains("[ O |   ]", "[   | X ]");
    }
}
