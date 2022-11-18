package generator;

import camp.nextstep.edu.missionutils.Randoms;
import constant.GameConstant;

public class BridgeRandomNumberGenerator implements BridgeNumberGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(GameConstant.RANDOM_LOWER_INCLUSIVE.getConstant()
                , GameConstant.RANDOM_UPPER_INCLUSIVE.getConstant());
    }
}
