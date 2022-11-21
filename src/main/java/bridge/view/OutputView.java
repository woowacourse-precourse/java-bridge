package bridge.view;

import bridge.type.ResultType;
import utils.BridgePrintTool;
import utils.IOMessage;

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
    public static void printMap(List<List<String>> directionTypeLists) {
        printEachMap(directionTypeLists.get(0));
        printEachMap(directionTypeLists.get(1));
    }


    public static void printEachMap(List<String> directionTypeList) {
        printListStart();
        for (String shape : directionTypeList) {
            System.out.print(shape);
        }
        printListEnd();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(ResultType resultType, int tryCnt) {
        System.out.println(IOMessage.GAME_RESULT +  resultType.getResultType());
        System.out.println(IOMessage.TRY_CNT + tryCnt);
    }


    public static final void printGameStartMsg() {
        System.out.println(IOMessage.GAME_START_MSG);
    }

    public static final void printGameEndMsg() {
        System.out.println(IOMessage.GAME_EXIT_MSG);
    }

    public static final void printListStart() {
        System.out.print(BridgePrintTool.START);
    }

    public static final void printListEnd() {
        System.out.print(BridgePrintTool.END);
        System.out.println();
    }
}
