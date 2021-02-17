package aedtrabalhopratico.Service;

import aedtrabalhopratico.Model.*;
import aedtrabalhopratico.CommonFiles.LinkedLists.*;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Nuno
 */
public class ImovelService implements Serializable {

    private ClienteService clienteService = new ClienteService();
    Scanner KB1 = new Scanner(System.in);
    public Iterator<Imovel> iteratorImovel;
    Cliente cliente0 = new Cliente(0, "", 0000, false);

    public Imovel criarImovel() {

        Imovel imvl = new Imovel();

        System.out.println("Inserir o ID do imovel: ");
        imvl.setIDimovel(KB1.nextInt());
        System.out.println("O ID do imovel e: " + imvl.getIDimovel());

        System.out.println("Inserir a morada do imovel: ");
        imvl.setMorada(KB1.next());
        System.out.println("A morada do imovel e: " + imvl.getMorada());

        System.out.println("Inserir a area do imovel: ");
        imvl.setArea(KB1.nextDouble());
        System.out.println("O area do imovel e: " + imvl.getArea());

        System.out.println("Inserir o preco do imovel: ");
        imvl.setPreco(KB1.nextDouble());
        System.out.println("O preco do imovel e: " + imvl.getPreco() + "\n");

        LinkedStack<Cliente> visitasClientes = new LinkedStack<>();
        visitasClientes.push(cliente0);
        imvl.setVisitasLS(visitasClientes);

        /*System.out.println("Deseja adicionar a primeira visita? (sim/nao)");
        if (KB1.next().equals("sim")) {
            Cliente cliente1 = clienteService.criarCliente();
            visitasClientes.push(cliente1);
            return imvl;
        } else if (KB1.next().equals("nao")) {
            return imvl;
        }*/
        
        return imvl;
    }

    public Iterator<Imovel> getIteratorImovel() {
        return iteratorImovel;
    }

    public Imovel findByID(Integer IDimovel) {
        Iterator<Imovel> it = this.iteratorImovel;
        while (it.hasNext()) {
            Imovel imovel1 = it.next();
            if (imovel1.IDimovel == IDimovel) {
                return imovel1;
            }
        }
        return null;
    }

}
