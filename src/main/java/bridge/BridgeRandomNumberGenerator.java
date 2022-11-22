package bridge;

import camp.nextstep.edu.missionutils.Randoms;

public class BridgeRandomNumberGenerator implements BridgeNumberGenerator {

    public static final int RANDOM_LOWER_INCLUSIVE = 0;
    public static final int RANDOM_UPPER_INCLUSIVE = 1;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }

}
