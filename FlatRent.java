import java.util.Scanner;

class Flat{
        private String name;
        private int rent;
        private int distance;
        private int travelTime;
        private int locationAdvantage;    

        private static final int travelCost = 5;
        private static final int distanceCost = 10;
        private static final int workingDays = 20;
         
public Flat(String name, int rent, int distance, int travelTime, int locationAdvantage) {
            this.name = name;
            this.rent = rent;
            this.distance = distance;
            this.travelTime = travelTime;
            this.locationAdvantage = locationAdvantage;
        }

        public int getTotalCost(){
            int distanceCostTotal = distance*distanceCost*workingDays;
            int travelCostTotal = travelTime*travelCost*workingDays;
            return rent+distanceCostTotal+travelCostTotal-locationAdvantage;
        };

        public String getName() {
            return name;
        }
        public int getRent() {
            return rent;
        }
        public int getDistance() {
            return distance;
        }
        public int getTravelTime() {
            return travelTime;
        }
        public int getLocationAdvantage() {
            return locationAdvantage;
        }
          
}


public class FlatRent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of flat details to find the best flat near your company ");
        
        //input no of flat details
        int noOfFlats = sc.nextInt();
        sc.nextLine();

        Flat[] flatArr = new Flat[noOfFlats];

        for(int i=0; i<noOfFlats; i++){
            System.out.println("Enter Flat Name, Flat Rent, Distance from Office, Travelling Time to Office & Location Advantage Saving "+(i+1));
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("Rent: ");
            int rent = sc.nextInt();
            System.out.println("Distance: ");
            int distance = sc.nextInt();
            System.out.println("Travel Time: ");
            int travelTime = sc.nextInt();
            System.out.println("Location Advantage: ");
            int locationAdvantage = sc.nextInt();
            sc.nextLine();
            
            
            flatArr[i] = new Flat(name, rent, distance, travelTime, locationAdvantage);
        }
        
        
        
        System.out.println("No of flats are: "+noOfFlats);
        for(int i=0; i<noOfFlats; i++){
            Flat f = flatArr[i];
            System.out.println("Flat " + (i + 1) + ": " + f.getName() + ", Rent: " + f.getRent() +
            ", Distance: " + f.getDistance() + "km, Travel Time: " + f.getTravelTime() +
            "mins, Location Advantage: " + f.getLocationAdvantage() +
            ", Net Cost: " + f.getTotalCost());
        }
        Flat bestFlat = flatArr[0];
        int minCost = flatArr[0].getTotalCost();
        
        for(int i=1; i<noOfFlats; i++){
            if(flatArr[i].getTotalCost()<minCost){
                bestFlat = flatArr[i];
                minCost = flatArr[i].getTotalCost();
        }
    }
    System.out.println("Best Flat for you is: ");
    System.out.println("Name: "+ bestFlat.getName()+", Total Cost: "+ bestFlat.getTotalCost());
    sc.close();
}
}
