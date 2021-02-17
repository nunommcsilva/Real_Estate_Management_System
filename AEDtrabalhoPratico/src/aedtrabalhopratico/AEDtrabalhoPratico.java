package aedtrabalhopratico;

import aedtrabalhopratico.Model.*;
import aedtrabalhopratico.Service.*;
import aedtrabalhopratico.CommonFiles.LinkedLists.*;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Nuno
 */
public class AEDtrabalhoPratico implements Serializable {

    private Scanner scanner = new Scanner(System.in);
    public LinkedList<Imovel> imoveisLL = new LinkedList<>();
    private ImovelService imovelService1 = new ImovelService();
    private String inputStr;
    private int inputInt;
    private int nClientesDesc = 2;        // Modificar em caso de teste
    public String filename = "file.ser";

    /**
     * @param args the command line arguments
     * @param imobiliaria
     */
    public void saveToFile(AEDtrabalhoPratico imobiliaria) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(imobiliaria);

            out.close();
            file.close();

            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    public AEDtrabalhoPratico readFromFile() {
        AEDtrabalhoPratico imobiliaria1 = null;
        try {
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object 
            imobiliaria1 = (AEDtrabalhoPratico) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            //System.out.println("a = " + object1.a); 
            //System.out.println("b = " + object1.b); 
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        return imobiliaria1;
    }

    public void run() {

        System.out.println("\nBem vindo a gestao de imoveis");
        System.out.println("Escolha a sua opcao");

        System.out.println("10 - Criar imovel");
        System.out.println("20 - Adicionar visita");
        System.out.println("31 - Pesquisar imovel por Morada");
        System.out.println("32 - Pesquisar imovel por Preco");
        System.out.println("33 - Pesquisar imovel por Area");
        System.out.println("34 - Exibir imovel por IDimovel");
        System.out.println("40 - Listar todos os imoveis");
        System.out.println("50 - Eliminar imovel");
        //System.out.println("60 - Guardar em ficheiro");
        //System.out.println("70 - Abrir ficheiro");
        System.out.println("80 - TESTE");

        int option = scanner.nextInt();
        switch (option) {
//##################################     //Criar imovel//     ##################
            case 10:
                Imovel imovel1 = imovelService1.criarImovel();
                imoveisLL.add(imovel1);
                imoveisLL.selectionSort();
                System.out.println("\n Imovel criado.");
                break;

//#########################     //Adicionar visita//     #######################                    
            case 20:
                System.out.println("\n Digite o ID do imovel ao qual quer adicionar uma visita: \n");
                inputInt = scanner.nextInt();
                LinkedNode node2 = imoveisLL.head;
                do {
                    Imovel imo = (Imovel) node2.getElement();
                    if (imo.getIDimovel() == inputInt) {
                        ClienteService clntSrvc = new ClienteService();
                        imo.visitasLS.push(clntSrvc.criarCliente());
                        System.out.println("\n Cliente adicionado \n");
                        System.out.println("\n Imovel n°" + inputInt + ":" + imo.toString());
                    }
                    node2 = node2.next;
                } while (node2 != null);

                break;

//#########################     //Exibir imovel por Morada     //###############
            case 31:
                System.out.println("\n Digite a morada pretendida para os imoveis a pesquisar: ");
                inputStr = scanner.next();
                LinkedNode node31 = imoveisLL.head;
                System.out.println("\n Estao disponiveis os seguintes imoveis: ");
                do {
                    Imovel imo = (Imovel) node31.getElement();
                    if (imo.getMorada().equals(inputStr)) {
                        System.out.println("\n Imovel n°" + imo.getIDimovel() + ":" + imo.toString());
                    }
                    node31 = node31.next;
                } while (node31 != null);

                break;

//#########################     //Exibir imovel por preco     //################
            case 32:
                System.out.println("\n Digite o preco pretendido para os imoveis a pesquisar: ");
                //parte-se do principio que o valor inserido sera um int
                inputInt = scanner.nextInt();
                LinkedNode node32 = imoveisLL.head;
                System.out.println("\n Estao disponiveis os seguintes imoveis: ");
                do {
                    Imovel imo = (Imovel) node32.getElement();
                    //caso o preco tenha casas decimais, e feito o arredondamento para int
                    if ((int) Math.round(imo.getPreco()) == inputInt) {
                        System.out.println("\n Imovel n°" + imo.getIDimovel() + ":" + imo.toString());
                    }
                    node32 = node32.next;
                } while (node32 != null);

                break;

//#########################     //Exibir imovel por area     //#################
            case 33:
                System.out.println("\n Digite a area pretendida para os imoveis a pesquisar: ");
                //parte-se do principio que o valor inserido sera um int
                inputInt = scanner.nextInt();
                LinkedNode node33 = imoveisLL.head;
                System.out.println("\n Estao disponiveis os seguintes imoveis: ");
                do {
                    Imovel imo = (Imovel) node33.getElement();
                    //caso a area tenha casas decimais, e feito o arredondamento para int
                    if ((int) Math.round(imo.getArea()) == inputInt) {

                        System.out.println("\n Imovel n°" + imo.getIDimovel() + ":" + imo.toString());
                    }
                    node33 = node33.next;
                } while (node33 != null);

                break;

//#########################     //Exibir imovel por IDimovel     //#############
            case 34:
                System.out.println("\n Digite o ID do imovel a exibir");
                inputInt = scanner.nextInt();
                LinkedNode node34 = imoveisLL.head;

                do {

                    Imovel imo = (Imovel) node34.getElement();
                    if (imo.getIDimovel() == inputInt) {
                        System.out.println("\n Imovel n°" + inputInt + ":" + imo.toString());

                        System.out.println("\n Deseja verificar se ha clientes com direito a desconto? (sim/nao)");
                        inputStr = scanner.next();
                        if (inputStr.equals("sim")) {
                            if (imo.getVisitasLS().count > nClientesDesc) {

                                LinkedStack<Cliente> temp = new LinkedStack<>();
                                temp.push(imo.getVisitasLS().pop());
                                System.out.println("Os clientes \n"
                                        + temp.toString()
                                        + "e \n"
                                        + imo.getVisitasLS().peek().toString()
                                        + "\n\n tem direito a 5% de desconto \n");
                                imo.getVisitasLS().push(temp.pop());
                            } else {
                                System.out.println("\n Ainda nao ha clientes com direito a desconto");
                            }
                        }
                    }
                    node34 = node34.next;

                } while (node34 != null);

                break;

//#########################     //Listar todos os imoveis//     ################                
            case 40:
                System.out.println("\n Lista de imoveis:");
                System.out.println(imoveisLL.toString() + "\n");
                break;

//#########################     //Eliminar imovel//     ########################                
            case 50:

                System.out.println("\n Digite o ID do imovel a eliminar: ");
                inputInt = scanner.nextInt();
                LinkedNode node50 = imoveisLL.head;
                do {
                    Imovel imo = (Imovel) node50.getElement();
                    if (imo.getIDimovel() == inputInt) {

                        imoveisLL.remove(imo);

                        System.out.println("\n O imovel n°" + inputInt + " foi removido");

                    }
                    node50 = node50.next;
                } while (node50 != null);

                System.out.println("\n Situacao atual da lista de  imoveis:\n" + imoveisLL.toString() + "\n");

                break;

//#########################     // Guardar em ficheiro     #####################               
            //case 60:
            //saveToFile(imobiliaria);
            //break;
//#########################     // Abrir ficheiro      #########################                
            //case 70:
            // imobiliaria = readFromFile();
            //break;
//#########################     //TESTE     ####################################
            case 80:

                System.out.println("\nA partir de quantos clientes pretende oferecer desconto?");
                nClientesDesc = scanner.nextInt();

                Cliente cliente1 = new Cliente(1, "Ana", 3687, false);
                Cliente cliente2 = new Cliente(2, "Carolina", 7492, false);
                Cliente cliente7 = new Cliente(7, "Jaime", 2875, false);
                LinkedStack<Cliente> visitas1LS = new LinkedStack<>();
                visitas1LS.push(cliente1);
                visitas1LS.push(cliente2);
                visitas1LS.push(cliente7);
                Imovel casa1 = new Imovel(1, "Lisboa", 50.0, 100000.0, visitas1LS);

                Cliente cliente3 = new Cliente(3, "Daniel", 1787, false);
                Cliente cliente4 = new Cliente(4, "Eurico", 9746, false);
                LinkedStack<Cliente> visitas2LS = new LinkedStack<>();
                visitas2LS.push(cliente3);
                visitas2LS.push(cliente4);
                Imovel casa2 = new Imovel(2, "Santarem", 75.0, 120000.0, visitas2LS);

                Cliente cliente5 = new Cliente(5, "Pedro", 6483, false);
                Cliente cliente6 = new Cliente(6, "Joana", 2974, false);
                LinkedStack<Cliente> visitas3LS = new LinkedStack<>();
                visitas3LS.push(cliente5);
                visitas3LS.push(cliente6);
                Imovel casa3 = new Imovel(3, "Leiria", 100.0, 135000.0, visitas3LS);

                imoveisLL.add(casa1);
                imoveisLL.add(casa2);
                imoveisLL.add(casa3);

                System.out.println("\n Lista de todos os imoveis:\n" + imoveisLL.toString() + "\n");

                break;

//##############################################################################                
            default:
                System.out.println("Opcao invalida");
                break;
        }
        run();

    }

}
