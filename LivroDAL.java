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
    System.out.println("Na lista temos " + lista.size() + " livros.");
    
    switch(op)
    {
        case 2:
            i=0;break;
        case 3:int a=i;
            if(a++ >= 0){i=i-1;}break;
        case 4: int b=i;
            if(b++<= 6){i=i+1;}break;
        case 5:
            i=6;break;
    }
    Livro livro = lista.get(i);
    
    desconecta();
    
    return livro;
}
}