package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String STATUS_MOVABLE = "O";
    private static final String STATUS_UNMOVABLE = "X";

    private final List<String> bridge;
    private final Results results;
    private int trial = 1;
    private String successOrFail;

    private boolean isAlive;

    public BridgeGame(List<String> bridge, Results results) {
        this.bridge = bridge;
        this.results = results;
    }

    public int getTrial() {
        return trial;
    }
    public Results getResults() {
        return results;
    }
    public List<String> getBridge() {
        return bridge;
    }
    public String getSuccessOrFail() {
        return successOrFail;
    }
    public boolean isAlive() {
        return isAlive;
    }

    public void setSuccessOrFail(String successOrFail) {
        this.successOrFail = successOrFail;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userCommand) {
        if (userCommand.equals(bridge.get(getRound()))) {
            this.results.addCurrentResult(new RoundResult(userCommand, STATUS_MOVABLE));
            this.isAlive = true;
            return;
        }
        this.results.addCurrentResult(new RoundResult(userCommand, STATUS_UNMOVABLE));
        this.isAlive = false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        trial++;
        this.results.deleteAll();
    }

    public boolean isProcessing(){
        return this.results.getResults().size() < bridge.size();
    }

    public int getRound(){
        return this.results.getResults().size();
    }

}
