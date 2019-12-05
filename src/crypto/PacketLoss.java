/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import javax.swing.JOptionPane;


public class PacketLoss {
    private int sCount;
    private int rCount;
    
    public int getsCount() {
        return 100;
    }

    public void setsCount(int sCount) {
        this.sCount = sCount;
    }

    public int getrCount() {
        return rCount;
    }

    public void setrCount(int rCount) {
        this.rCount = rCount;
    }
    
    public void calPacketLoss(){
        int s = getsCount();
        int r = getrCount();
        float pLoss = (s/r)*100;
        JOptionPane.showMessageDialog(null, "Packet Loss: " + pLoss + "%");
    }

}
