package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.facade.BridgeGameFacade;
import bridge.service.dto.request.BridgeSizeRequestDto;
import bridge.service.dto.request.GameRetryRequestDto;
import bridge.service.dto.request.SelectBlockRequestDto;
import bridge.service.dto.response.BridgeResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameTest {
    private BridgeGame bridgeGame;
    private Bridge bridge;

    @BeforeEach
    void init() {
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        Player player = new Player();
        bridge = new Bridge();
        BridgeGameFacade facade = new BridgeGameFacade(bridge, player);
        bridgeGame = new BridgeGame(bridgeMaker, player, facade);
    }

    @DisplayName("건널 수 있는 다리들을 매개변수로 받아 다리 생성")
    @Test
    void should_createBridge_When_create() {
        final String bridgeSize = "3";
        BridgeSizeRequestDto dto = new BridgeSizeRequestDto(bridgeSize);
        bridgeGame.create(dto);
        assertThat(bridge.isDoneCrossingBridge(3)).isTrue();
    }

    @DisplayName("플레이어가 이동하려는 칸을 입력받아서 건널 수 있는지 없는지 표시")
    @Test
    void should_BridgeStatus_When_move() {
        final String bridgeSize = "3";
        BridgeSizeRequestDto dto = new BridgeSizeRequestDto(bridgeSize);
        bridgeGame.create(dto);
        String blockToMove = "U";
        SelectBlockRequestDto requestDto = new SelectBlockRequestDto(blockToMove);
        BridgeResponseDto responseDto = bridgeGame.move(requestDto);
        assertThat(responseDto.getBridgeStatus()).isNotNull();
        assertThat(responseDto.getBridgeStatus()).isNotNull();
    }

    @DisplayName("게임 재시작 여부를 입력받아 재시작을 원한다면 true")
    @Test
    void should_True_When_retry() {
        final String INPUT_RETRY = "R";
        GameRetryRequestDto dto = new GameRetryRequestDto(INPUT_RETRY);
        boolean canRetry = bridgeGame.retry(dto);
        assertThat(canRetry).isTrue();
    }

    @DisplayName("게임 재시작 여부를 입력받아 그대로 게임종료를 원한다면 false")
    @Test
    void should_False_When_retry() {
        final String INPUT_RETRY = "Q";
        GameRetryRequestDto dto = new GameRetryRequestDto(INPUT_RETRY);
        boolean canRetry = bridgeGame.retry(dto);
        assertThat(canRetry).isFalse();
    }
}
