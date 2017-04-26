package Frames;

//GODWITHME

import Clases.lista_vertices;
import Busquedas.busqueda_anchura;
import javax.swing.JOptionPane;

public class menu_principal extends javax.swing.JFrame {
   
    public static boolean peso, val_eur;    //hacemos staticas estas variables para que cada vez q creamos un objeto de esta clase nadamas exista una variable en todos los objetos
    busqueda_anchura bus = new busqueda_anchura();
    datos_anchura dat_anch = new datos_anchura();
    
    public menu_principal() {
        initComponents();
    
        setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btncerrar = new javax.swing.JButton();
        btncrear = new javax.swing.JButton();
        btnmostrar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnanchura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btncerrar.setText("Cerrar");
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });

        btncrear.setText("Crear Grafo");
        btncrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncrearActionPerformed(evt);
            }
        });

        btnmostrar.setText("Mostrar Grafo");
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar Grafo");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnanchura.setText("Busqueda por Anchura");
        btnanchura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanchuraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnmostrar)
                    .addComponent(btncrear, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btncerrar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnanchura)
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncerrar)
                .addGap(41, 41, 41)
                .addComponent(btncrear)
                .addGap(36, 36, 36)
                .addComponent(btnmostrar)
                .addGap(30, 30, 30)
                .addComponent(btneliminar)
                .addGap(26, 26, 26)
                .addComponent(btnanchura)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrearActionPerformed
        int resp_peso, resp_val_eur;
        
        lista_vertices objlist = new lista_vertices();
        
        if(objlist.inicio2 == null)
        {
            resp_peso = JOptionPane.showConfirmDialog(null, "¿Deseas agregar peso al grafo?", "Peso!",JOptionPane.YES_NO_OPTION);
            resp_val_eur = JOptionPane.showConfirmDialog(null,"¿Deseas agregar valor heuristico al grafo?","Valor heuristico!", JOptionPane.YES_NO_OPTION);
            
            if(resp_peso == 0)  //si presionan SI al joptionpane (mensaje)
            {
                peso = true;
            }
            else
            {
                peso = false;
            }
            
            if(resp_val_eur == 0)
            {
                val_eur = true;
            }
            else {
                val_eur = false;
            }
       
            dibujar obj_dib=new dibujar();
            obj_dib.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Ya tienes un grafo creado. Elimina el actual para poder crear uno nuevo", "Ya tienes uno creado", JOptionPane.ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_btncrearActionPerformed

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btncerrarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        lista_vertices obj = new lista_vertices();
        
        if(obj.inicio2 != null)
        {
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar su grafo actual?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if(resp == 0)
            {
                obj.borrar_list_vertices();
                obj.borrar_list_adyacente();
                obj.borrar_list_coord();
                JOptionPane.showMessageDialog(null,"Su grafo se ah eliminado correctamente", "Eliminacion exitosa",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
            JOptionPane.showMessageDialog(null,"No ah creado ningun grafo","Error", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed
        lista_vertices obj=new lista_vertices();
        Mostrar_Grafo mostrar = new Mostrar_Grafo();
        if(obj.inicio2 == null)
        {
            JOptionPane.showMessageDialog(null,"No ah creado ningun grafo","Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            
            mostrar.setVisible(true);
            //obj.cons_all_coord();
        }
    }//GEN-LAST:event_btnmostrarActionPerformed

    private void btnanchuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanchuraActionPerformed
        dat_anch.setVisible(true);
    }//GEN-LAST:event_btnanchuraActionPerformed
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnanchura;
    private javax.swing.JButton btncerrar;
    private javax.swing.JButton btncrear;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnmostrar;
    // End of variables declaration//GEN-END:variables
}
