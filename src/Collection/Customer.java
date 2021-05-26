package Collection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    protected String name;
    protected int age;
    protected char gender;

}

public class Customer {
    protected Person client;
    protected int members;
    protected Location[] bucketList;
    protected ArrayList<Integer> choices;
    protected Location[] shortestRoute;
    // private float budget;

    public Customer() {
        bucketList = new Location[5];
        choices = new ArrayList<>();
    }

    public void acceptDetails() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        client.name = input.nextLine();
        System.out.print("Enter number of tickets you want to book: ");
        this.members = input.nextInt();
    }

    public void questionnaire() {

    }


    public void acceptBucket() {
        Scanner input = new Scanner(System.in);
        System.out.println("Which continent do you want to visit?\n1.Europe\nAsia\n");
        int countryChoice = input.nextInt();

        switch (countryChoice) {

        }
        System.out.println("Make your bucket list");
        System.out.println("1.Spain\n2.France\n3.Germany\n0.Go back to main menu");
        int choose = -1;
        int b = 1;
        ArrayList<Integer> choices = new ArrayList<>();
        choices.add(0);
        bucketList[0] = new Location();
        bucketList[0].name = "India";
        System.out.print("Enter country numbers you want to visit (Enter 0 to stop):  ");
        while (choose != 0) {
            System.out.print("Enter: ");
            choose = input.nextInt();
            switch (choose) {
                case 0:
                    System.out.println("Going back");
                    break;
                case 1:
                    choices.add(1);
                    bucketList[b] = new Location();
                    bucketList[b].name = "Spain";
                    System.out.println(bucketList[b].name + " Added");
                    b += 1;
                    break;
                case 2:
                    choices.add(2);
                    bucketList[b] = new Location();
                    bucketList[b].name = "France";
                    System.out.println(bucketList[b].name + " Added");
                    b += 1;
                    break;
                case 3:
                    choices.add(3);
                    bucketList[b] = new Location();
                    bucketList[b].name = "Germany";
                    System.out.println(bucketList[b].name + " Added");
                    b += 1;
                    break;
                default:
                    System.out.println("Please enter correct choice.");
                    break;
            }
        }


        String line = "";
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\Europe.csv"));
            double[][] graph = new double[choices.size()][choices.size()];
            Location[] locArr = new Location[choices.size()];
            int l = 0;                                    // l for locArr traversal
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] country = line.split(splitBy);    // use comma as separator

                for (int m = 0; m < choices.size(); m++) {          //m for bucketList traversal
                    if (bucketList[m].name.equals(country[0])) {
                        locArr[l] = new Location();
                        locArr[l].name = country[0];
                        l += 1;
                        graph[m] = new double[choices.size()];
                        for (int j = 0; j < choices.size(); j++) {
                            graph[m][j] = Double.parseDouble(country[choices.get(j) + 1]);
                        }
                        break;
                    }
                }
            }

            for (Location location : locArr) {
                System.out.println("--" + location.name);
            }
            for (double[] doubles : graph) {
                for (double aDouble : doubles) {
                    System.out.print("***" + aDouble + "   ");
                }
                System.out.println();
            }
            computeShortestPath(locArr, graph);
        } catch (
                IOException e) {
            e.printStackTrace();
        }


    }


    public List<Integer> findMinRoute(double[][] tsp) {
        double sum = 0;
        int counter = 0;
        int j = 0, i = 0;
        double min = Double.MAX_VALUE;
        List<Integer> visitedRouteList = new ArrayList<>();

        visitedRouteList.add(0);
        int[] route = new int[tsp.length];


        while (i < tsp.length
                && j < tsp[i].length) {

            // Corner of the Matrix
            if (counter >= tsp[i].length - 1) {
                break;
            }


            if (j != i && !(visitedRouteList.contains(j))) {
                if (tsp[i][j] < min) {
                    min = tsp[i][j];
                    route[counter] = j + 1;
                }
            }
            j++;

            if (j == tsp[i].length) {
                sum += min;
                min = Integer.MAX_VALUE;
                visitedRouteList.add(route[counter] - 1);
                j = 0;
                i = route[counter] - 1;
                counter++;
            }
        }

        i = route[counter - 1] - 1;

        for (j = 0; j < tsp.length; j++) {

            if ((i != j) && tsp[i][j] < min) {
                min = tsp[i][j];
                route[counter] = j + 1;
            }
        }

        sum += min;

        System.out.print("Minimum Duration is : ");
        System.out.println(sum);

        System.out.println("ArrayList after addition of an element : " + visitedRouteList);
        return visitedRouteList;
    }

    void computeShortestPath(Location[] locArr, double[][] graph) {
        List<Integer> visitedRouteList = findMinRoute(graph);
        System.out.println("ROUTE");
        for (int i = 0; i < visitedRouteList.size(); i++) {
            System.out.println("====" + locArr[visitedRouteList.get(i)].name);
        }
    }
    // Driver Code

}



