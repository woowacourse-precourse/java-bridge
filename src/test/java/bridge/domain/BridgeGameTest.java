package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("다리건너기를 관리하는 클래스 내에서 User의 이동을 저장하는 메서드가 정상 작동하는지 테스트")
    @Test
    public void brideGameMoveTest() {

        //given
        BridgeNumberGenerator numberGenerator = new BridgePrinterTest.TestNumberGenerator(newArrayList(1, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeGame.setBridge(bridgeMaker.makeBridge(3));
        bridgeGame.setUser();

        //when
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");

        //then
        assertThat(bridgeGame.getUser().getUserMovings().size()).isEqualTo(3);
        assertThat(bridgeGame.getUser().getUserMovings()).containsExactly("U", "U", "D");

    }

    @DisplayName("다리건너기를 관리하는 클래스 내에서 재시도 선택 시 User의 이동 목록이 초기화되고 게임 실행 횟수가 증가하는지 테스트")
    @Test
    public void brideGameRetryTest() {
        //given
        testSetting1();

        //when
        bridgeGame.retry();
        bridgeGame.retry();

        //then
        assertThat(bridgeGame.getUser().getUserMovings().size()).isEqualTo(0);
        assertThat(bridgeGame.getUser().getCount()).isEqualTo(3);
    }


    @DisplayName("다리 건너기 게임 중 사용자의 입력값과 건널 수 있는 다리가 일치하지 않을 때 해당 라운드의 결과")
    @Test
    public void roundClearTest() {
        //given
        testSetting1();

        //when
        boolean roundClear = bridgeGame.roundClear();

        //then
        assertThat(roundClear).isEqualTo(false);

    }

    @DisplayName("다리 건너기 게임에서 사용자의 입력값과 건널 수 있는 다리가 모두 일치했을 경우 해당 게임의 결과")
    @Test
    public void gameClearTest() {
        //given
        testSetting2();

        //when
        boolean gameClear = bridgeGame.gameClear();

        //then
        assertThat(gameClear).isEqualTo(true);

    }


    public void testSetting1() {
        BridgeNumberGenerator numberGenerator = new BridgePrinterTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeGame.setBridge(bridgeMaker.makeBridge(3));
        bridgeGame.setUser();
        bridgeGame.getUser().addUserMoving("U");
        bridgeGame.getUser().addUserMoving("U");
    }

    public void testSetting2() {
        BridgeNumberGenerator numberGenerator = new BridgePrinterTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeGame.setBridge(bridgeMaker.makeBridge(3));
        bridgeGame.setUser();
        bridgeGame.getUser().addUserMoving("U");
        bridgeGame.getUser().addUserMoving("D");
        bridgeGame.getUser().addUserMoving("D");
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