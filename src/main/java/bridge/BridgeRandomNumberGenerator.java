package bridge;

import camp.nextstep.edu.missionutils.Randoms;

public class BridgeRandomNumberGenerator implements BridgeNumberGenerator {

    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;

    // BridgeNumberGenerator를 상속받고, generate를 재정의한다.
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }
}
