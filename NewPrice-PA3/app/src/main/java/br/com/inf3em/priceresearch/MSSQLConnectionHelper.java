package br.com.inf3em.priceresearch;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLConnectionHelper {

    public static final String TAG = "Conexao com o Banco de Dados";

    // as strings abaixo servem para a conexao com o BD na SOMEE.COM
    private static String mStringServerIpName = "bancoTcc.mssql.somee.com";
    private static String mStringUserName = "marcoslogin";
    private static String mStringPassword = "16js193bd";
    private static String mStringDatabase = "bancoTcc";


    // usando o banco de dados no pc do laboratorio/casa LOCALHOST
    //private static String mStringServerIpName = "10.0.2.2";
    //private static String mStringUserName = "sa";
    //private static String mStringPassword = "@ITB123456";
    //private static String mStringDatabase = "bdTCC";
    //private static String mStringInstance = "SQLEXPRESS";
    //private static String mStringPort = "1433";
    // com esta abordagem o aplicativo funciona  no EMULADOR.
    // no celular real isso nao é possível


    private static String mStringConnectionUrl;

    public static Connection getConnection(Context mContext){
        Connection mConnection = null;
        try{
            // adicionar politica para criar uma tarefa
            StrictMode.ThreadPolicy mThreadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(mThreadPolicy);

            // verificar se a biblioteca jtds foi copiada para o projeto do app
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            // abordagem para o SOMEE.COM
            mStringConnectionUrl="jdbc:jtds:sqlserver://" +
                                 mStringServerIpName +
                                 ";databaseName=" +
                                 mStringDatabase +
                                 ";user=" +
                                 mStringUserName +
                                 ";password=" +
                                 mStringPassword + ";";

            // para usar com o LOCALHOST ou MySQL o código acima é diferent

            // passando a string de conexao para o objeto de conexao
            mConnection = DriverManager.getConnection(mStringConnectionUrl);

            // criar um registro para indicar o sucesso com a conexao
            // esse registro só irá aparecer no Android Studio
            Log.i (TAG,"Connection successful"); // realizado com sucesso a conexao



        } catch (ClassNotFoundException mException){
            String mMessage = "Class not found:" + mException.getMessage();
            Toast.makeText(mContext, mMessage, Toast.LENGTH_LONG).show();
            Log.e(TAG, mMessage);
            mException.printStackTrace();


        }  catch (SQLException mException){
            String mMessage = "Fail Sql Database:" + mException.getMessage();
            Toast.makeText(mContext, mMessage, Toast.LENGTH_LONG).show();
            Log.e(TAG, mMessage);
            mException.printStackTrace();


        }  catch (Exception mException){
            String mMessage = "Unknown fail:" + mException.getMessage();
            Toast.makeText(mContext, mMessage, Toast.LENGTH_LONG).show();
            Log.e(TAG, mMessage);
            mException.printStackTrace();


        }

        return mConnection;


    }



}
