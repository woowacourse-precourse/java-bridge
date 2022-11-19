package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.BlockExpression;
import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.domain.Result;
import bridge.service.dto.request.BridgeSizeRequestDto;
import bridge.service.dto.request.SelectBlockRequestDto;
import bridge.service.dto.response.BridgeResponseDto;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final Bridge bridge;
    private final Player player;
    private final Result result;

    public BridgeGame(BridgeMaker bridgeMaker, Bridge bridge, Player player, Result result) {
        this.bridgeMaker = bridgeMaker;
        this.bridge = bridge;
        this.player = player;
        this.result = result;
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
        String playerBlock = dto.getBlock();
        String bridgeBlock = bridge.getBlockByPlayerPosition(player.getPosition());

        if(bridgeBlock.equals(playerBlock)) {
            result.addBlocks(BlockExpression.getBlockExpressionByMove(bridgeBlock));
            player.move();
            validateGameClear(player.getPosition());
            return new BridgeResponseDto(result);
        }

        result.addBlocks(BlockExpression.getBlockExpressionByNotMove(bridgeBlock));
        result.fail();
        return new BridgeResponseDto(result);
    }

    private void validateGameClear(int position) {
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
    public void retry() {
    }
}
