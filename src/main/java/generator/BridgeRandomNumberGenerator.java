package generator;

import camp.nextstep.edu.missionutils.Randoms;
import constant.NumberConstant;

public class BridgeRandomNumberGenerator implements BridgeNumberGenerator {
    private static final int RANDOM_UPPER_INCLUSIVE = NumberConstant.RANDOM_UPPER_INCLUSIVE.getConstant();
    private static final int RANDOM_LOWER_INCLUSIVE = NumberConstant.RANDOM_LOWER_INCLUSIVE.getConstant();

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }
}
