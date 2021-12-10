
public class Bat extends Mammal {

    public Bat() {
        energyLevel = 300;

    }
	
	public void fly() {
		System.out.println("the sound of a bat taking off");
		energyLevel -= 50;
	}
	public void eatHumans() {
		System.out.println("Munch");
		energyLevel += 25;
	}
	public void attackTown() {
		System.out.println("town on fire");
		energyLevel -= 100;
	}
}
