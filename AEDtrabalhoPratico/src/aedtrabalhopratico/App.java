package aedtrabalhopratico;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Nuno
 */
public class App implements Serializable {

    private Scanner scanner = new Scanner(System.in);
    public String filename = "file.ser";
    int option = scanner.nextInt();
    //public AEDtrabalhoPratico imobiliaria;

    public static void main(String[] args) {
        AEDtrabalhoPratico AEDtp = new AEDtrabalhoPratico();
        AEDtp.run();

    }
}
//
//
//
//
//
//
//
//
//

/*
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
        System.out.println("Bem vindo");
        System.out.println("Selecione sua opcao");
        System.out.println("60 - Guardar em ficheiro");
        System.out.println("70 - Abrir ficheiro");
        System.out.println("80 - Inicializar a aplicacao");
        

        switch (option) {
            case 60:
                //saveToFile(imobiliaria);
                break;

            case 70:
               // imobiliaria = readFromFile();
                break;

            case 80:
                AEDtrabalhoPratico AEDtp = new AEDtrabalhoPratico();
                AEDtp.run();
                break;

            default:
                System.out.println("Opcao invalida");
                break;
        }
        //run();

    }
 */
