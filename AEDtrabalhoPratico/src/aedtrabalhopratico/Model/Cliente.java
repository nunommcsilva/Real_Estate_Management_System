package aedtrabalhopratico.Model;

import java.io.*;

/**
 *
 * @author Nuno
 */
public class Cliente implements Comparable, Serializable {

    public Integer IDcliente;
    public String nome;
    public Integer nif;
    public Boolean temDesconto;
//##############################################################################

    public Cliente() {
        this.IDcliente = 0;
        this.nome = "";
        this.nif = 0;
        this.temDesconto = false;
    }

    public Cliente(Integer IDcliente, String nome, Integer nif, Boolean temDesconto) {
        this.IDcliente = IDcliente;
        this.nome = nome;
        this.nif = nif;
        this.temDesconto = temDesconto;
    }
//##############################################################################

    public Integer getIDcliente() {
        return IDcliente;
    }

    public void setIDcliente(Integer IDcliente) {
        this.IDcliente = IDcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public Boolean isTemDesconto() {
        return temDesconto;
    }

    public void setTemDesconto(Boolean temDesconto) {
        this.temDesconto = temDesconto;
    }
//##############################################################################

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "\n\n Cliente: \n"
                + "IDcliente:'" + IDcliente + '\'' + ", \n"
                + "nome:'" + nome + '\'' + ", \n"
                + "NIF: " + nif + ", \n"
                + "temDesconto? " + temDesconto;
    }

    @Override
    public int compareTo(Object obj) {
        int result;

        if (nif.equals(((Cliente) obj).nif)) {

            if (nome.equals(((Cliente) obj).nome)) {

                if (IDcliente.equals(((Cliente) obj).IDcliente)) {

                    result = temDesconto.compareTo(((Cliente) obj).temDesconto);

                } else {
                    result = IDcliente.compareTo(((Cliente) obj).IDcliente);
                }
            } else {
                result = nome.compareTo(((Cliente) obj).nome);
            }
        } else {
            result = nif.compareTo(((Cliente) obj).nif);
        }
        return result;
    }
//##############################################################################
}
