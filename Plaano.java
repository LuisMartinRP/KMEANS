/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Luis Martin R.P
 */
public class Plaano{
    JPanel p;
    int w,h;
    
    public Plaano(JPanel p){
        this.p=p;
    }
    
    public void paint(double[]pgx,double[]pgy,int points,int nc,int[]pcg,double[]cxg,double[]cyg,int[]re,int[]gr,int[]bl,boolean clasificando){
        int cont=0;
        double gx,gy;
        Graphics2D g=(Graphics2D)p.getGraphics();
        
        g.clearRect(0,0,1110,560);
        g.translate(100, 550);
        g.drawLine (0, 0, 1000, 0);
        g.drawLine (0, 0, 0, -500);
        for(int i=0;i<=1000;i+=100){
            g.fillOval (i-3, -3, 6, 6);
            g.drawString(String.valueOf(cont),i-3, 15);
            if(i<=500){
                g.fillOval (-3, (-1*i)-3, 6, 6);
                g.drawString(String.valueOf(cont),-10,(-1*i)-3);
            }
            cont++;
        }
        cont=0;
        if(!clasificando){
            for(int i=0;i<points;i++){
                g.setColor (Color.blue);
                gx=(pgx[i]*100)-3;
                gy=(pgy[i]*-100)-3;
                g.fillOval ((int)gx,(int)gy, 6, 6);
            }
        }else{
            /*int re=(int)(Math.random()*254);
            int gr=(int)(Math.random()*200);
            int bl=(int)(Math.random()*200);*/
            for(int i=0;i<pcg.length;i++){
                Color color=new Color(re[pcg[i]], gr[pcg[i]], bl[pcg[i]]);
                g.setColor (color);
                gx=(pgx[i]*100)-3;
                    gy=(pgy[i]*-100)-3;
                    if(pcg.length>0)
                        g.fillOval ((int)gx, (int)gy, 6, 6);
                
            }
            /*for(int j=0;j<nc;j++){
                Color color=new Color(re[j], gr[j], bl[j]);
                g.setColor (color);
                for(int i=0;i<points;i++){
                    gx=(pgx[i]*100)-3;
                    gy=(pgy[i]*-100)-3;
                    if(pcg.length>0)
                        if(pcg[i]==j)
                            g.fillOval ((int)gx, (int)gy, 6, 6);
                }*/
                /*re=(int)(Math.random()*254);
                gr=(int)(Math.random()*254);
                bl=(int)(Math.random()*254);*/
            
        }
        
        for(int i=0;i<nc;i++){
            if(cxg.length!=0 && cyg.length!=0){
                g.setColor (Color.red);
                gx=(cxg[i]*100)-3;
                gy=(cyg[i]*-100)-3;
                g.fillOval ((int)gx,(int)gy, 6, 6);
            }
        }
        //System.out.println("Si entro");
    }
}
