package ui;

import fantasyworld.*;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static MagicalRealm realm = new MagicalRealm();
    private static boolean isRunning = true;

    public static void showMenu() {
        while (isRunning) {
            try {
                System.out.println("\nМеню управления волшебным миром:");
                System.out.println("1. Добавить фею");
                System.out.println("2. Добавить эльфа");
                System.out.println("3. Добавить гнома");
                System.out.println("4. Добавить хоббита");
                System.out.println("5. Удалить существо");
                System.out.println("6. Показать всех существ");
                System.out.println("7. Выполнить магию для всех существ");
                System.out.println("8. Найти хоббитов по любимой еде");
                System.out.println("0. Выход");

                int choice = getValidIntInput("Выберите пункт меню: ");

                switch (choice) {
                    case 1:
                        addFairy();
                        break;
                    case 2:
                        addElf();
                        break;
                    case 3:
                        addDwarf();
                        break;
                    case 4:
                        addHobbit();
                        break;
                    case 5:
                        removeCreature();
                        break;
                    case 6:
                        realm.displayCreatures();
                        break;
                    case 7:
                        realm.performMagicForAll();
                        break;
                    case 8:
                        findHobbitsByFood();
                        break;
                    case 0:
                        System.out.println("Выход из программы.");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void addFairy() {
        String name = getValidStringInput("Введите имя феи: ");
        int age = getValidAgeInput("Введите возраст феи: ");
        String wingColor = getValidStringInput("Введите цвет крыльев: ");
        realm.addCreature(new Fairy(name, age, wingColor));
    }

    private static void addElf() {
        String name = getValidStringInput("Введите имя эльфа: ");
        int age = getValidAgeInput("Введите возраст эльфа: ");
        String bowType = getValidStringInput("Введите тип лука: ");
        realm.addCreature(new Elf(name, age, bowType));
    }

    private static void addDwarf() {
        String name = getValidStringInput("Введите имя гнома: ");
        int age = getValidAgeInput("Введите возраст гнома: ");
        String craft = getValidStringInput("Введите специальность гнома: ");
        realm.addCreature(new Dwarf(name, age, craft));
    }

    private static void addHobbit() {
        String name = getValidStringInput("Введите имя хоббита: ");
        int age = getValidAgeInput("Введите возраст хоббита: ");
        String food = getValidStringInput("Введите любимую еду хоббита: ");
        realm.addCreature(new Hobbit(name, age, food));
    }

    private static void removeCreature() {
        String nameToRemove = getValidStringInput("Введите имя существа для удаления: ");
        if (realm.removeCreature(nameToRemove)) {
            System.out.println("Существо " + nameToRemove + " удалено");
        } else {
            System.out.println("Существо с именем " + nameToRemove + " не найдено.");
        }
    }

        private static void findHobbitsByFood() {
        String foodToFind = getValidStringInput("Введите любимую еду хоббитов для поиска: ");
        List<Hobbit> foundHobbits = realm.findHobbitsByFavoriteFood(foodToFind);
        if (!foundHobbits.isEmpty()) {
            System.out.println("Найдены хоббиты:");
            foundHobbits.forEach(System.out::println);
        } else {
            System.out.println("Хоббиты с такой любимой едой не найдены.");
        }
    }

    private static int getValidIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    private static int getValidAgeInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    throw new IllegalArgumentException("Возраст должен быть положительным числом.");
                }
                return age;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число для возраста.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getValidStringInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Строка не может быть пустой.");
                }
                if (hasNumber(input)) {
                    throw new IllegalArgumentException("Строка не может содержать цифры.");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static boolean hasNumber(String input) {
        return input.chars().anyMatch(Character::isDigit);
    }
}