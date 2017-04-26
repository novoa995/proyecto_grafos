package Frames;

//GODWITHME

import Clases.lista_vertices;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class dibujar extends javax.swing.JFrame implements MouseListener
{
    public final int diametro=30; //hacemo final la variable diametro para que no cambie de valor nunca
    public int x, y, vertices=0;
    public boolean err_nombre = false, nombre_rep;  // con nom_rep controlamos que no se repitan los nombres en los vertices
    public Graphics gpanel=null;
        
    public dibujar() {  //metodo constructor dibujar da un estad inicial al ejecutar el programa
        //super("dibujar circulo");
        initComponents();
        
        pnl.addMouseListener(this);  //ponemos el escuchador de eventos en el panel

        setTitle("Dibujar Grafo");
        setLocationRelativeTo(null);    //hace que la ventana se posicione en el centro de la pantalla
        setResizable(false);        //evita que modifiquemos el tamaño de la ventana
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //hacemos que al dar click en cerrar de la ventana nada mas cierre esta ventana y no todo el programa
        
        btnaristas.setEnabled(false);   //inabilitamos el boton aristas
        btnlisto.setEnabled(false);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        g=pnl.getGraphics();
        
//        g.setColor(Color.red);
//        g.drawLine(10,10,50,10);
////        Graphics2D circulo=(Graphics2D) g;
////        circulo.setPaint(Color.BLUE);
//        circulo.drawOval(100, 100, 50, 50);
     
//        g.drawOval(20,20,60,60);
        
        /*Graphics papel=pnl.getGraphics();
        papel.setColor(Color.gray);
       papel.drawOval(20,20,60,60);*/
         
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl = new javax.swing.JPanel();
        btnaristas = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnlisto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl.setBackground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );

        btnaristas.setText("Dibujar Aristas");
        btnaristas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaristasActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnlisto.setText("Listo");
        btnlisto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlistoActionPerformed(evt);
            }
        });

        jLabel1.setText("Toque en cualquier posicion del siguiente panel para dibujar un nodo del grafo.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnlisto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(btnaristas)
                        .addGap(121, 121, 121)
                        .addComponent(btncancelar)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaristas)
                    .addComponent(btncancelar)
                    .addComponent(btnlisto))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaristasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaristasActionPerformed
        info_arista frame_ar=new info_arista(gpanel,btnlisto);
        frame_ar.setVisible(true);
    }//GEN-LAST:event_btnaristasActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        lista_vertices obj = new lista_vertices();
        obj.borrar_list_adyacente();
        obj.borrar_list_vertices();
        dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnlistoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlistoActionPerformed
        JOptionPane.showMessageDialog(null, "Su grafo se ah creado con exito :D", "Completado", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }//GEN-LAST:event_btnlistoActionPerformed

    public static void main(String args[]) 
    {   
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
            java.util.logging.Logger.getLogger(dibujar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dibujar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dibujar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dibujar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dibujar().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaristas;
    private javax.swing.JButton btncancelar;
    public static javax.swing.JButton btnlisto;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel pnl;
    // End of variables declaration//GEN-END:variables

    
    public void dibujar_arista(Graphics g ,int x, int y, int x1, int y1)
    {
////        Graphics g = pnl.getGraphics();
        g.setColor(Color.CYAN);
        g.drawLine(x,y,x1,y1);
    }
    
    public void dibujar_peso(Graphics g , String peso, int x, int y, int x1, int y1)
    {
        int x_final;
        int y_final;
        
        x_final = (x + x1) / 2;
        y_final = (y + y1) / 2;
        
        g.setColor(Color.GREEN);
        g.drawString(peso, x_final, y_final);
    }
    
    public void habilitar_listo(JButton botonlist) 
    {
        botonlist.setEnabled(true); //habilitamos el boton de listo cuando se crea una arista
    }
    
    @Override
    public void mousePressed(MouseEvent e) //metodo q invoca cuando se presiona el boton del raton
    {   
        lista_vertices obj_list=new lista_vertices();
        int radio = diametro / 2;
        
        if(e.getButton() == 1) //INDICAMOS QUE CUANDO SE DE CLICK IZQUIERDO ENTRE AL IF
        {
            int x_oval = e.getX();
            int y_oval = e.getY();
            do
            {   err_nombre=false;       //con esta variable controlamos que el usuario escriba un nombre en el campo, sino escribe nada y pone aceptar se activa esta bandera para error
                
                String nombre = JOptionPane.showInputDialog(null,"Dame nombre para el vertice");
                nombre_rep=obj_list.consultar_nombre(nombre);
                
                if(nombre_rep == true)
                {
                    err_nombre=true;
                    JOptionPane.showMessageDialog(null,"El nombre no se puede repetir, intente con otro","Error",JOptionPane.ERROR_MESSAGE);
                } 
                else if(nombre != null && !nombre.equals(""))    //indicamos que para q entre a este if el campo del joptionpane no tiene q estar vacio, y se tiene q presionar aceptar
                {
                    gpanel=pnl.getGraphics();
                    err_nombre = false;
                    gpanel.setColor(Color.CYAN);
                    gpanel.drawString(nombre, x_oval-radio, y_oval-radio);
                    gpanel.fillOval(x_oval-radio, y_oval-radio, diametro, diametro);
                    vertices++;     //contador de vertices
                    obj_list.insertar_vertice(nombre);  //al dibujar el vertice creamos su nodo
                    obj_list.insertar_coordenada(nombre, x_oval, y_oval);   //insertaos coordenadas del vertice para despues poder dibujar las aristas
                }
                else if (nombre != null && nombre.equals(""))   //cuando se presiona aceptar sin dar cadena
                {
                    err_nombre = true;
                    JOptionPane.showMessageDialog(null,"Escribe un nombre correcto para el vertice","Error",JOptionPane.ERROR_MESSAGE);
                }
               
            }while(err_nombre == true);
        }
        
        if(vertices  > 1)    //despues de crear dos vertices habilitaremos el boton de aristas
        {
            btnaristas.setEnabled(true);
            //btnlisto.setEnabled(true);
        }
    }
     @Override
    public void mouseClicked(MouseEvent e) { //meoto q se invoca cuando se presiona y se suelta el boton del raton

    }

    @Override
    public void mouseReleased(MouseEvent e) { //metodo q invoca cuando sube el boton del raton (quita el dedo)
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.println ("has entrado al pnl");
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println ("Te has salido del pnl");
    }

}
