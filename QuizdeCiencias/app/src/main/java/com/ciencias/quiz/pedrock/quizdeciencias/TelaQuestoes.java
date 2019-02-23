package com.ciencias.quiz.pedrock.quizdeciencias;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ciencias.quiz.pedrock.quizdeciencias.helper.DbHelper;

public class TelaQuestoes extends AppCompatActivity {


    private TextView titulo;
    private ImageView imgTitulo;
    private Button btnProxima;

    private String enunciado;
    private String letraA, letraB, letraC, letraD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_questoes);

        // Obtendo a disciplina escolhida anteriormente
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



        String nomeTabela = "";
        if (nome.equalsIgnoreCase("Química")) nomeTabela = DbHelper.TABLE_QUIMICA;
        else if (nome.equalsIgnoreCase("Física")) nomeTabela = DbHelper.TABLE_FISICA;
        else nomeTabela = DbHelper.TABLE_BIOLOGIA;

        DbHelper db = new DbHelper(getApplicationContext());

        String sql = "SELECT * FROM " + nomeTabela + " ;";
        SQLiteDatabase banco = db.getReadableDatabase();

        Cursor cursor = banco.rawQuery(sql, null);

        //btnProxima = (Button) findViewById(R.id.btnAvancar);

        cursor.moveToFirst();

        TextView questao = (TextView) findViewById(R.id.lblEnunciado);
        questao.setText(cursor.getString(0) + ") " + cursor.getString(1));

    }


    private int getImagem(String titulo) throws Exception {
        int[] imgID = {R.drawable.quimica, R.drawable.fisica, R.drawable.biologia};

        if (titulo.equalsIgnoreCase("Química")) return imgID[0];
        else if (titulo.equalsIgnoreCase("Física")) return imgID[1];
        else if (titulo.equalsIgnoreCase("Biologias")) return imgID[2];
        else throw new Exception("Erro: título inválido!");
    }



}
