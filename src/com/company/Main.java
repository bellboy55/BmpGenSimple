package com.company;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.File;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {
        // CONSTANTS //
        final int IMG_WIDTH = 8;
        final int IMG_HEIGHT = 5;

	    boolean[][] imgarray = new boolean[IMG_HEIGHT][IMG_WIDTH]; // Initialize array

        // -- for testing purposes -- //
        imgarray[0][1] = true;
        imgarray[1][3] = true;
        imgarray[2][3] = true;
        imgarray[4][2] = true;
        // -------------------------- //

	    for (int i = 0; i < imgarray.length; i++) System.out.println(Arrays.toString(imgarray[i])); // Print array

        convertBoolarrToBmp(imgarray, "img.bmp");
    }

    public static boolean convertBoolarrToBmp(boolean[][] boolarr, String filename) {
        try {
            // make buffered image
            final BufferedImage buffimg = new BufferedImage(boolarr[0].length, boolarr.length, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < boolarr.length; i++) {
                for (int j = 0; j < boolarr[0].length; j++) {
                    if (boolarr[i][j] == false) buffimg.setRGB(j, i, Color.WHITE.getRGB());
                    else buffimg.setRGB(j, i, Color.BLACK.getRGB());
                }
            }

            // make rendered image
            RenderedImage rendimg = buffimg;
            ImageIO.write(rendimg, "bmp", new File(filename));

            return true;
        } catch (java.io.IOException | java.lang.IndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }
    }
}
