package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * @param position 다리의 위치 ( 아래칸, 위칸)
     * @param player   사용자
     *                 <p>
     *                 다리의 size 만큼 사용자는 칸을 선택하여 List 에 담는다.
     */
    public void start(String position, Player player) {
        player.selectPosition(position);
    }


}
