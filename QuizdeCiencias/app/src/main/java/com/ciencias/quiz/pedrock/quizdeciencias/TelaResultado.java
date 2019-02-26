package com.ciencias.quiz.pedrock.quizdeciencias;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.ciencias.quiz.pedrock.quizdeciencias.R;
import com.ciencias.quiz.pedrock.quizdeciencias.helper.DbHelper;

import org.w3c.dom.Text;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TelaResultado extends AppCompatActivity {

    private static final int NUMERO_CAMPOS = 7;
    private static final int NUMERO_QUESTOES = 5;

    private ListView listQuestoes;
    private SimpleAdapter simple;
    private Intent abreMenu;

    ArrayList<HashMap<String, String>> lista = new ArrayList<HashMap<String, String>>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        // Criando objetos para recuperar dados anteriores
        Bundle dados = getIntent().getExtras();
        DbHelper db = new DbHelper(getApplicationContext());

        // Recuperando matéria selecionada + letras marcadas
        String sql = dados.getString("consulta");
        ArrayList<String> respostasMarcadas = new ArrayList<String>();
        respostasMarcadas = dados.getStringArrayList("assinaladas");

        // Lendo Banco de Dados
        SQLiteDatabase banco = db.getReadableDatabase();
        Cursor cursor = banco.rawQuery(sql, null);

        // Array para pegar as questões do Banco de Dados
        String[][] questoes = new String[NUMERO_QUESTOES][NUMERO_CAMPOS];
        cursor.moveToFirst();

        int totalAcertos = 0, totalErros = 0;

        // Adicionando as questões do banco de dados, no array de Strings
        for (int linha = 0; linha < NUMERO_QUESTOES; linha++) {


            for (int coluna = 0; coluna < NUMERO_CAMPOS; coluna++) {
                questoes[linha][coluna] = cursor.getString(coluna);

            }

            if (respostasMarcadas.get(linha).equals(questoes[linha][6])) totalAcertos++;
            cursor.moveToNext();
        }

        HashMap<String, String> item;
        for (int i = 0; i < NUMERO_QUESTOES; i++) {
            item = new HashMap<String, String>();
            item.put("enunciado", questoes[i][0] + ") " + questoes[i][1]);
            item.put("letraA", questoes[i][2]);
            item.put("letraB", questoes[i][3]);
            item.put("letraC", questoes[i][4]);
            item.put("letraD", questoes[i][5]);
            lista.add(item);
        }


        // Usar o Adaptador para linkar e visualizar os dados
        simple = new SimpleAdapter(getApplicationContext(), lista,
                R.layout.multi_lines,
                new String[] {"enunciado", "letraA", "letraB", "letraC", "letraD"},
                new int[] {R.id.enunciado, R.id.A, R.id.B, R.id.C, R.id.D});

        // Linkando o Adaptador para a lista
        ((ListView) findViewById(R.id.listView)).setAdapter(simple);

        TextView titulo = (TextView) findViewById(R.id.txtAcertos);
        titulo.setText(titulo.getText() + " " + String.valueOf(totalAcertos) + "/5 ");
        Toast.makeText(getApplicationContext(), "Fim do Quiz!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
       this.abreMenu = new Intent(TelaResultado.this, MainActivity.class);
       startActivity(abreMenu);
    }




}
