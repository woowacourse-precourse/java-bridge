package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(List<String> bridge, List<String> userPath) {
        String map = makeWholeMap(bridge, userPath);
        System.out.println(map);
    }

    private String makeWholeMap(List<String> bridge, List<String> userPath) {
        String upperMap = "" + makeUpperMap(bridge,
                userPath, new StringBuilder("["));
        String lowerMap = "" + makeLowerMap(bridge,
                userPath, new StringBuilder("["));

        return upperMap + '\n' + lowerMap;
    }
    private StringBuilder makeUpperMap(List<String> bridge, List<String> userPath, StringBuilder upperMap) {
        for (int position = 0; position < userPath.size(); position++) {
            upperMap.append(selectUpperBlock(bridge.get(position), userPath.get(position)));
            upperMap.append("|");
        }
        upperMap.deleteCharAt(upperMap.length()-1);
        return upperMap.append("]");
    }

    private String selectUpperBlock(String nowBridge, String nowUser) {
        if (nowBridge.equals("D") && nowUser.equals("U")) {
            return " X ";
        }
        if (nowBridge.equals("U") && nowUser.equals("U")) {
            return " O ";
        }
        return "   ";
    }

    private StringBuilder makeLowerMap(List<String> bridge, List<String> userPath, StringBuilder lowerMap) {
        for (int position = 0; position < userPath.size(); position++) {
            lowerMap.append(selectLowerBlock(bridge.get(position), userPath.get(position)));
            lowerMap.append("|");
        }
        lowerMap.deleteCharAt(lowerMap.length()-1);
        return lowerMap.append("]");
    }

    private String selectLowerBlock(String nowBridge, String nowUser) {
        if (nowBridge.equals("U") && nowUser.equals("D")) {
            return " X ";
        }
        if (nowBridge.equals("D") && nowUser.equals("D")) {
            return " O ";
        }
        return "   ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMapResult(List<String> bridge, List<String> userPath) {
        System.out.println("\n최종 게임 결과");
        printMap(bridge, userPath);
    }

    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printGameResult(boolean result) {
        System.out.println("\n게임 성공 여부: " + getGameResult(result));
    }

    public String getGameResult(boolean result) {
        if (result) {
            return "성공";
        }
        return "실패";
    }

    public void printTotalTry(int tryCount) {
        System.out.println(String.format("총 시도한 횟수: %d", tryCount));
    }
}
