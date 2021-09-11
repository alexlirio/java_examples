package br.com.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


public class GoogleQRCodes {

	public static void main(String[] args) {
		String textoTest = "123456789012345678@123456@12345678123#a2345678901234567890123456789012#1234567^12345678123#a2345678901234567890123456789012#1234567";
		gerarQrCode(textoTest);
	}

	private static void gerarQrCode(String texto) {
		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix bitMatrix = null;
		try {
			bitMatrix = writer.encode(texto, BarcodeFormat.QR_CODE, 200, 200);
			MatrixToImageWriter.writeToFile(bitMatrix, "png", new File("src/main/resources/qr_png.png"));
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BufferedImage gerarQrCodeBufferedImage(String texto) {
		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix bitMatrix = null;
		try {
			bitMatrix = writer.encode(texto, BarcodeFormat.QR_CODE, 200, 200);
			BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
			return image;
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
