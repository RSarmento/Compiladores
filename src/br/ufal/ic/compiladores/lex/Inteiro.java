package br.ufal.ic.compiladores.lex;

/**
 * Created by rivo on 21/03/17.
 */
public class Inteiro extends Token {
    private int valor;

    public Inteiro(int valor) {
        super(Categoria.CTEINT);
        this.valor = valor;
    }

    public String toString() {
        return "Token: <" + super.getCategoria() + " , " + valor
                + "> posição (" + super.getLinha() + " , " + super.getColuna()
                + ")";
    }
}
