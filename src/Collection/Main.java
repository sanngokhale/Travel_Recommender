package Collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void initialization(Continents[] continent) throws FileNotFoundException {
        for (int i=0;i<3;i++)
            continent[i] = new Continents();
        continent[0].name="Europe";
        continent[1].name="Asia";
        continent[2].name="North America";
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


    public static void main(String[] args) throws FileNotFoundException {
        Continents[] continent = new Continents[3];
        initialization(continent);
      /* for (int i = 0; i < 3; i++) {
           System.out.println("***"+continent[i].name+"***");
            for (int j = 0; j < 8; j++) {
                System.out.println(continent[i].allPlaces[j].name);
            }
        }*/
        Customer c1 = new Customer();
        Scanner sc = new Scanner(System.in);
        int opt, opt1=-1, opt2, opt3=-1, opt4=-1;
        boolean flag=false;
        do {
            System.out.println("\n\t\t\tPlease select a kind of user:");
            System.out.println("\n\n\t\t\t\t1.New User\n\n\t\t\t\t2.Existing User\n\n\t\t\t\t3.Exit");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    do {
                        System.out.println("\n\n\n\t\t\t\tNEW USER\n");
                        System.out.println("\n\n\t\t\tChoose the type of details you want to enter:");
                        System.out.println("\n\n\t\t\t\t1.Personal Details\n\n\t\t\t\t2.Travel Details\n\n\t\t\t\t3.Back\n\n\t\t\t\t ");
                        opt1 = sc.nextInt();
                        switch (opt1) {
                            case 1://personal details
                                c1.acceptPersonalDetails();
                                flag=true;
                                break;
                            case 2:// Travel details
                                if(!flag) System.out.println("Please fill personal details first as you are a new user!");
                                else {
                                    System.out.println("Which continent do you want to visit?\n1.Europe\n2.Asia\n3.North America\n");
                                    int countiChoice = sc.nextInt();
                                    c1.acceptBucket(continent[countiChoice - 1]);
                                }
                            System.out.println("\n\n* For modifications,Please visit 'existing user' section");
                                break;
                            default:
                                break;
                        }
                    } while (opt1 != 3);
                    break;
                case 2: //existing user
                    do {
                        System.out.println("\n\n\t\t\t***** EXISTING USER *****");
                        System.out.println("Please select the type of operation that you would like to perform:");
                        System.out.println("\n\n\t\t\t1.View Personal Details\n\n\t\t\t2.View Travel Details\n\n\t\t\t3.Edit Details\n\n\t\t\t4.Back\n\n\t\t\t");
                        opt2 = sc.nextInt();
                        switch (opt2) {
                            case 1://call t personal details
                            case 2://call to travel details
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
                                            } while (opt4!=3);
                                            break;
                                        case 2://for deleting
                                            break;
                                        case 3://
                                            break;
                                        default:
                                            break;
                                    }

                                }while(opt3!=4);
                        }
                    }while(opt2!=4);

            }
        } while (opt!= 3);
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
    }
}
