package bridge;

public enum RetryResponse {
    R, Q;
    public static RetryResponse of(String value){
        if(value.equals("R"))return RetryResponse.R;
        if(value.equals("Q"))return RetryResponse.Q;
        throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해주세요");
    }
}
