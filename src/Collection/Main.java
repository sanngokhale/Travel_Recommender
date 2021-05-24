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
                System.out.println("Hello I did it!!");
                System.out.println(continent[i].allPlaces[j].name);
            }
        }

        Customer c1=new Customer();
        c1.acceptBucket();
        // n is the number of nodes i.e. V
        /*int n = 4;

        int[][] graph = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        // Boolean array to check if a node
        // has been visited or not
        boolean[] v = new boolean[n];
        Customer c = new Customer();
        // Mark 0th node as visited
        v[0] = true;
        int ans = Integer.MAX_VALUE;

        // Find the minimum weight Hamiltonian Cycle
        ans = Customer.tsp(graph, v, 0, n, 1, 0, ans);

        // ans is the minimum weight Hamiltonian Cycle
        System.out.println(ans);
    */
    }
}
