package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge) {
        System.out.println(getMap(bridge.getFootholds(), bridge.getCrossed()));
    }

    public String getMap(List<String> footholds, List<String> crossed) {
        return getCrossedLine("U", footholds, crossed) + "\n" + getCrossedLine("D", footholds, crossed);
    }

    public String getCrossedLine(String lineName, List<String> footholds, List<String> crossed) {
        String line = "[";
        for (int i = 0; i < crossed.size(); i++) {
            line += getStageStatus(lineName, footholds.get(i), crossed.get(i));
            if (i < crossed.size() - 1) {
                line += "|";
            }
        }
        line += "]";
        return line;
    }

    public String getStageStatus(String lineName, String foothold, String input) {
        if (!lineName.equals(input)) {
            return "   ";
        }

        if (foothold.equals(input)) {
            return " O ";
        }

        return " X ";
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge bridge, boolean clear) {
        System.out.println("최종 게임 결과");
        System.out.println(getMap(bridge.getFootholds(), bridge.getCrossed()));
        System.out.println("게임 성공 여부: " + getClearMessage(clear));
        System.out.println("총 시도한 횟수: " + bridge.getTried());
    }

    public String getClearMessage(boolean clear) {
        if (clear) {
            return "성공";
        }
        return "실패";
    }
}
