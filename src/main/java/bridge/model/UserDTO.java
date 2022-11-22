package bridge.model;

public class UserDTO {
    private Integer position;
    private Integer count;
    private Boolean result;
    public Integer getPosition(){
        return this.position;
    }
    public Integer getCount(){
        return this.count;
    }
    public Boolean getResult(){return this.result;}
    public void setUserDTO(User user){
        this.position = user.getPosition();
        this.count = user.getCount();
        this.result = user.getResult();
    }
}
