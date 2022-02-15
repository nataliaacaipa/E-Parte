package institute.immune.e_parte;

public class User {
    private int id;
    private String name;
    private String mail;
    private String password;

    User(int i, String n, String m, String p){
        id = i;
        name = n;
        mail = m;
        password = p;
    }


    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
