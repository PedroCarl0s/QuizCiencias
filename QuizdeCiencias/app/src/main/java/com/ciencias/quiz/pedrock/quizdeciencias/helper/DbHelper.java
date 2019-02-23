package com.ciencias.quiz.pedrock.quizdeciencias.helper;

import android.content.Context;
import android.database.SQLException;
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
                + " (id INT(2) PRIMARY KEY, enunciado TEXT NOT NULL, " +
                "letraA VARCHAR(40) NOT NULL, letraB VARCHAR(40) NOT NULL, " +
                "letraC VARCHAR(40) NOT NULL, letraD VARCHAR(40) NOT NULL, resposta CHAR(1));";


        String sqlFisica = "CREATE TABLE IF NOT EXISTS " + TABLE_FISICA
                + " (id INT(2) PRIMARY KEY, enunciado TEXT NOT NULL, " +
                "letraA VARCHAR(40) NOT NULL, letraB VARCHAR(40) NOT NULL, " +
                "letraC VARCHAR(40) NOT NULL, letraD VARCHAR(40) NOT NULL, resposta CHAR(1));";

        String sqlBiologia = "CREATE TABLE IF NOT EXISTS " + TABLE_BIOLOGIA
                + " (id INT(2) PRIMARY KEY, enunciado TEXT NOT NULL, " +
                "letraA VARCHAR(40) NOT NULL, letraB VARCHAR(40) NOT NULL, " +
                "letraC VARCHAR(40) NOT NULL, letraD VARCHAR(40) NOT NULL, resposta CHAR(1) );";




        try {

            db.execSQL(sqlQuimica);
            Log.i("INFO DB:", "tabela de química criada com sucesso");

        } catch (Exception error) {
            Log.i("INFO DB: ", "Erro ao criar tabela de química");
        }


        try {

            db.execSQL(sqlFisica);
            Log.i("INFO DB:", "tabela de física criada com sucesso");

        } catch (Exception error) {
            Log.i("INFO DB: ", "Erro ao criar tabela de física");
        }


        try {

            db.execSQL(sqlBiologia);
            Log.i("INFO DB:", "tabela de biologia criada com sucesso");

        } catch (Exception error) {
            Log.i("INFO DB: ", "Erro ao criar tabela de biologia");
        }


        try {

            db.execSQL(insertQuimica());
            Log.i("INFO TB: ", "inserção em química feita com sucesso");

        } catch (Exception error) {
            Log.i("INFO TB: ", "Erro ao inserir dados na tabela de química");
        }


        try {

            db.execSQL(insertFisica());
            Log.i("INFO TB: ", "inserção em física feita com sucesso");

        } catch (Exception error) {
            Log.i("INFO TB: ", "Erro ao inserir dados na tabela de física");
        }


        try {

            db.execSQL(insertBiologia());
            Log.i("INFO TB: ", "inserção em biologia feita com sucesso");

        } catch (Exception error) {
            Log.i("INFO TB: ", "Erro ao inserir dados na tabela de biologia");
        }



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public String insertQuimica() {

        String questoes = "INSERT INTO " + TABLE_QUIMICA +
                " VALUES(1, 'Um material que pode ser considerado substância pura é:', 'a) o petróleo', 'b) o querosene', 'c) o carbono diamante', 'd) a água do mar', 'c'), " +
                " (2, 'As partículas fundamentais de um átomo são:', 'a) apenas prótons', 'b) apenas prótons e nêutrons', 'c) apenas elétrons', 'd) prótons, nêutrons e elétrons', 'd'), " +
                " (3, 'Densidade é uma propriedade definida pela relação:', 'a) massa / pressão', 'b) massa / volume', 'c) pressão / volume', 'd) pressão / temperatura', 'b'), " +
                " (4, 'Durante a digestão de alimentos no estômago ocorre a fundamental precipitação do composto químico chamado:', 'a) bicarbonato de sódio', 'b) ácido clorídrico', 'c) ácido sulfúrico', 'd) ácido cianídrico', 'b'), " +
                " (5, 'A sublimação consiste na passagem direta de uma substância do estado sólido para gasoso. Ela ocorre nos compostos:', 'a) neve e naftalina', 'b) naftalina e gelo seco', 'c) nuvens e gelo seco', 'd) parafina e gelo', 'b');";

        return questoes;
    }

    public String insertFisica() {


        String questoes = "INSERT INTO " + TABLE_FISICA +
                " VALUES(1, 'Considere um ponto na superfície da Terra. Podemos afirmar que:', 'a) o ponto descreve uma trajetória circular', 'b) o ponto está em repouso', 'c) o ponto descreve uma trajetória elíptica', 'd) a trajetória descrita depende do referencial adotado', 'd'), " +
                " (2, 'Um parafuso se desprende do teto de um ônibus que está em movimento, com velocidade constante em relação a Terra. Desprezando a resistência do ar, a trajetória do parafuso, em relação ao ônibus, é:', 'a) retilínea e vertical', 'b) parabólica', 'c) um ponto geométrico', 'd) inclinada', 'a'), " +
                " (3, 'Calor é:', 'a) Uma função da temperatura do corpo', 'b) Energia Térmica contida em um corpo', 'c) Energia em trânsito entre dois corpos, motivada por uma diferença de temperatura', 'd) A variação de temperatura de um corpo', 'c'), " +
                " (4, 'Qual das alternativas abaixo apresenta o fenômeno estudado por Albert Einstein que lhe rendeu o Prêmio Nobel de Física?', 'a) Efeito fotoelétrico', 'b) Relatividade restrita', 'c) Relatividade Geral', 'd) Movimento browniano', 'a'), " +
                " (5, 'O criador da pilha elétrica, dispositivo que converte energia química em energia elétrica, foi:', 'a) Georg Simon Ohm', 'b) Alessandro Volta', 'c) André-Marie Ampère', 'd) Luigi Galvani', 'b');";



        return questoes;
    }

    public String insertBiologia() {

        String questoes = "INSERT INTO " + TABLE_BIOLOGIA +
                " VALUES(1, 'Em uma cadeia alimentar, os decompositores garantem a ciclagem de nutrientes. Assinale os organismos que atuam na decomposição em um ecossistema:', 'a) Bactérias e protozoários', 'b) Fungos e protozoários', 'c) Bactérias e fungos', 'd) Fungos e plantas', 'c'), " +
                " (2, 'Na espécie humana, a cor dos olhos se deve à pigmentação da(o):', 'a) Retina', 'b) Córnea', 'c) Pupila', 'd) Íris', 'd'), " +
                " (3, 'Dos biomas abaixo, qual deles é exclusivamente brasileiro?', 'a) Cerrado', 'b) Caatinga', 'c) Pampas', 'd) Pantanal', 'b'), " +
                " (4, 'A biogênese é uma teoria que:', 'a) admite as mutações espontâneas', 'b) admite a geração espontânea', 'c) admite que, para o aparecimento de um organismo, deve haver um indivíduo antecedente', 'd) se baseia na teoria de Darwin', 'c'), " +
                " (5, 'O processo de oxidação dos alimentos através do qual a planta obtém energia para a manutenção de seus processos vitais denomina-se:', 'a) Fotossíntese', 'b) Respiração', 'c) Fotólise', 'd) Transpiração', 'a');";

        return questoes;
    }

}