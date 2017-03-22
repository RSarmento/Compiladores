package br.ufal.ic.compiladores.lex;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

/**
 * Created by rivo on 21/03/17.
 */
public class Lexema {
    
    private InputStream codFonte;
    private Hashtable<String, Palavra> palavrasCatalogadas;
    private char c = ' ';
    private char controle = ' ';
    private static int linha = 1;
    private static int coluna = 1;

    public Lexema() {
        palavrasCatalogadas = new Hashtable<String, Palavra>();
        addPalavrasReservadas();
    }

    public Token nextToken() throws IOException {

        Palavra retornada;

        for (;;) {
            ++coluna;
            if (controle != '%') // caracter que nao pertence a linguagem
                c = (char) codFonte.read();
            switch (c) {
                case ' ': // espaço em branco
                case '\t': // tabulação
                    controle = ' ';
                    continue;
                case '\r':
                    controle = ' ';
                    coluna = 0;
                    continue;
                case '\n': // nova linha
                    ++linha;

                    continue;
                case '{':
                case '}':
                case '[':
                case ']':
                case '(':
                case ')':
                case ';':
                case ',':
                case '.':
                case '*':
                case '/':
                case '+':
                case '-':
                case '"':
                case '\'':
                    controle = ' ';
                    retornada = palavrasCatalogadas.get(Character.toString(c));
                    retornada.setLinhaColuna(linha, coluna);
                    return retornada;
                case '#': // tratameno de comentário
                    do {
                        c = (char) codFonte.read();
                    } while (c != '\r');
                    controle = ' ';
                    coluna = 0;
                    continue;
                case '=':
                    c = (char) codFonte.read();
                    if (c == '=') { // igualdade
                        Palavra.OPIG.setLinhaColuna(linha, coluna);
                        controle = ' ';
                        return Palavra.OPIG;
                    } else {
                        retornada = new Palavra(Categoria.INVAL, "=" + c);
                        retornada.setLinhaColuna(linha, coluna);
                        controle = '%';
                        return retornada;
                    }
                case '!':
                    c = (char) codFonte.read();
                    if (c == '=') { // diferente
                        Palavra.OPDIF.setLinhaColuna(linha, coluna);
                        controle = ' ';
                        return Palavra.OPDIF;
                    } else {
                        retornada = new Palavra(Categoria.INVAL, "!" + c);
                        retornada.setLinhaColuna(linha, coluna);
                        controle = '%';
                        return retornada;
                    }
                case '>':
                    c = (char) codFonte.read();
                    if (c == '=') { // maior ou igual
                        Palavra.OPMAIIG.setLinhaColuna(linha, coluna);
                        controle = ' ';
                        return Palavra.OPMAIIG;
                    } else {
                        Palavra.OPMAIQ.setLinhaColuna(linha, coluna);
                        controle = '%';
                        return Palavra.OPMAIQ;
                    }
                case '<':
                    c = (char) codFonte.read();
                    if (c == '=') { // menor ou igual
                        Palavra.OPMENIG.setLinhaColuna(linha, coluna);
                        controle = ' ';
                        return Palavra.OPMENIG;
                    } else if (c == '-') { // atribuição
                        Palavra.OPATRB.setLinhaColuna(linha, coluna);
                        controle = ' ';
                        return Palavra.OPATRB;
                    } else {
                        Palavra.OPMENQ.setLinhaColuna(linha, coluna);
                        controle = '%';
                        return Palavra.OPMENQ;
                    }

                default:
                    break;
            }
            break;
        }
        if (Character.isDigit(c)) {
            int valorInt = 0;
            do {
                valorInt = 10 * valorInt
                        + Integer.parseInt(Character.toString(c));
                c = (char) codFonte.read();
                ++coluna;
            } while (Character.isDigit(c));
            if (c != '.') {
                Token inteiro = new Inteiro(valorInt);
                inteiro.setLinhaColuna(linha, coluna);
                controle = '%';
                return inteiro;
            }

            float x = valorInt;
            float d = 10;
            for (;;) {
                c = (char) codFonte.read();
                ++coluna;
                if (!Character.isDigit(c)) {
                    controle = '%';
                    break;
                }
                x = x + Integer.parseInt(Character.toString(c)) / d;
                d = d * 10;
            }
            Token pont = new PontoFlutuante(x);
            pont.setLinhaColuna(linha, coluna);
            return pont;
        }
        if (Character.isLetter(c)) {
            StringBuffer b = new StringBuffer();
            do {
                b.append(c);
                c = (char) codFonte.read();
                ++coluna;
            } while (Character.isLetterOrDigit(c) || c == '_');
            controle = '%';
            String s = b.toString();
            Palavra w = (Palavra) palavrasCatalogadas.get(s);
            if (w != null) {
                w.setLinhaColuna(linha, coluna);
                return w;
            }

            w = new Palavra(Categoria.ID, s);
            palavrasCatalogadas.put(s, w);
            w.setLinhaColuna(linha, coluna);
            return w;
        }

        return null;

    }

