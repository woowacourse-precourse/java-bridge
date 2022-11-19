package bridge;

public class Exception {
    public Boolean isEmpty(String checkEmpty) {
        return checkEmpty.isEmpty() && checkEmpty.isBlank();
    }

    public Boolean isRangeInThreeAndTwenty(int bridgeSize) {
        return bridgeSize < 3 || bridgeSize > 20;
    }
}
