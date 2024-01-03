package app.example.app.Entities;

public class HelloMessage {

    private String username;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.username = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
