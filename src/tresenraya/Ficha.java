/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tresenraya;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class Ficha {
    
    private Turno turno;
    private int x;
    private int y;
    
    public enum Turno {
        USUARIO,IA,SIN_ASIGNAR;
    }
    
    private int pixelesCuadrados = 200;
    
    public Ficha(int x, int y){
        this.turno = Turno.SIN_ASIGNAR;
        this.x = x;
        this.y = y;
    
    }
    
    
    public void paintComponent(Graphics2D g2d){
        switch (this.turno){
            case IA:
                String urlO = "https://farm5.staticflickr.com/4041/4663655552_1128e5ef10.jpg";
                pintarFicha(this.x,this.y,g2d,urlO);
                break;
            case USUARIO:
                String urlX = "https://www.drodd.com/images14/x15.jpg";
                pintarFicha(this.x,this.y,g2d,urlX);
                break;
            default:
                break;
        }
    }
    
        private void pintarFicha(int x, int y, Graphics2D g2d, String urlFicha) {

        try {

            URL url = new URL(urlFicha);

            Image imagen = ImageIO.read(url);
            g2d.drawImage(imagen, (x*pixelesCuadrados)+1, (y*pixelesCuadrados)+1, pixelesCuadrados - 2, pixelesCuadrados - 2, null);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "No carga la URL");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No la imagen");
        }

    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    
    
    
    
}
