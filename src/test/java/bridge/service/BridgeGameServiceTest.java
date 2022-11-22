package bridge.service;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.MoveResult;
import bridge.domain.Player;
import bridge.dto.MoveResultDto;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameServiceTest {
    private final BridgeNumberGenerator bridgeNumberGenerator =
            new bridge.TestNumberGenerator(newArrayList(1, 0, 0));
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private BridgeGameService bridgeGameService;

    @BeforeEach
    void setUp() {
        bridgeGameService = new BridgeGameService(bridgeMaker);
        bridgeGameService.initBridgeGame(3);
    }

    @Test
    @DisplayName("[정상] 사용자의 이동에 따른 MoveResult 결과를 반환한다.")
    void play() {
        Player player = new Player();
        MoveResultDto moveResultDto = bridgeGameService.play(player, "U");

        assertThat(moveResultDto.getMoveResult().get(0))
                .isEqualTo(List.of(MoveResult.SUCCESS));
    }

    @ParameterizedTest
    @DisplayName("[예외] 사용자의 이동에 따른 MoveResult 결과를 반환한다.")
    @CsvSource({"R, true", "Q, false"})
    void retry(String command, boolean expected) {
        Player player = new Player();
        MoveResultDto moveResultDto = bridgeGameService.play(player, "D");
        bridgeGameService.retry(player, command);

        assertThat(bridgeGameService.isPlayable()).isEqualTo(expected);
    }
}
