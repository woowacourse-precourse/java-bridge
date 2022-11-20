package bridge.dto;

public class PathDTO {
    private final String direction;
    private final String pass;

    public PathDTO(String direction, String pass) {
        this.direction = direction;
        this.pass = pass;
    }

    public String getDirection() {
        return direction;
    }

    public String getPass() {
        return pass;
    }
}
