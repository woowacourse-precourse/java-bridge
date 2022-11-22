package bridge.domain;

public enum SuccessOrFail {
    성공(true), 실패(false);

    public boolean isSuccess;

    SuccessOrFail(boolean isSuccessGame) {
        this.isSuccess = isSuccessGame;
    }
}
