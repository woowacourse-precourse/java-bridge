package generator;

import camp.nextstep.edu.missionutils.Randoms;
import constant.NumberConstant;

public class BridgeRandomNumberGenerator implements BridgeNumberGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(NumberConstant.RANDOM_LOWER_INCLUSIVE.getConstant()
                , NumberConstant.RANDOM_UPPER_INCLUSIVE.getConstant());
    }
}
