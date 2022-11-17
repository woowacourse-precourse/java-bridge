package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeRandomNumberGenerator bridgeRandomNumberGenerator) {
        this.bridgeNumberGenerator = bridgeRandomNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<Integer> bridgeNumber = new ArrayList<>(size);

        makeBridgeNumber(bridgeNumberGenerator, bridgeNumber, size);

        return bridgeWinning(bridgeNumber);
    }

    private void makeBridgeNumber(BridgeNumberGenerator bridgeNumberGenerator, List<Integer> numberList, int size){
        while (numberList.size() == size){
            numberList.add(bridgeNumberGenerator.generate());
        }
    }

    private List<String> bridgeWinning(List<Integer> bridgeNumberList){
        List<String> bridgeWinningList = new ArrayList<>(bridgeNumberList.size());
        for(int number : bridgeNumberList){
            bridgeWinningWord(bridgeWinningList,number);
        }
        return bridgeWinningList;
    }

    private void bridgeWinningWord(List<String> bridgeNumberList, int number){
        if(number == 1){
            bridgeNumberList.add("U");
        }
        if(number == 0){
            bridgeNumberList.add("D");
        }
    }
}
