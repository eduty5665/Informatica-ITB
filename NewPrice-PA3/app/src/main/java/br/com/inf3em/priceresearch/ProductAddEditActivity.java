package br.com.inf3em.priceresearch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.slider.Slider;

import java.util.List;

public class ProductAddEditActivity extends AppCompatActivity {

    public static final String TAG = "Classe Adicionar e Editar Produto";

    //Objeto para controlar o tipo/modo de uso da classe
    String mMode; // ADD NEW        EDIT

    // criar os objetos para associar com o layout
    TextView mTextViewCancel;
    Button mButtonSave;
    EditText mEditTextName;
    EditText mEditTextPrice;
    RatingBar mRatingBarStar;
    Slider mSliderCycle;
    Chip mChip0, mChip1, mChip2, mChip3, mChip4;
    ChipGroup mChipGroupOption;
    // variaveis de controle para quantidade
    int vSlider;
    int vChip;
    // objeto para apresentar mensagens
    String mMessage;

    //funcionalidade/metodo para executar o resultado do CANCEL
    private void executeCancel(){
        Intent mIntentReply = new Intent();
        setResult(RESULT_CANCELED , mIntentReply);
        finish();

    }


    // implementar uma classe para escutar/ouvir/listener do clique no CANCEL
    // essa classe vai usar o ´executeCancel´
    public class ClickMyCancel implements View

            .OnClickListener{
        @Override
        public void onClick(View v) {
            executeCancel();
        }
    }


    // regra de negocio - é necessario/obrigatorio o nome e o preco e a escolha do chip
    private boolean isRequired(){
        if(
                TextUtils.isEmpty(mEditTextName.getText()) ||
                        TextUtils.isEmpty(mEditTextPrice.getText()) ||
                        vChip == 0

        ) {
            return true;
        } else {
            return false;
        }


    }



    private void saveProduct(){
        if(isRequired()) {
            mMessage = "Erro de preenchimento";
            Toast.makeText(getApplicationContext() , mMessage ,Toast.LENGTH_SHORT).show();
            return;
        }

        Intent mIntentResponse = new Intent();

        mMode = "ADD"; // INSERT

        int vId = getIntent().getIntExtra("EXTRA_ID" , -1  );

        if( vId != -1) {
            mMode = "EDIT";  // UPDATE
            mIntentResponse.putExtra("EXTRA_ID" , vId  );
        }

        String mName = mEditTextName.getText().toString();
        mIntentResponse.putExtra("EXTRA_NAME" , mName  );

        float vPrice = Float.valueOf(mEditTextPrice.getText().toString());
        mIntentResponse.putExtra("EXTRA_PRICE"  , vPrice);

        float vPerception = mRatingBarStar.getRating();
        mIntentResponse.putExtra("EXTRA_PERCEPTION"  , vPerception);

        mIntentResponse.putExtra("EXTRA_CYCLE" , vSlider);

        mIntentResponse.putExtra("EXTRA_FREQUENCY" , vChip );

        mIntentResponse.putExtra("EXTRA_MODE"  , mMode);

        setResult(RESULT_OK , mIntentResponse);
        finish();

        


    }


    public class ClickMyButtonSave implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            saveProduct();
        }
    }


    public class SliderMySlide implements Slider.OnChangeListener{
        @Override
        public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
             vSlider = (int) value;
             mChip0.setText(vSlider+"X");
        }
    }


    public class ChipGroupSelectionChip implements ChipGroup.OnCheckedStateChangeListener{
        @Override
        public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {

            switch (group.getCheckedChipId()) {
                case R.id.chip_consumption_cycle_1: vChip=1 ; break;
                case R.id.chip_consumption_cycle_2: vChip=2 ; break;
                case R.id.chip_consumption_cycle_3: vChip=3 ; break;
                case R.id.chip_consumption_cycle_4: vChip=4 ; break;
                default: vChip=0;
            }

        }
    }

    private void setChipNumber(int vChip){
        switch (vChip){
            case 1: mChip1.setChecked(true); break;
            case 2: mChip2.setChecked(true); break;
            case 3: mChip3.setChecked(true); break;
            case 4: mChip4.setChecked(true); break;

        }

    }

    // aqui deveria estar a funcionalidade para formatar o preço


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_edit_product);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        mTextViewCancel = findViewById(R.id.textView_cancel_product_add_edit);
        mTextViewCancel.setOnClickListener(new ClickMyCancel());

       mButtonSave = findViewById(R.id.button_save_product);
       mButtonSave.setOnClickListener(new ClickMyButtonSave());

       mEditTextName = findViewById(R.id.editText_product_name);

       mEditTextPrice = findViewById(R.id.editText_product_price);

       mRatingBarStar = findViewById(R.id.rating_product_price_perception);

       mSliderCycle = findViewById(R.id.slider_consumption_cycle);
       mSliderCycle.addOnChangeListener(new SliderMySlide());

       mChipGroupOption = findViewById(R.id.chip_group_option);
       mChipGroupOption.setOnCheckedStateChangeListener(new ChipGroupSelectionChip());

       mChip0 = findViewById(R.id.chip_consumption_cycle_0);
       mChip1 = findViewById(R.id.chip_consumption_cycle_1);
       mChip2 = findViewById(R.id.chip_consumption_cycle_2);
       mChip3 = findViewById(R.id.chip_consumption_cycle_3);
       mChip4 = findViewById(R.id.chip_consumption_cycle_4);

       // como os dados são enviados da tela 1 para essa tela 2
        // preciso recuperar os dados para apresentar na tela 2
        // faço isso com uso da classe Intent

        Intent mIntent = getIntent();

        // testar se tem id
        if( mIntent.hasExtra("EXTRA_ID")) {
            setTitle("Edit Product");

            String mName  = mIntent.getStringExtra("EXTRA_NAME");
            mEditTextName.setText(mName);

            // abaixo depende do seu app
            double vPrice = mIntent.getDoubleExtra("EXTRA_PRICE", 0);
            mEditTextPrice.setText("" + vPrice);
            // como é um valor numerico deveriamos formart isso
            // usando a classe String.format

            float vPerception = mIntent.getFloatExtra("EXTRA_PERCEPTION" , 0);
            mRatingBarStar.setRating(vPerception);

            float vFrequency = mIntent.getFloatExtra("EXTRA_FREQUENCY" , 0);
            mSliderCycle.setValue(vFrequency);

            vChip = mIntent.getIntExtra("EXTRA_CYCLE", 0);
            setChipNumber(vChip);  //setChipSelected



        } else {
            setTitle("Add New Product");
            vSlider = 1;
            vChip = 0;

        }


    }


    // se o meu layout vai ter um menu na barra do app
    // preciso criar o codigo do menu e o codigo dos itens do  menu
    //  exemplo de menu  ...    ou um   icone que representa uma acao


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.save_menu , menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_menu_save:
                saveProduct();
                return  true;
            default:
                return super.onOptionsItemSelected(item);

        }


    }
}
