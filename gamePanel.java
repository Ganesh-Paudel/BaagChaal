import java.awt.*;
import javax.swing.*;


public class gamePanel{

    int cellDistance = 50;
    int noOfCells = 5;

    int screenWidth = 700;
    int screenHeight = 700;


    //frame
    JFrame frame;
    //panel
    JPanel topPanel;
    boardPanel gridPanel;
    JPanel sidePanel;
    JPanel sidePanel1;
    JPanel sidePanel2;

    //label
    JLabel topLabel;
    JButton goats;

    //icon
    Image img = new ImageIcon(getClass().getResource("assets/goat.png")).getImage();
    Image resImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    ImageIcon goat = new ImageIcon(resImg);


    gamePanel(){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);

        topPanel = new JPanel();
        topPanel.setBackground(Color.darkGray);
        topPanel.setPreferredSize(new Dimension(screenWidth, 50));

        topLabel = new JLabel();
        topLabel.setText("BaagChaal");
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        topLabel.setForeground(Color.white);
        topLabel.setFont(new Font("Arial",Font.BOLD, 30));


        sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(100, screenHeight));
        sidePanel1 = new JPanel();
        sidePanel1.setPreferredSize(new Dimension(100, screenHeight));
        sidePanel2 = new JPanel();
        sidePanel2.setPreferredSize(new Dimension(screenWidth, 100));

        goats = new JButton();
        goats.setHorizontalAlignment(JButton.CENTER);
        goats.setIcon(goat);

        sidePanel2.add(goats);
        gridPanel = new boardPanel();
        topPanel.add(topLabel);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(gridPanel, BorderLayout.CENTER);
        frame.add(sidePanel, BorderLayout.EAST);
        frame.add(sidePanel1, BorderLayout.WEST);
        frame.add(sidePanel2, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    
}