package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.service.BridgeGameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameServiceTest {

    private static BridgeMaker bridgeMaker;
    private static BridgeGame bridgeGame;
    private static BridgeGameService bridgeGameService;

    @BeforeEach
    void beforeEach() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(10));
        bridgeGameService = new BridgeGameService(bridgeGame);
    }

    @ValueSource(ints = {3, 10, 18})
    @ParameterizedTest
    void 다리_길이_테스트(int size) {
        //when
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
        //then
        assertThat(bridgeGame.getBridgeSize()).isEqualTo(size);
    }

    @Test
    void 다리가_U_D_로만_이루어져_있는지_테스트() {
        //given
        List<String> bridge = bridgeGameService.getBridge();
        //when
        List<String> collect = bridge.stream().filter(mark -> mark.equals("U") || mark.equals("D"))
                .collect(Collectors.toList());
        //then
        assertThat(collect).isEqualTo(bridge);
    }

    @ValueSource(ints = {0, 6, 8})
    @ParameterizedTest
    void 플레이어가_이동한_칸이_건널_수_있는지_확인하는_기능_테스트(int index) {
        //given
        List<String> bridge = bridgeGameService.getBridge();
        //when
        String mark = bridge.get(index);
        bridgeGameService.startOneRound(mark);
        //then
        assertThat(bridgeGameService.success());
    }

    @Test
    void 다리를_끝까지_건너면_게임_성공인지_확인하는_테스트() {
        //given
        List<String> bridge = bridgeGameService.getBridge();
        //when
        for (String command : bridge) {
            bridgeGameService.startOneRound(command);
        }
        //then
        assertThat(bridgeGameService.isComplete());
    }

    @Test
    void 재시작해도_처음에_만든_다리와_일치한지_확인하는_테스트() {
        //given
        List<String> bridge = bridgeGameService.getBridge();
        //when
        bridgeGameService.restart();
        //then
        assertThat(bridgeGameService.getBridge()).isEqualTo(bridge);
    }

    @ValueSource(ints = {0, 6, 8})
    @ParameterizedTest
    void 시도한_횟수_확인하는_테스트(int retry) {
        //when
        for (int i = 0; i < retry; i++) {
            bridgeGameService.restart();
        }
        //then
        assertThat(bridgeGameService.getNumberOfAttempts()).isEqualTo(retry + 1);
    }
}
