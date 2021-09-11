package br.com.example;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageUtil {

	public static void main(String[] args) {
		
		File fileA = new File("src/main/resources/fileA.jpg");
		File fileB = new File("src/main/resources/fileB.jpg");
		
		System.out.println("The images are equals? Response is: " + compareImage(fileA, fileB));

	}

	// This API will compare two image file //
	// return true if both image files are equal else return false//**
	public static boolean compareImage(File fileA, File fileB) {
		try {
			// take buffer data from botm image files //
			BufferedImage biA = ImageIO.read(fileA);
			DataBuffer dbA = biA.getData().getDataBuffer();
			int sizeA = dbA.getSize();
			BufferedImage biB = ImageIO.read(fileB);
			DataBuffer dbB = biB.getData().getDataBuffer();
			int sizeB = dbB.getSize();
			// compare data-buffer objects //
			if (sizeA == sizeB) {
				for (int i = 0; i < sizeA; i++) {
					if (dbA.getElem(i) != dbB.getElem(i)) {
						return false;
					}
				}
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Failed to compare image files ...");
			return false;
		}
	}

}
