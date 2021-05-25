package Collection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person{
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
        bucketList=new Location[5];
        choices=new ArrayList<>();
    }
    public void acceptDetails(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter your name: ");
        client.name=input.nextLine();
        System.out.print("Enter number of tickets you want to book: ");
        this.members=input.nextInt();
    }

    public void questionnaire(){

    }


    public void acceptBucket(){
        Scanner input=new Scanner(System.in);
        System.out.println("Make your bucket list");
        System.out.println("1.Spain\n2.France\n3.Germany\n0.Go back to main menu");
        int choose=-1 ;
        int b=1;
        ArrayList<Integer> choices=new ArrayList<>();
        choices.add(0);
        bucketList[0]=new Location();
        bucketList[0].name="India";
        System.out.print("Enter country numbers you want to visit (Enter 0 to stop):  ");
        while(choose!=0){
            System.out.print("Enter: ");
            choose=input.nextInt();
            switch (choose){
                case 0:
                    System.out.println("Going back");
                    break;
                case 1: choices.add(1);
                        bucketList[b]=new Location();
                        bucketList[b].name="Spain";
                        System.out.println(bucketList[b].name+" Added");
                        b+=1;
                        break;
                case 2: choices.add(2);
                        bucketList[b]=new Location();
                        bucketList[b].name="France";
                        System.out.println(bucketList[b].name+" Added");
                        b+=1;
                        break;
                case 3: choices.add(3);
                        bucketList[b]=new Location();
                        bucketList[b].name="Germany";
                        System.out.println(bucketList[b].name+" Added");
                        b+=1;
                        break;
                default:
                    System.out.println("Please enter correct choice.");
                    break;
            }
        }


        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src\\Europe.csv"));
            double [][] graph=new double[choices.size()][choices.size()];
            int l=0;
            Location[] locArr= new Location[choices.size()];
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] country = line.split(splitBy);    // use comma as separator

                for(int m=0;m<choices.size();m++){
                    if(bucketList[m].name.equals(country[0])){
                        locArr[l]=new Location();
                        locArr[l].name=country[0];
                        l+=1;
                        graph[m]=new double[choices.size()];
                        for(int j=0;j<choices.size();j++){
                            graph[m][j]=Double.parseDouble(country[choices.get(j)+1]);
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
        }

        catch (
    IOException e)
        {
            e.printStackTrace();
        }
    }




    /*static int tsp(int[][] graph, boolean[] v, int currPos, int n, int count, int cost, int ans)
    {

        // If last node is reached and it has a link
        // to the starting node i.e the source then
        // keep the minimum value out of the total cost
        // of traversal and "ans"
        // Finally return to check for more possible values
        if (count == n && graph[currPos][0] > 0)
        {
            ans = Math.min(ans, cost + graph[currPos][0]);

            return ans;
        }

        // BACKTRACKING STEP
        // Loop to traverse the adjacency list
        // of currPos node and increasing the count
        // by 1 and cost by graph[currPos,i] value
        for (int i = 0; i < n; i++)
        {
            if (!v[i] && graph[currPos][i] > 0)
            {

                // Mark as visited
                v[i] = true;
                System.out.println("current pos: "+i);
                ans = tsp(graph, v, i, n, count + 1, cost + graph[currPos][i], ans);

                // Mark ith node as unvisited
                v[i] = false;
            }
        }
        return ans;
    }*/



        // Function to find the minimum
        // cost path for all the paths
        public void findMinRoute(int[][] tsp)
        {
            int sum = 0;
            int counter = 0;
            int j = 0, i = 0;
            int min = Integer.MAX_VALUE;
            List<Integer> visitedRouteList = new ArrayList<>();

            // Starting from the 0th indexed
            // city i.e., the first city
            visitedRouteList.add(0);
            int[] route = new int[tsp.length];

            // Traverse the adjacency
            // matrix tsp[][]
            while (i < tsp.length
                    && j < tsp[i].length) {

                // Corner of the Matrix
                if (counter >= tsp[i].length - 1) {
                    break;
                }

                // If this path is unvisited then
                // and if the cost is less then
                // update the cost
                if (j != i && !(visitedRouteList.contains(j))) {
                    if (tsp[i][j] < min) {
                        min = tsp[i][j];
                        route[counter] = j + 1;
                    }
                }
                j++;

                // Check all paths from the
                // ith indexed city
                if (j == tsp[i].length) {
                    sum += min;
                    min = Integer.MAX_VALUE;
                    visitedRouteList.add(route[counter] - 1);
                    j = 0;
                    i = route[counter] - 1;
                    counter++;
                }
            }

            // Update the ending city in array
            // from city which was last visited
            i = route[counter - 1] - 1;

            for (j = 0; j < tsp.length; j++) {

                if ((i != j) && tsp[i][j] < min) {
                    min = tsp[i][j];
                    route[counter] = j + 1;
                }
              //  System.out.println("  " + route[counter]);
            }

            /*sum += min;

            // Started from the node where
            // we finished as well.
            System.out.print("Minimum Cost is : ");
            System.out.println(sum);*/
            System.out.println("ArrayList after addition of an element : "+visitedRouteList);

        }


        // Driver Code

    }



