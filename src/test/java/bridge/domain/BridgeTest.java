package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {
    final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    void 다리_생성하기() throws Exception{
        //given
        List<String> bridge = bridgeMaker.makeBridge(10);

        //when
        Bridge newBridge = new Bridge(bridge);

        //then
        assertThat(newBridge.getSize()).isEqualTo(10);
        assertThat(newBridge.getBridge()).allMatch(o->o.equals("U") || o.equals("D"));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    void 정답과_유저의_마지막_답이_다를_때(int size) throws Exception{
        //given
        BridgeGame bridgeGame = new BridgeGame(new BridgeRandomNumberGenerator());
        bridgeGame.initBridge(size);
        bridgeGame.move("Incorrect Answer");

        //when
        GameStatus currentStatus = bridgeGame.getCurrentStatus();

        //then
        assertThat(currentStatus).isEqualTo(GameStatus.OVER);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 10})
    void 정답_판단하기(int size) throws Exception{
        //given
        List<String> bridge = bridgeMaker.makeBridge(size);
        Bridge answer = new Bridge(bridge);
        Bridge user = new Bridge(new ArrayList<>());

        //when
        for(int i=0; i<size; i++)
            user.moveNext(answer.getBridge().get(i));

        //then
        assertThat(user.matchAnswer(answer)).allMatch(o -> o.equals("O"));
        assertThat(user.matchAnswer(answer).size()).isEqualTo(size);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 10, 20})
    void 정답_판단하기_마지막_하나만_틀렸을_때(int size) throws Exception{
        //given
        List<String> bridge = bridgeMaker.makeBridge(size);
        Bridge answer = new Bridge(bridge);
        Bridge user = new Bridge(new ArrayList<>());

        //when
        for(int i=0; i<size-1; i++)
            user.moveNext(answer.getBridge().get(i));
        user.moveNext("Incorrect Answer");

        //then
        assertThat(user.matchAnswer(answer).subList(0, size-1)).allMatch(o->o.equals("O"));
        assertThat(user.matchAnswer(answer).get(size-1)).isEqualTo("X");
        assertThat(user.matchAnswer(answer).size()).isEqualTo(size);
    }
}