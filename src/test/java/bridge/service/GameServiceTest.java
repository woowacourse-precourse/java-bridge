package bridge.service;

import bridge.service.itf.GameService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest extends NsTest {
    GameService gameService;

    @BeforeEach
    void beforeEach() {
        gameService = new GameServiceImpl();
    }

    @DisplayName("재시작/종료 여부 묻기")
    @Nested
    class askOptionTest {

        @DisplayName("사용자가 Q(종료)를 입력한 경우")
        @Test
        void askOptionTest_quit() {
            assertSimpleTest(() -> {
                run("Q");
                assertThat(gameService.askOption()).isEqualTo(false);
            });
        }

        @DisplayName("사용자가 R(재시작)을 입력한 경우")
        @Test
        void askOptionTest_retry() {
            assertSimpleTest(() -> {
                run("R");
                assertThat(gameService.askOption()).isEqualTo(true);
            });
        }

    }



    @Override
    protected void runMain() {

    }
}
