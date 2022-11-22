package domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.service.BridgeGameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private static BridgeMaker bridgeMaker;
    private static BridgeGame bridgeGame;
    private static BridgeGameService bridgeGameService;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(20));
        bridgeGameService = new BridgeGameService(bridgeGame);
    }

    @DisplayName("다리 생성 성공 테스트")
    @ValueSource(ints = {5, 15, 20})
    @ParameterizedTest()
    void 다리_생성_성공_테스트(int size) {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));

        assertThat(bridgeGame.getBridgeSize()).isEqualTo(size);
    }

    @DisplayName("다리 생성시 U, D로만 이루어져 있으면 성공")
    @ValueSource(ints = {5, 15, 20})
    @ParameterizedTest()
    void 다리_생성시_UD_테스트(int size) {
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
        BridgeGameService bridgeGameService = new BridgeGameService(bridgeGame);
        List<String> bridge = bridgeGameService.getBridge();
        List<String> filtered = bridge.stream().filter(s -> s.equals("U") || s.equals("D"))
                .collect(Collectors.toList());
        assertThat(bridge).isEqualTo(filtered);
    }

    @DisplayName("다리 끝까지 성공 후 도달했다면 종료 성공")
    @Test
    void 다리끝_도달후_종료성공_테스트() {
        List<String> bridge = bridgeGameService.getBridge();

        for (String command : bridge) {
            bridgeGameService.moveNext(command);
        }

        assertThat(bridgeGameService.isComplete());
    }

    @DisplayName("시도한 횟수 확인 실패")
    @ValueSource(ints = {0, 5, 20})
    @ParameterizedTest
    void 시도한_횟수확인_실패_테스트(int retry) {
        for (int i = 0; i < retry; i++) bridgeGameService.restart();

        assertThat(bridgeGameService.getTryCnt()).isNotEqualTo(retry);
    }

    @DisplayName("시도한 횟수 확인 성공")
    @ValueSource(ints = {0, 5, 20})
    @ParameterizedTest
    void 시도한_횟수확인_성공_테스트(int retry) {
        for (int i = 0; i < retry; i++) bridgeGameService.restart();

        assertThat(bridgeGameService.getTryCnt()).isEqualTo(retry + 1);
    }

    @DisplayName("재시작 후 초기화 성공")
    @Test
    void 재시작후_초기화_성공_테스트() {
        List<String> bridge = bridgeGameService.getBridge();
        bridgeGameService.restart();
        assertThat(bridgeGameService.getBridge()).isEqualTo(bridge);
    }

    @DisplayName("다음 칸 이동 가능하면 성공")
    @ValueSource(ints = {0, 10, 19})
    @ParameterizedTest
    void 다음칸_이동_가능_성공(int index) {
        List<String> bridge = bridgeGameService.getBridge();
        String target = bridge.get(index);
        bridgeGameService.moveNext(target);
        assertThat(bridgeGameService.success());
    }
}
