package utils;

/**
 * Created by Student11 on 11/27/2014.
 */
public class User {
    private int id;
    private String password;
    private String username;
    private int age;
    private String name;
    private String adress;
    private String role;

    public int getId(){
        return  this.id;
    }


    public String getAdress() {
        if (adress!=null) {
            return adress;
        }else {
            return  "";
        }
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        if (name!=null) {
            return name;
        }else {
            return  "";
        }
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {

        return age;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(int id,String username,String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(int id,String username,String password,String role){
       this(id,username,password);
        this.role=role;
    }



    public User(int id,String password,String username,String role,int age){
        this(id,password,username,role);
        this.age = age;

    }

    public User(int id,String password,String username,String role,int age,String name){
        this(id,password,username,role,age);
        this.name = name;

    }
    public User(int id,String password,String username,String role,int age,String name, String adress){
        this(id,password,username,role,age,name);
        this.adress = adress;
    }




}
