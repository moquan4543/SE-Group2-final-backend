package edu.ntcu.model;


import java.util.Date;

public class Notification {
    private String content;
    private boolean state;
    private Date timestamp;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Notification() {
    }

    @Override
    public String toString() {
        return "Notification{" +
                "content='" + content + '\'' +
                ", state=" + state +
                ", timestamp=" + timestamp +
                '}';
    }
}
