package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final int size;
    private int location = 0;
    private int tryCount = 1;
    private boolean correct;
    private String lastMoving;

    private enum lineFlag {
        FIRST, SECOND;
    }

    public Bridge(List<String> bridge, int size) {
        this.bridge = bridge;
        this.size = size;
    }

    /**
     * 이동 가능한지 여부를 확인한다.
     */
    public boolean possibleMove(String moving) {
        return getAnswer(location).equals(moving);
    }

    /**
     * 현재 위치를 1 증가시킨다.
     */
    public void locationUpdate() {
        this.location++;
    }

    /**
     * 트라이 횟수를 1 증가시킨다.
     */
    public void tryCountUpdate() {
        this.tryCount++;
    }

    /**
     * 현재 위치의 정답을 가져온다.
     */
    private String getAnswer(int current) {
        return this.bridge.get(current);
    }

    public int getLocation() {
        return this.location;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public void setLastMoving(String moving) {
        this.lastMoving = moving;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    /**
     * 현재 진행도에 따른 다리 출력물을 반환한다.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int length = location;
        if (!correct) {
            length++;
        }
        buildLine(sb, length, lineFlag.FIRST);
        sb.append("\n");
        buildLine(sb, length, lineFlag.SECOND);
        return sb.toString();
    }

    /**
     * 출력해야 할 라인을 StringBuilder에 build 한다.
     */
    private void buildLine(StringBuilder sb, int length, lineFlag flag) {
        sb.append("[ ");
        for (int i = 0; i < length; i++) {
            appendCorrect(sb, i, flag);
            if (i < length - 1) {
                sb.append(" | ");
            }
        }
        sb.append(" ]");
    }

    /**
     * O, X, 공백 중 하나를 조건에 맞게 StringBuilder에 append한다.
     */
    private void appendCorrect(StringBuilder sb, int i, lineFlag flag) {
        if (i < location && flagCompare(flag, bridge.get(i))) {
            sb.append("O");
            return;
        }
        if (i == location && flagCompare(flag, lastMoving)) {
            sb.append("X");
            return ;
        }
        sb.append(" ");
    }

    /**
     * lineFlag에 따라 첫번째 라인이면 U랑 비교를, 두번째 라인이면 D랑 비교한다.
     */
    private boolean flagCompare(lineFlag flag, String str) {
        if (flag == lineFlag.FIRST)
            return str.equals("U");
        return str.equals("D");
    }
}
