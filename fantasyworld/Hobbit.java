package fantasyworld;

public class Hobbit extends MagicalCreature {
    private String favoriteFood;

    public Hobbit(String name, int age, String favoriteFood) {
        super(name, age);
        this.favoriteFood = favoriteFood;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    @Override
    public void useMagic() {
        System.out.println(getName() + " использует магию домашнего уюта.");
    }

    @Override
    public String toString() {
        return "Хоббит: " + getName() + ", возраст: " + getAge() + ", любимая еда: " + getFavoriteFood();
    }
}