package bridge.domain;

import static bridge.constant.MovingDirection.D;
import static bridge.constant.MovingDirection.U;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;

    public void init(Queue<Integer> numbers) {
        bridgeMaker = new BridgeMaker(numbers::poll);
        bridgeGame = new BridgeGame(bridgeMaker);
    }

    @Test
    void 게임시작시_종료여부는_종료되지않음이다() throws Exception {
        init(new LinkedList<>(List.of(1, 0, 1, 1)));
        Assertions.assertThat(bridgeGame.isFinished()).isFalse();
    }

    @Test
    void 게임시작시_실패여부는_실패하지않음이다() throws Exception {
        init(new LinkedList<>(List.of(1, 0, 1, 1)));
        Assertions.assertThat(bridgeGame.isNotFail()).isTrue();
    }

    @Test
    void 게임시작시_위치값은_0이다() throws Exception {
        init(new LinkedList<>(List.of(1, 0, 1, 1)));
        Assertions.assertThat(bridgeGame.getCurrentPosition()).isZero();
    }

    @Test
    void 게임처음시작시_시도횟수는_1이다() throws Exception {
        init(new LinkedList<>(List.of(1, 0, 1, 1)));
        Assertions.assertThat(bridgeGame.getTryCount()).isOne();
    }

    @Test
    void 정답다리에_일치하는_위치와_방향을_제시하면_긍정반환성공() throws Exception {
        init(new LinkedList<>(List.of(1, 0, 1, 1)));
        bridgeGame.setBridge(4);
        Assertions.assertThat(bridgeGame.hasSameDirectionAtPosition(0, U)).isTrue();
    }

    @Test
    void 사용자_다리_좌표와_결과_다리_좌표가_같은_방향을_가리키면_긍정반환성공() throws Exception {
        init(new LinkedList<>(List.of(1, 0, 1, 1)));
        bridgeGame.setBridge(4);
        bridgeGame.move(U);
        bridgeGame.move(D);
        bridgeGame.move(U);
        bridgeGame.move(U);
        Assertions.assertThat(bridgeGame.hasCorrectDirectionAtPosition(2)).isTrue();

    }

    @Test
    void 게임결과문구_반환_성공() throws Exception {
        init(new LinkedList<>(List.of(1, 0, 1, 1)));
        Assertions.assertThat(bridgeGame.getResultPhrase()).isEqualTo("성공");
    }
}