/**
 * This is the GadgetShop Class.
 * @author (Gideon Tibamanya)
 * @version (27/04/2019)
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class GadgetShop implements ActionListener {

    /**
     * instance variables for GadgetShop class
     */

    private ArrayList<Gadget> gadgetList = new ArrayList<>();

    private JFrame frame = new JFrame("Gadget Shop");

    //panels
    private JPanel modelPanel = new JPanel(new GridLayout(2, 1));
    private JPanel pricePanel = new JPanel(new GridLayout(2, 1));
    private JPanel weightPanel = new JPanel(new GridLayout(2, 1));
    private JPanel sizePanel = new JPanel(new GridLayout(2, 1));
    private JPanel creditPanel = new JPanel(new GridLayout(2, 1));
    private JPanel memoryPanel = new JPanel(new GridLayout(2, 1));
    private JPanel addClearPanel = new JPanel(new GridLayout(2, 1));
    private JPanel mp3DisplayAllPanel = new JPanel(new GridLayout(2, 1));
    private JPanel phoneNoPanel = new JPanel(new GridLayout(2, 1));
    private JPanel durationPanel = new JPanel(new GridLayout(2, 1));
    private JPanel downloadPanel = new JPanel(new GridLayout(2, 1));
    private JPanel displayNoPanel = new JPanel(new GridLayout(2, 1));

    //text fields
    private TextField modelTextField = new TextField();
    private TextField priceTextField = new TextField();
    private TextField weightTextField = new TextField();
    private TextField sizeTextField = new TextField();
    private TextField creditTextField = new TextField();
    private TextField memoryTextField = new TextField();
    private TextField phoneNoTextField = new TextField();
    private TextField durationTextField = new TextField();
    private TextField downloadTextField = new TextField();
    private TextField displayNoTextField = new TextField();

    //buttons
    private JButton addMobileBtn = new JButton("Add Mobile");
    private JButton clearBtn = new JButton("Clear");
    private JButton addMp3Btn = new JButton("Add MP3");
    private JButton displayAllBtn = new JButton("Display All");
    private JButton makeCallBtn = new JButton("Make A Call");
    private JButton downloadMusicBtn = new JButton("Download Music");

    /**
     * This is the main method which makes an instance of GadgetShop and uses it to initialise GUI elements  .
     * @param args Unused.
     * @return None.
     */
    public static void main(String[] args) {
        GadgetShop gadgetShop = new GadgetShop();
        gadgetShop.initialGuiComponents();
    }

    /**
     * This is the initialGuiComponents method which uses instance variables for GadgetShop to set up the gui for the system  .
     */
    public void initialGuiComponents() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 4));

        //Model Panel
        modelPanel.add(new JLabel("Model:"));
        modelPanel.add(modelTextField);
        frame.add(modelPanel);

        //Price Panel
        pricePanel.add(new JLabel("Price:"));
        pricePanel.add(priceTextField);
        frame.add(pricePanel);

        //Price Panel
        weightPanel.add(new JLabel("Weight:"));
        weightPanel.add(weightTextField);
        frame.add(weightPanel);

        //size Panel
        sizePanel.add(new JLabel("Size:"));
        sizePanel.add(sizeTextField);
        frame.add(sizePanel);

        //credit Panel
        creditPanel.add(new JLabel("Credit:"));
        creditPanel.add(creditTextField);
        frame.add(creditPanel);

        //memory Panel
        memoryPanel.add(new JLabel("Memory:"));
        memoryPanel.add(memoryTextField);
        frame.add(memoryPanel);

        //add clear Panel
        addClearPanel.add(addMobileBtn);
        addClearPanel.add(clearBtn);
        frame.add(addClearPanel);

        //add mp3 display all
        mp3DisplayAllPanel.add(addMp3Btn);
        mp3DisplayAllPanel.add(displayAllBtn);
        frame.add(mp3DisplayAllPanel);

        //phone no
        phoneNoPanel.add(new JLabel("Phone No:"));
        phoneNoPanel.add(phoneNoTextField);
        frame.add(phoneNoPanel);

        //duration
        durationPanel.add(new JLabel("Duration:"));
        durationPanel.add(durationTextField);
        frame.add(durationPanel);

        //download
        downloadPanel.add(new JLabel("Download:"));
        downloadPanel.add(downloadTextField);
        frame.add(downloadPanel);

        //display number
        displayNoPanel.add(new JLabel("Display No:"));
        displayNoPanel.add(displayNoTextField);
        frame.add(displayNoPanel);
        frame.add(makeCallBtn);
        frame.add(downloadMusicBtn);

        //add a listener to the different buttons
        addMobileBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        addMp3Btn.addActionListener(this);
        displayAllBtn.addActionListener(this);
        makeCallBtn.addActionListener(this);
        downloadMusicBtn.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
    }




    /***
     * this is the addMobile method it gets model,size from their respective text fields
     * it also calls different methods that return price, weight and credit
     * and then uses these values to create an instance of Mobile and add it to the gadgetList
     * @return None
     */

    public void addMobile() {
        String model = modelTextField.getText();
        String size = sizeTextField.getText();
        double price = getCost();
        int weight = getWeight();
        int credit = getCredit();
        if(price!=0 && weight!=0 && credit !=0){
            gadgetList.add(new Mobile(price, weight, model, size, credit));
            JOptionPane.showMessageDialog(frame, "Mobile Added");
            clearFields();
        }

    }

    /***
     * this is the addMp3 method. It gets model,size from their respective text fields
     * it also calls different methods that return price, weight and memory
     * and then uses these values to create an instance of Mp3 and add it to the gadgetList
     * @return None
     */
    public void addMp3() {
        String model = modelTextField.getText();
        String size = sizeTextField.getText();
        double price = getCost();
        int weight = getWeight();
        int memory = getMemory();
        if(price!=0 && weight!=0 && memory!=0){
            gadgetList.add(new Mp3(price, weight, model, size, memory));
            JOptionPane.showMessageDialog(frame, "Mp3 Added");
            clearFields();
        }
    }

    /***
     * this is the displayAll method.
     * It iterates through each gadget in gadgetList as it
     * prints it's display number and also calls print method
     * on that object to display the gadgets details
     *
     * @return None
     */
    public void displayAll() {
        for (int i=0; i<gadgetList.size(); i++) {
            System.out.println("Display no.  "+i);
            gadgetList.get(i).print();
        }
        JOptionPane.showMessageDialog(frame, "Display done check console");
    }

    /***
     * this is the makeCall method.
     * It gets phoneNumber from its text field,
     * checks its validity then calls makeCall method on a Mobile class object
     * @return None
     */
    public void makeCall() {
        String phoneNumber = phoneNoTextField.getText();
        int duration = getDuration();
        int displayNumber = getDisplayNo();
        
        if(phoneNumber==""){
            JOptionPane.showMessageDialog(frame, "Phone number is required");
        }else{
            if (displayNumber != -1 && displayNumber<gadgetList.size()) {
                Mobile ourMobile = (Mobile) gadgetList.get(displayNumber);
                ourMobile.MakeCall(phoneNumber, duration);
                JOptionPane.showMessageDialog(frame, "Make call performed check console");
            }else{
                JOptionPane.showMessageDialog(frame, "Invalid Display no");
            }
        }
    }

    /***
     * this is the makeCall method.
     * It gets phoneNumber from its text field,
     * checks its validity then calls makeCall method on a Mobile class object
     * @return None
     */
    public void downLoadMusic() {
        int downloadSize = getDownloadSize();
        int displayNumber = getDisplayNo();
        if (displayNumber != -1 && displayNumber<gadgetList.size()) {
            Mp3 ourMp3 = (Mp3) gadgetList.get(displayNumber);
            ourMp3.downloadMusic(downloadSize);
            JOptionPane.showMessageDialog(frame, "Download performed check console");
        }else{
            JOptionPane.showMessageDialog(frame, "Invalid Display no");
        }

    }

    /***
     * this is the getDisplayNo method.
     * It gets displayNumber from text field, attempts to convert it to an integer,
     * if it succeeds, it returns it else returns -1
     * @return int
     */
    public int getDisplayNo() {
        int displayNumber = -1;
        String userValue = displayNoTextField.getText();
        try {
            int convertedValue = Integer.parseInt(userValue);
            return convertedValue;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "display required and must be an integer greater than 0");
        }
        return displayNumber;
    }

    /***
     * this is the getDownloadSize method.
     * It gets download size from text field, attempts to convert it to an integer,
     * if it succeeds, it returns it else alerts an error and returns 0
     * @return int
     */
    public int getDownloadSize() {
        String downloadSize = downloadTextField.getText();
        try {
            int convertedDownloadSize = Integer.parseInt(downloadSize);
            return convertedDownloadSize;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "download size required and must be an integer");
            return 0;
        }
    }

    /***
     * this is the getDuration method.
     * It gets duration from text field, attempts to convert it to an integer,
     * if it succeeds, it returns it else alerts an error and returns 0
     * @return int
     */
    public int getDuration() {
        String duration = durationTextField.getText();
        try {
            int convertedDuration = Integer.parseInt(duration);
            return convertedDuration;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "duration required and must be an integer");
            return 0;
        }
    }

    /***
     * this is the getCost method.
     * It gets price from text field, attempts to convert it to a double,
     * if it succeeds, it returns it else alerts an error and returns 0
     * @return double
     */
    public double getCost() {
        String price = priceTextField.getText();
        try {
            double convertedPrice = Double.parseDouble(price);
            return convertedPrice;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "Cost required and must be a double");
            return 0;
        }

    }

    /***
     * this is the getWeight method.
     * It gets weight from text field, attempts to convert it to an int,
     * if it succeeds, it returns it else alerts an error and returns 0
     * @return int
     */
    public int getWeight() {
        String weight = weightTextField.getText();
        try {
            int convertedWeight = Integer.parseInt(weight);
            return convertedWeight;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "weight required and must be an integer");
            return 0;
        }
    }

    /***
     * this is the getCredit method.
     * It gets credit from text field, attempts to convert it to an int,
     * if it succeeds, it returns it else alerts an error and returns 0
     * @return int
     */
    public int getCredit() {
        String credit = creditTextField.getText();
        try {
            int convertedCredit = Integer.parseInt(credit);
            return convertedCredit;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "credit required and must be an integer");
            return 0;
        }
    }

    /***
     * this is the getMemory method.
     * It gets memory from text field, attempts to convert it to an int,
     * if it succeeds, it returns it else alerts an error and returns 0
     * @return int
     */
    public int getMemory() {
        String memory = memoryTextField.getText();
        try {
            int convertedMemory = Integer.parseInt(memory);
            return convertedMemory;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "memory required and must be an integer");
            return 0;
        }
    }

    /***
     * this is the clearFields method.
     * it sets text in all text fields to an empty string
     * @return None
     */
    public void clearFields() {
        modelTextField.setText("");
        priceTextField.setText("");
        weightTextField.setText("");
        sizeTextField.setText("");
        creditTextField.setText("");
        memoryTextField.setText("");
        phoneNoTextField.setText("");
        durationTextField.setText("");
        downloadTextField.setText("");
        displayNoTextField.setText("");
    }

    /***
     * this is the actionPerformed method.
     * It calls a given method basing on the button that has been pressed
     * @param e ActionEvent
     * @return None
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==addMobileBtn){
            addMobile();
        }

        if(e.getSource()==clearBtn){
            clearFields();
        }

        if(e.getSource()==addMp3Btn){
            addMp3();
        }

        if(e.getSource()==displayAllBtn){
            displayAll();
        }

        if(e.getSource()==makeCallBtn){
            makeCall();
        }

        if(e.getSource()==downloadMusicBtn){
            downLoadMusic();
        }

    }
}