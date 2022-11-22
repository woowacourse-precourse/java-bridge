package bridge.view;

import bridge.Lang;
import bridge.util.Console;
import java.util.List;

public class OutputView {
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
