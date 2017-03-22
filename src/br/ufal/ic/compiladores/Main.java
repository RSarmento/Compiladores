package br.ufal.ic.compiladores;

import br.ufal.ic.compiladores.lex.Lexema;
import br.ufal.ic.compiladores.lex.Token;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    private static Lexema lex;
    private static Token token;
    private static InputStream helloworld, fibonacci, shellsort;

    public static void main (String[] args) throws IOException{
        lex = new Lexema();

        helloworld = new FileInputStream("/home/rivo/RD_analisador_lexico/programas/helloworld.rd");
        fibonacci = new FileInputStream("/home/rivo/RD_analisador_lexico/programas/fibonacci.rd");
        //shellsort = new FileInputStream("/home/rivo/RD_analisador_lexico/programas/shellsort.rd");

        System.out.println("Tokens do programa helloworld.rd\n");
        lex.setCodFonte(helloworld);
        token = lex.nextToken();
        while (token != null) {
            System.out.println(token.toString() + "\n");
            token = lex.nextToken();
        }

        System.out.println("Tokens do programa fibonacci.rd\n");
        lex.setCodFonte(fibonacci);
        token = lex.nextToken();
        while (token != null) {
            System.out.println(token.toString() + "\n");
            token = lex.nextToken();
        }
    }
}