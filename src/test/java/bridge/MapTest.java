package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import enumCollections.GameStatus;
import enumCollections.Side;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MapTest extends NsTest {
    @DisplayName("맵 생성 테스트")
    @Test
    void 윗칸_이동_성공_테스트() {
        Map map = new Map();
        map.add(Side.UP, GameStatus.CONTINUE);
        map.add(Side.UP, GameStatus.SUCCESS);
        map.add(Side.UP, GameStatus.FAILURE);

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
        map.add(Side.UP, GameStatus.CONTINUE);
        map.add(Side.UP, GameStatus.CONTINUE);
        map.add(Side.UP, GameStatus.CONTINUE);
        map.add(Side.DOWN, GameStatus.FAILURE);
        new OutputView().printMap(map);
        assertThat(map.get().toString()).contains("?");
    }

    @Test
    void 윗칸_이동_실패_테스트_2() {
        Map map = new Map();
        map.add(Side.DOWN, GameStatus.CONTINUE);
        map.add(Side.DOWN, GameStatus.CONTINUE);
        map.add(Side.UP, GameStatus.CONTINUE);
        map.add(Side.DOWN, GameStatus.FAILURE);
        new OutputView().printMap(map);
    }

    @Override
    protected void runMain() {
        Controller controller = new Controller(new OutputView(), new InputView());
        controller.startGame(new BridgeGame());
    }

}