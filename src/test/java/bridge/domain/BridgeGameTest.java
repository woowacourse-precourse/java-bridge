package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.dto.MovingResultDto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("입력된 길이 만큼 다리가 생성된다.")
    @Test
    public void bridgeSettingTest() {
        //given
        BridgeGame game = new BridgeGame(new BridgeRandomNumberGenerator());
        int BRIDGE_SIZE = 3;

        //when
        game.settingBridge(BRIDGE_SIZE);

        //then
        assertThat(game.getBridge().size()).isEqualTo(BRIDGE_SIZE);
    }

    @DisplayName("이동 명령과 현재 다리의 상태에 따라 결과가 반환된다.")
    @Test
    void moveTest() {
        //given
        BridgeGame game = new BridgeGame(new TestNumberGenerator(newArrayList(1, 0, 0)));
        game.settingBridge(3);
        game.initGame();
        MovingResultDto answer = new MovingResultDto(newArrayList("O"), 1, false);

        //when
        MovingResultDto resultDto = game.move("U");

        //then
        assertThat(resultDto).isEqualTo(answer);
    }

    @DisplayName("재시도 한 만큼 시도 횟수가 증가한다.")
    @Test
    void retryTest() {
        //given
        BridgeGame game = new BridgeGame(new TestNumberGenerator(newArrayList(1, 0, 0)));
        game.settingBridge(3);
        game.initGame();
        int TRY_COUNT = 2;

        //when
        for (int i = 0; i < TRY_COUNT; i++) {
            game.retry("R");
        }

        //then
        assertThat(game.getTryCount()).isEqualTo(TRY_COUNT + 1);
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {
        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            // TIP: remove 시 삭제된 원소를 반환한다.
            return numbers.remove(0);
        }
    }
}