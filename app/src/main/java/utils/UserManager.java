package utils;

import java.util.ArrayList;

/**
 * Created by Student11 on 11/27/2014.
 */


public class UserManager {

    private static int userId = 0;
    private  static ArrayList<User>  allUsers = new ArrayList<User>();
    private static UserManager instance = null;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserManager.currentUser = currentUser;
    }

    private  static User currentUser;

    protected UserManager() {
        // Exists only to defeat instantiation.
    }



    public static UserManager getInstance() {
        if(instance == null) {
            instance = new UserManager();
        }
        return instance;
    }


    public  int getUserId() {

        return ++userId;
    }

    public  void addUser(User newUser){
        allUsers.add(newUser);
    }

    public  ArrayList<User>  getAllUsers(){
       return allUsers;
    }

    public  User  getUserBYid(int id){
        for (int i=0;i<allUsers.size();i++){
            if (allUsers.get(i).getId()==id){
                return allUsers.get(i);
            }
        }
        return  null;
    }

    public  void  removeById(int id){
        for (int i=0;i<allUsers.size();i++){
            if (allUsers.get(i).getId()==id){
                allUsers.remove(allUsers.get(i));
                break;
            }
        }
        return;
    }


    public  User  getUserByNameAndPassword(String useraneme,String password){
        for (int i=0;i<allUsers.size();i++){
            if (allUsers.get(i).getUsername().equals(useraneme) && allUsers.get(i).getPassword().equals(password)){
                return allUsers.get(i);
            }
        }
        return  null;
    }
}