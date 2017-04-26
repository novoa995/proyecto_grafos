package Busquedas;

//GODWITHME

import Clases.lista_vertices;
import Frames.Mostrar_Grafo;
import javax.swing.JOptionPane;

public class busqueda_anchura 
{
    Mostrar_Grafo mostrar = new Mostrar_Grafo();
    estados_abiertos edos_ab = new estados_abiertos();
    estados_cerrados edos_cerr=new estados_cerrados();
    Hijos hij=new Hijos();
    Hijos_aux hij_aux = new Hijos_aux();
    lista_vertices listas = new lista_vertices();
    
    public void busqueda_anchura(String edo_inicial, String edo_final)
    {   
        String padre;
        String actual[] = new String [2];
        
        padre = listas.consultar_padre(edo_inicial);    //consultamos de quien depende el nodo inicial
        edos_ab.insertar_cola(edo_inicial, null);  //insertamos el noodo incial con null(porque es el estado inicial y de padre tiene q tener null)
        //ponemos como valor actual el primer dato de la cola de estados abiertos
        actual[0] = (edos_ab.frente).dato_nodo;     
        actual[1] = (edos_ab.frente).padre;
        
        while( !actual[0].equalsIgnoreCase(edo_final) && edos_ab.frente != null )
        {
            edos_ab.eliminar_primero();     //eliminamos el primer dato de la cola de estados abiertos
            edos_cerr.insertar(actual[0], actual[1]);     //insertamos en la lista de estados cerrados el valor actual
            hij.buscar_hijos(actual[0]);    //buscamos los hijos del valor actual
            hij.tratar_repetidos();     //una vez encontrado los hijos, buscamos si essos hijos no se encuentran en las listas de edos abiertos y edos cerrados
            hij_aux.insertar_list_enEdosAb();   //insertamos la lista de hijos no repetidos en edos abiertos
            //ponemos como valor actual el primer dato de la cola de estados aviertos
            actual[0] = (edos_ab.frente).dato_nodo; 
            actual[1] = (edos_ab.frente).padre;
            //System.out.println("edo_actual: " + actual[0] + "/" + actual[1]);
        }
        
        if(actual[0].equalsIgnoreCase(edo_final))
        {   
            //edos_cerr.consultar_edosCerrados();
            edos_cerr.insertar(actual[0], actual[1]);
            //System.out.println("Solucion encontrada");
            String recorrido = edos_cerr.recorrer_camino(actual[0]);
            recorrido = "-" + recorrido;
            //System.out.println(recorrido);
            mostrar.setVisible(true);
            JOptionPane.showMessageDialog(null, "Este es el recorrido a seguir de su estado inicial hasta su estado final: \n"+recorrido);
        }
        else
        {
            System.out.println("Solucion no encontrada");
        }
    }
    
}
