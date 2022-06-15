/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tresenraya;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aaron
 */
public class Tablero extends JPanel {

    //atributos
    private Ficha ficha[][] = new Ficha[3][3];

    private int sizex = 600, sizey = 600;

    private int pixelesCuadrados = 200;

    private Ficha.Turno turno = Ficha.Turno.SIN_ASIGNAR;

    public Tablero() {

        for (int i = 0; i < ficha.length; i++) {
            for (int j = 0; j < ficha[i].length; j++) {
                ficha[i][j] = new Ficha(i, j);
            }
        }

        //ficha[1][0].setTurno(Ficha.Turno.USUARIO);
        //ficha[0][2].setTurno(Ficha.Turno.IA);
        //turno = Ficha.Turno.USUARIO;
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        //pintamos fondo blanco
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, sizex, sizey);

        //lineas hotizontales 
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, 200, 600, 200);
        g2d.drawLine(0, 400, 600, 400);

        //Lineas verticales
        g2d.drawLine(200, 0, 200, 600);
        g2d.drawLine(400, 0, 400, 600);

        /**
         * O => https://farm5.staticflickr.com/4041/4663655552_1128e5ef10.jpg X
         * X=> https://www.drodd.com/images14/x15.jpg
         */
        String urlX = "https://www.drodd.com/images14/x15.jpg";
        String urlO = "https://farm5.staticflickr.com/4041/4663655552_1128e5ef10.jpg";

        pintarFichas(g2d);

    }

    private void pintarFichas(Graphics2D g2d) {

        for (int i = 0; i < ficha.length; i++) {
            for (int j = 0; j < ficha[i].length; j++) {
                ficha[i][j].paintComponent(g2d);
            }
        }
    }

    public boolean setFicha(int x, int y, Ficha.Turno turno) {
        boolean fichaColocada = false;
        if (ficha[x][y].getTurno() == Ficha.Turno.SIN_ASIGNAR) {

            ficha[x][y].setTurno(turno);
            fichaColocada = true;
        } else {
            JOptionPane.showMessageDialog(null, "Casilla no disponible.");
        }
        return fichaColocada;
    }

    public void colocarFichaIA() {
        /*boolean colocada = false;
        int i = 0;
        while (i < ficha.length && !colocada) {
            int j = 0;
            while (j < ficha[i].length && !colocada) {
                if (ficha[i][j].getTurno() == Ficha.Turno.SIN_ASIGNAR) {
                    ficha[i][j].setTurno(Ficha.Turno.IA);
                    colocada = true;
                }
                j++;
            }
            i++;
        }*/

        
        boolean continuar = true;
        do {
            int num = (int) Math.floor(Math.random() * (1 - 9 + 1) + 9);
            switch (num) {
                case 1:
                    if (ficha[0][0].getTurno() == Ficha.Turno.IA || ficha[0][0].getTurno() == Ficha.Turno.USUARIO) {

                    } else if (ficha[0][0].getTurno() == Ficha.Turno.SIN_ASIGNAR) {
                        setFicha(0, 0, Ficha.Turno.IA);
                        setTurno(Ficha.Turno.USUARIO);
                        repaint();
                        continuar = false;
                    }

                    break;
                case 2:
                    if (ficha[0][1].getTurno() == Ficha.Turno.IA || ficha[0][1].getTurno() == Ficha.Turno.USUARIO) {

                    } else if (ficha[0][1].getTurno() == Ficha.Turno.SIN_ASIGNAR) {
                        setFicha(0, 1, Ficha.Turno.IA);
                        setTurno(Ficha.Turno.USUARIO);
                        repaint();
                        continuar = false;
                    }
                    break;
                case 3:
                    if (ficha[0][2].getTurno() == Ficha.Turno.IA || ficha[0][2].getTurno() == Ficha.Turno.USUARIO) {

                    } else if (ficha[0][2].getTurno() == Ficha.Turno.SIN_ASIGNAR) {
                        setFicha(0, 2, Ficha.Turno.IA);
                        setTurno(Ficha.Turno.USUARIO);
                        repaint();
                        continuar = false;
                    }
                    break;
                case 4:
                    if (ficha[1][0].getTurno() == Ficha.Turno.IA || ficha[1][0].getTurno() == Ficha.Turno.USUARIO) {

                    } else if (ficha[1][0].getTurno() == Ficha.Turno.SIN_ASIGNAR) {
                        setFicha(1, 0, Ficha.Turno.IA);
                        setTurno(Ficha.Turno.USUARIO);
                        repaint();
                        continuar = false;
                    }
                    break;
                case 5:
                    if (ficha[1][1].getTurno() == Ficha.Turno.IA || ficha[1][1].getTurno() == Ficha.Turno.USUARIO) {

                    } else if (ficha[1][1].getTurno() == Ficha.Turno.SIN_ASIGNAR) {
                        setFicha(1, 1, Ficha.Turno.IA);
                        setTurno(Ficha.Turno.USUARIO);
                        repaint();
                        continuar = false;
                    }
                    break;
                case 6:
                    if (ficha[1][2].getTurno() == Ficha.Turno.IA || ficha[1][2].getTurno() == Ficha.Turno.USUARIO) {

                    } else if (ficha[1][2].getTurno() == Ficha.Turno.SIN_ASIGNAR) {
                        setFicha(1, 2, Ficha.Turno.IA);
                        setTurno(Ficha.Turno.USUARIO);
                        repaint();
                        continuar = false;
                    }
                    break;
                case 7:
                    if (ficha[2][0].getTurno() == Ficha.Turno.IA || ficha[2][0].getTurno() == Ficha.Turno.USUARIO) {

                    } else if (ficha[2][0].getTurno() == Ficha.Turno.SIN_ASIGNAR) {
                        setFicha(2, 0, Ficha.Turno.IA);
                        setTurno(Ficha.Turno.USUARIO);
                        repaint();
                        continuar = false;
                    }
                    break;
                case 8:
                    if (ficha[2][1].getTurno() == Ficha.Turno.IA || ficha[2][1].getTurno() == Ficha.Turno.USUARIO) {

                    } else if (ficha[2][1].getTurno() == Ficha.Turno.SIN_ASIGNAR) {
                        setFicha(2, 1, Ficha.Turno.IA);
                        setTurno(Ficha.Turno.USUARIO);
                        repaint();
                        continuar = false;
                    }
                    break;
                case 9:
                    if (ficha[2][2].getTurno() == Ficha.Turno.IA || ficha[2][2].getTurno() == Ficha.Turno.USUARIO) {

                    } else if (ficha[2][2].getTurno() == Ficha.Turno.SIN_ASIGNAR) {
                        setFicha(2, 2, Ficha.Turno.IA);
                        setTurno(Ficha.Turno.USUARIO);
                        repaint();
                        continuar = false;
                    }
                    break;
                default:
                    System.out.println("algo pasa");
            }

        } while (continuar);

    }

    public boolean quedanCasillasLibres() {
        boolean quedanCasillas = false;
        int i = 0;
        while (i < ficha.length && !quedanCasillas) {
            int j = 0;
            while (j < ficha[i].length && !quedanCasillas) {
                if (ficha[i][j].getTurno() == Ficha.Turno.SIN_ASIGNAR) {
                    quedanCasillas = true;
                }
                j++;
            }
            i++;
        }

        return quedanCasillas;

    }

    public void reiniciarJuego() {
        for (int i = 0; i < ficha.length; i++) {
            for (int j = 0; j < ficha.length; j++) {
                ficha[i][j].setTurno(Ficha.Turno.SIN_ASIGNAR);
            }
        }
        setFicha(1, 1, Ficha.Turno.IA);
        setTurno(Ficha.Turno.USUARIO);
        repaint();
    }

    public boolean comprobarSiHayGanador(Ficha.Turno turno) {
        boolean hayGanador = false;

        if (ficha[0][0].getTurno() == turno && ficha[0][1].getTurno() == turno && ficha[0][2].getTurno() == turno) {
            hayGanador = true;
        } else if (ficha[1][0].getTurno() == turno && ficha[1][1].getTurno() == turno && ficha[1][2].getTurno() == turno) {
            hayGanador = true;
        } else if (ficha[2][0].getTurno() == turno && ficha[2][1].getTurno() == turno && ficha[2][2].getTurno() == turno) {
            hayGanador = true;
        } else if (ficha[0][0].getTurno() == turno && ficha[1][0].getTurno() == turno && ficha[2][0].getTurno() == turno) {
            hayGanador = true;
        } else if (ficha[0][1].getTurno() == turno && ficha[1][1].getTurno() == turno && ficha[2][1].getTurno() == turno) {
            hayGanador = true;
        } else if (ficha[0][2].getTurno() == turno && ficha[1][2].getTurno() == turno && ficha[2][2].getTurno() == turno) {
            hayGanador = true;
        } else if (ficha[0][0].getTurno() == turno && ficha[1][1].getTurno() == turno && ficha[2][2].getTurno() == turno) {
            hayGanador = true;
        } else if (ficha[0][2].getTurno() == turno && ficha[1][1].getTurno() == turno && ficha[2][0].getTurno() == turno) {
            hayGanador = true;
        }

        return hayGanador;

    }

    public Ficha.Turno getTurno() {
        return turno;
    }

    public void setTurno(Ficha.Turno turno) {
        this.turno = turno;
    }
}
