package view;

import bridge.BridgeDraw;
import game.GameAnnounce;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public String joinLine(List<String> positionMap) {
        return String.join("|", positionMap);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upMap, List<String> downMap) {
        System.out.println("[" + joinLine(upMap) + "]");
        System.out.println("[" + joinLine(downMap) + "]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count, List<String> upMap, List<String> downMap) {
        System.out.println(GameAnnounce.finish.getAnnouncement());
        printMap(upMap, downMap);
        System.out.println(GameAnnounce.fail.getAnnouncement() + count);
    }

    public void printSuccessResult(int count, List<String> upMap, List<String> downMap) {
        System.out.println(GameAnnounce.finish.getAnnouncement());
        printMap(upMap, downMap);
        System.out.println(GameAnnounce.success.getAnnouncement() + count);
    }
}
