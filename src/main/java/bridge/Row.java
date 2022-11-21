package bridge;

public enum Row {

    DOWN("D"), UP("U");

    private String code;

    Row(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static String getRowCodeByIndex(int index) {
        return values()[index].getCode();
    }
}
