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
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

public class FileClient {
	ImageCrypto imageCrypto;
	PacketLoss packetLoss;
        private Socket s;
        int sentCount = 0;
        
	
	public FileClient(String host, int port, String file) {
		try {
			s = new Socket(host, port);
			sendFile(file);
       
		} catch (Exception e) {
			JOptionPane.showMessageDialog(imageCrypto, e);
		}		
	}
	
	public void sendFile(String file) throws IOException, Exception {
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[16];
		
		while (fis.read(buffer) > 0) {
			dos.write(buffer);
                        sentCount++;
		}
                
               JOptionPane.showMessageDialog(imageCrypto,"File sent successfully");
		fis.close();
		dos.close();	
	}
	
	
}