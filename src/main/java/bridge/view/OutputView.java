package bridge.view;

import bridge.command.MarkCommand;
import bridge.command.MovingCommand;
import bridge.service.BridgeGameService;
import bridge.view.phrases.OutputPhrases;
import java.util.List;

public class OutputView {

    public static void printMap(List<String> bridge, List<String> result) {
        System.out.println(upstairs(bridge, result));
        System.out.println(downstairs(bridge, result));
    }

    private static String upstairs(List<String> bridge, List<String> result) {
        return getString(bridge, result, MovingCommand.UpStairs.get());
    }

    private static String downstairs(List<String> bridge, List<String> result) {
        return getString(bridge, result, MovingCommand.DownStairs.get());
    }

    private static String getString(List<String> bridge, List<String> result, String stair) {
        StringBuilder sb = new StringBuilder("[ ");

        for(int i=0; i<result.size(); i++) {
            sb.append(getMarkCommand(bridge.get(i), result.get(i), stair));
            sb.append(" | ");
        }

        return sb.replace(sb.length()-2, sb.length()-1, "]").toString();
    }

    private static String getMarkCommand(String bridgeMark, String resultMark, String stair) {
        if(bridgeMark.equals(stair) && resultMark.equals(MarkCommand.Possible.get())) {
            return MarkCommand.Possible.get();
        }
        if(!bridgeMark.equals(stair) && resultMark.equals(MarkCommand.Impossible.get())) {
            return MarkCommand.Impossible.get();
        }
        return " ";
    }

    public static void printResult(BridgeGameService bridgeGameService, int numberOfAttempts) {
        System.out.println(OutputPhrases.finalGameResult.getPhrase());
        printMap(bridgeGameService.getBridge(), bridgeGameService.getResult());
        System.out.println();
        System.out.println(OutputPhrases.gameStatus.getPhrase().concat(gameStatus(bridgeGameService)));
        System.out.println(OutputPhrases.numberOfAttempts.getPhrase().concat(Integer.toString(numberOfAttempts)));
    }

    private static String gameStatus(BridgeGameService bridgeGameService) {
        if(!bridgeGameService.isComplete()) return "실패";
        return "성공";
    }

    public static void printStart() {
        System.out.println(OutputPhrases.startGame.getPhrase());
    }
}
