package br.ufal.ic.compiladores.lex;

/**
 * Created by rivo on 21/03/17.
 */

public class Token {
    private Categoria categoria;
    private int linha;
    private int coluna;

    public Token(Categoria categoria) {
        this.setCategoria(categoria);
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setLinhaColuna(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
