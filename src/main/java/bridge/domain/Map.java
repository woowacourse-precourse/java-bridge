package bridge.domain;

import static org.assertj.core.util.Lists.newArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * 현재 진행 상황을 출력하는 로직
 */
public class Map {
    private List<String> passedPath;
    private List<String> arePaths;

    public Map() {
        passedPath = new ArrayList<>();
        arePaths = new ArrayList<>();
    }

    /**
     * 게임 진행에 따라 지도(게임 경과)를 업데이트
     *
     * @param direction: 이동 방향 (U, D)
     * @param isPath:    정답 경로 여부
     */
    public void update(String direction, boolean isPath) {
        passedPath.add(direction);
        if (isPath) {
            arePaths.add(Mark.PATH.toString());
            return;
        }
        if (!isPath) {
            arePaths.add(Mark.BLOCK.toString());
        }
    }

    /**
     * 현재 진행상황을 정해진 형식에 맞추어 반환
     *
     * @return: upperPath와 lowerPath 순으로 담긴 List
     */
    public List<String> getCurrentMap() {
        validateSameArrayLength();
        List<String> upperPath = new ArrayList<>();
        List<String> lowerPath = new ArrayList<>();
        for (int i = 0; i < passedPath.size(); i++) {
            fillPaths(upperPath, lowerPath, i);
        }
        return newArrayList(makePathStringFormat(upperPath), makePathStringFormat(lowerPath));
    }

    public List<String> getPassedPath() {
        return passedPath;
    }

    private void fillPaths(List<String> upperPath, List<String> lowerPath, int index) {
        String direction = passedPath.get(index);
        String isAnswer = arePaths.get(index);
        if (direction.equals(Direction.UP.toString())) {
            fillUpperPath(upperPath, lowerPath, isAnswer);
            return;
        }
        if (direction.equals(Direction.DOWN.toString())) {
            fillLowerPath(upperPath, lowerPath, isAnswer);
        }
    }

    private void fillUpperPath(List<String> upperPath, List<String> lowerPath, String isAnswer) {
        upperPath.add(isAnswer);
        lowerPath.add(Mark.UNKNOWN.toString());
    }

    private void fillLowerPath(List<String> upperPath, List<String> lowerPath, String isAnswer) {
        upperPath.add(Mark.UNKNOWN.toString());
        lowerPath.add(isAnswer);
    }

    private void validateSameArrayLength() {
        if (passedPath.size() != arePaths.size()) {
            throw new IllegalStateException("[ERROR] 진행 경과를 기록한 리스트와 정답을 기록한 리스트의 길이가 다릅니다.");
        }
    }

    private String makePathStringFormat(List<String> path) {
        return "[ " + String.join(" | ", path) + " ]";
    }
}
