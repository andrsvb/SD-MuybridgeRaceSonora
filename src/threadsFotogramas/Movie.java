package threadsFotogramas;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * @ author Isabel Mu–oz. Distributed Systems. This class demonstrates how to
 * load sequential images from a horse giving the illusion of a horse running
 */

public class Movie extends Component {

	private static final long serialVersionUID = 1L;

	BufferedImage[] imgs;
	// array with the horse's movement images

	int cImg = 0; // current movement
	int numImages = 0; // num of cartoon's images
	int width = 0; // of the image
	int widthFrame = 0; // of the frame
	int cWidth = 0;

	Movie(String source, int numImages) {

		Integer i = new Integer(0);
		imgs = new BufferedImage[numImages];
		this.numImages = numImages;

		for (i = 0; i < numImages; i++) {
			try { // load the image sequences in the array
				imgs[i] = ImageIO.read(new File(source + i.toString() + ".gif"));
			}
			catch (IOException e) {
				e.toString();
			}
		}
		width = imgs[0].getWidth();
		widthFrame = width * numImages;
	}

	public void nextMovement() {
		cImg = (cImg + 1) % numImages;
		cWidth = (cWidth + 1) % (numImages * 4);
	}

	public void paint(Graphics g) {
		// the image will be repaint each 1/4 of the image size
		g.drawImage(imgs[cImg], cWidth * width / 4, 0, null);
	}

	public Dimension getPreferredSize() {
	  // This sets the dimension of the canvas where the images will be displayed
		return new Dimension(imgs[cImg].getWidth(null) * numImages,
				imgs[cImg].getHeight(null));
	}
}
