package bridge;

import java.util.List;

public class Comparator {
    /**
     * 사용자가 선택한 곳으로 다리를 건널 수 있는지 확인한다.
     *
     * @param bridge    다리
     * @param round     현재 회차
     * @param userInput 사용자가 선택한 곳
     * @return 건널 수 있으면 true, 건널 수 없으면 false를 반환
     */
    public boolean compare(List<String> bridge, int round, String userInput) {
        return bridge.get(round).equals(userInput);
    }
}
