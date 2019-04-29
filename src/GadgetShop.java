import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class GadgetShop {

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

    public static void main(String[] args) {
        GadgetShop gadgetShop = new GadgetShop();
        gadgetShop.initialGuiComponents();
    }

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

        //display no.
        displayNoPanel.add(new JLabel("Display No:"));
        displayNoPanel.add(displayNoTextField);
        frame.add(displayNoPanel);
        frame.add(makeCallBtn);
        frame.add(downloadMusicBtn);

        // add listeners
        addMobileBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               addMobile();
            }
        });

        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        addMp3Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMp3();
            }
        });

        displayAllBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAll();
            }
        });

        makeCallBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeCall();
            }
        });

        downloadMusicBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                downLoadMusic();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

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

    public void addMp3() {
        String model = modelTextField.getText();
        double price = getCost();
        int weight = getWeight();
        String size = sizeTextField.getText();
        int memory = getMemory();
        if(price!=0 && weight!=0 && memory!=0){
            gadgetList.add(new Mp3(price, weight, model, size, memory));
            JOptionPane.showMessageDialog(frame, "Mp3 Added");
            clearFields();
        }
    }

    public void displayAll() {
        //display the display no.
        //method to display each item in the list is called

        for (int i=0; i<gadgetList.size(); i++) {
            System.out.println("Display no.  "+i);
            gadgetList.get(i).print();
        }
        JOptionPane.showMessageDialog(frame, "Display done check console");
    }

    public void makeCall() {
        String phoneNumber = phoneNoTextField.getText();
        int duration = getDuration();

        int displayNumber = getDisplayNo();
        if (displayNumber != -1 && displayNumber<gadgetList.size()) {
            Mobile ourMobile = (Mobile) gadgetList.get(displayNumber);
            ourMobile.MakeCall(phoneNumber, duration);
            JOptionPane.showMessageDialog(frame, "Make call performed check console");
        }else{
            JOptionPane.showMessageDialog(frame, "Invalid Display no");
        }
    }

    public void downLoadMusic() {
        //The display number and download size are input via the GUI.
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
}