package bridge;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BridgeTest {

    @Test
    void 이동함수() {
        BridgeGame bridgeGame = new BridgeGame();
        List bridge = new ArrayList<>();
        bridge.add("U");
        bridge.add("D");
        bridge.add("U");

        Assertions.assertThat(bridgeGame.move(bridge, "U")).isEqualTo(true);
        Assertions.assertThat(bridgeGame.move(bridge, "D")).isEqualTo(false);
    }

    @Test
    void 게임_재시도() {
        BridgeGame bridgeGame = new BridgeGame();

        Assertions.assertThat(bridgeGame.retry("R")).isEqualTo(true);
        Assertions.assertThat(bridgeGame.getTryCount()).isEqualTo(2);
        Assertions.assertThat(bridgeGame.retry("R")).isEqualTo(true);
        Assertions.assertThat(bridgeGame.retry("Q")).isEqualTo(false);
        Assertions.assertThat(bridgeGame.getTryCount()).isEqualTo(3);

    }

    @Test
    void 다음_칸으로_넘어갈_수_있는지() {
        BridgeGame bridgeGame = new BridgeGame();
        List bridge = new ArrayList<>();
        bridge.add("U");
        bridge.add("D");
        bridge.add("U");

        Assertions.assertThat(bridgeGame.move(bridge, "U")).isEqualTo(true);
        bridgeGame.nextStep();
        Assertions.assertThat(bridgeGame.getBridgeIdx()).isEqualTo(1);
    }

    @Test
    void 다리_끝에_도달할_경우_중단(){
        BridgeGame bridgeGame = new BridgeGame();
        boolean result = bridgeGame.reachTheGoal(new ArrayList<>(3), false);
        bridgeGame.setBridgeIdx(3);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    void 다리길이입력_예외처리() {
        Assertions.assertThatThrownBy(() -> Exceptions.isNum("3a")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Exceptions.isNum("aa")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동방향입력_예외처리() {
        Assertions.assertThatThrownBy(() -> Exceptions.isUOrD("u")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Exceptions.isUOrD("1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시도입력_에외처리() {
        Assertions.assertThatThrownBy(() -> Exceptions.isROrQ("r")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Exceptions.isROrQ("a")).isInstanceOf(IllegalArgumentException.class);
    }

}
