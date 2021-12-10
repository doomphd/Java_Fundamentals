
import java.util.ArrayList;

public class CafeUtil{

int getStreakGoal(){
    int sum =0;
    for(int i = 0; i <= 10; i++){
        sum += i;
    }
    return sum;
}

double getOrderTotal(double[] prices){
    double sum =0;
    for(int i = 0; i < prices.length; i++){
        sum += prices[i];
    }
    return sum;
}
void displayMenu(ArrayList<String> menuItems){

    for(int i = 0; i < menuItems.size(); i++){
    String name = menuItems.get(i); // to access an element in an ArrayList using an index
    System.out.println(i + " " + name);
    }

}

void addCustomer(ArrayList<String> customers){
    System.out.println("Please enter your name: ");
    String userName = System.console().readLine();
    System.out.println("Hello, " + userName);
    System.out.println("Here are "+customers.size() +" people in front of you");

    customers.add(userName); // to add an item to an ArrayList





}

}