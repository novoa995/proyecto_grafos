package Busquedas;

//GODWITHME
class Lista_Cerrados
{
    String dato_nodo;
    String padre;
    Lista_Cerrados enlace;
}

public class estados_cerrados {
    
    public static Lista_Cerrados nuevo, inicio, p, n, q;
    
    
    public void insertar(String dato, String padre)
    {
        nuevo = new Lista_Cerrados();
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
    
    public boolean consultar_tratRep(String dato)   //metodo para consultar si los datos d elos hijos no estan en esta lista(estados cerrados)
    {   boolean encontrado = false;
       q=inicio;
        while(q != null)
        {
            if(q.dato_nodo.equalsIgnoreCase(dato))
            {
                encontrado = true;
            }
            q=q.enlace;
        } 
        return encontrado;
    }
    
    
    public String recorrer_camino(String edo_final)
    {
        String recorrido="";
        q=inicio;
        while(q != null)
        {
            if(q.dato_nodo.equals(edo_final))
            {
                recorrido = q.dato_nodo + "-" + recorrido;
                edo_final = q.padre;
                q=inicio;
            }
            else
                q=q.enlace;
        }
        return recorrido;
    }
    
    
    public void consultar_edosCerrados()
    {System.out.println("LISTA Cerrados-------------");
       q=inicio;
        while(q != null)
        {
            System.out.println(q.dato_nodo+"/"+q.padre);
            q=q.enlace;
        } 
    }
    
}
