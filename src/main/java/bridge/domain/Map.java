package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 현재 진행 상황을 출력하는 로직
 */
public class Map {
    List<String> upperPath;
    List<String> lowerPath;

    public Map() {
        upperPath = new ArrayList<>();
        lowerPath = new ArrayList<>();
    }

    /**
     * 현재 진행 상황을 업데이트하는 메소드
     * @param direction: 사용자가 입력 방향(U, D)
     * @param answer: 정답 방향(U, D)
     */
    public void update(String direction, String answer) {
        String mark;
        if (direction.equals(answer)) {
            mark = Mark.PATH.toString();
        } else {
            mark = Mark.BLOCK.toString();
        }

        if (direction.equals(Direction.UP.toString())) {
            upperPath.add(mark);
            lowerPath.add(Mark.UNKNOWN.toString());
        }
        if (direction.equals(Direction.DOWN.toString())) {
            upperPath.add(Mark.UNKNOWN.toString());
            lowerPath.add(mark);
        }
    }

    /**
     * 현재 진행상황을 정해진 형식에 맞추어 반환
     * @return: upperPath와 lowerPath 순으로 담긴 List
     */
    public List<String> getCurrentMap() {
        return List.of(makePathStringFormat(upperPath), makePathStringFormat(lowerPath));
    }

    private String makePathStringFormat(List<String> path) {
        return "[ " + String.join(" | ", path) + " ]";
    }
}