    public void addPalavrasReservadas() {
        // Palavras Reservadas
        palavrasCatalogadas.put("VERDADEIRO", Palavra.PRV);
        palavrasCatalogadas.put("FALSO", Palavra.PRF);
        palavrasCatalogadas.put("OU", Palavra.PROU);
        palavrasCatalogadas.put("E", Palavra.PRE);
        palavrasCatalogadas.put("RETORNE", Palavra.PRRETO);
        palavrasCatalogadas.put("FUNCAO", Palavra.PRFUNC);
        palavrasCatalogadas.put("INTEIRO", Palavra.PRINT);
        palavrasCatalogadas.put("PRPFT", Palavra.PRPFT);
        palavrasCatalogadas.put("BOOLEANO", Palavra.PRBOOL);
        palavrasCatalogadas.put("CARACTER", Palavra.PRCAR);
        palavrasCatalogadas.put("VETOR", Palavra.PRVET);
        palavrasCatalogadas.put("TEXTO", Palavra.PRCC);
        palavrasCatalogadas.put("SE", Palavra.PRSE);
        palavrasCatalogadas.put("ENTAO", Palavra.PRENTAO);
        palavrasCatalogadas.put("PARA",Palavra.PRPARA);
        palavrasCatalogadas.put("ENQUANTO",Palavra.PRENQUANTO);
        palavrasCatalogadas.put("BIBLIOTECA",Palavra.PRBIB);

        // Delimitadores
        palavrasCatalogadas.put("(", Palavra.DELAPAR);
        palavrasCatalogadas.put(")", Palavra.DELFPAR);
        palavrasCatalogadas.put("{", Palavra.DELACHAVES);
        palavrasCatalogadas.put("}", Palavra.DELFCHAVES);
        palavrasCatalogadas.put("[", Palavra.DELACOLCH);
        palavrasCatalogadas.put("]", Palavra.DELFCOLCH);
        palavrasCatalogadas.put(".", Palavra.DELPONTO);
        palavrasCatalogadas.put(";", Palavra.DELPONTVIRG);
        palavrasCatalogadas.put(",", Palavra.DELVIRG);
        palavrasCatalogadas.put("'", Palavra.DELASPAS);
        palavrasCatalogadas.put("\"", Palavra.DELASPAD);

        // Operadores
        palavrasCatalogadas.put("<-", Palavra.OPATRB);
        palavrasCatalogadas.put("+", Palavra.OPAD);
        palavrasCatalogadas.put("-", Palavra.OPSUB);
        palavrasCatalogadas.put("*", Palavra.OPMULT);
        palavrasCatalogadas.put("/", Palavra.OPDIV);
        palavrasCatalogadas.put(">", Palavra.OPMAIQ);
        palavrasCatalogadas.put("<", Palavra.OPMENQ);
        palavrasCatalogadas.put(">=", Palavra.OPMAIIG);
        palavrasCatalogadas.put("<=", Palavra.OPMENIG);
        palavrasCatalogadas.put("==", Palavra.OPIG);
        palavrasCatalogadas.put("!=", Palavra.OPDIF);

    }

    public void setCodFonte(InputStream codFonte) {
        this.codFonte = codFonte;
    }

}
