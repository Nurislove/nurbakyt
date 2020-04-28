public class User {
    private int id;
    private static int id_gen = 0;
    private String name;
    private String username;
    private String password;

    public User() {
        generateId();
    }

    public User(String s, String password) {
        this();
        setUsername(s);
        setPassword(password);

    }

    public User(String name, String surname, int id_gen, int id) {
        generateId();
        setName(name);
        setUsername(username);
        this.id = id;
        this.name = name;
        this.username = username;
        setPassword(password);
    }


    private void setPassword(String password) {

        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    private void generateId() {
        id = id_gen++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
