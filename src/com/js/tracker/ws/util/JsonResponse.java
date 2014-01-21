package com.js.tracker.ws.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.gson.Gson;

public class JsonResponse {
	private boolean status;
	private String message;
	private Object response;

	public JsonResponse(boolean status, String message, Object response) {
		super();
		this.status = status;
		this.message = message;
		this.response = response;
	}

	public String getJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	private static final int IMG_WIDTH = 800;
	private static final int IMG_HEIGHT = 553;

	public static void main(String[] args) {

		try {

			BufferedImage originalImage = ImageIO.read(new File(
					"c:\\cap\\puran.jpg"));
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
					: originalImage.getType();

			BufferedImage resizeImageJpg = resizeImage(originalImage, type);
			ImageIO.write(resizeImageJpg, "jpg", new File(
					"c:\\cap\\mkyong_jpg.jpg"));

			BufferedImage resizeImagePng = resizeImage(originalImage, type);
			ImageIO.write(resizeImagePng, "png", new File(
					"c:\\cap\\mkyong_png.jpg"));

			BufferedImage resizeImageHintJpg = resizeImageWithHint(
					originalImage, type);
			ImageIO.write(resizeImageHintJpg, "jpg", new File(
					"c:\\cap\\mkyong_hint_jpg.jpg"));

			BufferedImage resizeImageHintPng = resizeImageWithHint(
					originalImage, type);
			ImageIO.write(resizeImageHintPng, "png", new File(
					"c:\\cap\\mkyong_hint_png.jpg"));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private static BufferedImage resizeImage(BufferedImage originalImage,
			int type) {
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT,
				type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();

		return resizedImage;
	}

	private static BufferedImage resizeImageWithHint(
			BufferedImage originalImage, int type) {

		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT,
				type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		return resizedImage;
	}
}
