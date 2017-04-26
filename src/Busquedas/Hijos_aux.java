//GODWITHME
package Busquedas;

class list_aux
{
    String dato_nodo;
    String padre;
    list_aux enlace;
}

public class Hijos_aux {

     public static list_aux nuevo, inicio, p, n, q;
     estados_abiertos edos_ab = new estados_abiertos();
     
     public void insertar_hijos_noRep(String dato,String padre)
    {
        
        nuevo = new list_aux();
        nuevo.dato_nodo=dato;
        nuevo.padre = padre;
        nuevo.enlace=null;
        
        if(inicio == null)
        {
            inicio=nuevo;
        }
        else
        {
            p.enlace=nuevo;
        }
        p=nuevo;
    }
     
     
      public void insertar_list_enEdosAb()
    {
        q=inicio;
        while(q != null)
        {
            edos_ab.insertar_cola(q.dato_nodo, q.padre);
            q=q.enlace;
        }
        eliminar_datos_list();
    }
      
      
      void eliminar_datos_list()
      {
          nuevo = inicio = p = n = q = null;
      }
      
      
       public void consultar_hijos()
    {System.out.println("HIJOS AUX----------------------------");
        q=inicio;
        while(q != null)
        {
            System.out.println(q.dato_nodo+"/"+q.padre);
            q=q.enlace;
        }
    }
    
}
