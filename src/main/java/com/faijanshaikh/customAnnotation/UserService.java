package main.java.com.faijanshaikh.customAnnotation;


public class UserService {
    @AdminOnly(admin = "user")
    @AdminOnly(admin = "user1")
    @AdminOnly(admin = "user2")
    public void deleteUser() {
        System.out.println("user deleted");
    }
}
