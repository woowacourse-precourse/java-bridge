package bridge.View;

import static bridge.Type.OutputMsg.*;

import bridge.Type.DirectionType;
import bridge.Domain.Record;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printBridgeLengthMsg() {
        System.out.println("\n"+BRIDGE_LENGTH_MSG.getMsg());
    }
    public static void printStartGameMsg() {
        System.out.println(START_MSG.getMsg());
    }
    public static void printRetryQuitMsg() {
        System.out.println("\n"+CHOOSE_RETRY_QUIT_MSG.getMsg());
    }
    public static void printResultMsg() {
        System.out.println("\n"+RESULT_MSG.getMsg());
    }
    public static void printMovingMsg() {
        System.out.println("\n"+CHOOSE_UPDOWN_MSG.getMsg());
    }
    public static void printIsSuccessMsg() {
        System.out.print("\n"+ISSUCCESS_MSG.getMsg());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> movingRecord, List<String> bridge) {
        printOneMap(movingRecord, bridge, 1);
        printOneMap(movingRecord, bridge, 0);
    }

    public static void printOneMap(List<String> movingRecord, List<String> bridge, int maptype) {
        System.out.print("[ ");
        for (int i = 0; i < movingRecord.size(); i++) {
            System.out.print(DirectionType.findByString(bridge.get(i))
                .mapMakeByDirection(movingRecord.get(i), maptype));
            if (i != movingRecord.size() - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(Record movingRecord, List<String> bridge, boolean successFlag) {
        printResultMsg();
        printMap(movingRecord.getRecord(), bridge);
        printIsSuccessMsg();
        if (successFlag) {
            System.out.println("성공");
        }
        if (!successFlag) {
            System.out.println("실패");
        }
        System.out.println(SUM_OF_RETRY_COUNT.getMsg() + movingRecord.getRetryCount());
    }
}
