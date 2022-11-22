package bridge;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 필드 변경 가능
 * 메서드의 시그니처(인자, 이름)와 반환 타입 변경 불가
 */

public class BridgeRandomNumberGenerator implements BridgeNumberGenerator {

    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;


    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }
}