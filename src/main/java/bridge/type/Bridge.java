package bridge.type;

public enum Bridge {
    UP_CORRECT("U","O"),
    UP_WRONG("U","X"),
    DOWN_CORRECT("U","O"),
    DOWN_WRONG("U","X");

    private String bridgeType;
    private String status;

    private Bridge(String bridgeType,String status) {
        this.bridgeType = bridgeType;
    }

}
