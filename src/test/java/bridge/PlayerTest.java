package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.Player;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PlayerMoveTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR] 이동할 칸은 U나 D여야 합니다.";

    @DisplayName("U와 D를 입력하지 않을 때 error 발생")
    @Test
    void moveByInValidCommand() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("DD"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("U "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        List<String> bridge = List.of("U", "D", "U", "D");
        Player player = new Player(bridge);
        player.move();
    }
}

class PlayerRetryTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR] 재시도: R, 종료: Q 외에 다른 값을 입력했습니다.";

    @DisplayName("R과 Q를 입력하지 않을 때 error 발생")
    @Test
    void moveByInValidCommand() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Q "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" R"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        List<String> bridge = List.of("D", "D", "U", "D");
        Player player = new Player(bridge);
        player.retry();
    }
}
