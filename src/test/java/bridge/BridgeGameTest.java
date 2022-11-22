package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeGame;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    @Test
    @DisplayName("잘못된 move 입력시 false return")
    void moveFailTest(){
        BridgeGame game=new BridgeGame(3,new TestNumberGenerator(createTestList()));
        assertThat(game.move("D")).isFalse();
    }

    @Test
    @DisplayName("올바른 move 입력시 true return")
    void moveSuccessTest(){
        BridgeGame game=new BridgeGame(3,new TestNumberGenerator(createTestList()));
        assertThat(game.move("U")).isTrue();
    }

    List<Integer> createTestList(){
        List<Integer> test=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            test.add(1);
        }
        return test;
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
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
