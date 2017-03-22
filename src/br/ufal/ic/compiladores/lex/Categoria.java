package br.ufal.ic.compiladores.lex;

/**
 * Created by rivo on 21/03/17.
 */
public enum Categoria {
    //	public final static int
    ID ,
    CTEINT ,
    CTEPFT,

    //Palavras reservadas
    PRV,
    PRF,
    PROU,
    PRE,
    PRRETO,
    PRFUNC,
    PRSE,
    PRENTAO,
    PRPARA,
    PRENQUANTO,
    PRINT,
    PRPFT,
    PRBOOL,
    PRCAR,
    PRCC,
    PRVET,
    PRBIB,

    //Delimtadores
    DELAPAR ,
    DELFPAR,
    DELACOLCH ,
    DELFCOLCH ,
    DELACHAVES ,
    DELFCHAVES ,
    DELPONTVIRG,
    DELVIRG,
    DELPONTO ,
    DELASPAS ,
    DELASPAD ,

    //Operadores
    OPATRB,
    OPAD,
    OPSUB,
    OPMULT,
    OPDIV,
    OPMAIQ,
    OPMENQ,
    OPMAIIG,
    OPMENIG,
    OPIG,
    OPDIF,

    INVAL;
}
