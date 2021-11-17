package test5;

/**
 * @ClassName ScalaDemo-uniform
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月21日21:49 - 周四
 * @Describe
 */
public class Uniform extends Cloth {
    Person person;

    public Uniform(Person p) {
        this.person = p;
    }

    @Override
    public String getName() {
        //这里的name必须加person才是学生，不然还是父类中的name
        return person.name + "穿校服";
    }

    @Override
    public int getPower() {
        return person.getPower() + 20;
    }
}
