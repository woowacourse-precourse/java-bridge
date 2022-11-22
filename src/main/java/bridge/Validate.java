package bridge;

public class Validate {
    // TODO: 사용자로부터 입력받은 다리의 개수를 검증하여 반환한다.
    public static int bridgeSize(String bridgeSize){
        return Exception.validateRangeThreeToTwenty
                (Exception.convertStringToInteger(bridgeSize));
    }

    // TODO: 사용자로부터 입력받은 이동할 칸을 검증하여 반환한다.
    public static String moving(String moving){
        return Exception.validateInputValueForMove(moving);
    }

    // TODO: 사용자로부터 입력받은 게임 재시작 여부를 검증하여 반환한다.
    public static String gameCommend(String gameCommend){
        return Exception.validateInputValueForReStart(gameCommend);
    }
}
