package bridge;

import domain.Bridge;
import domain.MoveStatus;
import domain.OutPutMessage;

import java.util.ArrayList;
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
    public void printMap(Bridge bridge) {
        List<String> upBridge = new ArrayList<>();
        List<String> downBridge = new ArrayList<>();
        for (MoveStatus out : bridge.getResult()) {
            String[] split = out.toString().split(OutPutMessage.SPLIT_TYPE.get());
            upBridge.add(split[0]);
            downBridge.add(split[1]);
        }
        System.out.println(OutPutMessage.LEFT_BRIDGE.get() + toDrawing(upBridge) + OutPutMessage.RIGHT_BRIDGE.get());
        System.out.println(OutPutMessage.LEFT_BRIDGE.get() + toDrawing(downBridge) + OutPutMessage.RIGHT_BRIDGE.get());
    }

    private String toDrawing(List<String> bridge) {
        if(bridge.size() == 1){
            return bridge.get(0);
        }
        StringBuilder sb = new StringBuilder();
        for (String out : bridge) {
            sb.append(out).append(OutPutMessage.PARTITION.get());
        }
        return deleteLastPartition(sb);
    }

    private String deleteLastPartition(StringBuilder sb) {
        return sb.delete(sb.length() - 3, sb.length()).toString();
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge bridge, int count) {
        System.out.println(OutPutMessage.END_MESSAGE.get());
        printMap(bridge);
        System.out.println(OutPutMessage.IS_GAME_CLEAR.get() + statusToString(bridge.isWrong()));
        System.out.println(OutPutMessage.TOTAL_GAME_COUNT.get() + count);
    }

    private String statusToString(boolean status) {
        if(status){
            return OutPutMessage.GAME_FAIL.get();
        }
        return OutPutMessage.GAME_CLEAR.get();
    }
}
