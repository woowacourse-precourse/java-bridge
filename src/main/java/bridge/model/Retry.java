package bridge.model;

public enum Retry {
    RETRY("R"),
    QUIT("Q");

    private String description;

    Retry(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
