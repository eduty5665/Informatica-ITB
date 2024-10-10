package br.com.inf3em.priceresearch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {

    public static final String TAG = "List Product";

    // objetos da classe
    // como teremos a ferramenta de busca  usamos um
    // objeto para representar o texto buscado
    public String TEXT_SEARCH = "my text";

    //  como teremo uma listagem dos produtos
    //  fazemos uso do objeto para ADAPTAR os dados na tela
    public ProductAdapter mProductAdapter;

    // objetos para representar elementos da tela
    //  um para exibir o nome do usuário logado
    //  e outro para representar o total da minha compra
    // SPOILER - talvez no seu app vc nao precise deles
    TextView mTextViewFullName, mTextViewTotalValue;

    //objeto para controlar as preferencias ou dados do app
    //  esses preferencias/dados tem origem no momento
    // que o usuario loga no app
    SharedPreferences mSharedPreferences;

    // objeto que controla SE NA TELA 2
    //  CANCELOU  ou   CONFIRMOU  a operação de ADD / EDIT
    ActivityResultLauncher <Intent> mActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            // testar o resultado
            if( result.getResultCode() == RESULT_OK   ) {
                // obter os dados que estavam na tela 2
                // para isso faço uso da classe Bundle
                Bundle mBundle = result.getData().getExtras();
                // o objeto mbundle obtem os dados que sao enviados
                // como constantes EXTRA

                // recuperar os dados vindos da tela 2
                int vId = mBundle.getInt("EXTRA_ID", 0);
                String mName = mBundle.getString("EXTRA_NAME");
                // vId e mName   99,9999% vai ter no seu app
                // os outros objetos/variaveis abaixo depende do seu tcc
                float vPrice = mBundle.getFloat("EXTRA_PRICE" , 0);

                float vPerception = mBundle.getFloat("EXTRA_PERCEPTION" , 0);

                int vFrequency = mBundle.getInt("EXTRA_FREQUENCY" ,0);

                int vCycle     = mBundle.getInt("EXTRA_CYCLE", 0);

                String mMode = mBundle.getString("EXTRA_MODE");

                String mMessage = "Aunt Little Mary, hi!";

                // testar se o usuario está   ADD = insert = cadastrando novo
                //  ou  EDIT = edição = atualizando = update

                if( mMode.equals("EDIT")  ) {
                    Product mProduct = new Product(vId, mName, vPrice, vPerception);
                    int vResult = ProductDao.updateProduct(mProduct , getApplicationContext());
                    if(vResult == 1) {
                        mMessage = "Aunt Little Mary, edit ok";
                        setupRecyclerViewAdapter();
                    } else {
                        mMessage = "Aunt Little Mary, edit fail";
                    }
                } else {
                    Product mProduct = new Product(       mName, vPrice, vPerception);
                    int vResult = ProductDao.insertProduct(mProduct , getApplicationContext());
                    if(vResult == 1) {
                        mMessage = "Aunt Little Mary, insert ok";
                        setupRecyclerViewAdapter();
                    } else {
                        mMessage = "Aunt Little Mary, insert fail";
                    }
                }
                mTextViewTotalValue.setText("R$ 0,00");
                Toast.makeText(getApplicationContext() , mMessage , Toast.LENGTH_SHORT).show();


            } else  if( result.getResultCode() == RESULT_CANCELED  ) {
                Toast.makeText(getApplicationContext() , "Aunt Mary you canceled" , Toast.LENGTH_SHORT).show();

            } else   {
                Toast.makeText(getApplicationContext() , "Aunt Mary an unexpected error" , Toast.LENGTH_SHORT).show();

            }


        }
    });


    // objeto para escutar o clique de 1 item da listagem
    // escutar = ouvir = listener
    private View.OnClickListener mOnItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // o objeto  'v'  representa a visualização do item da listagem
            // quando clico no item preciso saber qual é a posição do
            // item na lista


        }
    }



    private void setupRecyclerViewAdapter() {
    }


}
