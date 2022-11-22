package bridge;

import java.util.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(UpperBridge upperBridge, LowerBridge lowerBridge) {
        // should also user enum here
//        for (String b: bridgeCheck){
////            System.out.printf("%s","O");
//            System.out.println(b);
//        }
//        int OArray = bridgeCheck.indexOf(String.valueOf('0'));
//        System.out.println("this is O array"+bridgeCheck.indexOf(String.valueOf('O')));
//        System.out.println("this is X array"+bridgeCheck.indexOf(String.valueOf('X')));

        final String joinUpperBridge = String.join(" | ",upperBridge.upperStatus);
        final String joinLowerBridge = String.join(" | ",lowerBridge.lowerStatus);
        System.out.printf("[ %s ]\n",joinUpperBridge);
        System.out.printf("[ %s ]\n",joinLowerBridge);
        // think that we are checking twice
        // first if there's 1 > 0 / second if there's 0 > 0
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String successOrFail, UpperBridge upperBridge, LowerBridge lowerBridge) {

        System.out.println("최종 게임 결과");
//        String joinUpperBridge = upperBridge.printBridge();
//        String joinLowerBridge = lowerBridge.printBridge();
//        System.out.printf("[%s]\n[%s]\n", joinUpperBridge, joinLowerBridge);
        printMap(upperBridge, lowerBridge);
        System.out.println();
        System.out.printf("게임 성공 여부: %s\n",successOrFail);
        System.out.printf("총 시도한 횟수: %s\n",BridgeGame.allTryCount);

    }
}
