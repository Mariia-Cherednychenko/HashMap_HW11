package ua.ithlillel.dnipro.Cherednychenko;

public class Main {

    public static void main(String[] args) {
       /* MySet<String> set = new MySet<>(100);
        set.add("hello");
        set.add("world");
        set.add("!");
        set.add("hello");
        set.add("trulalala");

        for(String s :set){
            System.out.println(s);
        }*/

       /*MyMap<String, String> myMap = new MyMap<>();
       myMap.put("Vasya", "Student");
        myMap.put("Petya", "Student");
        myMap.put("Oleg", "Engineer");
        myMap.put("Vasya", "Engineer");

        //System.out.println(myMap.get("Vasya"));

        for (MyMap.Pair<String, String> pair:myMap.pairSet()){
            System.out.println(pair.getKey()+" => "+ pair.getValue());
        }*/

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
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }

    }
}

