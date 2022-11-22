package bridge.view;

import bridge.model.Tile;
import bridge.model.PlayerStatus;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    OutputView outputView;
    OutputStream out;

    @BeforeEach
    void beforeEach() {
        outputView = new OutputView();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("현재까지 움직인 경로 출력하는 테스트")
    @ParameterizedTest
    @MethodSource("expectedOutput")
    void printMapTest(boolean isSuccess, List<Tile> path, String expectedOutput) {
        outputView.printMap(isSuccess, path);
        assertThat(out.toString().trim())
                .isEqualTo(expectedOutput);
    }

    static Stream<Arguments> expectedOutput() {
        boolean success = true;
        List<Tile> path1 = List.of(Tile.UP_TILE, Tile.DOWN_TILE, Tile.UP_TILE);
        String expected1 = "[ O |   | O ]\n[   | O |   ]";
        boolean fail = false;
        List<Tile> path2 = List.of(Tile.UP_TILE, Tile.DOWN_TILE, Tile.UP_TILE);
        String expected2 = "[ O |   | X ]\n[   | O |   ]";
        return Stream.of(
                Arguments.of(success, path1, expected1),
                Arguments.of(fail, path2, expected2));
    }

    @DisplayName("게임 성공 결과 테스트")
    @Test
    void printResultSuccessTest() {
        List<Tile> path = List.of(Tile.UP_TILE, Tile.DOWN_TILE, Tile.UP_TILE);
        outputView.printResult(PlayerStatus.COMPLETE_CROSSING_BRIDGE, 5, path);

        String expectedOutput
                = "최종 게임 결과\n[ O |   | O ]\n[   | O |   ]\n\n게임 성공 여부: 성공\n총 시도한 횟수: 5";

        assertThat(out.toString().trim())
                .isEqualTo(expectedOutput);
    }

    @DisplayName("게임 실패 결과 테스트")
    @Test
    void printResultFailTest() {
        List<Tile> path = List.of(Tile.UP_TILE, Tile.DOWN_TILE, Tile.UP_TILE);
        outputView.printResult(PlayerStatus.FALL_BRIDGE, 5, path);

        String expectedOutput
                = "최종 게임 결과\n[ O |   | X ]\n[   | O |   ]\n\n게임 성공 여부: 실패\n총 시도한 횟수: 5";

        assertThat(out.toString().trim())
                .isEqualTo(expectedOutput);
    }
}
