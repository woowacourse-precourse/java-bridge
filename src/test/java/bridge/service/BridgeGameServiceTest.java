package bridge.service;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.SuccessFail;
import bridge.domain.UserCharacters;
import bridge.dto.CurrentStatusDto;
import bridge.dto.RetrySatutsDto;
import bridge.BridgeNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameServiceTest {

    @Test
    void 브릿지_저장() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>());
        Serivce bridgeGameService = new BridgeGameService(bridgeGame, new UserCharacters(new ArrayList<>()),
                new BridgeMaker(new TestNumberGenerator(new ArrayList<>(Arrays.asList(1, 1, 1)))));
        bridgeGameService.saveBridge(3);
        assertThat(bridgeGame.getBridge()).isEqualTo(new ArrayList<>(Arrays.asList("U", "U", "U")));
    }

    @Test
    void 다리이동실패케이스() {
        Serivce bridgeGameService = new BridgeGameService(new BridgeGame(new ArrayList<>()), new UserCharacters(new ArrayList<>()),
                new BridgeMaker(new TestNumberGenerator(new ArrayList<>(Arrays.asList(1, 1, 1)))));
        bridgeGameService.saveBridge(3);
        CurrentStatusDto currentStatusDto = bridgeGameService.move("D");
        assertThat(currentStatusDto.getSuccessFail()).isEqualTo(SuccessFail.FAIL);
    }

    @Test
    void 다리이동_한번성공_케이스() {
        Serivce bridgeGameService = new BridgeGameService(new BridgeGame(new ArrayList<>()), new UserCharacters(new ArrayList<>()),
                new BridgeMaker(new TestNumberGenerator(new ArrayList<>(Arrays.asList(1, 1, 1)))));
        bridgeGameService.saveBridge(3);
        CurrentStatusDto currentStatusDto = bridgeGameService.move("U");
        assertThat(currentStatusDto.getSuccessFail()).isEqualTo(SuccessFail.UNIT_SUCCESS);

    }

    @Test
    void 다리이동_전체성공_케이스() {
        Serivce bridgeGameService = new BridgeGameService(new BridgeGame(new ArrayList<>()), new UserCharacters(new ArrayList<>(Arrays.asList("U", "U"))),
                new BridgeMaker(new TestNumberGenerator(new ArrayList<>(Arrays.asList(1, 1, 1)))));
        bridgeGameService.saveBridge(3);
        CurrentStatusDto currentStatusDto = bridgeGameService.move("U");
        assertThat(currentStatusDto.getSuccessFail()).isEqualTo(SuccessFail.OverallSuccess);

    }

    @Test
    void 다시시작() {
        Serivce bridgeGameService = new BridgeGameService(new BridgeGame(new ArrayList<>()), new UserCharacters(new ArrayList<>(Arrays.asList("U", "U"))),
                new BridgeMaker(new TestNumberGenerator(new ArrayList<>(Arrays.asList(1, 1, 1)))));
        bridgeGameService.saveBridge(3);
        RetrySatutsDto retrySatutsDto = bridgeGameService.isRetry("R");
        assertThat(retrySatutsDto.isRetryFlag()).isTrue();
    }

    @Test
    void 다시시작_안함() {
        Serivce bridgeGameService = new BridgeGameService(new BridgeGame(new ArrayList<>()), new UserCharacters(new ArrayList<>(Arrays.asList("U", "U"))),
                new BridgeMaker(new TestNumberGenerator(new ArrayList<>(Arrays.asList(1, 1, 1)))));
        bridgeGameService.saveBridge(3);
        RetrySatutsDto retrySatutsDto = bridgeGameService.isRetry("Q");
        assertThat(retrySatutsDto.isRetryFlag()).isFalse();
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