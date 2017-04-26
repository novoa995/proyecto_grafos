package Busquedas;

//GODWITHME
class Cola
{
    String dato_nodo;
    String padre;
    Cola enlace;
}

public class estados_abiertos {
    
    public static Cola frente = null, fin = null, nuevo = null, p = null;
    
    void insertar_cola(String dato, String padre)
    {
        nuevo = new Cola();
        nuevo.dato_nodo = dato;
        nuevo.padre = padre;
        nuevo.enlace = null;
        
        if(frente == null)
        {
            frente = fin = nuevo;
        }
        else
        {
            fin.enlace = nuevo;
            fin = nuevo;
        }
    }
    
    void eliminar_primero()
    {
        if(frente != null)
        {
            p = frente;
            frente = p.enlace;
            p=null;
            
            if(frente == null)
            {
                fin = null;
            }
        }
    }
    
    public boolean consultar_tratRep(String dato)//metodo para consultar si los datos d elos hijos no estan en esta lista(estados abiertos)
    {   boolean encontrado = false;
        if(frente != null)
        {
            p = frente;
            do{
                if(p.dato_nodo.equalsIgnoreCase(dato))
                {
                    encontrado = true;
                }
                p = p.enlace;
            }while (p != null);
        }
        return encontrado;
    }
    
    
    public void consultar_edosAbiertos()
    {
        if(frente != null)
        {   
            System.out.println("LISTA ABIERTA--------------");
            p = frente;
            do{
                System.out.println(p.dato_nodo+"/"+p.padre);
                p = p.enlace;
            }while (p != null);
        }
    }
    
}
