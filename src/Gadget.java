
/**
 * this is the main class with four attributes and and two subclasses which are Mobile and mp3.
 * @author (Gideon Tibamanya) (18026660)
 * @version (08/03/2019)
 */

//public static void main(String[]args)

class Gadget {
    /**
     * instance variables for Gadget class.
     */
    private int weight;
    private String Model;
    private String Size;
    private double Price;

    /**
     * Constructor for objects of class Gadget. includes cost,weight,model,size.
     * 
     */
    
    public Gadget(double TheCost, int TheWeight , String TheModel , String TheSize)
    {
        weight = TheWeight;
        Model = TheModel;
        Price = TheCost;
        Size = TheSize;
    }
    
    /**
     * this accesor method returnds the price
     */
    
    public double getPrice()
    {
        return Price;
    }
    
    /**
     * this accesor method returnds the weight
     */
    
    public int getweight()
    {
        return weight;
    }
    
    /**
     * this accesor method returnds the model
     */
    
    public String getModel()
    {
        return Model;
    }
    
    /**
     * this accesor method returns the size
     */
    
    public String getSize()
    {
        return Size;
    }
    
   
    /**
     * Mutator method to display the model, price,weight,and size 
     */
    
    public void print()
    {
        System.out.println(" --------------------------------------------------");
        System.out.println("  ");
        System.out.println(" The price of the Gadget is £ " + Price + " Pounds ");
        System.out.println("  ");
        System.out.println(" ---------------------------------------------------");
        System.out.println("  ");
        System.out.println(" The Weight is " + weight + " Gram ");
        System.out.println("  ");
        System.out.println(" ---------------------------------------------------");
        System.out.println("  ");
        System.out.println(" The Model is " + Model + weight );
        System.out.println("  ");
        System.out.println(" ----------------------------------------------------");
        System.out.println("  ");
        System.out.println(" The Size is " + Size);
        System.out.println(" -----------------------------------------------------");

    }

    
}

