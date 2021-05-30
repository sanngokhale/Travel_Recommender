package Collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void initialization(Continents[] continent) throws FileNotFoundException {
        for (int i = 0; i < 3; i++)
            continent[i] = new Continents();
        continent[0].name = "Europe";
        continent[1].name = "Asia";
        continent[2].name = "North America";
        //continent[0].name="Europe";

        File myObj = new File("src\\file1.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            for (int i = 0; i < 3; i++) {
                continent[i].allPlaces = new Location[8];
                for (int j = 0; j < 8; j++) {
                    continent[i].allPlaces[j] = new Location();
                    continent[i].allPlaces[j].name = myReader.nextLine();
                }
            }
        }
        myReader.close();
    }


    public static void readUserData() {

    }

    public static void writeUserData(Customer[] c) throws IOException {
        /*List<List<String>> rows = Arrays.asList(
                Arrays.asList("Jean", "author", "Java"),
                Arrays.asList("David", "editor", "Python"),
                Arrays.asList("Scott", "editor", "Node.js")
        );*/

        FileWriter csvWriter = new FileWriter("src\\users.csv");
        for (int i = 0; i < c.length; i++) {
            if (c[i] != null) {
                ArrayList<String> data = new ArrayList<>();
                data.add(Integer.toString(c[i].id));
                data.add(c[i].password);
                data.add(c[i].client.name);
                System.out.println("---" + c[i].id);
                System.out.println("***" + data.get(0));
                for (int j = 0; j < c[i].choices.size(); j++) {
                    data.add(c[i].bucketList[j].name);
                }
                for (int j = 0; j < c[i].choices.size(); j++) {
                    data.add(c[i].shortestRoute[j].name);
                }
                data.add(String.valueOf(c[i].minDuration));
                System.out.println(data);
                csvWriter.append("line");
                csvWriter.append(",");
                //csvWriter.append(Arrays.toString(data.toArray()));
                csvWriter.append(String.join(",", data));
                csvWriter.append("\n");
            }
        }
        csvWriter.flush();
        csvWriter.close();

      /*  FileWriter csvWriter = new FileWriter("new.csv");
        csvWriter.append("Name");
        csvWriter.append(",");
        csvWriter.append("Role");
        csvWriter.append(",");
        csvWriter.append("Topic");
        csvWriter.append("\n");

        for (List<String> rowData : rows) {
            csvWriter.append(String.join(",", rowData));
            csvWriter.append("\n");
        }*/

    }


    public static void main(String[] args) throws IOException {
        Continents[] continent = new Continents[3];
        initialization(continent);
      /* for (int i = 0; i < 3; i++) {
           System.out.println("***"+continent[i].name+"***");
            for (int j = 0; j < 8; j++) {
                System.out.println(continent[i].allPlaces[j].name);
            }
        }*/
        //Customer[] customer = new Customer[20];
        Customer c;
        Hashing hash = new Hashing();
        int count = 0;
        int min = 10;
        int idBase = 100;
        c = new Customer();
        Scanner sc = new Scanner(System.in);
        int opt, opt1 = -1, opt2, opt3 = -1, opt4 = -1,edit=-1;
        boolean flag2 = false;
        boolean flag1;
        int details = 0;
        do {
            flag1 = false;
            System.out.println("\n\t\t\tPlease select a kind of user:");
            System.out.println("\n\n\t\t\t\t1.New User\n\n\t\t\t\t2.Existing User\n\n\t\t\t\t3.Exit");

            opt = sc.nextInt();
            switch (opt) {
                case 1: //new user
                    do {
                        System.out.println("\n\n\n\t\t\t\tNEW USER\n");
                        //System.out.println("Password is ");
                        if (c.password.equals("")) {

                            c.id = idBase + min + (int) (Math.random() * (min + 5));
                            //c.id= idBase+count*2 ;//Math.random()   maintain min and max
                            count++;
                            min += 10;
                            System.out.print("Create Password: ");
                            c.password = sc.next();
                            System.out.println("Registration is successful!");
                            System.out.println("Your customer id is " + c.id + ",  keep it for future reference.");
                        }
                        //initialize a customer from the array of user

                        // System.out.println("Enter pa");
                        //save the password, name, id(random)  --->customer che variables...
                        //message...registration is successful...
                        //this is ur id, keep it for future reference
                        System.out.println("\n\n\t\t\tChoose the type of details you want to enter:");
                        System.out.println("\n\n\t\t\t\t1.Personal Details\n\n\t\t\t\t2.Travel Details\n\n\t\t\t\t3.Back\n\n\t\t\t\t ");
                        opt1 = sc.nextInt();
                        switch (opt1) {
                            case 1://personal details
                                c.acceptPersonalDetails();
                                flag1 = true;
                                break;
                            case 2:// Travel details
                                if (!flag1) System.out.println("Please fill personal details first as you are a new user!");
                                else {
                                    System.out.println("Which continent do you want to visit?\n1.Europe\n2.Asia\n3.North America\n");
                                    int countiChoice=sc.nextInt();
                                    while (true) {
                                        //countiChoice = ;
                                        // System.out.print("Enter: ");
                                        if (countiChoice < 4 && countiChoice > 0) {
                                            break;
                                        }
                                        else{
                                            System.out.println("Enter a valid option!!");
                                            countiChoice = sc.nextInt();
                                        }
                                    }
                                    c.acceptBucket(continent[countiChoice - 1]);
                                    flag2 = true;
                                    hash.create(c);

                                }
                                System.out.println("\n\n* For modifications,Please visit 'existing user' section");
                                break;
                            default:
                                break;
                        }


                        // name , id, password, bucket list into the csv
                        //will go into the hashtable--->object of customer
                    } while (opt1 != 3);
                    break;
                case 2: //existing user
                    //do {
                        boolean exitoption=false;
                        boolean password_validation=false;
                        System.out.println("\n\n\t\t\t***** EXISTING USER *****");
                        System.out.println("Please enter your customer id : ");
                        int custId = sc.nextInt();
                        Customer temp = hash.search(custId);
                        if (temp==null) {
                           System.out.println("You are not registered...Please enter new user and register!!");
                           c=new Customer();
                            break;
                        }
                        else c=temp;
                        System.out.println("Enter password : ");
                        String password = sc.next();
                        //c = hash.search(password);
                        while(!password_validation){
                            if(c.password.equals(password)){
                                System.out.println("Login is Successful!!");
                                password_validation=true;
                            }
                            else{
                                System.out.println("Invalid password");
                                System.out.println("1)Re-enter or 2)Exit");
                                int choice= sc.nextInt();
                                if(choice==1){
                                    System.out.println("Please re-enter.. ");
                                    password = sc.next();
                                }
                                else exitoption=true;
                            }
                        }
                        if(exitoption) break;
                        //else continue;
                            //if(!password_validation) break;
                        //login
                        //enter id, password
                        //search...match ->menu
                        //1)hashing search-->id not registered!!
                        //if id-yes....and password do not match...1)reenter 2)go to main menu & register as a new user, go back
                        do {
                            System.out.println("Please select the type of operation that you would like to perform:");
                            System.out.println("\n\n\t\t\t1.View Personal Details\n\n\t\t\t2.View Travel Details\n\n\t\t\t3.Edit Details\n\n\t\t\t4.Back\n\n\t\t\t");
                            opt2 = sc.nextInt();
                            //opt2;
                            switch (opt2) {
                                case 1:
                                    System.out.println(c.client.name);
                                    //call t personal details
                                    continue;
                                case 2:
                                    System.out.println("Bucket list  is " + c.bucketList[2].name);
                                    //System.out.println("Pleas enter your customer id");
                                    //int key = sc.nextInt();
                                    // hash.search(custId);
                                    //call to travel details
                                    continue;
                                case 3:
                                    do {
                                        System.out.println("\n\n\t\t\t***** EDIT INFORMATION *****");
                                        System.out.println("\n\n\t\tPlease select among the editing options:\n\n");
                                        System.out.println("\t\t\t\t1.Modify\n\n\t\t\t\t2.Delete\n\n\t\t\t\t3.Back\n\n\t\t\t\t");
                                        opt3 = sc.nextInt();
                                        switch (opt3) {
                                            case 1://modify personal or travel detail
                                                do {
                                                    System.out.println("\n\n\tChoose The Type Of Details You Want To Modify:\n\n\t\t\t1.Personal Details\n\n\t\t\t");
                                                    System.out.println(" 2. Travel Details\n\n\t\t\t3.Back\n\n\t\t\t");

                                                    opt4 = sc.nextInt();
                                                    switch (opt4) {
                                                        case 1://personal
                                                            break;
                                                        case 2:
                                                            break;
                                                    }
                                                } while (opt4 != 3);
                                                break;
                                            case 2://for deleting
                                                break;
                                            case 3://
                                                break;
                                            default:
                                                break;
                                        }

                                    } while (opt3 != 4);
                                    break;
                                case 4:
                                    System.out.println("Going back");
                                    break;
                            }
                       // }while(edit!=4);
                    } while (opt2 != 4);

            }
        } while (opt != 3);
        /*switch (countiChoice) {
            case 1:
                c1.acceptBucket(continent[countiChoice - 1].allPlaces);
                break;
            case 2: for (int j = 0; j < 8; j++) {
                System.out.println(continent[1].allPlaces[j].name);
            }
            break;
            case 3: for (int j = 0; j < 8; j++) {
                System.out.println(continent[2].allPlaces[j].name);
            }
            break;
        }*/
        for (int i = 0; i < hash.customer.length; i++) {
            if (hash.customer[i] != null) {
                   ArrayList<String> data = new ArrayList<>();
                data.add(Integer.toString(hash.customer[i].id));
                data.add(hash.customer[i].password);
                data.add(hash.customer[i].client.name);
               // System.out.println("---" + hash.customer[i].id);
                System.out.println(data);
                /*for (int j = 0; j < hash.customer[i].choices.size(); j++) {
                    data.add(hash.customer[i].bucketList[j].name);
                }
                for (int j = 0; j < hash.customer[i].choices.size(); j++) {
                    data.add(hash.customer[i].shortestRoute[j].name);
                }*/
                data.add(String.valueOf(hash.customer[i].minDuration));
                //System.out.println(data);
            }
        }
        writeUserData(hash.customer);
    }
}


