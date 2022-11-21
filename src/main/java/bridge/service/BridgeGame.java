package bridge.service;

import bridge.BridgeMaker;
import bridge.constance.GameConstance;
import bridge.domain.*;
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
    private final Bridge bridge;
    private final Player player;
    private BridgeStatus bridgeStatus;

    public BridgeGame(BridgeMaker bridgeMaker, Bridge bridge, Player player) {
        this.bridgeMaker = bridgeMaker;
        this.bridge = bridge;
        this.player = player;
        this.bridgeStatus = new BridgeStatus();
    }

    public void create(BridgeSizeRequestDto dto) {
        List<String> bridge = bridgeMaker.makeBridge(dto.getBridgeSize());
        this.bridge.init(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeResponseDto move(SelectBlockRequestDto dto) {
        int currentPosition = player.getCurrentPosition();
        String blockToMove = dto.getBlock();
        String blockMark = expressionOfBlock(currentPosition, blockToMove);
        BridgeStatus bridgeStatus = marking(blockMark, blockToMove);
        return new BridgeResponseDto(bridgeStatus);
    }

    private String expressionOfBlock(int currentPosition, String block) {
        if (bridge.canCross(currentPosition, block)) {
            player.move();
            isDoneCrossingBridge(player.getCurrentPosition());
            return GameConstance.CROSSABLE_EXPRESSION;
        }
        player.fail();
        return GameConstance.NOT_CROSSABLE_EXPRESSION;
    }

    private void isDoneCrossingBridge(int currentPosition) {
        if(bridge.isDoneCrossingBridge(currentPosition)) {
            player.success();
        }
    }

    private BridgeStatus marking(String mark, String block) {
        if(block.equals(GameConstance.UP_BLOCK_EXPRESSION)) {
            bridgeStatus.addStatus(mark, GameConstance.EMPTY_BLOCK);
            return bridgeStatus;
        }

        bridgeStatus.addStatus(GameConstance.EMPTY_BLOCK, mark);
        return bridgeStatus;
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
    public boolean retry(GameRetryRequestDto dto) {
        if (canGameRetry(dto.getRetry())) {
            gameInit();
            return true;
        }
        return false;
    }

    private boolean canGameRetry(String retry) {
        return retry.equals(GameConstance.RETRY);
    }

    private void gameInit() {
        player.init();
        bridgeStatus = new BridgeStatus();
    }

    public GameResultResponseDto result() {
        return new GameResultResponseDto(bridgeStatus, player);
    }
}
