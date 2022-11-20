package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.OutputView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameControllerTest {

    private static final BridgeMaker bridgeMaker= new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(10));

    @ValueSource(ints = {3,10,18})
    @ParameterizedTest
    void 다리_길이_테스트(int size){
        //when
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
        //then
        assertThat(bridgeGame.getBridgeSize()).isEqualTo(size);
    }

    @Test
    void 다리가_U_D_로만_이루어져_있는지_테스트(){
        //given
        List<String> bridge = bridgeGame.getBridge();
        //when
        List<String> collect = bridge.stream().filter(mark -> mark.equals("U") || mark.equals("D"))
                .collect(Collectors.toList());
        //then
        assertThat(collect).isEqualTo(bridge);
    }

    @ValueSource(ints = {0,6,8})
    @ParameterizedTest
    void 플레이어가_이동한_칸이_건널_수_있는지_확인하는_기능_테스트(int index){
        //given
        List<String> bridge = bridgeGame.getBridge();
        //when
        String mark = bridge.get(index);
        bridgeGame.move(index, mark);
        //then
        assertThat(bridgeGame.success());
    }
}
