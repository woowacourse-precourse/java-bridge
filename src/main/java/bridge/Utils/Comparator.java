package bridge.Utils;

import java.util.List;

/**
 * 사용자의 입력과 현재 게임 진행상황을 비교하고 결과값을 리턴한다.
 * 다리를 건넜는지, 건너고 있는 중인지 남은 칸과 비교한다.
 */
public class Comparator {
    private int tryCount;
    private int location;

    public Comparator() {
        this.tryCount = 1;
        this.location = 0;
    }

    public void addTryCount() {
        tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isPassable(List<String> bridge) {
        return bridge.size() > location;
    }

    public boolean passBlockAndResult(List<String> bridge, String direction) {
        if (bridge.get(location).equals(direction)) {
            location++;
            return true;
        }
        return false;
    }

    public List<String> getPassedBridge(List<String> bridge) {
        return bridge.subList(0, location);
    }

}
