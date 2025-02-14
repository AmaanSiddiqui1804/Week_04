/* 8. Piped Streams - Inter-Thread Communication
📌 Problem Statement:
Implement a Java program where one thread writes data into a PipedOutputStream and another thread reads data from a PipedInputStream.
Requirements:
Use two threads for reading and writing.
Synchronize properly to prevent data loss.
Handle IOException.
 */
package com.piped_streams;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            pos.write("Hello from Writer Thread!".getBytes());
            pos.close(); // Close stream after writing
        } catch (IOException e) {
            System.out.println("Writer Error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;
            System.out.print("Reader received: ");
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
            pis.close();
        } catch (IOException e) {
            System.out.println("Reader Error: " + e.getMessage());
        }
    }
}

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writer = new WriterThread(pos);
            Thread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

            writer.join();
            reader.join();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
