package bridge.view;

import bridge.domain.RoundResult;
import bridge.service.BridgeMapMaker;
import bridge.domain.Constants;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeMapMaker bridgeMapMaker, RoundResult roundResult) {
        if (roundResult.equals(RoundResult.SELECTED_UPPER_CASE_IF_CORRECT)) {
            printPartOfTheMap(bridgeMapMaker.getUpperBridgeMap(), Constants.SUCCESSFUL_CASE_MAP);
            printPartOfTheMap(bridgeMapMaker.getLowerBridgeMap(), Constants.NON_ANSWER_CASE_MAP);
        }

        if (roundResult.equals(RoundResult.SELECTED_UPPER_CASE_IF_WRONG)) {
            printPartOfTheMap(bridgeMapMaker.getUpperBridgeMap(), Constants.FAILED_CASE_MAP);
            printPartOfTheMap(bridgeMapMaker.getLowerBridgeMap(), Constants.NON_ANSWER_CASE_MAP);
        }

        if (roundResult.equals(RoundResult.SELECTED_LOWER_CASE_IF_CORRECT)) {
            printPartOfTheMap(bridgeMapMaker.getUpperBridgeMap(), Constants.NON_ANSWER_CASE_MAP);
            printPartOfTheMap(bridgeMapMaker.getLowerBridgeMap(), Constants.SUCCESSFUL_CASE_MAP);
        }

        if (roundResult.equals(RoundResult.SELECTED_LOWER_CASE_IF_WRONG)) {
            printPartOfTheMap(bridgeMapMaker.getUpperBridgeMap(), Constants.NON_ANSWER_CASE_MAP);
            printPartOfTheMap(bridgeMapMaker.getLowerBridgeMap(), Constants.FAILED_CASE_MAP);
        }
    }

    private static void printPartOfTheMap(StringBuilder priorMap, String roundResult) {
        System.out.print(priorMap);
        System.out.print(roundResult);
        System.out.println(Constants.END_MAP);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
    }
}
