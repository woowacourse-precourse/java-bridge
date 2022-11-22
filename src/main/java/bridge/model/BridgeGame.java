package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String RETRY = "R";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private List<String> marks;
    private int gameCount;
    List<String> bridge;
    BridgeMaker bridgeMaker;
    private int position;
    private String resultOfGame;
    List<String[]> map;

    public BridgeGame() {
        this.marks = new ArrayList<>();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        resultOfGame = SUCCESS;
        gameCount = 1;
        position = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userInputCourse) {
        if (!isAbleToCross(userInputCourse)) {
            marks.add("X");
            return;
        }
        marks.add("O");
        position++;
    }

    private boolean isAbleToCross(String course) {
        return bridge.get(position).equals(course);
    }

    /**
     * 사용자의 입력과 현재까지 건너온 길의 마지막이 불일치하는지 검증하는 메소드
     *
     * @return
     */
    public boolean isDiscord() {
        if (isX(marks, "X")) {
            resultOfGame = FAIL;
            return true;
        }
        return false;
    }

    public boolean isX(List<String> marks, String result) {
        return marks.get(marks.size() - 1).equals(result);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String cmd) {
        if (cmd.equals(RETRY)) {
            resultOfGame = SUCCESS;
            gameCount++;
            return true;
        }
        return false;
    }

    /**
     * 재시작일 경우 현재 다리를 건넌 상태를 초기화 하는 메소드
     */
    public void backToFirstSection() {
        position = 0;
        marks.clear();
    }

    /**
     * 다리를 무사히 건너갔는지 확인하는 메소드
     *
     * @return
     */
    public boolean isEndOfBridge() {
        return bridge.size() != marks.size();
    }

    public void makeBridge(int size) {
        bridge = bridgeMaker.makeBridge(size);
    }


    /**
     * output에서 그려질 때 필요한 그림 정보를 따로 저장
     * output에서는 보내준 그림을 print만 하는 것으로 수정
     *
     * @param bridge
     * @param marks
     * @return
     */
    public void makeMap(List<String> bridge, List<String> marks) {
        map = makeBridgeSections(bridge, marks);
    }

    public List<String[]> makeBridgeSections(List<String> bridge, List<String> marks) {
        List<String[]> temp = new ArrayList<>();
        for (int i = 0; i < marks.size(); i++) {
            String[] bridgeSection = makeBridgeSection(bridge.get(i), marks.get(i));
            temp.add(bridgeSection);
        }
        return temp;
    }

    private String[] makeBridgeSection(String course, String mark) { // "U", "O"
        String[] section = {" ", " "};
        int pos = selectPosition(course);
        section[pos] = mark;
        return section;
    }

    private int selectPosition(String course) {
        if (course.equals(Course.TOP.getDirection())) {
            return Course.TOP.getNumber();
        }
        return Course.BOTTOM.getNumber();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getMarks() {
        return marks;
    }

    public int getGameCount() {
        return gameCount;
    }

    public String getResultOfGame() {
        return resultOfGame;
    }

    public List<String[]> getMap() {
        return map;
    }
}
