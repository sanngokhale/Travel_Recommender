import java.util.Map;

public class Location {
    public String name;
    public Map<Location,Location> map;

}

class Continents{
    public String name;
    public Location[] allPlaces;

    public void displayList(){
        System.out.println("***"+name+"***");
        for(int i=0;i< allPlaces.length;i++){
            System.out.println((i+1)+". "+ allPlaces[i]);
        }
    }

    public void acceptList(Location[] all_places){
        this.allPlaces=all_places.clone();
    }
}

