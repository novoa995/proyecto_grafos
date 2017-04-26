package Clases;

import Busquedas.Hijos;
import Frames.Mostrar_Grafo;
import java.awt.Graphics;

//GOD WITH ME

class Nodo
{
    //LISTA DE VERTICES
    String informacion;
    double num1;
    double num2;
    Nodo enlace;
    Nodo enlace1;
    
    
    //LISTA DE ADYACENCIA
    String padre; 
    String hijo;
    
    double num3;
    int peso;
    int val_eur;
    Nodo enlace2;   //enlace del nodo adyacente (hijo)
    Nodo enlace3;   //enlace del sig nodo adnyasente (sig hijo)
    Nodo enlace4;   //enlaces de union de toda la lista
}
class Nodo1{    //LISTA DE COORDENADAS DE LOS VERTICES
    String nombre;
    int x;
    int y;
    Nodo1 enlace;
}

//LISTA DE ARISTAS (guardamos las coordenadas de las aristas para luego dibujarlas en MOSTRAR)
class Nodo2
{
    String peso;
    int x;
    int y;
    int x1;
    int y1;
    Nodo2 enlace;
}
public class lista_vertices
{   
    public static Nodo nuevo, inicio, p, n, q;  //LISTA VERTICES
    public static Nodo nuevo2, inicio2, p2, n2, q2;    //LISTA DE ADYACENCIA
    public static Nodo1 nuevo3, inicio3, p3, n3, q3;    //LISTA DE COORDENADAS DE VERTICES
    public static Nodo2 nuevo4, inicio4, p4, n4, q4;    //LISTA DE COORDENADAS DE ARISTAS
    

    
    //LISTA DE VERTICES----------------------------------------------
    
