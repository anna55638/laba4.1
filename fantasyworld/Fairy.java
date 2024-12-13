package fantasyworld;

public class Fairy extends MagicalCreature {
    private String wingColor;

    public Fairy(String name, int age, String wingColor) {
        super(name, age);
        this.wingColor = wingColor;
    }

    public String getWingColor() {
        return wingColor;
    }

    @Override
    public void useMagic() {
        System.out.println(getName() + " разбрасывает волшебную пыльцу.");
    }

    @Override
    public String toString() {
        return "Фея: " + getName() + ", возраст: " + getAge() + ", цвет крыльев: " + getWingColor();
    }
}
