package Collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void initialization(Continents[] continent) throws FileNotFoundException {
        File myObj = new File("src\\file1.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            for (int i = 0; i < 1; i++) {
                continent[i] = new Continents();
                continent[i].allPlaces = new Location[8];
                for (int j = 0; j < 8; j++) {
                    continent[i].allPlaces[j] = new Location();
                    continent[i].allPlaces[j].name = myReader.nextLine();
                }
            }
        }
        myReader.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        Continents[] continent = new Continents[1];
        initialization(continent);
     /*   for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.println("TSP");
                System.out.println(continent[i].allPlaces[j].name);
            }
        }*/

        Customer c1 = new Customer();
        Scanner input = new Scanner(System.in);
        System.out.println("Which continent do you want to visit?\n1.Europe\nAsia\n");
        int countiChoice = input.nextInt();

        switch (countiChoice) {
            case 1:
                c1.acceptBucket(continent[countiChoice - 1].allPlaces);
                break;
            /*case 2: for (int j = 0; j < 8; j++) {
                System.out.println(continent[1].allPlaces[j].name);
            }
            case 3: for (int j = 0; j < 8; j++) {
                System.out.println(continent[2].allPlaces[j].name);
            }*/
        }



    }
}
