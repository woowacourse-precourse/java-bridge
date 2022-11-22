package bridge.view;

import bridge.domain.BridgeShape;
import bridge.domain.MyBridge;

import java.util.HashMap;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String TRY_CNT = "총 시도한 횟수: %s";
    private static final String SUCCESS = "게임 성공 여부: %s";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(HashMap<String, String> bridgeMap) {
        System.out.println(bridgeMap.get("U"));
        System.out.println(bridgeMap.get("D"));
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(boolean success, MyBridge myBridge, int tryCnt) {
        System.out.println();
        System.out.println("최종 게임 결과");
        BridgeShape.makeLines(myBridge);
        System.out.println(String.format(SUCCESS, successToString(success)));
        System.out.println(String.format(TRY_CNT, tryCnt));
    }

    private static String successToString(boolean success) {
        if (success){
            return "성공";
        }
        return "실패";
    }

    public static void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public static void printInputSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void printMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void printRetry(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
