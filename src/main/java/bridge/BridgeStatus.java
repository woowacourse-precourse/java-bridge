package bridge;

public enum BridgeStatus {
    DOWN(0, "D"),
    UP(1, "U");

    private final int statusNumber;
    private final String statusLetter;

    BridgeStatus(int statusNumber, String statusLetter) {
        this.statusNumber = statusNumber;
        this.statusLetter = statusLetter;
    }

    public static String convertNumberToLetter(int number) {
        for (BridgeStatus bridgeStatus : BridgeStatus.values()) {
            if (bridgeStatus.statusNumber == number) {
                return bridgeStatus.statusLetter;
            }
        }
        return null;
    }

    public static int convertLetterToNumber(String letter) {
        for (BridgeStatus bridgeStatus : BridgeStatus.values()) {
            if (bridgeStatus.statusLetter.equals(letter)) {
                return bridgeStatus.statusNumber;
            }
        }
        return 0;
    }

    public int getStatusNumber() {
        return this.statusNumber;
    }
}
