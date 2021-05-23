import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Person{
    protected String name;
    protected int age;
    protected char gender;

}

public class Customer {
    private Person client;
    private int members;
    private Location[] bucketList;
    private Location[] shortestRoute;
    private float budget;

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
        System.out.println("Make your bucket list");
        System.out.println("1.Spain\n2.France\n3.Germany\n0.Go back to main menu");
        System.out.print("Enter country numbers you want to visit:  ");
        ArrayList<String> choices=new ArrayList<>();

        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src\\Europe.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);    // use comma as separator

            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }



    static int tsp(int[][] graph, boolean[] v, int currPos, int n, int count, int cost, int ans)
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
                System.out.println("vertex: "+i+"***  cost: "+cost);
                ans = tsp(graph, v, i, n, count + 1, cost + graph[currPos][i], ans);

                // Mark ith node as unvisited
                v[i] = false;
            }
        }
        return ans;
    }

}
