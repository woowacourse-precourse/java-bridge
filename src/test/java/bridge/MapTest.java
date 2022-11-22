package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import controller.Controller;
import enumCollections.Side;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MapTest extends NsTest {
    private static final List<String> upperSide = List.of("O", "O", " ");
    private static final List<String> bellowSide = List.of(" ", " ", "X");

    @DisplayName("맵 생성 테스트")
    @Test
    void 윗칸_이동_성공_테스트() {
        Map map = new Map();
        map.add(Side.UP, true);
        map.add(Side.UP, true);
        map.add(Side.DOWN, false);

        assertThat(map.get().toString())
                .contains(upperSide);
    }

    @DisplayName("맵 생성 테스트")
    @Test
    void 맵_생성_테스트() {
        Map map = new Map();
        map.add(Side.DOWN, true);
        map.add(Side.UP, true);
        map.add(Side.DOWN, false);

        assertThat(map.get().toString())
                .contains("/");
    }

    @DisplayName("맵 생성 테스트")
    @Test
    void 맵_생성_테스트2() {
        Map map = new Map();
        map.add(Side.UP, true);
        map.add(Side.DOWN, true);
        map.add(Side.DOWN, true);

        assertThat(map.get().toString())
                .contains("/");
    }

    @DisplayName("맵 생성 테스트")
    @Test
    void 맵_생성_테스트3() {
        Map map = new Map();
        map.add(Side.UP, true);
        map.add(Side.DOWN, true);
        map.add(Side.UP, true);

        assertThat(map.get().toString())
                .contains("/");
    }

    @DisplayName("맵 반환 테스트")
    @Test
    void 맵_반환_테스트() {
        Map map = new Map();
        map.add(Side.UP, true);
        map.add(Side.DOWN, true);
        map.add(Side.UP, true);

        map.get().stream()
                .forEach(line -> {
                    System.out.print("[ ");
                    System.out.print(String.join(" | ", line));
                    System.out.print(" ]\n");
                });
    }

    @Test
    void 아래칸_이동_실패_테스트() {
        runMain();
        assertThat(output()).contains("?");
    }

    @Test
    void 윗칸_이동_실패_테스트() {
        Map map = new Map();
        map.add(Side.UP, true);
        map.add(Side.UP, true);
        map.add(Side.UP, true);
        map.add(Side.DOWN, false);
//        new OutputView().printMap(map.get());
        assertThat(map.get().toString()).contains("?");
    }

    @Test
    void 윗칸_이동_실패_테스트_2() {
        Map map = new Map();
        map.add(Side.DOWN, true);
        map.add(Side.DOWN, true);
        map.add(Side.UP, true);
        map.add(Side.DOWN, false);
//        new OutputView().printMap(map.get());
    }

    @Override
    protected void runMain() {
        Controller controller = new Controller(new OutputView(), new InputView());
        controller.startGame(new BridgeGame());
    }

    static Stream<Arguments> generateWrongBridgeValue() {
        return Stream.of(
                Arguments.of(List.of("O", "O", " ")),
                Arguments.of(List.of(" ", " ", "X"))
        );
    }

}