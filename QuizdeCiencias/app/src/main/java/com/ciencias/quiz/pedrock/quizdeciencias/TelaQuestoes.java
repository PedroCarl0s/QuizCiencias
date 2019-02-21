package com.ciencias.quiz.pedrock.quizdeciencias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TelaQuestoes extends AppCompatActivity {


    private TextView titulo;
    private ImageView imgTitulo;

    private String enunciado;
    private String letraA, letraB, letraC, letraD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_questoes);

        String[] letras =  {"Hélio", "Mercaptano", "Metano", "Enxofre"};
        letras[0] = "letraA";
        Questao q1 = new Questao("teste", letras);


        enunciado = q1.getEnunciado();
        letraA = q1.getLetraA();
        letraB = q1.getLetraB();
        letraC = q1.getLetraC();
        letraD = q1.getLetraD();


        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("titulo");

        imgTitulo = (ImageView) findViewById(R.id.imgTitulo);


        // Tenta alterar a imageView para a disciplina do parâmetro
        try {
            int imagem = getImagem(nome);

            imgTitulo.setImageResource(imagem);

        } catch (Exception error) {
            error.getMessage();
        }

        // Recebe o textView da Activity e altera
        titulo = findViewById(R.id.lblTitulo);
        titulo.setText(nome);

    }


    private int getImagem(String titulo) throws Exception {
        int[] imgID = {R.drawable.quimica, R.drawable.fisica, R.drawable.biologia};

        if (titulo.equalsIgnoreCase("Química")) return imgID[0];
        else if (titulo.equalsIgnoreCase("Física")) return imgID[1];
        else if (titulo.equalsIgnoreCase("Biologias")) return imgID[2];
        else throw new Exception("Erro: título inválido!");
    }

}
