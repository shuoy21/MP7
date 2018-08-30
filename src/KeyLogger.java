import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
	
public class KeyLogger implements KeyListener {

		static String text = "";
		static JLabel label = new JLabel(text, JLabel.CENTER);
		
		public static void main(String[] args) {
			JFrame frame = new JFrame();
			label.setText("MP7"); 
	    
			frame.addKeyListener(new KeyLogger());
			frame.add(label);
			frame.setSize(400, 400); 
			frame.setVisible(true); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.addKeyListener(new KeyLogger());
		}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_TYPED) {
			text += e.getKeyChar();
			label.setText(text);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	}
