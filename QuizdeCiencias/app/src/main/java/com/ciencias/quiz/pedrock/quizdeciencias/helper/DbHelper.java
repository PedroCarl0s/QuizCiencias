package com.ciencias.quiz.pedrock.quizdeciencias.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {


    public static int VERSION = 1;
    public static String NAME_DB = "DB_MATERIAS";

    public static String TABLE_QUIMICA = "quimica";
    public static String TABLE_FISICA = "fisica";
    public static String TABLE_BIOLOGIA = "biologia";


    public DbHelper(Context context) {
        super(context, NAME_DB, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlQuimica = "CREATE TABLE IF NOT EXISTS " + TABLE_QUIMICA
                + " (id INTEGER PRIMARY KEY, enunciado TEXT NOT NULL, " +
                " letraA VARCHAR NOT NULL, letraB VARCHAR NOT NULL, " +
                " letraC VARCHAR NOT NULL, letraD VARCHAR NOT NULL, correta CHAR );";


        String sqlFisica = "CREATE TABLE IF NOT EXISTS " + TABLE_FISICA
                + " (id INTEGER PRIMARY KEY, enunciado TEXT NOT NULL, " +
                " letraA VARCHAR NOT NULL, letraB VARCHAR NOT NULL, " +
                " letraC VARCHAR NOT NULL, letraD VARCHAR NOT NULL, correta CHAR );";

        String sqlBiologia = "CREATE TABLE IF NOT EXISTS " + TABLE_BIOLOGIA
                + " (id INTEGER PRIMARY KEY, enunciado TEXT NOT NULL, " +
                " letraA VARCHAR NOT NULL, letraB VARCHAR NOT NULL, " +
                " letraC VARCHAR NOT NULL, letraD VARCHAR NOT NULL, correta CHAR );";


        String insertQuimica = "";
        String insertFisica = "";
        String insertBiologia = "";


        try {

            // Criando tabelas
            db.execSQL(sqlQuimica);
            db.execSQL(sqlFisica);
            db.execSQL(sqlBiologia);


            Log.i("INFO DB", "Sucesso ao criar tabela!");

        } catch (Exception error) {
            Log.i("INFO DB", "Erro, o a tabela 'química' não pôde ser criada!");
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*
    public String insertQuimica() {
        String questoes = "INSERT INTO TABLE " + TABLE_QUIMICA +
                " VALUES(1, Unifor-CE Um material que pode ser considerado substância pura é: , " +
                " a) o petróleo, b) o querosene, c) o carbono diamante, d) a água do mar, c " +
                " (2, As partículas fundamentais de um átomo são:, a) apenas prótons, b) apenas prótons e nêutrons, c) apenas elétrons, d) prótons, nêutrons e elétrons, d " +
                " (3, Densidade é uma propriedade definida pela relação:, a) massa / pressão, b) massa / volume, c) pressão / volume, d) pressão / temperatura, b " +
                " () );";




        return questoes;
    }
    */
}