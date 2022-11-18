package bridge;

import java.util.ArrayList;
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
        /**
         * 여기서만 쓰일 것들.
         * NumberConvertor
         */
        List<String> tmp = new ArrayList<>(size);


        NumberConvertor numberConvertor = new NumberConvertor();
        // 위에 이놈 어떡하지.. 어떻게 처리할까

        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            // 랜덤으로 주어지는 0 또는 1 의 값은 쓰일 일이 여기 밖에 없음.
            // U / D 로 여기서 바꿔버려 됨.
            // 어차피 input 값과 비교도 U/D 이니까.
            String upOrDown = numberConvertor.convert(number);
            // 1,0 을 U,D로 바꾸는 기능 따로 빼기.
            // U,D는 상수? 하는게 나을듯
            tmp.add(i, upOrDown); // ex) (U,D,U,U,D,U)
        }

        return tmp;
    }
}
