package fantasyworld;

public class Dwarf extends MagicalCreature {
    private String craftSpeciality;

    public Dwarf(String name, int age, String craftSpeciality) {
        super(name, age);
        this.craftSpeciality = craftSpeciality;
    }

    public String getCraftSpeciality() {
        return craftSpeciality;
    }

    @Override
    public void useMagic() {
        System.out.println(getName() + " использует руническую магию.");
    }

    @Override
    public String toString() {
        return "Гном: " + getName() + ", возраст: " + getAge() + ", специальность: " + getCraftSpeciality();
    }
}
