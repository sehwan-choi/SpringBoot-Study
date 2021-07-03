package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Lombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        Lombok lombok = new Lombok();
        lombok.setAge(1);
        lombok.setName("test");

        System.out.println("lombok = " + lombok);
    }
}
