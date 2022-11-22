package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Map<Integer,String> printMap(List<String> bridgeU, List<String> bridgeD) {
        Map map = new HashMap<>();
        String str_BridgeU = str_BridgeUD(bridgeU);
        String str_BridgeD = str_BridgeUD(bridgeD);
        String re_BridgeU = bridgeReplace(str_BridgeU);
        String re_BridgeD = bridgeReplace(str_BridgeD);
        System.out.println(re_BridgeU);
        System.out.println(re_BridgeD);
        map.put(0,re_BridgeU);
        map.put(1,re_BridgeD);
        return map;
    }

    public String str_BridgeUD(List<String> bridge_U_Or_D) {
        String bridgeOX = bridge_U_Or_D.toString();
        return bridgeOX;
    }

    public String bridgeReplace(String str_Bridge) {
        String bridgeRe = str_Bridge.replaceAll(",", "|")
                .replaceFirst("\\[", "[ ")
                .replaceAll("  ", "   ");
        return bridgeRe;
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
