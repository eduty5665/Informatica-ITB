package br.com.inf3em.priceresearch;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    // essa classe representa o CRUD com a tabela PRODUCT

    public static final String TAG = "Crud Product";

    public static int insertProduct(Product mProduct , Context mContext){
        int vResponse = 0; // 0 deu erro       1 deu certo
        String mSql;
        try{
            mSql = "INSERT INTO products (name , price , rating , status , image , amountConsumption , consumptionCycle) VALUES ( ? , ? , ? , ? , ? , ? , ?)";

            // preparar as ?s (parametros) para pegar (get) os dados no objeto produto
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1 , mProduct.getName());
            mPreparedStatement.setDouble(2 , mProduct.getPrice());
            mPreparedStatement.setFloat(3 , mProduct.getRating());
            mPreparedStatement.setInt(4 , mProduct.getStatus());
            mPreparedStatement.setLong(5 , mProduct.getImage());
            mPreparedStatement.setInt(6 , mProduct.getAmountConsumption());
            mPreparedStatement.setInt(7 , mProduct.getConsumptionCycle());

            vResponse = mPreparedStatement.executeUpdate();  //0 erro    1 sucesso row affected

        } catch (Exception e){
            String mMessage = "Erro ao inserir na tabela PRODUCTS" + e.getMessage();
            Log.e(TAG , mMessage);
        }

        return vResponse;

    }
    public static int updateProduct(Product mProduct , Context mContext){
        int vResponse = 0; // 0 deu erro       1 deu certo
        String mSql;
        try{
            mSql = "UPDATE products SET name=? , price=? , rating=? , status=? , image=? , amountConsumption=? , consumptionCycle=? WHERE id=?" ;

            // preparar as ?s (parametros) para pegar (get) os dados no objeto produto
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1 , mProduct.getName());
            mPreparedStatement.setDouble(2 , mProduct.getPrice());
            mPreparedStatement.setFloat(3 , mProduct.getRating());
            mPreparedStatement.setInt(4 , mProduct.getStatus());
            mPreparedStatement.setLong(5 , mProduct.getImage());
            mPreparedStatement.setInt(6 , mProduct.getAmountConsumption());
            mPreparedStatement.setInt(7 , mProduct.getConsumptionCycle());
            mPreparedStatement.setInt(8 , mProduct.getId());

            vResponse = mPreparedStatement.executeUpdate();  //0 erro    1 sucesso row affected

        } catch (Exception e){
            String mMessage = "Erro ao atualizar na tabela PRODUCTS" + e.getMessage();
            Log.e(TAG , mMessage);
        }

        return vResponse;

    }
    public static int deleteProduct(Product mProduct , Context mContext){
        int vResponse = 0; // 0 deu erro       1 deu certo
        String mSql;
        try{
            mSql = "DELETE FROM products WHERE id=?";

            // preparar as ?s (parametros) para pegar (get) os dados no objeto produto
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);


            mPreparedStatement.setInt(1 , mProduct.getId());

            vResponse = mPreparedStatement.executeUpdate();  //0 erro    1 sucesso row affected

        } catch (Exception e){
            String mMessage = "Erro ao deletar na tabela PRODUCTS" + e.getMessage();
            Log.e(TAG , mMessage);
        }

        return vResponse;

    }
    public static int deleteAllProduct( Context mContext){
        int vResponse = 0; // 0 deu erro       1 deu certo
        String mSql;
        try{
            mSql = "DELETE FROM products ";

            // preparar as ?s (parametros) para pegar (get) os dados no objeto produto
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);



            vResponse = mPreparedStatement.executeUpdate();  //0 erro    1 sucesso row affected

        } catch (Exception e){
            String mMessage = "Erro ao deletar todos na tabela PRODUCTS" + e.getMessage();
            Log.e(TAG , mMessage);
        }

        return vResponse;

    }



    public static List<Product> listAllProducts(Context mContext){
        // R-READ   listagem   select
        List<Product> mProductList = null;
        // a minha lista de produtos não contém nada
        String mSql;
        try{
            mSql = "SELECT id, name, price, rating, status, image, amountConsumption, consumptionCycle FROM products ORDER BY name ASC";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // quando fazemos select temos um conjunto de dados (uma listagem)
            // essa listagem chama-se conjunto de resultado (ResultSet)
            ResultSet mResultSet = mPreparedStatement.executeQuery();  //  botao RUN   F5

            // criar um objeto para armazenar na memoria a listagem - instanciar
            mProductList = new ArrayList<Product>();  // Array é uma lista que pode mudar - dinamica
            while(mResultSet.next()){
                // enquanto a leitura do proximo item é verdadeira
                mProductList.add(new Product(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getDouble(3),
                        mResultSet.getInt(4),
                        mResultSet.getInt(5),
                        mResultSet.getInt(6),
                        mResultSet.getInt(7),
                        mResultSet.getInt(8)  , 0

                ));


            }


        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mProductList;

    }
    public static List<Product> listAllProductsByStatus(Context mContext , int vStatus){
        // R-READ   listagem   select
        List<Product> mProductList = null;
        // a minha lista de produtos não contém nada
        String mSql;
        try{
            mSql = "SELECT id, name, price, rating, status, image, amountConsumption, consumptionCycle FROM products WHERE status=" + vStatus + " ORDER BY name ASC";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // quando fazemos select temos um conjunto de dados (uma listagem)
            // essa listagem chama-se conjunto de resultado (ResultSet)
            ResultSet mResultSet = mPreparedStatement.executeQuery();  //  botao RUN   F5

            // criar um objeto para armazenar na memoria a listagem - instanciar
            mProductList = new ArrayList<Product>();  // Array é uma lista que pode mudar - dinamica
            while(mResultSet.next()){
                // enquanto a leitura do proximo item é verdadeira
                mProductList.add(new Product(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getDouble(3),
                        mResultSet.getInt(4),
                        mResultSet.getInt(5),
                        mResultSet.getInt(6),
                        mResultSet.getInt(7),
                        mResultSet.getInt(8) , 0

                ));


            }


        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mProductList;

    }
    public static List<Product> listAllProductsByPrice(Context mContext , int vPrice){
        // R-READ   listagem   select
        List<Product> mProductList = null;
        // a minha lista de produtos não contém nada
        String mSql;
        try{
            mSql = "SELECT id, name, price, rating, status, image, amountConsumption, consumptionCycle FROM products WHERE price=" + vPrice + " ORDER BY name ASC";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // quando fazemos select temos um conjunto de dados (uma listagem)
            // essa listagem chama-se conjunto de resultado (ResultSet)
            ResultSet mResultSet = mPreparedStatement.executeQuery();  //  botao RUN   F5

            // criar um objeto para armazenar na memoria a listagem - instanciar
            mProductList = new ArrayList<Product>();  // Array é uma lista que pode mudar - dinamica
            while(mResultSet.next()){
                // enquanto a leitura do proximo item é verdadeira
                mProductList.add(new Product(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getDouble(3),
                        mResultSet.getInt(4),
                        mResultSet.getInt(5),
                        mResultSet.getInt(6),
                        mResultSet.getInt(7),
                        mResultSet.getInt(8) , 0

                ));


            }


        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mProductList;

    }
    public static List<Product> searchProductsByName(Context mContext , String mName){
        // R-READ   listagem   select
        List<Product> mProductList = null;
        // a minha lista de produtos não contém nada
        String mSql;
        try{
            mSql = "SELECT id, name, price, rating, status, image, amountConsumption, consumptionCycle FROM products WHERE name LIKE '%" + mName + "%' ORDER BY name ASC";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // quando fazemos select temos um conjunto de dados (uma listagem)
            // essa listagem chama-se conjunto de resultado (ResultSet)
            ResultSet mResultSet = mPreparedStatement.executeQuery();  //  botao RUN   F5

            // criar um objeto para armazenar na memoria a listagem - instanciar
            mProductList = new ArrayList<Product>();  // Array é uma lista que pode mudar - dinamica
            while(mResultSet.next()){
                // enquanto a leitura do proximo item é verdadeira
                mProductList.add(new Product(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getDouble(3),
                        mResultSet.getInt(4),
                        mResultSet.getInt(5),
                        mResultSet.getInt(6),
                        mResultSet.getInt(7),
                        mResultSet.getInt(8) , 0

                ));


            }


        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mProductList;

    }


}
