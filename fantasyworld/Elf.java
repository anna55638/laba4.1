package fantasyworld;

public class Elf extends MagicalCreature {
    private String bowType;

    public Elf(String name, int age, String bowType) {
        super(name, age);
        this.bowType = bowType;
    }

    public String getBowType() {
        return bowType;
    }

    @Override
    public void useMagic() {
        System.out.println(getName() + " творит лесную магию.");
    }

    @Override
    public String toString() {
        return "Эльф: " + getName() + ", возраст: " + getAge() + ", тип лука: " + getBowType();
    }
}
