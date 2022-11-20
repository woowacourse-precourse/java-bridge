package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Nested
    class MoveTest extends NsTest {
        @DisplayName("이동 명령어로 소문자 u를 입력했을 때 예외 발생")
        @Test
        void testLowerU() {
            assertThatThrownBy(() -> run("u"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("이동 명령어로 소문자 d를 입력했을 때 예외 발생")
        @Test
        void testLowerD() {
            assertThatThrownBy(() -> run("d"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Override
        protected void runMain() {
            Player player = new Player();
            String direction = readLine();
            player.move(direction);
        }
    }

    @Nested
    class CompareTest {
        @DisplayName("3번 정답 1번 오답인 경우")
        @Test
        void right3Wrong1() {
            Player player = new Player();
            List<String> inputDirections = new ArrayList<>(List.of("U", "D", "U", "D"));
            List<String> bridge = new ArrayList<>(List.of("U", "D", "U", "U"));
            List<Boolean> compareResult = new ArrayList<>();
            for (String direction : inputDirections) {
                player.move(direction);
                compareResult.add(player.compareWith(bridge));
            }
            List<Boolean> answers = new ArrayList<>(List.of(true, true, true, false));
            assertThat(compareResult).isEqualTo(answers);
        }

        @DisplayName("4번 입력 모두 정답인 경우")
        @Test
        void right4() {
            Player player = new Player();
            List<String> inputDirections = new ArrayList<>(List.of("U", "D", "U", "U"));
            List<String> bridge = new ArrayList<>(List.of("U", "D", "U", "U"));
            List<Boolean> compareResult = new ArrayList<>();
            for (String direction : inputDirections) {
                player.move(direction);
                compareResult.add(player.compareWith(bridge));
            }
            List<Boolean> answers = new ArrayList<>(List.of(true, true, true, true));
            assertThat(compareResult).isEqualTo(answers);
        }
    }
}