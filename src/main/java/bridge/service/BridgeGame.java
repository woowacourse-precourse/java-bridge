package bridge.service;

import bridge.domain.Bridge;
import bridge.dto.BridgeMove;
import bridge.dto.BridgeMove.Response;
import bridge.exception.ErrorCode;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame implements BridgeGameInf {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Override
    public BridgeMove.Response move(BridgeMove.Request request, Bridge bridge) {
        validateIndex(request.getIndex(), bridge.getSequence().size());
        if (isPossibleMove(request, bridge)) {
            if (bridge.getSequence().size() - 1 == request.getIndex()) {
                return new Response(true, true, request.getAttemptCount());
            }
            return new Response(false, true, request.getAttemptCount());
        }
        return new Response(false, false, request.getAttemptCount());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Override
    public void retry() {
    }

    private boolean isPossibleMove(BridgeMove.Request request, Bridge bridge) {
        return bridge.getSequence().get(request.getIndex())
            .equals(request.getSpaceStatus().getLetter());
    }

    private void validateIndex(int index, int bridgeSize) {
        if (index < 0 || index >= bridgeSize) {
            throw new IllegalArgumentException(ErrorCode.INDEX_OUT_OF_BOUND.getMessage());
        }
    }
}
