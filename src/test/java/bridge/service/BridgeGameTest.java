package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.facade.BridgeGameFacade;
import bridge.service.dto.request.BridgeSizeRequestDto;
import bridge.service.dto.request.SelectBlockRequestDto;
import bridge.service.dto.response.BridgeResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Assertions.assertThat(bridge.isDoneCrossingBridge(3)).isTrue();
    }

    //실패 TODO : Random 값을 어떻게 알아내야 할지 생각하기 (테스트하기 좋은 코드로 개선)
    @DisplayName("건널 수 있는 다리들을 매개변수로 받아 다리 생성")
    @Test
    void should_BridgeStatus_When_move() {
        final String bridgeSize = "3";
        BridgeSizeRequestDto dto = new BridgeSizeRequestDto(bridgeSize);
        bridgeGame.create(dto);
        String blockToMove = "U";
        SelectBlockRequestDto requestDto = new SelectBlockRequestDto(blockToMove);
        BridgeResponseDto responseDto = bridgeGame.move(requestDto);
        Assertions.assertThat(responseDto.getBridgeStatus().getUpBlocks()).contains("O");
        Assertions.assertThat(responseDto.getBridgeStatus().getDownBlocks()).contains(" ");
    }
}
