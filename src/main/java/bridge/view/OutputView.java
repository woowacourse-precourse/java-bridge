package bridge.view;

import bridge.Env;
import bridge.Lang;
import bridge.util.Console;

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
    public void printMap(List<List<String>> maps) {
        maps.forEach(map -> Console.printLine(this.affixMapDelimiter(map)));
        Console.printLine("");
    }

    private String affixMapDelimiter(List<String> map) {
        return String.format(
                "[ %s ]",
                String.join(" | ", map)
        );
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> maps, boolean isPass, int tries) {
        Console.printLine(Lang.get(Lang.GAME_RESULT));

        this.printMap(maps);

        Console.printLine(Lang.format(Lang.IS_GAME_PASS, this.getGameStatusText(isPass)));
        Console.printLine(Lang.format(Lang.TOTAL_ATTEMPT, tries));
    }

    private String getGameStatusText(boolean isPass) {
        if (isPass) {
            return Lang.get(Lang.GAME_IS_PASS);
        }

        return Lang.get(Lang.GAME_IS_FAIL);
    }
}
