package aedtrabalhopratico.Service;

import aedtrabalhopratico.Model.*;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Nuno
 */
public class ClienteService implements Serializable {

    Scanner KB = new Scanner(System.in);

    public Cliente criarCliente() {

        Cliente clnt = new Cliente();

        System.out.println("\nPor favor insira os dados do visitante: ");

        System.out.println("Inserir o IDcliente: ");
        clnt.setIDcliente(KB.nextInt());
        System.out.println("O IDcliente e: " + clnt.getIDcliente());

        System.out.println("Inserir o nome: ");
        clnt.setNome(KB.next());
        System.out.println("O nome e: " + clnt.getNome());

        System.out.println("Inserir o NIF: ");
        clnt.setNif(KB.nextInt());
        System.out.println("O NIF e: " + clnt.getNif());

        clnt.setTemDesconto(false);

        return clnt;
    }

}
