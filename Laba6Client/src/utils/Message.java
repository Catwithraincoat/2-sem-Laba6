package utils;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 57L;
    public String str;

    public Message(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
