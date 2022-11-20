package bridge.view;

import bridge.command.MarkCommand;
import bridge.command.MovingCommand;
import bridge.controller.BridgeGame;
import bridge.view.phrases.OutputPhrases;
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

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame, int numberOfAttempts) {
        System.out.println(OutputPhrases.finalGameResult.getPhrase());
        printMap(bridgeGame.getBridge(), bridgeGame.getResult());
        System.out.println();
        System.out.println(OutputPhrases.gameStatus.getPhrase().concat(gameStatus(bridgeGame)));
        System.out.println(OutputPhrases.numberOfAttempts.getPhrase().concat(Integer.toString(numberOfAttempts)));
    }

    private static String gameStatus(BridgeGame bridgeGame) {
        if(!bridgeGame.isComplete()) return "실패";
        return "성공";
    }

    public static void printStart() {
        System.out.println(OutputPhrases.startGame.getPhrase());
    }
}
