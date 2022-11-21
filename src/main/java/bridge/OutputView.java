package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    enum Guide {
        START("다리 건너기 게임을 시작합니다."),
        BRIDGESIZEINPUT("다리의 길이를 입력해주세요. (3 이상 20 이하)"),
        MOVECOMMANDINPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        GAMECOMMANDINPUT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        private final String message;
        Guide(String message) { this.message = message; }
    }

    enum Level {
        UP("U"),
        DOWN("D");

        private final String id;
        Level(String id) { this.id = id; }
    }

    /**
     * 현재까지 이동한 경로를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(List<String> path, List<String> bridge) {
        for (Level level : Level.values())
            printMapByLevel(path, bridge, level);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(List<String> path, List<String> bridge, int numberOfTry) {
        printMessage("\n최종 게임 결과");
        printMap(path, bridge);
        String passOrFail = getPassOrFail(path.equals(bridge));
        printMessage("\n게임 성공 여부: " + passOrFail);
        printMessage(String.format("총 시도한 횟수: %d", numberOfTry));
    }

    public void printMessage(String message) { System.out.println(message); }

    public void printNewLine() { System.out.println(""); }

    /**
     * 게임 시작 문구 출력
     */
    public void guideStart() { guide(Guide.START); }

    /**
     * 다리 길이 입력 안내 출력
     */
    public void guideBridgeSizeInput() { guide(Guide.BRIDGESIZEINPUT); }

    /**
     * 이동할 칸 입력 안내 출력
     */
    public void guideMovingCommandInput() { guide(Guide.MOVECOMMANDINPUT); }

    /**
     * 게임 재시작/종료 코드 입력 안내 출력
     */
    public void guideGameCommandInput() { guide(Guide.GAMECOMMANDINPUT); }

    private void guide(Guide guide) {
        printNewLine();
        System.out.println(guide.message);
    }

    private String getSign(String pathAtIndex, String bridgeAtIndex, Level level) {
        if (!pathAtIndex.equals(level.id)) return " ";
        if (pathAtIndex.equals(bridgeAtIndex)) return "O";
        return "X";
    }

    private void printMapByLevel(List<String> path, List<String> bridge, Level level) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int index = 0; index < path.size(); index++) {
            if (index != 0) stringBuilder.append("|");
            String sign = getSign(path.get(index), bridge.get(index), level);
            stringBuilder.append(" ").append(sign).append(" ");
        }
        stringBuilder.append("]");
        printMessage(stringBuilder.toString());
    }

    private String getPassOrFail(boolean pass) {
        if (pass) return "성공";
        return "실패";
    }
}
