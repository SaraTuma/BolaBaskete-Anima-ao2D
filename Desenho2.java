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
public class Desenho2 extends JPanel implements Runnable{
    
    Thread t = new Thread (this);
    
    public Bola bola = new Bola();
    public int y=1;
    public int bateu=0; 
    private int angulo=0;
    private double aceleracao=1.1;
    private boolean terminar=true;
    
    
     public Desenho2(){
         t.start();
       JFrame f = new JFrame();
        f.setSize(600,600);
        f.setTitle("Bola de baskete batendo no chão");
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
       // g2.rotate(Math.toRadians(angulo*-1),bola.getPosx()+(bola.getLargura()/2), bola.getPosy()+(bola.getAltura()/2));
        AffineTransform obj = g2.getTransform();
            g2.translate(0, y);

            g2.drawImage(bola.getImg(),bola.getPosx(),bola.getPosy(), bola.getLargura(), bola.getAltura(), this);
        g2.setTransform(obj);
        //obj= g2.getTransform();
        
    }
    
    private void dormir(){
        try {
            t.sleep(15);
        } catch (InterruptedException ex) {
            Logger.getLogger(Desenho2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void actualizar(){
       // this.angulo = (int) (this.angulo >= 360 ? 0 : 1 + this.angulo);
        if(bola.getPosy()+bola.getAltura()>570)
        {
            System.out.println( "BATEU NO CHÃO " );
            y=y*-1; bateu++;
        }  
        bola.setDy(++y);
        bola.setPosy(bola.getPosy()+bola.getDy());  
    }
    
    @Override
    public void run(){ 
       while(terminar){
           //Limitei a quantidade de batidas (ao chão!!)
           if(bateu==40) break; 
            actualizar(); //Actualizando a nova posicao da bola e suas alterações
            dormir(); //Pausar a execução da thread
            repaint(); //Chamada do metodo paintComponet()
       }
    }
}
