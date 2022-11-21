package bridge;

public enum Success {

    SUCCESS(true, Constant.SUCCESS),
    FAIL(false,Constant.FAIL);
    private final boolean isSuccess;
    private final String isSuccessWord;
    Success(boolean b, String s) {
        isSuccess=b;
        isSuccessWord=s;
    }
    public boolean getIsSuccess(){
        return isSuccess;
    }
    public String getIsSuccessWord(){
        return isSuccessWord;
    }
}
