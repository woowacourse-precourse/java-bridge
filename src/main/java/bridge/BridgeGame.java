package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private int currentIndex;

    // 게임 시도 횟수
    private int gameTryCount;

    // 다리 진행 사항
    private List<String> bridgeUpMemory;
    private List<String> bridgeDownMemory;

    public BridgeGame(int bridgeLength) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(bridgeLength);
        bridgeUpMemory = new ArrayList<>();
        bridgeDownMemory = new ArrayList<>();
        gameTryCount = 1;
        currentIndex = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * 사용자의 입력을 인자로 받는다. 다리의 현재 위치에서 건널 수 있는 곳과 입력이 일치하면 한 칸 나아가고 true 반환, 일치하지 않으면 위치를 처음으로 돌리고, false 반환(종료)
     */
    public boolean move(String moveInput) {
        if (bridge.get(currentIndex).equals(moveInput)) {
            currentIndex++;
            saveUpBridgeMemory(moveInput,true);
            saveDownBridgeMemory(moveInput,true);
            return true;
        }
        saveUpBridgeMemory(moveInput,false);
        saveDownBridgeMemory(moveInput,false);
        currentIndex = 0;
        return false;
    }

    /**
     * 진행 사항을 각각 위 아래로 저장하는 메소드
     * @param moveInput
     */
    public void saveUpBridgeMemory(String moveInput, boolean isSuccess) {
        if (isSuccess == false && moveInput.equals("U")) {
            bridgeUpMemory.add("X");
            return;
        }
        if (moveInput.equals("U")) {
            bridgeUpMemory.add("O");
            return;
        }
        bridgeUpMemory.add(" ");
    }

    public void saveDownBridgeMemory(String moveInput, boolean isSuccess) {
        if (isSuccess == false && moveInput.equals("D")) {
            bridgeDownMemory.add("X");
            return;
        }
        if (moveInput.equals("D")) {
            bridgeDownMemory.add("O");
            return;
        }
        bridgeDownMemory.add(" ");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommandInput) {
        if (gameCommandInput.equals("Q"))
            return false;

        bridgeUpMemory = new ArrayList<>();
        bridgeDownMemory = new ArrayList<>();
        gameTryCount++;
        return true;
    }

    /**
     * 다리 끝까지 도달한 상태인 지 알려주는 메서드
     *
     * @return true 이면 종료, false 이면 진행 중
     */
    public boolean isEnd() {
        if (bridge.size() == currentIndex)
            return true;
        return false;
    }


    public int getGameTryCount() {
        return gameTryCount;
    }

    public List<String> getBridgeUpMemory() {
        return bridgeUpMemory;
    }

    public List<String> getBridgeDownMemory() {
        return bridgeDownMemory;
    }
}