    public void insertar_vertice(String dato)
    {
        nuevo = new Nodo();
        nuevo.informacion=dato;
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
    
    public void consultar_vertices()
    {
        q=inicio;
        while(q != null)
        {
            System.out.println("LISTA 1");
            System.out.print(q);
            System.out.print("\t"+q.informacion);
            System.out.print("\t"+q.enlace);
            System.out.print("\t"+q.enlace1);
            q=q.enlace;
        }
    }
    
     public boolean consultar_nombre(String nombre)
    {   boolean bandera=false;
        q=inicio;
        while(q != null)
        {
            if(q.informacion.equalsIgnoreCase(nombre))
            {
                bandera=true;
            }
            q=q.enlace;
        }
        
        return bandera;
    }
     
     public void borrar_list_vertices()
     {
         nuevo=null;
         inicio=null;
         p=null; 
         n=null; 
         q=null;             
     }
    
    //---------------------------------------------------------------------
     
    
    //LISTA DE ADYACENCIA---------------------------------------------
     
     public void insertar_adyacencia(String dato1, String dato2, int val_peso, int valor_heur)
     {  boolean exis_ady;
        nuevo2 = new Nodo();
        
        nuevo2.padre = dato1;
        nuevo2.hijo = dato2;
        
        nuevo2.peso = val_peso;
        nuevo2.val_eur = valor_heur;
        nuevo2.enlace3=null;
        nuevo2.enlace2 = consultar_v2_adyacente(dato2);
        nuevo2.enlace4 = null;
        //si ya exsite un enlace de adyacencia en el vertice de la lista1 (lista de vertices) retornamos un false
        consultar_v1_adyacente(dato1, nuevo2);   //metood para guardar enlace de nodo adyacente actual en enlace del nodo de la lista 1
        
        if(inicio2 == null)
        {
            inicio2=nuevo2;
        }
        else
        {
            p2.enlace4=nuevo2;
            /*if(exis_ady == false)
            {
                p2.enlace3 = nuevo2;
            }*/
        }
        p2=nuevo2;
     }
     
     public void consultar_v1_adyacente(String nombre, Nodo enlace_adyacente) //consulta el elemento adyacente (buscamos en la lista de vertices (lista1))
    {   //boolean exis_ady = false;
         
        q=inicio;
        while(q != null)
        {
           if(q.informacion.equals(nombre))
           {
               if(q.enlace1 == null)    //si en enlace1 del nodo de la lista1 esta vacio entra a esta condicion, sino se va al else
               {
                   q.enlace1 = enlace_adyacente;    // guardamos el enlace del nodo adyacente al nodo principal
                   //exis_ady = true;
                   break;
               }
               else
               {    //si eel vertice de la lista1 ya tiene valor enlace1, guardamos el enlace en el hijo principal de ese nodo
                   q2 = q.enlace1;
                   q2.enlace3 = enlace_adyacente;
                   break;
               }
           }
            
            q=q.enlace;
        }
        //return exis_ady;
    }
     
      public Nodo consultar_v2_adyacente(String nombre)  //consulta el elemento adyacente (buscamos en la lista de vertices (lista1))
    {
         Nodo enlace_vertice = null;    //ENLACE_VERTICE SIRVE RETORNAR EL ESPACIO DE MOMORIA QUE OCUPA EL VERTICE PRINCIPAL
         
        q=inicio;
        while(q != null)
        {
           if(q.informacion.equals(nombre))
           {
               enlace_vertice = q;   // guardamos el enlace del nodo principal para retornarlo al nodo adyacente
               break;
           }
            
            q=q.enlace;
        }
        return enlace_vertice;
    }
      
      public void consultar_list_adyacencia()
    {
        q2=inicio2;
        while(q2 != null)
        {
            System.out.println("LISTA 2");
            System.out.print(q2);
            System.out.print ("\t"+q2.hijo);
            System.out.print ("\t"+q2.padre);
            System.out.print ("\t"+q2.peso);
            System.out.print ("\t"+q2.val_eur);
            System.out.print("\t" + q2.enlace2);
            System.out.print("\t" + q2.enlace3);
            System.out.print("\t" + q2.enlace4);
            q2=q2.enlace4;
        }
    }
      
      public void borrar_list_adyacente()
     {
         nuevo2=null;
         inicio2=null;
         p2=null; 
         n2=null; 
         q2=null;
     }
      
      
      
      //LISTA DE COORDENADAS----------------------------------------------
    
    public void insertar_coordenada(String dato, int cord_x, int cord_y)
    {
        nuevo3 = new Nodo1();
        
        nuevo3.nombre = dato;
        nuevo3.x = cord_x;
        nuevo3.y = cord_y;
        
        nuevo3.enlace=null;
        
        if(inicio3 == null)
        {
            inicio3=nuevo3;
        }
        else
        {
            p3.enlace=nuevo3;
        }
        p3=nuevo3;
    }
     
    
    public int[] consultar_coord(String nombre)   //consultamos las coordenadas de los vertices para dibujar aristas
    {
        int cord_vert[] = new int [2];
        q3=inicio3;
        while(q3 != null)
        {
            if(q3.nombre.equalsIgnoreCase(nombre))
            {
                cord_vert[0] = q3.x;
                cord_vert[1] = q3.y;
            } 
            q3=q3.enlace;
        }
        return cord_vert;
    }
    
    public void borrar_list_coord()
     {
         nuevo3=null;
         inicio3=null;
         p3=null; 
         n3=null; 
         q3=null;
     }
    
    /*public int[] cons_all_coord()   //consultamos todas las coordenadas para volver a dibujarlas en "Mostrar"
    { 
//        Mostrar_Grafo mostrar=new Mostrar_Grafo();
        int cord_vert[] = new int [2];
        if(q3 == null)
        {
            q3=inicio3;
        }
        
        while(q3 != null)
        {     System.out.print(q3);
            System.out.print("\t" + q3.nombre + "\t");
            cord_vert[0] = q3.x;
            cord_vert[1] = q3.y;
           
            q3=q3.enlace;
            
            if(q3 == null)
            {
                Mostrar_Grafo.vertices = false;
            
            }
            break;
        }

        return cord_vert;
    }*/
    
    
    public void cons_all_coord(Graphics g)   //consultamos las coordenadas de los vertices para dibujar aristas
    {   
        Mostrar_Grafo mostrar=new Mostrar_Grafo();
       
        int coord_vert[] = new int [2];
        
        q3=inicio3;
        while(q3 != null)
        {
            coord_vert[0] = q3.x;
            coord_vert[1] = q3.y;
            
            mostrar.dibujar_vertice(g,q3.nombre,coord_vert[0],coord_vert[1]);
          
            q3=q3.enlace;
        }
    }
    
    
    
    //LISTA DE ARISTAS---------------------------------------------
    
    public void insertar_coord_arista(String peso,int x, int y, int x1, int y1)
    {
        nuevo4 = new Nodo2();
        
        nuevo4.peso=peso;
        nuevo4.x = x;
        nuevo4.y = y;
        nuevo4.x1 = x1;
        nuevo4.y1 = y1;
        nuevo4.enlace=null;
   
        if(inicio4 == null)
        {
            inicio4 = nuevo4;
        }
        else
        {
            p4.enlace = nuevo4;
        }
        p4 = nuevo4;
    }
    
    public void cons_all_aristas(Graphics g)   //consultamos las coordenadas de los vertices para dibujar aristas
    {   
        Mostrar_Grafo mostrar=new Mostrar_Grafo();
       
        
        q4 = inicio4;
        while(q4 != null)
        {
            mostrar.dibujar_arista(g , q4.peso, q4.x ,q4.y,q4.x1, q4.y1);
          
            q4 = q4.enlace;
        }
    }
    //-----------------------------------------------------------------------------------------------------------
    
    
    
    //BUSQUEDAS POR ANCHURA Y POR PROFUNDIDAD--------------------------------------------------------------------------
     
    public String consultar_padre(String ndo_actual)  //metodo para consultar el padre de un nodo (para las busquedas de anchura y profundidad)
    {   String padre=null;
        q2=inicio2;
        while(q2 != null)
        {
            if(q2.hijo.equalsIgnoreCase(ndo_actual))
            {
                padre = q2.padre;
                break;
            }               
            q2=q2.enlace4;
        }
        return padre;
    }
    
    public void consultar_hijos(String ndo_actual)  //PRIMERO CONSULTAMOS LA LISTA1 DE LOS VERTICES, PARA ENCONTRAR SI TIENE NODOS ADYACENTES (HIJOS) EN SU ENLACE1
    {   Hijos hijos=new Hijos();
        q=inicio;
        while(q != null)
        {
            if(q.informacion.equalsIgnoreCase(ndo_actual))
            {   //METODO DONDE CONSULTAMOS EN LA LISTA ADYACENTE LOS HIJOS DEL NODO ACTUAL-----------------
                q2 = q.enlace1;
                while(q2 != null)
                {
                    hijos.insertar_hijos(q2.hijo, ndo_actual);
                    q2 = q2.enlace3;
                }
                //-----------------------------------------------------------------------------------------------
                
                break; //terminamos el primer ciclo porque ya se ecnontro el nodo buscado
            }
            q=q.enlace;
        }
    }
    
}
    
    

