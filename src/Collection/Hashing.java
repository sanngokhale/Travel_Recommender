package Collection;

public class Hashing {

    protected int count;
    protected  Customer[] customer = new Customer[20];

    int hash(long id)           //calculate the hash address for given id
    {
        return (int) (id%20);
    }
//changes

    void create(Customer c) {
        if(count ==20){             //table full
            System.out.println("Table is full!!");
            return;
        }
        //System.out.println("Customer with id "+c.id + " has been registered!!");
        int i=hash(c.id); //find index to store the customer

        while(customer[i]!=null && i<=20){
            if(i==20){
                i=-1;
            }
            i++;                                    //if index is occupied, move forward
        }
      //  System.out.println("hash value "+i);
        customer[i]=new Customer();
        customer[i]=c;
        count++;                                        //increase count
    }


    /*void display()
    {
        if(count ==0){                          //empty condition
            System.out.println("Table is empty!!");
            return;
        }
        for(int i=0;i<40;i++){          //traverse and print when customer is present
            if(customer[i]!=null){
                System.out.println(i+" --> "+customer[i].id+"  "+customer[i].name);
            }
        }
    }*/

/*
    Customer search(int key) {
        int i=hash(key); //find address for given key
        Customer c1 = null;
        boolean flag=false;             //set flag to false
        while (i<20){
            if(customer[i]==null){         //if null move forward
                i++;
            }
            else if(customer[i].id != key) {     //if key doesn't match move forward
                i++;
            }
            else if(customer[i].id == key) {
                System.out.println("Found!!");  //if key matched display and break
           //     customer[i].display();
                flag=true;
                c1=customer[i];
                break;
               //set flag to true when key is found
            }
            if(i==19)i=0;
        }
        if(flag=true)
        return c1;
        return null;
    }*/


    Customer search(int key) {
        boolean flag = false;
        //System.out.println("Enter  the customer ID to be searched.");
        //long search_ID = sc.nextLong();
        int i = hash(key);
        //if {(hashtable[hashval] == null) hashval = (hashval + 1) % 20;

        if (customer[i] != null) {
            if (customer[i].id == key) {
                //customer[i].id .display();
                return customer[i];
            }
        }
        //(hashval + 1) % 20;

        int temp = i;
        i = (i + 1) % 20;
        while (temp != i) {
            if (customer[i] == null) i = (i + 1) % 20;
            else if (customer[i].id != key) i = (i + 1) % 20;
            else if (customer[i].id == key) {
                //customer[i].display();
                flag = true;
                break;
            }
        }
        if (!flag) return null;
        return customer[i];
    }

    /*void modifyPersonal(Scanner sc){
        System.out.println("Modify personal details: ");
        System.out.println("1.Modify name  2.Change number of tickets to be book");
        int choice = sca
    }

    void modifyTravel(){

    }*/



}
