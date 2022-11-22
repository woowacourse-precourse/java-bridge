package bridge;

import camp.nextstep.edu.missionutils.Randoms;

public class BridgeRandomNumberGenerator implements BridgeNumberGenerator {

    // 아래를 0으로 지정
    private static final int RANDOM_LOWER_INCLUSIVE = 0;

    // 위를 1로 지정
    private static final int RANDOM_UPPER_INCLUSIVE = 1;

    // 위(1) or 아래(0) 중 하나를 반환
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }

    public static int generate_num(){
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }
}
