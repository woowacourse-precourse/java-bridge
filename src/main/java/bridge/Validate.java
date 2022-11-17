package bridge;

public class Validate {
    // TODO: 사용자로부터 입력받은 다리의 개수를 검증하여 반환한다.
    public static int bridgeSize(String bridgeSize){
        return Exception.validateRangeThreeToTwenty
                (Exception.convertStringToInteger(bridgeSize));
    }
}
