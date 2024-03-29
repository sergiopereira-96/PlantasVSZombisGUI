/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import javax.swing.JOptionPane;
import logica.Tablero;
import logica.Usuario;

/**
 *
 * @author Cristina
 */
public class RegistroUsuario extends javax.swing.JFrame implements Serializable{
    //Atributos
    private PantallaInicial principal;
    private HashMap<String, Usuario> hmap = new HashMap<String, Usuario>();     //Almacenar usuario clave-nombre
    Usuario usr;        //Asociacion Usuario
    Tablero tab;        //Asociacion Tablero
    
    //Constructor
    /**
     * Creates new form RegistroUsuario1
     * @param ventana
     */
    public RegistroUsuario(PantallaInicial ventana) {
        principal = ventana;
        principal.setVisible(false);
        this.setVisible(true);
        initComponents();
        try {
            ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream("datosJuego.dat"));
            hmap = (HashMap) leerFichero.readObject();
            leerFichero.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Getter
    public HashMap<String, Usuario> getHmap() {
        return hmap;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelNewUser = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelDni = new javax.swing.JLabel();
        jButtonBorrar = new javax.swing.JButton();
        jButtonJugar = new javax.swing.JButton();
        jComboBoxDificultad = new javax.swing.JComboBox<>();
        jLabelDificultad = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldDni = new javax.swing.JTextField();

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plants vs Zombis");
        setResizable(false);

        jLabelNewUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabelNewUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNewUser.setText("Registro Usuarios");

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNombre.setText("Introducir el nombre: ");

        jLabelDni.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDni.setText("Introducir el DNI: ");

        jButtonBorrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButtonBorrar.setText("Borrar Datos");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jButtonJugar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButtonJugar.setText("J U G A R");
        jButtonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJugarActionPerformed(evt);
            }
        });

        jComboBoxDificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BAJA", "MEDIA", "ALTA", "IMPOSIBLE" }));
        jComboBoxDificultad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabelDificultad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDificultad.setText("Eliga la dificultad: ");

        jLabel1.setText("Si el usuario ya ha sido registrado, introducir SOLO el DNI");

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombre)
                            .addComponent(jTextFieldDni, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(111, 111, 111))))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelDni)
                        .addComponent(jLabelNombre))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabelDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabelNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelNewUser)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDni)
                    .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDificultad)
                    .addComponent(jComboBoxDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(616, 389));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJugarActionPerformed
        // TODO add your handling code here:
        String nombre = jTextFieldNombre.getText();
        String dni = jTextFieldDni.getText();
        String dificultad = (String) jComboBoxDificultad.getSelectedItem();
        
        if (dni.equals("")) {
            JOptionPane.showMessageDialog(this, "Introduzca el DNI", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (hmap.containsKey(dni)) {
            tab = new Tablero(7, 7, dificultad);
            usr = hmap.get(dni);
            TableroJuego t = new TableroJuego(tab, usr, this);
            t.setVisible(true);
        } else {
            if (nombre.equals("")) {
                JOptionPane.showMessageDialog(this, "Introduzca el Nombre y DNI", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                usr = new Usuario(nombre, dni, dificultad);
                hmap.put(dni, usr);
            }

            try {
                ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream("datosJuego.dat"));
                escribirFichero.writeObject(hmap);
                escribirFichero.close();
                tab = new Tablero(7, 7, dificultad);
                TableroJuego t = new TableroJuego(tab, usr, this);
                t.setVisible(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }            
    }//GEN-LAST:event_jButtonJugarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        // TODO add your handling code here:
        jTextFieldNombre.setText("");
        jTextFieldDni.setText("");
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonJugar;
    private javax.swing.JComboBox<String> jComboBoxDificultad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDificultad;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelNewUser;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
