package fr.xebia.devoxx.mongodb;

public class Speaker {

    private String login;
    private String fullname;
    private Session session;

    public Speaker(String login, String fullname, Session session) {
        this.login = login;
        this.fullname = fullname;
        this.session = session;
    }

    public Speaker(String login, String fullname) {
        this.login = login;
        this.fullname = fullname;
    }

    public Session getSession() {
        return session;
    }

    public String getFullname() {
        return fullname;
    }

    public String getLogin() {
        return login;
    }
}
