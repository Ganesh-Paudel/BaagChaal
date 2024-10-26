import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class boardPanel extends JPanel{
    private int size = 5;
    private int tileSize = 50;
    private int width = (size ) * tileSize;
    private int height = width;
    private boolean boardDrawn = false;

    ImageIcon tiger = new ImageIcon(getClass().getResource("assets/tiger.png"));
    

    public class tile extends JButton{
        int x;
        int y;
        ImageIcon value;
        tile(int x, int y){
            this.x =x;
            this.y = y;
            this.value = null;


        }
        public void setImage(ImageIcon value)
        {
            Image img = value.getImage();
            Image resizedImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImg);
            this.setIcon(resizedIcon);
        }
    }

    //buttons
    tile[][] chaals = new tile[5][5];
    JButton selectedButton = null;



    boardPanel(){
        this.setPreferredSize(new Dimension(400,400));
        // this.setBackground(Color.red);
        this.setLayout(new GridLayout(5,5,50,35));
        
        
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){

                tile tiles = new tile(i, j);
                chaals[i][j] = tiles;

                selectedButton = chaals[i][j];
                chaals[i][j].addActionListener(new setIconListener());
                


                this.add(tiles);
                

        }
    }
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (!boardDrawn)
    {
        drawBoard(g);
        setUpInitial();
    }
    
    
}
    public void setUpInitial(){
        chaals[0][0].setImage(tiger);
        chaals[size-1][0].setImage(tiger);
        chaals[0][size-1].setImage(tiger);
        chaals[size-1][size-1].setImage(tiger);
    }

    public void drawBoard(Graphics g)
    {
        int rows = size;
        int cols = size;
        int width = getWidth();
        int height = getHeight();
        
        int cellWidth = width / cols;
        int cellHeight = height / rows;

        g.setColor(Color.BLACK);
        for (int i = 0; i < cols; i++) {
            int x = i * cellWidth + 40;
            g.drawLine(x, 30, x, height-30);
        }

        for (int i = 0; i < rows; i++) {
            int y = i * cellHeight + 30;
            g.drawLine(30, y, width-30, y);
        }
        g.drawLine(30,0 , width, height);
        g.drawLine(width,0 , 0, height);
        g.drawLine(0, height/2 + 10, width/2, 0);
        g.drawLine(0, height/2 - 10, width/2, height-50);
        g.drawLine(width/2, height-50, width-30, height/2);
        g.drawLine(width-30, height/2, width/2, 0);

    }
    
    private class setIconListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();

            if (selectedButton != null && selectedButton != clickedButton) {
                // Transfer the icon from the selected button to the clicked button
                clickedButton.setIcon(selectedButton.getIcon());
                selectedButton.setIcon(null); // Remove icon from the previous button

                // Update selectedButton to the newly clicked button
                selectedButton = clickedButton;
            }
        
        }
    
    }

   
}



