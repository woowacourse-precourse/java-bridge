package bridge.domain;

import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;

/**
 * 플레이어 상태 관리
 */
public class Player {
    private final List<String> DIRECTIONS = newArrayList(
            Direction.DOWN.toString(), Direction.UP.toString());
    private Map map;
    private boolean isAlive;

    public Player(Map map) {
        this.map = map;
        this.isAlive = true;
    }

    /**
     * 플레이어 이동에 따라 생사여부(게임 실패 여부)와 지도 업데이트
     *
     * @param direction: 이동 방향(U, D)
     * @param answer:    정답 방향(U, D)
     */
    public boolean move(String direction, String answer) {
        validateDirection(direction);
        isAlive = direction.equals(answer);
        map.update(direction, isAlive);
        return isAlive;
    }

    /**
     * 메소드 호출 시점까지의 진행 경과 반환
     *
     * @return 메소드 호출 시점까지의 진행 경과
     */
    public List<String> checkMap() {
        return map.getCurrentMap();
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean hasSucceeded(List<String> bridge) {
        return map.getPassedPath().equals(bridge);
    }

    private void validateDirection(String direction) {
        if (!DIRECTIONS.contains(direction)) {
            throw new IllegalArgumentException("[ERROR] 이동 방향은 U 혹은 D만 입력할 수 있습니다.");
        }
    }
}
