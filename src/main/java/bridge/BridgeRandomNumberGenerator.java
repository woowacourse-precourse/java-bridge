package bridge;

import camp.nextstep.edu.missionutils.Randoms;

// generate사용해서 Random값 추출
// 코드 변경 불가

public class BridgeRandomNumberGenerator implements BridgeNumberGenerator {

    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }
}
