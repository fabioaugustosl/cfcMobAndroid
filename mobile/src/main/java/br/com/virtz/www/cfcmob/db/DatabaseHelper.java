package br.com.virtz.www.cfcmob.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "db_avalia";
    private static  int VERSAO = 1;

    public DatabaseHelper(Context context){
        super(context, BANCO_DADOS, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //veiculo
        db.execSQL("CREATE TABLE veiculo (_id INTEGER PRIMARY KEY," +
                " placa TEXT, modelo TEXT, fabricante TEXT, cor TEXT);");

        // instrutor
        db.execSQL("CREATE TABLE instrutor (_id INTEGER PRIMARY KEY, id_empresa INTEGER, " +
                " nome_empresa TEXT, nome TEXT, email TEXT, celular TEXT, " +
                " id_veiculo Integer, " +
                " FOREIGN KEY(id_veiculo) REFERENCES veiculo(_id));");

        //categoria treinamento (no caso A, B ,C...)
        db.execSQL("CREATE TABLE categoria_treinamento (_id INTEGER PRIMARY KEY, id_empresa INTEGER, nome TEXT);");

        // exercicios avaliativos
        db.execSQL("CREATE TABLE exercicios (_id INTEGER PRIMARY KEY, id_empresa INTEGER, " +
                " id_categoria INTEGER, titulo TEXT," +
                " FOREIGN KEY(id_categoria) REFERENCES categoria_treinamento(_id));");

        // aluno
        db.execSQL("CREATE TABLE aluno (_id INTEGER PRIMARY KEY, " +
                " nome TEXT, email TEXT, celular TEXT, " +
                " id_categoria1 Integer, id_categoria2 Integer," +
                " FOREIGN KEY(id_categoria1) REFERENCES categoria_treinamento(_id)," +
                " FOREIGN KEY(id_categoria2) REFERENCES categoria_treinamento(_id));");

        // aula
        db.execSQL("CREATE TABLE aula (_id INTEGER PRIMARY KEY, " +
                " data DATE, data_hora_inicio DATETIME, data_hora_fim DATETIME, " +
                " id_instrutor Integer, id_veiculo Integer, id_aluno Integer," +
                " FOREIGN KEY(id_instrutor) REFERENCES instrutor(_id)," +
                " FOREIGN KEY(id_veiculo) REFERENCES veiculo(_id)," +
                " FOREIGN KEY(id_aluno) REFERENCES aluno(_id));");

        // avaliacoes
        db.execSQL("CREATE TABLE avaliacao (_id INTEGER PRIMARY KEY, id_aula INTEGER, " +
                " pontos DOUBLE" +
                " FOREIGN KEY(id_aula) REFERENCES aula(_id));");

        /*db.execSQL("CREATE TABLE gasto (_id INTEGER PRIMARY KEY," +
                " categoria TEXT, data DATE, valor DOUBLE," +
                " descricao TEXT, local TEXT, viagem_id INTEGER," +
                " FOREIGN KEY(viagem_id) REFERENCES viagem(_id));");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("ALTER TABLE gasto ADD COLUMN pessoa TEXT");
    }

}

























