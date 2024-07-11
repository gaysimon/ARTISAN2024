import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class Main {

	public static String PATH="C:\\Users\\login\\Desktop\\numbers\\";	// path to images
	
	public static int size_x=28;	// size of the image (set when image is loaded)
	public static int size_y=28;
	
	public int nbTests=1000;		// number of images (set when loaded)
	
	public float[][] matrixImages;	// dataset as a matrix
	public int[] matrixLabels;		// labels as a vector
	
	public int epoch=0;				// current epoch
	public int test=0;				// current image
	
	
	public int number=2;	// choose a number
	
	
	private DisplayFrame display;	// display panel
	
	
	
	//public Neuron neuron;			// neuron	
	
	
	
	//////////////
	public Main(){
		
		///////////////////////////////////////////////////
		// initialization
		///////////////////////////////////////////////////
		//neuron=new Neuron(size_x*size_y);
		
		// load test matrix
		setData("train-images.idx3-ubyte","train-labels.idx1-ubyte");

		// initialize display frame
		display=new DisplayFrame(this);
		
		
		//////////////////////////////////////////////////
		// learning
		//////////////////////////////////////////////////
		
		// apply the learning process 50 times
		for (epoch=0;epoch<50;epoch++){
			
			float sumdelta=0;	// measure total error of the current epoch
			
			// for each test image
			for (test=0;test<matrixImages.length;test++){
				
				// set output value
				//int expected=0;
				//if (matrixLabels[test] == number) expected=1;
				
				// process neuron

				
				// reinforce neuron

				
				// add delta to the error sum
				//sumdelta+=Math.abs(neuron.delta);
				
				display.repaint();
				
				try {Thread.sleep(100);
				} catch (InterruptedException e) {e.printStackTrace();}
			}

			
			// display mean error of the epoch
			System.out.println("epoch n°"+epoch+" : "+(sumdelta/nbTests));
		}
		
		System.out.println("learning completed");
		
		
		//////////////////////////////////////////////////
		// exploitation
		//////////////////////////////////////////////////
		
		// test neuron on test dataset
		int errors=0;
		
		// load test matrix
		setData("t10k-images.idx3-ubyte","t10k-labels.idx1-ubyte");
		
		
		// test each image of the 
		for (test=0;test<matrixImages.length;test++){
			
			// process neuron

			
			//if (res<0.001) res=0;	// avoid low values displayed as "9.9586 x 10^-5" 
			//System.out.println(matrixLabels[test]+" -> "+res);
			

			// count errors
			//if (matrixLabels[test]==number && res<0.5 || matrixLabels[test]!=number && res>0.5) errors++;
			
		}

		
		// display error number
		System.out.println("errors : "+errors);
		
		display.repaint();
	}
	
	
	
	// load dataset in data matrices
	public void setData(String fileImg, String fileLabels){
		try {
			DataInputStream dataFile = new DataInputStream(
												new BufferedInputStream(
												   new FileInputStream(PATH+fileImg)));
			
			int magicNumber = dataFile.readInt();
	        int nbImages = dataFile.readInt();
	        size_y = dataFile.readInt();
	        size_x = dataFile.readInt();

	        System.out.println("magic number is " + magicNumber);
	        System.out.println("number of items is " + nbImages);
	        System.out.println("number of rows is: " + size_y);
	        System.out.println("number of cols is: " + size_x);
	        
	        int nbPixels=size_x*size_y;
	        matrixImages=new float[nbImages][nbPixels];
	        
	        for (int i=0;i<nbImages;i++){
	        	for (int j=0;j<nbPixels;j++){
	        		matrixImages[i][j]=((float)dataFile.readUnsignedByte())/255;
	        	}
	        }
	        
	        dataFile.close();
			
			DataInputStream labelFile = new DataInputStream(
												new BufferedInputStream(
												   new FileInputStream(PATH+fileLabels)));
			int labelMagicNumber = labelFile.readInt();
		    nbTests = labelFile.readInt();
	
		    System.out.println("labels magic number is: " + labelMagicNumber);
		    System.out.println("number of labels is: " + nbTests);
		
		    matrixLabels=new int[nbTests];
		    for (int i=0;i<nbTests;i++){
		    	matrixLabels[i]=labelFile.readUnsignedByte();
		    }
		    
		    labelFile.close();
		
		} catch (IOException e) {System.out.print(e);}
		
	}
	
	
	
	public static void main(String[] args) {
		
		new Main();
		
	}

}
