package navegandodboo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MauricioAsenjo
 */
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class LivroDAL {

    private static ObjectContainer db;
    //static ObjectSet<Livro> lista;
    static int i=4;
    static int a=0;

public static void conecta()
    {
        db = Db4o.openFile("meubanco.dbo");
    }

    public static void desconecta()
    {
        db.close();
    }


public static Livro getLivro(int op)
{
    conecta();
    ObjectSet<Livro> lista = db.get(Livro.class);
    Livro livro = null;
    switch(op)
    {
        case 2:
            i=0;break;
        case 3: a=i;
            if(a-- >= 0){i=i-1;}else{i=0;}
                break;
        case 4: a=i;
            if(a++<= 6){i=i+1;}else{i=6;}
                break;
        case 5:
            i=6;break;
    }
    //ARRUMAR
    if(i >= 0 && i <= 6)
    {
        livro = lista.get(i);
        desconecta();
        return livro;
       
    }
    else{
        desconecta();
        return null;
    }
    
}
}
