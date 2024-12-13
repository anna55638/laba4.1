package fantasyworld;

public abstract class MagicalCreature {
    private String name;
    private int age;

    protected MagicalCreature(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    public abstract void useMagic();
}
