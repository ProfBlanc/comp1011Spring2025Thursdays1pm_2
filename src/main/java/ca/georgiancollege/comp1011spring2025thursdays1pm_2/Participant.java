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

       Stream<Integer> s0 =  Stream.of(1, 2, 3);
       Stream<Boolean> s1 = Stream.of(true, false);
       Stream<Double> s2 = Stream.of(2.1, 1.1, 3.1, 55d, (double)100);

       s2.filter(x ->  x < 5 ).map(x -> x * 2);

      // Stream<Double> s3 =  s2.filter(x ->  x < 5 );


        return Stream.of("1", "2", "3")
                .map(s-> "avatar" + s)
                .map(s-> s + ".png").toList();
    }
}
