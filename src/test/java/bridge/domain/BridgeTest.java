package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
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
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 10})
    void 정답_판단하기(int stage) throws Exception{
        //given
        List<String> bridge = bridgeMaker.makeBridge(stage+1);
        Bridge answer = new Bridge(bridge);
        Bridge user = new Bridge(new ArrayList<>());

        //when
        for(int i=0; i<=stage; i++)
            user.moveNext(answer.getBridge().get(i));

        //then
        assertThat(user.matchAnswer(answer)).allMatch(o -> o.equals("O"));
        assertThat(user.matchAnswer(answer).size()).isEqualTo(stage+1);
    }
}