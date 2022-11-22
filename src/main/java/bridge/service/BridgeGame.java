package bridge.service;

import bridge.BridgeMaker;
import bridge.constance.GameConstance;
import bridge.domain.*;
import bridge.facade.BridgeGameFacade;
import bridge.service.dto.request.BridgeSizeRequestDto;
import bridge.service.dto.request.GameRetryRequestDto;
import bridge.service.dto.request.SelectBlockRequestDto;
import bridge.service.dto.response.BridgeResponseDto;
import bridge.service.dto.response.GameResultResponseDto;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final Player player;
    private final BridgeGameFacade bridgeGameFacade;

    public BridgeGame(BridgeMaker bridgeMaker, Player player, BridgeGameFacade bridgeGameFacade) {
        this.bridgeMaker = bridgeMaker;
        this.player = player;
        this.bridgeGameFacade = bridgeGameFacade;
    }

    public void create(BridgeSizeRequestDto dto) {
        List<String> bridge = bridgeMaker.makeBridge(dto.getBridgeSize());
        bridgeGameFacade.initBridge(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeResponseDto move(SelectBlockRequestDto dto) {
        int currentPosition = player.getCurrentPosition();
        String blockToMove = dto.getBlock();
        BridgeStatus bridgeStatus = bridgeGameFacade.moveToBlock(currentPosition, blockToMove);
        return new BridgeResponseDto(bridgeStatus);
    }

    public boolean playing() {
        return player.isPlaying();
    }

    public boolean isGameFailed() {
        return player.isFail();
    }

    public void addTryCount() {
        player.addTotalTryNumber();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean canRetry(GameRetryRequestDto dto) {
        if (checkInputRetry(dto.getRetry())) {
            bridgeGameFacade.gameInit();
            return true;
        }
        return false;
    }

    private boolean checkInputRetry(String retry) {
        return retry.equals(GameConstance.RETRY);
    }

    public GameResultResponseDto result() {
        BridgeStatus bridgeStatus = bridgeGameFacade.finalGameResult();
        return new GameResultResponseDto(bridgeStatus, player);
    }
}
