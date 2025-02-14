/* 5. ByteArray Stream - Convert Image to ByteArray
📌 Problem Statement:
Write a Java program that converts an image file into a byte array and then writes it back to another image file.
Requirements:
Use ByteArrayInputStream and ByteArrayOutputStream.
Verify that the new file is identical to the original image.
Handle IOException.
 */
package com.bytearray_stream;
import java.io.*;

public class ImageByteArray {
    public static void main(String[] args) {
        String sourceImage = "D:\\Week_04\\Day_03\\src\\com\\bytearray_stream\\TestImage.jpg"; //Original image
        String destinationImage = "D:\\Week_04\\Day_03\\src\\com\\bytearray_stream\\NewImage.jpg"; // New image file

        try {
            // Read image into byte array
            FileInputStream fis = new FileInputStream(sourceImage);
            ByteArrayOutputStream bs = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bs.write(buffer, 0, bytesRead);
            }
            fis.close();

            byte[] imageBytes = bs.toByteArray();

            // Writing byte array to new image file
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes);
            FileOutputStream fileOutputStream = new FileOutputStream(destinationImage);

            while ((bytesRead = byteArrayInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            fileOutputStream.close();
            System.out.println("Image copied successfully!");

        } catch (IOException e) {
            System.out.println("Error processing image: " + e.getMessage());
        }
    }
}
