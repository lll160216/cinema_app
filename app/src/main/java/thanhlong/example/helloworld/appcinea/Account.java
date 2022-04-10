package thanhlong.example.helloworld.appcinea;

import android.widget.ImageView;
import android.widget.TextView;

public class Account {
    private int avatar;
    private String name;
    private String codeNumber;

    public Account(int avatar, String name, String codeNumber) {
        this.avatar = avatar;
        this.name = name;
        this.codeNumber = codeNumber;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public String getCodeNumber() {
        return codeNumber;
    }
}
