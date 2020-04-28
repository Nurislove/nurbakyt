import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyApplication<currentLine, wiseSaying, fileUser, users> {
    private Scanner sc = new Scanner(System.in);
    private User signedUser;
    private boolean userProfile;
    private ArrayList<User> users;

    public MyApplication(String s) throws IOException {
    }

    public MyApplication(){

        users = new ArrayList<>();
        userProfile();
    }

    private void menu() throws FileNotFoundException {
        while (true) {
            if (signedUser == null) {
                System.out.println("You are not signed in.");
                System.out.println("1. Authentication");
                System.out.println("2. Exit");
                int choice = sc.nextInt();
                if (choice == 1){
                    authentication();
                }
                else break;
            }
            else {
                userProfile();
            }
        }
    }

    private void userProfile() {
        signedUser = null;
    }

    private void logOff() throws FileNotFoundException {
        signedUser = null;
        start();
    }


    private void authentication() throws FileNotFoundException {
        while (true){
            if (signedUser == null){
                System.out.println("1. Sign in");
                System.out.println("2. Sign up");
                System.out.println("3. Exit");
                int choice = sc.nextInt();
                if (choice == 1){
                    signIn();
                }
                else if (choice == 2){
                    signUp();
                }
                else
                    break;
            }
            else{
                System.out.println("1. Sign out");
                System.out.println("2. Exit");
                sc = new Scanner(System.in);
                int choice = sc.nextInt();
                if (choice == 1){
                    logOff();
                }
                else{
                    System.out.println("Good Bye!");
                    return;
                }
            }
        }
    }

    private void signIn() {
        try {
            System.out.println("Your Username:");
            sc = new Scanner(System.in);
            String username = sc.nextLine();
            FileReader reader = new FileReader("db.txt");

            String line;
            boolean existUser = false;
            while ((line = sc.next()) != null) {
                if (username.equals(line.split(" ")[3])){
                    existUser = true;
                    System.out.println("Your Password:");
                    String password = sc.nextLine();
                    if (password.equals(line.split(" ")[4])){
                        System.out.println("You are logged in successfully!");
                        signedUser = new User(line.split(" ")[1], line.split(" ")[2]);
                        reader.close();
                        return;
                    }
                    else{
                        System.out.println("Password is incorrect");
                    }
                }
            }
            if (!existUser){
                System.out.println("No user with such username");
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void signUp() {
        try {
            FileWriter writer = new FileWriter("db.txt", true);
            User user = new User();
            writer.write(user.getId() + " ");
            System.out.println("Enter First Name:");
            sc = new Scanner(System.in);
            String fname = sc.nextLine();
            writer.write(fname + " ");

            System.out.println("Enter Last Name:");
            String lname = sc.nextLine();
            writer.write(lname + " ");

            System.out.println("Enter Username:");
            String username = sc.nextLine();
            writer.write(username + " ");

            System.out.println("Enter Password:");
            String password = sc.nextLine();
            writer.write(password);
            writer.write("\n");
            writer.close();
            System.out.println("You have been registered successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws FileNotFoundException {
        File file = new File("db.txt");
        Scanner fileScanner = new Scanner(file);
        // fill userlist from db.txt

        while (true) {
            System.out.println("Welcome to my application!");
            System.out.println("Select command:");
            System.out.println("1. Menu");
            System.out.println("2. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                menu();
            } else {
                break;
            }
        }

        // save the userlist to db.txt
    }

    private void saveUserList() {
    String content = "";
        for (User user : users ){
            content += user.getName() + " " + user.getUsername() + " " + user.getId() + " " + user.getPassword();
        }
    }

    public static class Program {

        public static void main(String[] args) {
        try {
            File myFile = new File("text.txt");
            if (myFile.createNewFile()){
                System.out.println("File create: " + myFile.getName());
            }else {
                System.out.println("File exists");
            }
        }   catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        }
    }
    

   public static class WriteFile{
        public static void main(String[] args){
            try{
                FileWriter myFile = new FileWriter("file.txt");
                myFile.write("Lisa pretty");
                myFile.close();
                System.out.println("Wrote to the file");
            }catch (IOException e){
                System.out.println("Error");
                e.printStackTrace();
            }
        }
   }

   public class Person{
        private List<Admin> admins;

        public  void user(){
            if (admins!=null)
                for (Admin a : admins) a.user();
                admins.clear();
                admins = null;
        }
   }

   public class Admin{
        private List<Client> clients;
        private Person magazine;

        Admin(Person magaz){
            this.magazine = magaz;
        }

        public void user(){
            for (Client c:clients)
                clients.clear();
            clients = null;
        }
     }

     public  class  Client{
        private String name;
        private List<Admin> realAdmin;

        public void user(){

        }
     }
}
