/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitwise;

import javax.swing.JFrame;

/**
 *
 * @author Karthick
 */
public class SplitwiseDriver {

    /**
     * @param args the command line arguments
     */
    public static JFrame defFrame;
    
    public static void main(String[] args) {
        // TODO code application logic here
        defFrame = new LoginFrame();
        defFrame.setTitle("SplitWise");
        defFrame.setVisible(true);
        defFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
}
    
}
