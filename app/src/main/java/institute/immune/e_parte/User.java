package institute.immune.e_parte;

public class User {
    int id;
    String name;
    String mail;

    User(int i, String n, String c){
        id = i;
        name = n;
        mail = c;
    }

    @Override
    public String toString() {

        return name + mail;
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
}
