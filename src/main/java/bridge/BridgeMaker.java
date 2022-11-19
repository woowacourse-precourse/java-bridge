package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> result = new ArrayList<>();
        for(int index = 0; index < size; index++){
            if("U".equals("1")){}
            if("D".equals("0")){
                int number = bridgeNumberGenerator.generate();
                result.add(String.valueOf(number));
                System.out.println(result);
            }
        }

        return result;
    }

    public String OXjudge(String search, int number, String Line){
        char[] charInput = Line.toCharArray();
        if(search.equals("O")){
            charInput[number * 4 + 2] ='O';
        }
        if(search.equals("X")){
            charInput[number * 4 + 2] = 'X';
        }
        return String.valueOf(charInput);
    }

    public List<String> makeFormBridge(String Search, int number, String Line){
        char[] charInput = Line.toCharArray();
        List<String> makeResult = new ArrayList<>();
        if(!Search.equals("[") && Search.equals("]") && Search.equals("|").contains(String.valueOf(charInput[number * 4 + 2]))){
            makeResult.add(Search);
        }
            return mekeResult;
        }
    }



}
