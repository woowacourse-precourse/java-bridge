package bridge.domain;

public class Count {
    public static int tryCount = 0;
    public static int passCount = 0;

    public static int crossCount = 0;

    public static int getTryCount() {
        return tryCount;
    }

    public static void setTryCount(int tryCount) {
        Count.tryCount = tryCount;
    }

    public static int getPassCount() {
        return passCount;
    }

    public static void setPassCount(int passCount) {
        Count.passCount = passCount;
    }
}
