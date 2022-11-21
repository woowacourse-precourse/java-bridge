package bridge.utils;

public enum MapType {
    U_O("U", true, " O "),
    U_X("U", false, " X "),
    D_O("D", true, " O "),
    D_X("D", false, " X ");

    private String stairs;
    private boolean isPass;
    private String mapValue;

    MapType(String stairs, boolean isPass, String mapValue) {
        this.stairs = stairs;
        this.isPass = isPass;
        this.mapValue = mapValue;
    }

    public String getStairs() {
        return stairs;
    }

    public boolean isPass() {
        return isPass;
    }

    public String getMapValue() {
        return mapValue;
    }


}
