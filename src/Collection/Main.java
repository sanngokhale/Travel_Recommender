package Collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void initialization(Continents[] continent) throws FileNotFoundException {
        File myObj = new File("src\\file1.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            for (int i = 0; i < 3; i++) {
                continent[i]=new Continents();
                continent[i].allPlaces=new Location[3];
                for (int j = 0; j < 3; j++) {
                    continent[i].allPlaces[j]= new Location();
                    continent[i].allPlaces[j].name= myReader.nextLine();
                }
            }
        }
        myReader.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Continents[] continent = new Continents[3];
        initialization(continent);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("TSP");
                System.out.println(continent[i].allPlaces[j].name);
            }
        }

        Customer c1=new Customer();
        c1.acceptBucket();

    }
}
