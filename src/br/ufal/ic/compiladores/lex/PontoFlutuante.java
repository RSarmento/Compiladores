package br.ufal.ic.compiladores.lex;

/**
 * Created by rivo on 21/03/17.
 */
public class PontoFlutuante extends Token {
    private float valor;

    public PontoFlutuante(float valor) {
        super(Categoria.CTEPFT);
        this.valor = valor;
    }

    public String toString() {
        return "Token: <" + super.getCategoria() + " , " + valor
                + "> posição (" + super.getLinha() + " , " + super.getColuna()
                + ")";
    }

}