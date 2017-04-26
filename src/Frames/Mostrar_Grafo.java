package Frames;


import Clases.lista_vertices;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Mostrar_Grafo extends javax.swing.JFrame {

    private lista_vertices objlist = new lista_vertices();
    //public static boolean vertices=true;
    private int diametro=30;
    public Graphics gpnl=null;
    
    public Mostrar_Grafo() {
        
        initComponents();
        gpnl=pnl_mostrar.getGraphics();
    
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public void paint(Graphics g)
    { //       g= pnl_mostrar.getGraphics();
//        int coordenadas[] = new int [2];
//        int cont=0;
        
        super.paint(g);
        objlist.cons_all_coord(gpnl);
        objlist.cons_all_aristas(gpnl);
        //dibujar_vertice(gpnl,10,10);


        /*while(vertices == true)           //no sirvio este metodo
        {   
            coordenadas = objlist.cons_all_coord();
            System.out.println(coordenadas[0]+"  "+coordenadas[1]);
            g.fillOval(coordenadas[0],coordenadas[1], diametro, diametro);
            System.out.println("vertices: " + vertices);
        }*/
       
    }
    
    public void dibujar_vertice(Graphics g,String nombre,int x, int y)
    {   
        g.setColor(Color.CYAN);
        g.drawString(nombre,x,y);
        g.fillOval(x, y, diametro,diametro);
//        g.drawLine(x, y, 50, 50);
      
    }
    
    public void dibujar_arista(Graphics g, String peso, int x, int y, int x1, int y1)
    {
        int x_arista = x+(diametro/2);
        int y_arista = y+(diametro / 2);
        int x1_arista = x1+(diametro / 2);
        int y1_arista = y1+(diametro / 2);
        //dibujamos la arista
        g.setColor(Color.CYAN);
        g.drawLine( x_arista, y_arista, x1_arista, y1_arista );
        
        //dibujamos el peso de la arista
        int x_final = (x_arista + x1_arista) / 2;
        int y_final = (y_arista + y1_arista) / 2;
        g.setColor(Color.GREEN);
        g.drawString(peso,x_final, y_final);
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_mostrar = new javax.swing.JPanel();
        btnregresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl_mostrar.setBackground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout pnl_mostrarLayout = new javax.swing.GroupLayout(pnl_mostrar);
        pnl_mostrar.setLayout(pnl_mostrarLayout);
        pnl_mostrarLayout.setHorizontalGroup(
            pnl_mostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_mostrarLayout.setVerticalGroup(
            pnl_mostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        btnregresar.setText("Regresar");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });

        jLabel1.setText("En el siguiente area se mostrar el Grafo que usted realizo anteriormente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnregresar)
                        .addGap(27, 27, 27))
                    .addComponent(pnl_mostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnregresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        dispose();
    }//GEN-LAST:event_btnregresarActionPerformed

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
            java.util.logging.Logger.getLogger(Mostrar_Grafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mostrar_Grafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mostrar_Grafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mostrar_Grafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mostrar_Grafo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnregresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnl_mostrar;
    // End of variables declaration//GEN-END:variables
}
