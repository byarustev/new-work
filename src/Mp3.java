
/**
 * This is the Mp3 Class.
 * @author (Gideon Tibamanya)
 * @version (08/03/2019)
 */

public class Mp3 extends Gadget
{
    /**
     * instance variable for Mp3 class
     */

    private int memory;
    private int music;

    /**
     * Constructor for objects of class mp3.
     * initialise memory available.
     */
    public Mp3(double ThePrice, int TheWeight , String TheModel , String TheSize , int TheMemory)

    {
        super(ThePrice, TheWeight, TheModel, TheSize);
        memory = TheMemory;
        music = 0;
    }
    
    /**
     *  this mehtod returns memory
     */
    
    public int getMemory()
    {
    return memory;
    
    }
    
    
    /**
     * this method adds memory.
     */
    public void addMemory(int NewMemory)
    {
        memory = memory + NewMemory;
    }

    /**
     * this method downloads music with conditions. 
     */
    public void downloadMusic(int mSize)
    {
        music = mSize;
        if (memory >= mSize)
        {
            memory = memory - mSize;
            System.out.println(" -------------------------------------------------------");
            System.out.println("  ");
            System.out.println(" Download Finished Song" + mSize);
        }
        else 
        {
            System.out.println(" ------------------------------------------------------");
            System.out.println("  ");
            System.out.println(" Not Enough Memory ");
            
        }
    }
    
    /**
     * this method deletes music and displays when a song has been deleted 
     */

    public void delete (int mSize)
    {
        if ((music == mSize) || ((memory + mSize) < memory))
        {
    memory = memory + mSize;
    System.out.println(" -------------------------------------------------------------");
    System.out.println("  ");
    System.out.println("----- Song Deleted -----");
}
    else 
    {
    System.out.println(" ");
    System.out.println(" ---------------------------------------------------------------");
    System.out.println("  ");
    System.out.println(" No music has been Deleted ");
    
    
}
}

/**
 *  this method prints all the details of the Mp3 class 
 */

    public void print()
    {
    super.print();
    System.out.println(" ------------------------------------------------");
    System.out.println(" ################################################");

    }
}
