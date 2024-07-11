import javax.swing.JFrame;


public class DisplayFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	private DisplayPanel panel;

	public DisplayFrame(Main m){
		this.setTitle("Display");
    		this.setSize(700, 400);
    		this.setLocationRelativeTo(null);               
    		panel=new DisplayPanel(m);
    		this.setContentPane(panel);
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
