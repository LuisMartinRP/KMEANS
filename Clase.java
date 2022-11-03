/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans;

import java.util.ArrayList;

/**
 *
 * @author Luis Martin R.P
 */
public class Clase { 
    double distancia,menor;
    int pos,cont;
    int id[];
    double xsum=0,ysum=0;

     ArrayList<Punto> GenerarClase(ArrayList<Punto> atr,ArrayList<Punto> puntos){
        double[] dist=new double[atr.size()];
        ArrayList<Punto> centroides = new ArrayList<Punto>();
        id=new int[atr.size()];
        for(Punto p:puntos){
            for(int i=0;i<atr.size();i++){
                distancia=Math.sqrt(Math.pow(p.x-atr.get(i).x,2)+Math.pow(p.y-atr.get(i).y,2));
                dist[i]=distancia;
                id[i]=i;
            }
            p.clase=obtenerclase(dist,id);
            //System.out.println(p.clase);
        }
        calculaCentroide(puntos,atr.size(),atr,centroides);
        return centroides;
    }
    int obtenerclase(double[] dist,int[] id){
        for(int i=1;i<dist.length;i++){
            double auxc=dist[i];
            int aux2=id[i];
            int j=i-1;
            while(j>=0&&dist[j]>auxc){
                dist[j+1]=dist[j];
                id[j+1]=id[j];
                j--;
            }
            dist[j+1]=auxc;
            id[j+1]=aux2;
        }
        return id[0];
    }
    void calculaCentroide(ArrayList<Punto> puntos,int nc,ArrayList<Punto> atr,ArrayList<Punto> centroides){
        for(int i=0;i<nc;i++){
            xsum=0;
            ysum=0;
            cont=0;
            for(Punto p:puntos){
                if(p.clase==i){
                    xsum+=p.x;
                    ysum+=p.y;
                    cont++;
                }
            }
            Punto pu=new Punto();
            if(cont!=0){
                pu.x=xsum/cont;
                pu.y=ysum/cont;
                centroides.add(pu);
                //System.out.println(cont);
            }else{
                pu.x=atr.get(i).x;
                pu.y=atr.get(i).y;
            }
        }
    }
}
