package bridge.enums;

public enum SuccessOrFail {
    Success(true, "성공", "O"),
    Fail(false, "실패", "X");
    //이름 변경
    final private boolean check;
    final private String description;
    final private String show;

    SuccessOrFail(boolean check, String description, String show) {
        this.check = check;
        this.description = description;
        this.show = show;
    }

    public boolean isCheck() {
        return check;
    }

    public String getDescription() {
        return description;
    }

    public String getShow() {
        return show;
    }

    public static boolean getSuccess() {
        return Success.isCheck();
    }

    public static boolean getFail() {
        return Fail.isCheck();
    }

    public static String convertDescription(boolean result) {
        if (Success.isCheck() == result) {
            return Success.getDescription();
        }
        return Fail.getDescription();
    }

    public static String convertShow(boolean result) {
        if (Success.isCheck() == result) {
            return Success.getShow();
        }
        return Fail.getShow();
    }

}
