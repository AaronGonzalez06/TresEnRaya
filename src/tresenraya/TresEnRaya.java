/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tresenraya;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class TresEnRaya extends JFrame {

    private int sizex = 600, sizey = 600;

    private int pixelesCuadrados = 200;

    Tablero tablero = new Tablero();

    public TresEnRaya() {

        this.setTitle("Tres en raya");
        this.setSize(sizex, sizey + 20);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        primerMovimiento();

        iniciarComponentes();

    }

    private void iniciarComponentes() {
        //tablero = new Tablero();
        tablero.setBounds(0, 0, sizex, sizey);
        this.add(tablero);

        //primer turno
        tablero.setTurno(Ficha.Turno.USUARIO);

        tablero.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pulsarRaton(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

    }

    public void pulsarRaton(MouseEvent e) {
        boolean fichaColocada = false;
        if (tablero.getTurno() == Ficha.Turno.USUARIO) {
            //usuario
            int x = (int) (e.getX() / pixelesCuadrados);
            int y = (int) (e.getY() / pixelesCuadrados);
            fichaColocada = tablero.setFicha(x, y, Ficha.Turno.USUARIO);
            tablero.repaint();

            if (fichaColocada && !tablero.comprobarSiHayGanador(Ficha.Turno.USUARIO)) {
                if (tablero.quedanCasillasLibres()) {
                    //turno IA

                    tablero.setTurno(Ficha.Turno.IA);
                    tablero.colocarFichaIA();
                    tablero.setTurno(Ficha.Turno.USUARIO);
                    tablero.repaint();

                    if (tablero.comprobarSiHayGanador(Ficha.Turno.IA)) {
                        finDelJuego(Ficha.Turno.IA);
                    } else if (!tablero.quedanCasillasLibres()) {
                        finDelJuego(Ficha.Turno.SIN_ASIGNAR);
                    }

                } else {
                    finDelJuego(Ficha.Turno.SIN_ASIGNAR);
                }
            } else if (tablero.comprobarSiHayGanador(Ficha.Turno.USUARIO)) {
                finDelJuego(Ficha.Turno.USUARIO);
            }
        }
    }

    public void finDelJuego(Ficha.Turno turno) {
        switch (turno) {
            case IA:
                JOptionPane.showMessageDialog(null, "Gana la IA");
                break;
            case USUARIO:
                JOptionPane.showMessageDialog(null, "Gana el usuario");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Empate");
        }
        tablero.reiniciarJuego();
    }

    public void primerMovimiento() {

        //tablero.colocarFichaIA();
        tablero.setFicha(1, 1, Ficha.Turno.IA);
        tablero.setTurno(Ficha.Turno.USUARIO);
        tablero.repaint();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TresEnRaya ventana = new TresEnRaya();
        ventana.setVisible(true);
    }

}
