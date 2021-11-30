package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Presentacion extends JFrame {
    //atributos
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private JLabel labelImagen;
    private JTextArea textoExpectativas;
    private Titulos titulo;
    private Escucha escucha;

    //metodos
    public GUI_Presentacion() {
        initGUI();

        //Configuracion base de la ventana
        this.setTitle("MiPresentacion");
        this.setSize(600, 540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir Container y Layout del JFrame
        //Crear objetos Escucha y Control
        escucha = new Escucha();
        //Configurar JComponents
        titulo = new Titulos("Hola soy Sergio, oprime los botones ...", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco mas de mi...",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Monaco", Font.PLAIN, 20), Color.BLACK));
        panelDatos.setBackground(new Color(135,36,53));

        this.add(panelDatos, BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo");
        miFoto.addActionListener(escucha);
        miHobby = new JButton("Este es mi Hobby");
        miHobby.addActionListener(escucha);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addActionListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);
        panelBotones.setBackground(new Color(135,36,53));

        this.add(panelBotones, BorderLayout.SOUTH);

        labelImagen = new JLabel();
        textoExpectativas = new JTextArea(7, 40);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
        }

        private class Escucha implements ActionListener {
            private ImageIcon image;

            @Override
            public void actionPerformed(ActionEvent e) {
                //  JOptionPane.showMessageDialog(null,"Oprimiste boton");
                panelDatos.removeAll();
                if (e.getSource() == miFoto) {
                    image = new ImageIcon(getClass().getResource("/recursos/pcafe.jpg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);

                } else {
                    if (e.getSource() == miHobby) {
                        image = new ImageIcon(getClass().getResource("/recursos/senderismo.jpg"));
                        labelImagen.setIcon(image);
                        panelDatos.add(labelImagen);
                    } else {
                        textoExpectativas.setText("Mi nombre es Sergio Carmona, tengo 23 años y quiero " +
                                                    "ser desarrollador de software. \n"+
                                                    "Mis hobbys son hacer caminatas por la naturaleza, " +
                                                    "escuchar música y salir con mis amigos. \n" +
                                                    "Espero aprender lo que más pueda en este curso para " +
                                                    "lograr crear interfaces gráficas completas, amigables" +
                                                    " y eficientes");
                        textoExpectativas.setBackground(new Color(135,36,53));
                        textoExpectativas.setFont(new Font("TimesRoman", Font.PLAIN, 18));
                        textoExpectativas.setForeground(Color.ORANGE);
                        textoExpectativas.setLineWrap(true);

                        panelDatos.add(textoExpectativas);

                        image = new ImageIcon(getClass().getResource("/recursos/programando.png"));
                        labelImagen.setIcon(image);
                        panelDatos.add(labelImagen);
                    }
                }


                revalidate();

                repaint();
            }
        }
    }


