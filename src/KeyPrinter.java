import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyPrinter implements KeyListener {
    static String text = "";
    static JLabel label = new JLabel(text, JLabel.CENTER);
    static FileWriter fWriter;
    static File myFile;
    static BufferedWriter br;
    private static void setUp() throws IOException {
         myFile = new File("log.txt");
         fWriter = new FileWriter(myFile);
         br = new BufferedWriter(fWriter);
    }
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        //label.setText("MP7");
        frame.addKeyListener(new KeyPrinter());
        frame.add(label);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new KeyPrinter());
        setUp();
       
        
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getID() == KeyEvent.KEY_TYPED) {
        text += e.getKeyChar();
        label.setText(text);
        
    }
        if (e.getKeyChar() == KeyEvent.VK_P) {
            //If P is pressed then we write a file called log.txt on desktop
            System.out.println("Wrote to file!");
            try {
                
                br.append(text);
                br.flush();
                br.close();
            } catch (IOException ioe) {
              
            }
        }
    }
}
