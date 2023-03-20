package pl.jakubokrzesik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App{

    public static void main(String[] args){
        List<String> names = Arrays.asList("Jakub","Michal","Agnieszka","Kasia");
        Greeter greeter = new Greeter();

        List<String> ladies = new ArrayList<String>();

        for(String name:names){
            if(name.endsWith("a")){
                ladies.add(name);
            }
        }

        for(String name:ladies){
            greeter.greet(name);
        }

        names.stream()
                .filter(name -> name.endsWith("a"))
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(greeter::greet);
    }

}
