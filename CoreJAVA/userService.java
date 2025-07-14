import java.util.HashMap;
import java.util.Map;

public class userService {
    Map<String,User> userMap=new HashMap<>();
    private User currentUser=null;
    public boolean registerUser(String username,String password,String fullname,String contact ){
        if (userMap.containsKey(username)){
            System.out.println(" This Username is not Available ");
            return false;
        }
        User user=new User(username,password,fullname,contact);
        userMap.put(username,user);
        System.out.println("Registration Successfull");
        currentUser=new User(username, password, fullname, contact);

        return true;
    }
    public boolean login(String username,String password){
        if (!userMap.containsKey(username)){
            System.out.println(" This Username not exist");
            return false;
        }
        User user=userMap.get(username);
        if (!userMap.get(password).getPassword().equalsIgnoreCase(password)){
            System.out.println("Incorrect Password");
            return false;
        }
        currentUser=user;
        System.out.println("Welcome "+currentUser.getFullname());
        return true;
    }
    public void logoutUser(){
        if (currentUser!=null){
            System.out.println("Logout out"+currentUser.getFullname());
        }
        currentUser=null;

    }

    public User getCurrentUser() {
        return currentUser;
    }
    public boolean isLoggedIn(){
        return currentUser!=null;
    }
}
