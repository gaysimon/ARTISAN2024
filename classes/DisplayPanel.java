import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class DisplayPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Main main;
	
	public DisplayPanel(Main m){
		main=m;
	}
	
	public void paintComponent(Graphics g){
		
		g.setColor(Color.white);
		g.fillRect(0,0, this.getWidth(), this.getHeight());
		
		int test=main.test;
		if (test>main.nbTests) test--;
		
		int val=0;
		for (int i=0;i<Main.size_x;i++){
			for (int j=0;j<Main.size_y;j++){
				val=(int)(main.matrixImages[test][i+Main.size_x*j]*255);
				g.setColor(new Color(val,val,val));
				g.fillRect(10+5*i, 10+5*j, 5, 5);
			}
		}
		
		/*for (int i=0;i<Main.size_x;i++){
			for (int j=0;j<Main.size_y;j++){
				val=(int)(main.neuron.synaps[i+Main.size_x*j]*50)+128;
				if (val<0) val=0;
				if (val>255) val=255;
				g.setColor(new Color(val,val,val));
				g.fillRect(180+3*i, 10+3*j, 3, 3);
			}
		}/**/
		
		/*for (int n=0;n<10;n++){
			for (int i=0;i<Main.size_x;i++){
				for (int j=0;j<Main.size_y;j++){
					val=(int)(main.layer.layer[n].synaps[i+Main.size_x*j]*50)+128;
					if (val<0) val=0;
					if (val>255) val=255;
					g.setColor(new Color(val,val,val));
					g.fillRect(180+3*i+100*(n%5), 10+3*j+100*(n/5), 3, 3);
				}
			}
		}/**/
	}
	
}
