//GODWITHME
package Busquedas;

import Clases.lista_vertices;

class list_hijos{
    String dato_nodo;
    String padre;
    list_hijos enlace;
}

public class Hijos {    
    
    estados_abiertos edos_ab = new estados_abiertos();
    estados_cerrados edos_cerr = new estados_cerrados();
    Hijos_aux list_aux = new Hijos_aux();
    lista_vertices list_ver = new lista_vertices();
    public static list_hijos nuevo, inicio, p, n, q;
    
    
    //PRIMERO CONSULTAMOS SI EL VERTICE TIENE HIJOS
    public void buscar_hijos(String actual)
    {
      list_ver.consultar_hijos(actual);
    }
    
    
    //SI TIENE HIJOS SE MANDA A LLAMAR DESDE LISTA_VERTICE PARA INSERTAR HIJO POR HIJO 
    public void insertar_hijos(String hijo,String padre)
    {
        
        nuevo = new list_hijos();
        nuevo.dato_nodo=hijo;
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
    
    
    public void tratar_repetidos()
    {
        boolean cons_edosAb, cons_edosCerr;
        String x[] = new String [2];
        while(inicio!=null)     //repetir mientras la lista no este vacia   
        {
            x[0] = inicio.dato_nodo;    //insertamos el dato del vertice nodo por nodo
            x[1] = inicio.padre;        //asi mismo tambn guardamos el padre de cada dato del vertice
            inicio = inicio.enlace;     //borramos el primer nodo de la lista
            cons_edosAb = edos_ab.consultar_tratRep(x[0]);  //consultamos si el dato no esta en la lista de estados abiertos
            cons_edosCerr = edos_cerr.consultar_tratRep(x[0]);  //consultamos si el dato no esta en la lista de estados cerrados

            if (cons_edosAb == false && cons_edosCerr == false)     //si el dato no esta en ninguna de las dos listas entramos al if
            {
                list_aux.insertar_hijos_noRep(x[0], x[1]);  //inseramos el dato con su padre en la lista de hijos auxiliar
            }
        }
    }
    
    
    public void consultar_hijos()
    {System.out.println("HIJOS----------------------------");
        q=inicio;
        while(q != null)
        {
            System.out.println(q.dato_nodo+"/"+q.padre);
            q=q.enlace;
        }
    }
    
}
