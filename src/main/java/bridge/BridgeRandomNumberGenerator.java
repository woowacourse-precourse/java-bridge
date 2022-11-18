package bridge;

import camp.nextstep.edu.missionutils.Randoms;

public class BridgeRandomNumberGenerator implements BridgeNumberGenerator {

    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;


    // 0과 1 중 랜덤으로 하나를 출력하는 것
    // 정답 다리를 정하는 거 같음.
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }

}
