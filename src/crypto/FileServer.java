/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

/**
 *
 * @author DELL
 */
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.swing.JOptionPane;

public class FileServer extends Thread {
    
    public ImageCrypto imageCrypto;
    
    PacketLoss packetLoss;
    int receiveCount = 0;
	
	private ServerSocket ss;
    private ReentrantLock re;
	
	public FileServer(int port) {
		try {
			ss = new ServerSocket(port);
                        JOptionPane.showMessageDialog(imageCrypto, "Server is running");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
            
		while (true) {
                    try {            	
                            Socket clientSock = ss.accept();
                            saveFile(clientSock);
                            
			} catch (IOException e) {
                               
			}
		}
                
	}

	private void saveFile(Socket clientSock) throws IOException {
		DataInputStream dis = new DataInputStream(clientSock.getInputStream());
		FileOutputStream fos = new FileOutputStream("testfile.jpg");
		byte[] buffer = new byte[16];
		
		int filesize = 15123; // Send file size in separate msg
		int read = 0;
		int totalRead = 0;
		int remaining = filesize;
		while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
			totalRead += read;
			remaining -= read;
			//System.out.println("read " + totalRead + " bytes.");
			fos.write(buffer, 0, read);
                        receiveCount++;
		}
              
               
                
                //packetLoss.setrCount(receiveCount);
                //packetLoss.calPacketLoss();
		JOptionPane.showMessageDialog(imageCrypto, "File recieved Successfully");
		fos.close();
		dis.close();
	}	
}