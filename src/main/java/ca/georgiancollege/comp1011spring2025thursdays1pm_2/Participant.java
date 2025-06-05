package ca.georgiancollege.comp1011spring2025thursdays1pm_2;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Participant {

    private String name;
    private Image avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public Participant(String name, Image avatar) {
            setName(name);
            setAvatar(avatar);
    }
    public static List<String> listOfNames(){
        return Arrays.asList("Cool Cat,Sunshine,Reckless Roger".split(","));
    }
    public static List<String> listOfAvatars(){
        return Stream.of("1", "2", "3").map(s-> "avatar" + s).map(s-> s + ".png").toList();
    }
}
