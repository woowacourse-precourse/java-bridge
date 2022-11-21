package bridge;

import camp.nextstep.edu.missionutils.Randoms;

import static bridge.utils.constant.Constants.*;

public class BridgeRandomNumberGenerator implements BridgeNumberGenerator {



    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }
}
