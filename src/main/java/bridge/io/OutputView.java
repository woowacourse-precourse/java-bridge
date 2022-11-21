package bridge.io;

/*
* OutputView 패키지는 변경할 수 있다.
* OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경가능하다.
* 값 출력을 위해 필요한 메서드를 추가할 수 있다.
*  */

import bridge.game.BridgeGame;
import bridge.model.Model;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap() {
        String upperStep1 = replaceCommaToBar(Model.upperBridgeMap.toString());
        String upperStep2 = extractInBracket(upperStep1);
        System.out.println("[ " + upperStep2 + " ]");

        String lowerStep1 = replaceCommaToBar(Model.lowerBridgeMap.toString());
        String lowerStep2 = extractInBracket(lowerStep1);
        System.out.println("[ " + lowerStep2 + " ]");

        System.out.println();
    }
    private static String replaceCommaToBar(String string) {
        return string.replace(",", " |");
    }
    private static String extractInBracket(String string) {
        return string.substring(1,string.length()-1);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
        System.out.println("최종 게임 결과");
        printMap();
        System.out.println("게임 성공 여부: " + printGameResult());
        System.out.println("총 시도한 횟수: " + BridgeGame.tryCount);
    }
    private static String printGameResult() {
        int lastIndexOfBridge = Model.upperBridgeMap.size()-1;
        String upperLast = Model.upperBridgeMap.get(lastIndexOfBridge);
        String lowerLast = Model.lowerBridgeMap.get(lastIndexOfBridge);
        if (upperLast.equals("O") || lowerLast.equals("O")) {
            return "성공";
        }
        return "실패";
    }
}
