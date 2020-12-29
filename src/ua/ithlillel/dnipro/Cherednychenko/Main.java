package ua.ithlillel.dnipro.Cherednychenko;

public class Main {

    public static void main(String[] args) {

        MyMap<String, Integer> myMap = new MyMap<>();
        String string = "Я иду по парку, иду один и вижу как по воде пробегает луч солнца";
        String[] arraySting = string.toLowerCase().split("[,;\\s]+");

        for (String word : arraySting) {
            if (myMap.contains(word)) {
                myMap.put(word, myMap.get(word) + 1);
            } else {
                myMap.put(word, 1);
            }
        }

        for (MyMap.Pair<String, Integer> entry : myMap.pairSet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());

        }

    }
}

