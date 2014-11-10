package demo.domain;

public class User {

    private String id;

    private String username;

    private String givenName;

    private String familyName;

    public User() {
    }

    public User(String givenName, String familyName) {
        this.username = givenName.toLowerCase() + "." + familyName.toLowerCase();
        this.givenName = givenName;
        this.familyName = familyName;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, userName='%s' givenName='%s', familyName='%s']",
                id, username, givenName, familyName);
    }

}
