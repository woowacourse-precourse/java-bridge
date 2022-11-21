package bridge.model;

public enum Moving {
    UP("U"),
    DOWN("D");

    private String description;

    Moving(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
