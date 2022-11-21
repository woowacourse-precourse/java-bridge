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
    private final Result result;
    private Player player;

    public BridgeGame(BridgeMaker bridgeMaker, Bridge bridge, Result result) {
        this.bridgeMaker = bridgeMaker;
        this.bridge = bridge;
        this.result = result;
        this.player = new Player();
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
        boolean canCross = bridge.canCross(nowPosition, dto.getBlock());
        boolean isUpBlock = bridge.isUpBlock(nowPosition);
        return moveOrFail(canCross, isUpBlock);
    }

    private BridgeResponseDto moveOrFail(boolean canCross, boolean isUpBlock) {
        if (canCross) {
            result.addBlocks(BlockExpression.getBlockExpressionByMove(isUpBlock));
            player.move();
            validateGameSuccess(player.nowPosition());
            return new BridgeResponseDto(result);
        }

        result.addBlocks(BlockExpression.getBlockExpressionByNotMove(isUpBlock));
        result.fail();
        return new BridgeResponseDto(result);
    }

    private void validateGameSuccess(int position) {
        if (bridge.isDoneCrossingBridge(position)) {
            result.success();
        }
    }

    public boolean playing() {
        return !result.gameOver();
    }

    public boolean isFail() {
        return result.isFail();
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
            this.result.init();
            this.player.init();
            return true;
        }
        return false;
    }

    public GameResultResponseDto result() {
        return new GameResultResponseDto(result, player);
    }
}
