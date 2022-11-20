package bridge.View;

import bridge.Model.Bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final OutputView getInstance = new OutputView();
    private static List<String> bridgeMapUp = new ArrayList<>();
    private static List<String> bridgeMapDown = new ArrayList<>();


    public void init() {
        bridgeMapUp = new ArrayList<>();
        bridgeMapDown = new ArrayList<>();
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge, int count) {
        bridgeMapUp = printBridge(bridge.getUp(), count);
        bridgeMapDown = printBridge(bridge.getDown(), count);

        bridgeMapUp.stream().forEach(System.out::print);
        System.out.println();
        bridgeMapDown.stream().forEach(System.out::print);
        System.out.println();
    }

    private List<String> printBridge(List<String> result, int count) {
        List<String> bridgeMap = new ArrayList<>();
        int resultIndex = 0;
        for(int index = 0; index<count*2+1; index++) {
            if(index == 0) {
                bridgeMap.add("[ ");
                continue;
            }
            if(index%2 != 0) {
                bridgeMap.add(result.get(resultIndex));
                resultIndex++;
                continue;
            }
            if(index%2 == 0 && index != count*2) {
                bridgeMap.add(" | ");
                continue;
            }
            if(index == count*2) {
                bridgeMap.add(" ]");
            }
        }
        return bridgeMap;
    }

    public String getString() {
        StringBuilder output = new StringBuilder();
        for(String input: bridgeMapUp) {
            output.append(input);
        }
        output.append('\n');
        for(String input: bridgeMapDown) {
            output.append(input);
        }
        return output.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        bridgeMapUp.stream().forEach(System.out::print);
        System.out.println();
        bridgeMapDown.stream().forEach(System.out::print);
        System.out.println();
    }
}
