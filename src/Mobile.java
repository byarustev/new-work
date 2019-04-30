/**
 * this is the Mobile subclass of the Gadget class which allows to add credit and make calls.
 *
 * @author (Gideon Tibamanya) (1802660)
 * @version (08 / 03 / 2019)
 */
public class Mobile extends Gadget {
    /**
     * declaring variables/ 1 attribute
     */
    private int credit;

    /**
     * constructor for objects in the Mobile class
     * initialise credit
     */
    public Mobile(double theCost, int theWeight, String theModel, String theSize, int theMinutes) {
        super(theCost, theWeight, theModel, theSize);
        credit = theMinutes;
    }

    /**
     * Mutator Method to be able to add credit
     */
    public void addCredit(int newCredit) {
        credit = credit + newCredit;

    }

    /**
     * accessor method to return credit
     */

    public int getCredit() {
        return credit;
    }

    /**
     * this method  Makes calls and displays the duration
     */
    public void MakeCall(String phone, int duration) {
        if (credit == 0) {
            System.out.println(" ------------------------------------------------------");
            System.out.println("  ");
            System.out.println(" You need more than 0 credit to make a phone call, please toup ");

        } else {
            System.out.println(" -------------------------------------------------------");
            System.out.println("  ");
            System.out.println(" The Number is " + phone + " has been dailed and its been " + duration + " minutes ");
            System.out.println(" --------------------------------------------------------");
            System.out.println("  ");
            credit = credit - duration;

        }

    }

    /**
     * this method displays details of the Mobile
     */
    public void print() {
        super.print();
        System.out.println("--------------------------------------------------------");
        System.out.println("  ");
        System.out.println(" Your Remaining credit is : " + credit);

    }
}
