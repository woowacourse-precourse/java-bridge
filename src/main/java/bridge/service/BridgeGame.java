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

    public BridgeGame(BridgeMaker bridgeMaker, Bridge bridge) {
        this.bridgeMaker = bridgeMaker;
        this.bridge = bridge;
        this.player = new Player();
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
        int nowPosition = player.nowPosition();
        String mark = getMarkByMove(nowPosition, dto.getBlock());
        return response(mark, dto.getBlock());
    }

    private BridgeResponseDto response(String mark, String block) {
        if(block.equals(GameConstance.UP_BLOCK_EXPRESSION)) {
            bridgeStatus.addStatus(mark, GameConstance.EMPTY_BLOCK);
            return new BridgeResponseDto(bridgeStatus);
        }

        bridgeStatus.addStatus(GameConstance.EMPTY_BLOCK, mark);
        return new BridgeResponseDto(bridgeStatus);
    }

    private String getMarkByMove(int currentPosition, String block) {
        if (bridge.canCross(currentPosition, block)) {
            player.move();
            isDoneCrossingBridge(player.nowPosition());
            return GameConstance.CROSSABLE;
        }
        player.fail();
        return GameConstance.NOT_CROSSABLE;
    }

    private void isDoneCrossingBridge(int currentPosition) {
        if(bridge.isDoneCrossingBridge(currentPosition)) {
            player.success();
        }
    }

    public boolean playing() {
        return !player.isGameOver();
    }

    public boolean isFail() {
        return player.getResult().equals(Player.Result.FAIL);
    }

    public void tryGame() {
        player.tryGame();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(GameRetryRequestDto dto) {
        if (dto.getRetry().equals(GameConstance.RETRY)) {
            this.player.init();
            bridgeStatus = new BridgeStatus();
            return true;
        }
        return false;
    }

    public GameResultResponseDto result() {
        return new GameResultResponseDto(bridgeStatus, player);
    }
}
