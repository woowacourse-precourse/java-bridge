package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.BlockExpression;
import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.domain.Result;
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
        result.tryMove();
        String playerBlock = dto.getBlock();
        String bridgeBlock = bridge.getBlockByPlayerPosition(player.getPosition());

        return moveOrFail(playerBlock, bridgeBlock);
    }

    private BridgeResponseDto moveOrFail(String playerBlock, String bridgeBlock) {
        if(bridgeBlock.equals(playerBlock)) {
            result.addBlocks(BlockExpression.getBlockExpressionByMove(bridgeBlock));
            player.move();
            validateGameSuccess(player.getPosition());
            return new BridgeResponseDto(result);
        }

        result.addBlocks(BlockExpression.getBlockExpressionByNotMove(bridgeBlock));
        result.fail();
        return new BridgeResponseDto(result);
    }

    private void validateGameSuccess(int position) {
        if(bridge.isDoneCrossingBridge(position)) {
            result.success();
        }
    }

    public boolean gameOver() {
        return result.gameOver();
    }

    public boolean isFail() {
        return result.isFail();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(GameRetryRequestDto dto) {
        if(dto.getRetry().equals("R")) {
            this.result.init();
            this.player = new Player();
            return true;
        }
        return false;
    }

    public GameResultResponseDto result() {
        return new GameResultResponseDto(result);
    }
}
