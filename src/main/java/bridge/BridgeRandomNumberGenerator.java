package bridge;

import camp.nextstep.edu.missionutils.Randoms;

public class BridgeRandomNumberGenerator implements BridgeNumberGenerator {

    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }
}

// 추가된 요구 사항
// 1.Random 값 추출은 제공된 bridge.BridgeRandomNumberGenerator의 generate()를 활용
// 2.BridgeRandomNumberGenerator, BridgeNumberGenerator 클래스의 코드는 변경 불가능