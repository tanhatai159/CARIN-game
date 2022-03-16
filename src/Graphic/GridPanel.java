package Graphic;

import MainClass.GameStates;
import java.awt.*;
import javax.swing.*;
import static MainClass.GameStates.generateVirus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
//draw rect version
//public class GridPanel extends JPanel {
//
//        private final int NUM_SQUARES = 144;
//        private final int RECT_SIZE = 55;
//        private ArrayList<Rectangle> grid = null;
//
//        public GridPanel() {
//
//            setSize( 900, 500 );
//
//            // Build the grid
//            grid = new ArrayList<Rectangle>( NUM_SQUARES );
//
//            for( int y=0; y < NUM_SQUARES / 16; ++y ) {
//                for( int x=0; x < NUM_SQUARES / 9; ++x ) {
//                    Rectangle rect = new Rectangle( x * RECT_SIZE, y * RECT_SIZE, RECT_SIZE, RECT_SIZE );
//                    grid.add(rect);
//                }
//            }
//        }
//
//        @Override
//        protected void paintComponent(Graphics g) {
//
//            super.paintComponent(g);
//
//            g.setColor(new Color(151,52,46));
//            g.fillRect(0, 0, 900, 500);
//
//            // paint the grid
//            for( Rectangle r : grid ) {
//                g.setColor(new Color(193,82,75));
//                g.fillRect( 5+(r.x), r.y, r.width-1, r.height-1 );
//            }
//        }
//    }

//draw
public class GridPanel extends JPanel {

    JPanel buttonP = new JPanel();
    JButton[] btn = new JButton[9];

    public GridPanel(){
        buttonP.setLayout(new GridLayout(3,3));
        buttonP.setBackground(Color.red);
        for(int i=0;i<9;i++){
            btn[i] = new JButton(" ");
            buttonP.add(btn[i]);
            btn[i].setFont(new Font("Roboto Condensed",Font.PLAIN,80));
            btn[i].setFocusable(false);

        }
    }

}


