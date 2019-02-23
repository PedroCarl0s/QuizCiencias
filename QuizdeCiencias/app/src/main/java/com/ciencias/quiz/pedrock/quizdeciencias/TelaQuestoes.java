package com.ciencias.quiz.pedrock.quizdeciencias;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ciencias.quiz.pedrock.quizdeciencias.helper.DbHelper;


public class TelaQuestoes extends AppCompatActivity {

    private Cursor cursor;
    private TextView questao;

    private RadioButton letraA;
    private RadioButton letraB;
    private RadioButton letraC;
    private RadioButton letraD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_questoes);

        // Obtendo a disciplina escolhida anteriormente
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("titulo");


        // Tenta alterar a imageView para a disciplina do parâmetro
        try {
            int imagem = getImagem(nome);

            ImageView imgTitulo = (ImageView) findViewById(R.id.imgTitulo);
            imgTitulo.setImageResource(imagem);

        } catch (Exception error) {
            error.getMessage();
        }

        // Altera o texto do textView
        TextView titulo = (TextView) findViewById(R.id.lblTitulo);
        titulo.setText(nome);


        // Testa o nome da matéria escolhida, para usar uma CONSTANTE
        String nomeTabela = "";
        if (nome.equalsIgnoreCase("Química")) nomeTabela = DbHelper.TABLE_QUIMICA;
        else if (nome.equalsIgnoreCase("Física")) nomeTabela = DbHelper.TABLE_FISICA;
        else nomeTabela = DbHelper.TABLE_BIOLOGIA;

        // Cria um objeto para poder ler o banco criado
        DbHelper db = new DbHelper(getApplicationContext());

        // Realiza a pesquisa
        String sql = "SELECT * FROM " + nomeTabela + " ;";
        SQLiteDatabase banco = db.getReadableDatabase();

        this.cursor = banco.rawQuery(sql, null);
        this.cursor.moveToFirst();

        this.questao = (TextView) findViewById(R.id.lblEnunciado);
        this.letraA = (RadioButton) findViewById(R.id.letraA);
        this.letraB = (RadioButton) findViewById(R.id.letraB);
        this.letraC = (RadioButton) findViewById(R.id.letraC);
        this.letraD = (RadioButton) findViewById(R.id.letraD);

        // Modifica o enunciado e alternativas da questão
        alterarTexto(this.cursor);

    }

    // AlertDialog após clicar no botão voltar
    @Override
    public void onBackPressed() {

        // Cria Alerta
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        // Nomeia as mensagens
        alert.setTitle("Você deseja sair ?");
        alert.setMessage("Se vocẽ sair, seu progresso será perdido!");

        // Configura cancelamento
        alert.setCancelable(false);

        // Configura ícone
        alert.setIcon(android.R.drawable.ic_dialog_alert);

        alert.setPositiveButton("Ficar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alert.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alert.create();
        alert.show();
    }

    public void avancarQuestao(View view) {

        if (!this.cursor.isAfterLast()) {
            alterarTexto(this.cursor);
        }
    }


    private int getImagem(String titulo) throws Exception {
        int[] imgID = {R.drawable.quimica, R.drawable.fisica, R.drawable.biologia};

        if (titulo.equalsIgnoreCase("Química")) return imgID[0];
        else if (titulo.equalsIgnoreCase("Física")) return imgID[1];
        else if (titulo.equalsIgnoreCase("Biologias")) return imgID[2];
        else throw new Exception("Erro: título inválido!");
    }


    private void alterarTexto(Cursor cursor) {

            this.questao.setText(cursor.getString(0) + ") " + cursor.getString(1));
            this.letraA.setText(cursor.getString(2));
            this.letraB.setText(cursor.getString(3));
            this.letraC.setText(cursor.getString(4));
            this.letraD.setText(cursor.getString(5));

            this.cursor.moveToNext();
    }

}