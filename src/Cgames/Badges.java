package Cgames;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Badges extends Stats{
	public Badges() {
		
	}
    public void starter() {
    	URL url = getClass().getResource("History.txt");
    	String mainPath = null;
    	boolean played = false;
    	try {
			URI uri = url.toURI();
			mainPath = Paths.get(uri).toString();
            mainPath = mainPath.replace("\\bin\\", "\\src\\");
            List<String> x = Files.readAllLines(Path.of(mainPath));
            if(!(x.isEmpty() || x.get(0).equals(""))) {
            	played = true;
            }
            
		} catch (URISyntaxException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	JFrame frame = new JFrame();
    	int c = 25;
		frame.setLayout(new GridLayout(5,5));
		if(played) {
    		try {
				displayPicture(frame, ImageIO.read(new URL("https://i1.sndcdn.com/avatars-000578186550-y571sy-t500x500.jpg")));
			    c-- ;
    		} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		for(int k = 0; k<c;k++) { 
			try {
				displayPicture(frame,  ImageIO.read(new URL(
						"https://upload.wikimedia.org/wikipedia/commons/0/06/Question-mark.jpg")));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		frame.setTitle("Your guessing Badges");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		frame.setVisible(true);
    }
	public Badges(Path path) {

		// TODO Auto-generated constructor stub
	}
	public static void displayPicture(JFrame frame, BufferedImage img) throws MalformedURLException, IOException {
	 ImageIcon icon = new ImageIcon(img);
	 Image cImage = icon.getImage();
     icon = new ImageIcon(createResizedCopy(cImage, 250, 130, true));
     JLabel label = new JLabel(icon);

     JScrollPane scrollPane = new JScrollPane(label);
     scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
     frame.add(scrollPane, BorderLayout.CENTER);
		  }

	static BufferedImage createResizedCopy(Image originalImage, 
            int scaledWidth, int scaledHeight, 
            boolean preserveAlpha)
    {
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
        g.dispose();
        return scaledBI;
    }
}
