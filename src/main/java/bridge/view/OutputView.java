package bridge.view;

import bridge.model.BridgeGame;
import bridge.model.Result;

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
    public static void printMap(int index, List<String> bridge) {
        String[] map = makeMap(index, bridge);
        System.out.println(map[0]);
        System.out.println(map[1]);

    }

    public static void printMapFail(int index, List<String> bridge) {
        String[] map = makeMap(index, bridge);
        StringBuffer Up = new StringBuffer();StringBuffer Down = new StringBuffer();
        Up.append(map[0]);Down.append(map[1]);
        if(Up.charAt(Up.length()-3) != 'O'){
            Up.replace(Up.length()-3,Up.length()-2,"X");Down.replace(Down.length()-3,Down.length()-2," ");
        }
        if(Down.charAt(Down.length()-3) != 'O'){
            Down.replace(Down.length()-3,Down.length()-2,"X");Up.replace(Up.length()-3,Up.length()-2," ");
        }
        System.out.println(Up);System.out.println(Down);
    }

    private static String[] makeMap(int index, List<String> bridge) {
        StringBuilder Up = new StringBuilder("[");StringBuilder Down = new StringBuilder("[");
        for (String block : bridge.subList(0,index+1)) {
            if (block.equals("U")) {
                Up.append(" O ");Down.append("   ");
            }
            if (block.equals("D")) {
                Up.append("   ");Down.append(" O ");
            }
            Up.append("|");Down.append("|");
        }
        Up.replace(Up.length()-1,Up.length(),"]");Down.replace(Down.length()-1,Down.length(),"]");
        return new String[]{Up.toString(), Down.toString()};
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(Result result,BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printFinalMap(result,bridgeGame);
        System.out.print("게임 성공 여부: ");
        System.out.println(checkIsDone(result.getIsDone()));
        System.out.println("총 시도한 횟수: "+result.getAttemptCount());


    }
    private static void printFinalMap(Result result,BridgeGame bridgeGame){
        if (result.getIsDone()){
            printMap(bridgeGame.getLength()-1,bridgeGame.getBridge());
            return;
        }
        printMapFail(bridgeGame.getPlayerFinalIndex(),bridgeGame.getBridge());
    }
    private static String checkIsDone(boolean isDone){
        if(isDone)
            return "성공";
        return "실패";
    }

    public static void printException(Exception exception) {
        System.out.printf(exception.getMessage() + System.lineSeparator());
    }
}
