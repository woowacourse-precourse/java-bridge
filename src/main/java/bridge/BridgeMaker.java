package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.util.Lists.newArrayList;

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
        List<String> choice = new ArrayList<>();
        for(int i = 0;i<size;i++){
           choice.add(i,Answer());
        }
        return choice;
    }

    private int InputAnswer(){

        BridgeNumberGenerator gn = new BridgeRandomNumberGenerator();
        int randomNumber = bridgeNumberGenerator.generate();
        return randomNumber;
    }

    private String Answer(){
        int randomNumber = InputAnswer();
        String answer = null;
        if(randomNumber == 1){
           answer = "U";
        } if(randomNumber == 0) {
            answer = "D";
        }
        return answer;
    }

}
