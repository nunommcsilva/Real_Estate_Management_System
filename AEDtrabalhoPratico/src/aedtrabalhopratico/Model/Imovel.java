package aedtrabalhopratico.Model;

import java.util.Iterator;
import aedtrabalhopratico.CommonFiles.LinkedLists.*;
import java.io.*;

/**
 *
 * @author Nuno
 */
public class Imovel implements Comparable, Serializable {

    public Integer IDimovel;
    public String morada;
    public Double area;
    public Double preco;
    public LinkedStack<Cliente> visitasLS;
    public Iterator<Imovel> iteratorImovel;

//##############################################################################    
    public Imovel() {
        this.IDimovel = 0;
        this.morada = "";
        this.area = 0.0;
        this.preco = 0.0;
        this.visitasLS = visitasLS;
    }

    public Imovel(Integer IDimovel, String morada, Double area, Double preco,
            LinkedStack<Cliente> visitasLS) {
        this.IDimovel = IDimovel;
        this.morada = morada;
        this.area = area;
        this.preco = preco;
        this.visitasLS = visitasLS;
    }
//##############################################################################    

    public Integer getIDimovel() {
        return IDimovel;
    }

    public void setIDimovel(Integer IDimovel) {
        this.IDimovel = IDimovel;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LinkedStack<Cliente> getVisitasLS() {
        return visitasLS;
    }

    public void setVisitasLS(LinkedStack<Cliente> visitasLS) {
        this.visitasLS = visitasLS;
    }

    public Iterator<Imovel> getIteratorImovel() {
        return iteratorImovel;
    }

//##############################################################################    
    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "\n\n\n Imovel \n{"
                + "\n IDimovel:'" + IDimovel + '\''
                + ", morada:'" + morada + '\''
                + ", area=" + area
                + "m^2, preco=" + preco
                + "€, \n visitas:" + visitasLS
                + '}';
    }

    @Override
    public int compareTo(Object obj) {
        Integer result = 0;

        if (preco.equals(((Imovel) obj).preco)) {

            if (area.equals(((Imovel) obj).area)) {

                if (morada.equals(((Imovel) obj).morada)) {

                    if (IDimovel.equals(((Imovel) obj).IDimovel)) {

                        result = IDimovel.compareTo(((Imovel) obj).IDimovel);
                    }
                } else {
                    result = morada.compareTo(((Imovel) obj).morada);
                }
            } else {
                result = area.compareTo(((Imovel) obj).area);
            }
        } else {
            result = preco.compareTo(((Imovel) obj).preco);
        }
        return result;
    }
//##############################################################################

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
