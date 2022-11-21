package bridge;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.util.Lists.newArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.test.NsTest;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest extends NsTest{
    @DisplayName("입력된 이동값과 다리정보가 같다면 true를 리턴")
    @Test
    void 입력된_이동값과_다리정보의_값이_같음(){
        BridgeGame game = new BridgeGame(List.of("U","D","U"));
        assertThat(true).isEqualTo(game.move("U"));
        assertThat(true).isEqualTo(game.move("D"));
        assertThat(true).isEqualTo(game.move("U"));
    }
    @DisplayName("입력된 이동값과 다리정보가 다르면 false를 리턴")
    @Test
    void 입력된_이동값과_다리정보의_값이_다름(){
        BridgeGame game = new BridgeGame(List.of("U","D","U"));
        assertThat(false).isEqualTo(game.move("D"));
    }
    @DisplayName("다리 생성 테스트")
    @Test
    void 다리_생성(){
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(newArrayList(1,1,1,0));
        BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(4);
        assertThat(bridge).containsExactly("U","U","U","D");
    }
    @DisplayName("다리 건너기를 성공했다면, 시도 횟수와 true를 리턴")
    @Test
    void 다리건너기_성공(){
        BridgeGame game = new BridgeGame(List.of("U","D","U"));
        game.move("U");
        game.move("D");
        game.move("U");
        assertThat(true).isEqualTo(game.checkSuccess());
        assertThat(1).isEqualTo(game.getTryNumber());
    }
    @DisplayName("다리건너기 게임 2번 시도만에 성공")
    @Test
    void 두번_시도만에_성공(){
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }
    @DisplayName("다리건너기게임 중도 포기")
    @Test
    void 중도포기(){
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}