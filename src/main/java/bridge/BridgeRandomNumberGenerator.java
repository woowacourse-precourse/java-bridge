package bridge;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * Random 값 추출은 제공된 bridge.BridgeRandomNumberGenerator의 generate()를 활용한다.
 * BridgeRandomNumberGenerator, BridgeNumberGenerator 클래스의 코드는 변경할 수 없다.
 * 다리 칸을 생성하기 위한 Random 값은 아래와 같이 추출한다.
*/
public class BridgeRandomNumberGenerator implements BridgeNumberGenerator {

    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }
}
