package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> randomList;
    private boolean exitCode = false;
    private final int size;
    private int cnt = 1;
    private ReadPrintDto readPrintDto;
    private BridgeMaker bridgeMaker;
    public BridgeGame(int size) {
        this.readPrintDto = new ReadPrintDto();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.size = size;
        this.randomList = bridgeMaker.makeBridge(size);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(List<List<String>> userMap,String userMove) {
        int sizeUser = userMap.get(0).size();
        userMap = compareValue(userMap, userMove, sizeUser);
        return userMap;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}