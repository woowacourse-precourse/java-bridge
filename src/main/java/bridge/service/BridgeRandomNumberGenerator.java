package bridge.service;

import camp.nextstep.edu.missionutils.Randoms;

public class BridgeRandomNumberGenerator implements BridgeNumberGenerator {

    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;

    @Override
    public int generate() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
        validGenerateBridgeRandomNumber(randomNumber);
        return randomNumber;
    }

    private void validGenerateBridgeRandomNumber(int number) {
        if (number!=RANDOM_LOWER_INCLUSIVE && number != RANDOM_UPPER_INCLUSIVE) {
            throw new IllegalStateException();
        }
    }
}
