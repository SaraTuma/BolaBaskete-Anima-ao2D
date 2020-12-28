/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolaBaskete;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sara Tuma
 */
public class Dessenho3 extends JPanel implements Runnable{

     Thread t = new Thread (this);
    
    public Bola bola = new Bola();
    public int y=1;
    private int angulo=0;
    private boolean formato=false;
    private int chao;
    private double aceleracao=1.1;
    
    
    public Dessenho3(){
        t.start();
       JFrame f = new JFrame();
        f.setSize(600,600);
        f.setTitle("Bola de baskete batendo o chão, versão 3");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
       // f.setBackground(Color.black);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        
        this.setSize(600,600);
        f.add(this);
        f.setVisible(true);
        
    }
    
          @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D) g;
        g2.setColor(Color.black);
       chao=this.getHeight()-150;
        g2.fillRect(0, chao, this.getWidth(), 150);
        
        g2.rotate(Math.toRadians(angulo),bola.getPosx()+(bola.getLargura()/2), bola.getPosy()+(bola.getAltura()/2));
        g2.translate(0, bola.getDx());
        g2.drawImage(bola.getImg(),bola.getPosx(),bola.getPosy(), bola.getLargura(), bola.getAltura(), this);
    }
    
     private void dormir(){
        try {
            t.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(Desenho2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void actualizar(){
         
         this.angulo = (int) (this.angulo >= 360 ? 0 : 1 + this.angulo);
        
            //Quando a bola bate no chão
        if(bola.getPosy()==chao)
        {
            bola.setAltura(bola.getAltura()-5);
            bola.setDy(bola.getDy()*-1*(int)aceleracao);
        }
       
        if(bola.getPosy()==0){
            bola.setDy(bola.getDy()*-1);
        }
        bola.setPosy(bola.getPosy()+bola.getDy());
       // System.out.println("Posicao em y: "+bola.getPosy()+bola.getAltura());
            
     }
     
    
    @Override
    public void run() {
        while(true){
           actualizar();
            dormir();
            repaint();
        }
    }
    
}
