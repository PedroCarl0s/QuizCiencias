package com.ciencias.quiz.pedrock.quizdeciencias;

public class Questao {

    private String enunciado;
    private String letraA, letraB, letraC, letraD;


    public Questao(String enunciado, String[] letras) {
        this.enunciado = enunciado;
        this.letraA = letras[0];
        this.letraB = letras[1];
        this.letraC = letras[2];
        this.letraD = letras[3];
    }


    public String getEnunciado() {
        return this.enunciado;
    }

    public String getLetraA() {
        return this.letraA;
    }

    public String getLetraB() {
        return this.letraB;
    }

    public String getLetraC() {
        return this.letraC;
    }

    public String getLetraD() {
        return this.letraD;
    }

}