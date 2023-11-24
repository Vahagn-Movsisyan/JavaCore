package classwork.immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImmutableClassExampleTest {
    public static void main(String[] args) {
        Map<ImmutableClassExample, Integer> myMap = new HashMap<>();
        List<String> userList = new ArrayList<>();
        userList.add("RUS");
        userList.add("ARM");
        ImmutableClassExample immutableClassExample = new ImmutableClassExample("poxos", "poxos@mail.re", "poxos2002", userList);

        myMap.put(immutableClassExample, 1);
        immutableClassExample.getUserLanguage().add("ENG");
        System.out.println(myMap.get(immutableClassExample));
    }
}
