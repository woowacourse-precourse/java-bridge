package bridge.domain;

// TODO 주의! InputView OutputView를 사용하지 않습니다.
//  `BridgeGame`의 메서드의 이름은 변경할 수 없습니다
//  인자와 반환 타입은 추가, 변경 가능합니다.

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private FootPrint footPrint; //TODO Result 안으로 옮기기
    private Bridge bridge;
    private Result result;

    public BridgeGame() {
        footPrint = new FootPrint();
        result = new Result();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param footrestLocation
     */
    public GameStatus move(FootrestLocation footrestLocation) {
        if (footPrint == null) {
            throw new IllegalStateException("초기화 안됨");
        }
        Integer order = footPrint.getOrder(); //차례
        footPrint.record(footrestLocation);
        if (bridge.canMove(order, footrestLocation)) {
            if (bridge.isLast(order)) {
                result.recordSuccess(footPrint);
                return GameStatus.SUCCESS;
            }
            return GameStatus.MOVE_SUCCESS;
        } else {
            // 마지막 값을 X로 변경
            footPrint.failAtLast();
            result.recordFail(footPrint);
            return GameStatus.FAIL;
        }
        // Bridge 초기화 안됐으면 일단 예외 반환(모든 메서드 마찬가지)

        // footPrint의 다음 차례를 꺼낸다
        // board에 이동이 가능한지 확인
        // 이동이 가능하면
        //   footprint에 기록
        //   이동한 곳이 X라면 -> 실패 반환(-1)
        //   이동한 곳이 O라면 ->
        //     만약 board의 끝점이었다면 -> 성공(1) 반환
        //     아니라면 움직였다(0) 반환
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        footPrint = new FootPrint();
    }

    public void saveBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public Result getResult() {
        return result;
    }

    public FootPrint getFootPrint() {
        return footPrint;
    }
}
