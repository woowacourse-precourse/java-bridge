package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.Bridges;
import bridge.domain.Player;
import bridge.service.dto.request.BridgeSizeRequestDto;
import bridge.service.dto.request.PlayerMovementRequestDto;
import bridge.service.dto.response.BridgeStateResponseDto;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final Bridges bridges;
    private final Player player;

    public BridgeGame(BridgeMaker bridgeMaker, Bridges bridges, Player player) {
        this.bridgeMaker = bridgeMaker;
        this.bridges = bridges;
        this.player = player;
    }

    public void create(BridgeSizeRequestDto dto) {
        List<String> realBridges = bridgeMaker.makeBridge(dto.getBridgeSize());
        bridges.generate(realBridges);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeStateResponseDto move(PlayerMovementRequestDto dto) {
        String positionByPlayerToMove = dto.getMovePlayer();
        String bridge = bridges.getBridgeByPositionToMove(player.getPosition());

        List<String> upSpaces = new ArrayList<>();
        List<String> downSpaces = new ArrayList<>();
        if(bridge.equals(positionByPlayerToMove)) {
            if(bridge.equals("U")) {
                upSpaces.add("O");
                downSpaces.add("    ");
            }
            else {
                upSpaces.add("    ");
                downSpaces.add("O");
            }

            player.move();
        }
        else {
            if(bridge.equals("U")) {
                upSpaces.add("    ");
                downSpaces.add("X");
            }
            else {
                upSpaces.add("X");
                downSpaces.add("    ");
            }
        }

        return new BridgeStateResponseDto(upSpaces, downSpaces);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
