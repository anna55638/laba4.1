package fantasyworld;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MagicalRealm {
    private List<MagicalCreature> creatures;

    public MagicalRealm() {
        creatures = new ArrayList<>();
    }

    public void addCreature(MagicalCreature creature) {
        creatures.add(creature);
    }

    public boolean removeCreature(String name) {
        return creatures.removeIf(creature -> creature.getName().equalsIgnoreCase(name));
    }

    public void displayCreatures() {
        if (creatures.isEmpty()) {
            System.out.println("В волшебном мире пока никого нет.");
        } else {
            creatures.forEach(System.out::println);
        }
    }
//выполняет действие для всех существ
    public void performMagicForAll() {
        creatures.forEach(MagicalCreature::useMagic);
    }

    public List<Hobbit> findHobbitsByFavoriteFood(String favoriteFood) {
        return creatures.stream()
                .filter(creature -> creature instanceof Hobbit)  //Фильтрует поток, чтобы оставить только элементы, которые являются объектами типа Hobbit
                .map(creature -> (Hobbit) creature) //Преобразует каждый оставшийся элемент потока в объект типа Hobbit
                .filter(hobbit -> hobbit.getFavoriteFood().equalsIgnoreCase(favoriteFood))//оставляет только совпадения с едой
                .collect(Collectors.toList());
    }
}