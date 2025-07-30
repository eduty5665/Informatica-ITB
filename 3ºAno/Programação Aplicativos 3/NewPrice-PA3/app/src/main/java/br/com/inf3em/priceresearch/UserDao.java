package br.com.inf3em.priceresearch;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    // essa classe representa o CRUD com a tabela User

    public static final String TAG = "Crud User";

    public static int insertUser(User mUser , Context mContext){
        int vResponse = 0; // 0 deu erro       1 deu certo
        String mSql;
        try{
            mSql = "INSERT INTO Users (fullName, username, password, email, createDate, apikey, resetPasswordOtp , resetPasswordCreatedAt) VALUES ( ? , ? , ? , ? , ? , ? , ?, ?)";

            // preparar as ?s (parametros) para pegar (get) os dados no objeto produto
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1 , mUser.getFullName());
            mPreparedStatement.setString(2 , mUser.getUserName());
            mPreparedStatement.setString(3 , mUser.getPassword());
            mPreparedStatement.setString(4 , mUser.getEmail());
            mPreparedStatement.setLong(5 , mUser.getCreateDate());
            mPreparedStatement.setString(6 , mUser.getApiKey());
            mPreparedStatement.setString(7 , mUser.getResetPasswordOtp());
            mPreparedStatement.setLong(8 , mUser.getResetPasswordCreatedAt());

            vResponse = mPreparedStatement.executeUpdate();  //0 erro    1 sucesso row affected

        } catch (Exception e){
            String mMessage = "Erro ao inserir na tabela UserS" + e.getMessage();
            Log.e(TAG , mMessage);
        }

        return vResponse;

    }
    public static int updateUser(User mUser , Context mContext){
        int vResponse = 0; // 0 deu erro       1 deu certo
        String mSql;
        try{
            mSql = "UPDATE Users SET fullName=? , userName=? , password=? , email=? , createDate=? , apiKey=? , resetPasswordOtp=?, resetPasswordCreatedAt WHERE id=?" ;

            // preparar as ?s (parametros) para pegar (get) os dados no objeto produto
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1 , mUser.getFullName());
            mPreparedStatement.setString(2 , mUser.getUserName());
            mPreparedStatement.setString(3 , mUser.getPassword());
            mPreparedStatement.setString(4 , mUser.getEmail());
            mPreparedStatement.setLong(5 , mUser.getCreateDate());
            mPreparedStatement.setString(6 , mUser.getApiKey());
            mPreparedStatement.setString(7 , mUser.getResetPasswordOtp());
            mPreparedStatement.setLong(8 , mUser.getResetPasswordCreatedAt());
            mPreparedStatement.setInt(9 , mUser.getId());

            vResponse = mPreparedStatement.executeUpdate();  //0 erro    1 sucesso row affected

        } catch (Exception e){
            String mMessage = "Erro ao atualizar na tabela UserS" + e.getMessage();
            Log.e(TAG , mMessage);
        }

        return vResponse;

    }
    public static int deleteUser(User mUser , Context mContext){
        int vResponse = 0; // 0 deu erro       1 deu certo
        String mSql;
        try{
            mSql = "DELETE FROM Users WHERE id=?";

            // preparar as ?s (parametros) para pegar (get) os dados no objeto produto
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);


            mPreparedStatement.setInt(1 , mUser.getId());

            vResponse = mPreparedStatement.executeUpdate();  //0 erro    1 sucesso row affected

        } catch (Exception e){
            String mMessage = "Erro ao deletar na tabela UserS" + e.getMessage();
            Log.e(TAG , mMessage);
        }

        return vResponse;

    }
    public static int deleteAllUser( Context mContext){
        int vResponse = 0; // 0 deu erro       1 deu certo
        String mSql;
        try{
            mSql = "DELETE FROM Users ";

            // preparar as ?s (parametros) para pegar (get) os dados no objeto produto
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);



            vResponse = mPreparedStatement.executeUpdate();  //0 erro    1 sucesso row affected

        } catch (Exception e){
            String mMessage = "Erro ao deletar todos na tabela UserS" + e.getMessage();
            Log.e(TAG , mMessage);
        }

        return vResponse;

    }



    public static List<User> listAllUsers(Context mContext){
        // R-READ   listagem   select
        List<User> mUserList = null;
        // a minha lista de produtos não contém nada
        String mSql;
        try{
            mSql = "SELECT id, fullName, userName, password, email, createDate, apiKey, resetPasswordOtp, resetPasswordCreatedAt FROM Users ORDER BY fullName ASC";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // quando fazemos select temos um conjunto de dados (uma listagem)
            // essa listagem chama-se conjunto de resultado (ResultSet)
            ResultSet mResultSet = mPreparedStatement.executeQuery();  //  botao RUN   F5

            // criar um objeto para armazenar na memoria a listagem - instanciar
            mUserList = new ArrayList<User>();  // Array é uma lista que pode mudar - dinamica
            while(mResultSet.next()){
                // enquanto a leitura do proximo item é verdadeira
                mUserList.add(new User(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getInt(6),
                        mResultSet.getString(7),
                        mResultSet.getString(8),
                        mResultSet.getLong(9)


                ));


            }


        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mUserList;

    }
    public static List<User> listAllUsersByStatus(Context mContext , int vStatus){
        // R-READ   listagem   select
        List<User> mUserList = null;
        // a minha lista de produtos não contém nada
        String mSql;
        try{
            mSql = "id, fullName, userName, password, email, createDate, apiKey, resetPasswordOtp, resetPasswordCreatedAt FROM Users WHERE status=" + vStatus + " ORDER BY userName ASC";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // quando fazemos select temos um conjunto de dados (uma listagem)
            // essa listagem chama-se conjunto de resultado (ResultSet)
            ResultSet mResultSet = mPreparedStatement.executeQuery();  //  botao RUN   F5

            // criar um objeto para armazenar na memoria a listagem - instanciar
            mUserList = new ArrayList<User>();  // Array é uma lista que pode mudar - dinamica
            while(mResultSet.next()){
                // enquanto a leitura do proximo item é verdadeira
                mUserList.add(new User(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getInt(6),
                        mResultSet.getString(7),
                        mResultSet.getString(8),
                        mResultSet.getLong(9)

                ));


            }


        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mUserList;

    }
    public static List<User> listAllUsersByPrice(Context mContext , int vPrice){
        // R-READ   listagem   select
        List<User> mUserList = null;
        // a minha lista de produtos não contém nada
        String mSql;
        try{
            mSql = "SELECT id, fullName, userName, password, email, createDate, apiKey, resetPasswordOtp, resetPasswordCreatedAt FROM Users WHERE price=" + vPrice + " ORDER BY name ASC";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // quando fazemos select temos um conjunto de dados (uma listagem)
            // essa listagem chama-se conjunto de resultado (ResultSet)
            ResultSet mResultSet = mPreparedStatement.executeQuery();  //  botao RUN   F5

            // criar um objeto para armazenar na memoria a listagem - instanciar
            mUserList = new ArrayList<User>();  // Array é uma lista que pode mudar - dinamica
            while(mResultSet.next()){
                // enquanto a leitura do proximo item é verdadeira
                mUserList.add(new User(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getInt(6),
                        mResultSet.getString(7),
                        mResultSet.getString(8),
                        mResultSet.getLong(9)

                ));


            }


        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mUserList;

    }
    public static List<User> searchUsersByName(Context mContext , String mName){
        // R-READ   listagem   select
        List<User> mUserList = null;
        // a minha lista de produtos não contém nada
        String mSql;
        try{
            mSql = "SELECT id, fullName, userName, password, email, createDate, apiKey, resetPasswordOtp, resetPasswordCreatedAt FROM Users WHERE name LIKE '%" + mName + "%' ORDER BY name ASC";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // quando fazemos select temos um conjunto de dados (uma listagem)
            // essa listagem chama-se conjunto de resultado (ResultSet)
            ResultSet mResultSet = mPreparedStatement.executeQuery();  //  botao RUN   F5

            // criar um objeto para armazenar na memoria a listagem - instanciar
            mUserList = new ArrayList<User>();  // Array é uma lista que pode mudar - dinamica
            while(mResultSet.next()){
                // enquanto a leitura do proximo item é verdadeira
                mUserList.add(new User(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getInt(6),
                        mResultSet.getString(7),
                        mResultSet.getString(8),
                        mResultSet.getLong(9)

                ));


            }


        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mUserList;

    }


}
