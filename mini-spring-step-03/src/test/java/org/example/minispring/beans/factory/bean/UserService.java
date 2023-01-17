package org.example.minispring.beans.factory.bean;

/**
 * @author lks
 */
public class UserService {
    private String userName;

    public UserService() {
    }

    public String id;

    @Override
    public String toString() {
        return "UserService{" +
                "userName='" + userName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserService(String userName) {
        this.userName = userName;
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息方法");
    }

    private void query(){
        System.out.println("查询");
    }
}
