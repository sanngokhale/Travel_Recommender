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
        System.out.println("Customer with id "+c.id + " has been registered!!");
        int i=hash(c.id); //find index to store the customer

        while(customer[i]!=null && i<=20){
            if(i==20){
                i=-1;
            }
            i++;                                    //if index is occupied, move forward
        }
        System.out.println("hash value "+i);
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


    void search(int key) {
        int i=hash(key);                //find address for given key
        boolean flag=false;             //set flag to false
        while (i<20){
            if(customer[i]==null){         //if null move forward
                i++;
            }
            else if(customer[i].id!=key) {     //if key doesn't match move forward
                i++;
            }
            else if(customer[i].id==key) {
                System.out.println("Found!!");  //if key matched display and break
           //     customer[i].display();
                flag=true;                      //set flag to true when key is found
                break;
            }
        }

        if(!flag) {
            System.out.println("Data not found!!");         //if key is not found
        }
    }
}
