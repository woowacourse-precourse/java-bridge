package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import enumCollections.GameStatus;
import enumCollections.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MapTest extends NsTest {
    @DisplayName("맵 생성 테스트")
    @Test
    void 윗칸_이동_성공_테스트() {
        Map map = new Map();
        map.add(Position.UP, GameStatus.CONTINUE);
        map.add(Position.UP, GameStatus.SUCCESS);
        map.add(Position.UP, GameStatus.FAILURE);

        assertThat(map.get().toString()).contains(">");
    }

    @Test
    void 아래칸_이동_실패_테스트() {
        runMain();
        assertThat(output()).contains("?");
    }

    @Test
    void 윗칸_이동_실패_테스트() {
        Map map = new Map();
        map.add(Position.UP, GameStatus.CONTINUE);
        map.add(Position.UP, GameStatus.CONTINUE);
        map.add(Position.UP, GameStatus.CONTINUE);
        map.add(Position.DOWN, GameStatus.FAILURE);
        new OutputView().printMap(map);
        assertThat(map.get().toString()).contains("?");
    }

    @Test
    void 윗칸_이동_실패_테스트_2() {
        Map map = new Map();
        map.add(Position.DOWN, GameStatus.CONTINUE);
        map.add(Position.DOWN, GameStatus.CONTINUE);
        map.add(Position.UP, GameStatus.CONTINUE);
        map.add(Position.DOWN, GameStatus.FAILURE);
        new OutputView().printMap(map);
    }

    @Override
    protected void runMain() {
        Controller controller = new Controller(new OutputView(), new InputView());
        controller.startGame(new BridgeGame());
    }

}