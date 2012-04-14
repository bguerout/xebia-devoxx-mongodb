package fr.xebia.devoxx.mongodb;

public class Session {

    private String name;
    private int duration;

    public Session(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }
}

