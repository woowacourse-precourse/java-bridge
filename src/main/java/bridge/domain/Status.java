package bridge.domain;


public enum Status{
    START(true),
    FAIL(false),
    SUCCESS(true);

    private boolean status;
    Status(boolean status){
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
