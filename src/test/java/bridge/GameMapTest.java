package bridge;

import bridge.domain.bridgegame.GameMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameMapTest {
    @DisplayName("게임 맵 생성")
    @Test
    void generateMapString() {
        GameMap gameMap = GameMap.generateMap(List.of(" ", "O"), List.of("O", " "));
        assertThat(gameMap.toString()).contains("[   | O ]", "[ O |   ]");
    }
}
