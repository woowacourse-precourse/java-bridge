package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.code.GameStatus;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    @Test
    @DisplayName("잘못된 move 입력시 false return")
    void moveFailTest(){
        BridgeGame game=new BridgeGame(3,new TestGenerator(createTestList()));
        assertThat(game.move("D")).isFalse();
    }

    @Test
    @DisplayName("올바른 move 입력시 true return")
    void moveSuccessTest(){
        BridgeGame game=new BridgeGame(3,new TestGenerator(createTestList()));
        assertThat(game.move("U")).isTrue();
    }

    @Test
    @DisplayName("재실행 후 게임상태 확인")
    void retryTest(){
        BridgeGame game=new BridgeGame(3,new TestGenerator(createTestList()));
        assertThat(game.retry("R")).isEqualTo(2);
        assertThat(game.getGameStatus()).isEqualTo(GameStatus.PLAY);
    }

    @Test
    @DisplayName("게임 종료 후 게임 상태 확인")
    void quitTest(){
        BridgeGame game=new BridgeGame(3,new TestGenerator(createTestList()));
        assertThat(game.retry("Q")).isEqualTo(1);
        assertThat(game.getGameStatus()).isEqualTo(GameStatus.FAIL);
    }
    List<Integer> createTestList(){
        List<Integer> test=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            test.add(1);
        }
        return test;
    }

    static class TestGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            int num=numbers.get(0);
            numbers.remove(0);
            return num;
        }
    }
}
