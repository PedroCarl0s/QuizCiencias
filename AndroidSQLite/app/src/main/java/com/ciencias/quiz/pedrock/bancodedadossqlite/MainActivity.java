package com.ciencias.quiz.pedrock.bancodedadossqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {

            // Criando Banco
            SQLiteDatabase bancoDados = openOrCreateDatabase("questoes", MODE_PRIVATE, null);

            // Criando tabelas
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS quimica (numeracao INT(2) PRIMARY KEY, enunciado VARCHAR, letraA VARCHAR, letraB VARCHAR, letraC VARCHAR, letraD VARCHAR)");


            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS fisica (numeracao INT(2), enunciado VARCHAR, letraA VARCHAR, letraB VARCHAR," +
                    "letraC VARCHAR, letraD VARCHAR)");


            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS biologia(numeracao INT(2), enunciado VARCHAR, letraA VARCHAR, letraB VARCHAR," +
                    "letraC VARCHAR, letraD VARCHAR)");


            // Inserindo dados
            bancoDados.execSQL("INSERT INTO quimica VALUES(01, 'No Gás de Cozinha contém um gás que nos permite perceber quando há vazamento, " +
                    "devido seu odor característico. Esse gás é: ', 'Hélio', 'Mercaptano', 'Metano', 'Nitrogênio')");



            // Recuperando dados
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM quimica", null);
            int numeracao = cursor.getColumnIndex("numeracao");
            int enunciado = cursor.getColumnIndex("enunciado");
            int letraA = cursor.getColumnIndex("letraA");
            int letraB = cursor.getColumnIndex("letraB");
            int letraC = cursor.getColumnIndex("letraC");
            int letraD = cursor.getColumnIndex("letraD");

            cursor.moveToFirst();
            while (cursor != null) {
                Log.i("RESULTADO", cursor.getString(numeracao));
                Log.i("1) ", cursor.getString(enunciado));
                Log.i("a) ", cursor.getString(letraA));
                Log.i("b) ", cursor.getString(letraB));
                Log.i("c) ", cursor.getString(letraC));
                Log.i("d) ", cursor.getString(letraD));

                cursor.moveToNext();
            }

        } catch (Exception error) {
            error.getStackTrace();
        }





    }
}
