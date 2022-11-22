package bridge.controller;

import static bridge.util.lib.setInput;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeNumberGenerator;
import bridge.data.Command;
import bridge.data.Glass;
import bridge.data.State;
import bridge.view.BridgeView;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeControllerTest {

    BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));

    BridgeController brdCtrl = new BridgeController(numberGenerator);

    @Test
    void 옳은_사이즈_값을_받을_수_있는지() {
        String correct = "20";
        setInput(correct);

        assertThat(brdCtrl.getSize()).isEqualTo(Integer.parseInt(correct));
    }

    @Test
    void 옳은_커멘드를_받을_수_있는지() {

        setInput(Command.QUIT.KEY());

        assertThat(brdCtrl.getCommand()).isEqualTo(Command.QUIT.KEY());

    }


    @Test
    void 이동하고_올바르게_STATE_여부를_판정하는지() {
        setInput("3");
        brdCtrl.initGame(); // TestNumberGenerator를 사용해 bridge는 UDD인 상태
        setInput(Glass.UP.MOVE());
        assertThat(brdCtrl.getMove()).isEqualTo(State.SAFE);
        setInput(Glass.UP.MOVE());
        assertThat(brdCtrl.getMove()).isEqualTo(State.FAIL);
    }


    @Test
    void 올바르게_종료하는지() {
        이동하고_올바르게_STATE_여부를_판정하는지(); // 안정적인 종료를 위해 위 테스트로 맵을 이동한 기록을 남김
        setInput(Command.QUIT.KEY());
        assertThat(brdCtrl.dead(State.FAIL)).isEqualTo(false);
    }


    public static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        public TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}