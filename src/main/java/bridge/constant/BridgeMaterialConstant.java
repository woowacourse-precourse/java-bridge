package bridge.constant;

public enum BridgeMaterialConstant {
    FIRST_TYPE_SUCCESS(" O "),
    FIRST_TYPE_FAIL(" X "),
    FIRST_TYPE_BLANK("   "),

    SECOND_TYPE_SUCCESS("| O "),
    SECOND_TYPE_FAIL("| X "),
    SECOND_TYPE_BLANK("|   ");

    final String bridgeMaterial;
    BridgeMaterialConstant(String bridgeMaterial) {
        this.bridgeMaterial = bridgeMaterial;
    }

    public String getBridgeMaterial() {
        return bridgeMaterial;
    }

}
