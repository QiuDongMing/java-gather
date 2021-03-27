package com.qdm.classloder;

/**
 * @author qiudm
 * @date 2019/2/27 11:19
 * @desc
 */
public class MainTest {


    public static void main(String[] args) {

        //String str = "hello";

        String str = new String("hello");


        new MainTest().changeVal(str);
        System.out.println("str = " + str);

        People p = new People();
        p.setName("name");
        new MainTest().changeVal(p);
        System.out.println("p = " + p);

    }


    public void changeVal(String str) {
        str = "hello2";
    }

    public void changeVal(final People people) {
        people.setName("name2");
    }


}


class People {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }
}


