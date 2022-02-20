package institute.immune.e_parte;

/**User class to read table user un our database
 *
 */
public class User {
    private int id;
    private String name;
    private String mail;
    private String password;

    User(int id, String name, String mail, String password){
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
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
