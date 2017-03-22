package br.ufal.ic.compiladores.lex;

/**
 * Created by rivo on 21/03/17.
 */
public class Palavra extends Token {
    private String lexema = "";

    public Palavra(Categoria invalido, String lexema) {
        super(invalido);
        this.lexema = lexema;
    }

    public final static Palavra
            PRV = new Palavra(Categoria.PRV, "VERDADEIRO"),
            PRF = new Palavra(Categoria.PRF, "FALSO"),
            PROU = new Palavra(Categoria.PROU, "OU"),
            PRE = new Palavra(Categoria.PRE, "E"),
            PRRETO = new Palavra(Categoria.PRRETO, "RETORNE"),
            PRFUNC = new Palavra(Categoria.PRFUNC, "FUNC"),
            PRINT = new Palavra(Categoria.PRINT, "INT"),
            PRPFT = new Palavra(Categoria.PRPFT, "PTF"),
            PRBOOL = new Palavra(Categoria.PRBOOL, "BOOL"),
            PRCAR = new Palavra(Categoria.PRCAR, "CARA'RE"),
            PRVET = new Palavra(Categoria.PRVET, "VET"),
            PRCC = new Palavra(Categoria.PRCC, "CC"),
            PRSE = new Palavra(Categoria.PRSE, "SE"),
            PRENTAO = new Palavra(Categoria.PRENTAO, "ENTAO"),
            PRPARA = new Palavra(Categoria.PRPARA, "PARA"),
            PRENQUANTO = new Palavra(Categoria.PRENQUANTO,"ENQUANTO"),
            PRBIB = new Palavra(Categoria.PRBIB, "BIBLIOTECAS"),


    // Delimitadores
    DELAPAR = new Palavra(Categoria.DELAPAR, "("),
            DELFPAR = new Palavra(Categoria.DELFPAR, ")"),
            DELACOLCH = new Palavra(Categoria.DELACOLCH, "["),
            DELFCOLCH = new Palavra(Categoria.DELFCOLCH, "]"),
            DELACHAVES = new Palavra(Categoria.DELACHAVES, "{"),
            DELFCHAVES = new Palavra(Categoria.DELFCHAVES, "}"),
            DELPONTVIRG = new Palavra(Categoria.DELPONTVIRG, ";"),
            DELVIRG = new Palavra(Categoria.DELVIRG, ","),
            DELPONTO = new Palavra(Categoria.DELPONTO, "."),
            DELASPAS = new Palavra(Categoria.DELASPAS, "'"),
            DELASPAD = new Palavra(Categoria.DELASPAD, "\""),

    // Operadores
    OPATRB = new Palavra(Categoria.OPATRB, "="),
            OPAD = new Palavra(Categoria.OPAD, "+"),
            OPSUB = new Palavra(Categoria.OPSUB, "-"),
            OPMULT = new Palavra(Categoria.OPMULT, "*"),
            OPDIV = new Palavra(Categoria.OPDIV,"/"),
            OPMAIQ = new Palavra(Categoria.OPMAIQ, ">"),
            OPMENQ = new Palavra(Categoria.OPMENQ, "<"),
            OPMAIIG = new Palavra(Categoria.OPMAIIG, ">"),
            OPMENIG = new Palavra(Categoria.OPMENIG, "<"),
            OPIG = new Palavra(Categoria.OPIG, "=="),
            OPDIF = new Palavra(Categoria.OPDIF, "!=");




    public String toString() {
        return "Token: <" + super.getCategoria() + " , " + lexema
                + "> posição (" + super.getLinha() + " , " + super.getColuna()
                + ")";
    }

    public String getLexema() {
        return lexema;
    }

}
