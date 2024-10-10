package br.com.inf3em.priceresearch;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>  implements Filterable {
    // MARCOS FAÇA A SUBCLASSE ProductViewHolder MANUALMENTE
    public static final String TAG = "Product Adapter";  //psfs

    private View.OnClickListener mOnClickListener; // escutador/ouvinte do click

    private View.OnLongClickListener mOnLongClickListener; //escutador/ouvinte de um click longo = pressionamento

    private Context mContext;

    private List<Product> mProductList; // objeto para lista de : produtos

    private TextView mTextViewTotalPrice; // objeto para mostrar o total dos preços da compra

    private List<Product> mProductListFull; // essa lista é uma cópia em memória - será usado na pesquisa

    // construtor para a classe ProductAdapter


    public ProductAdapter(Context context, List<Product> productList, TextView textViewTotalPrice) {
        mContext = context;
        mProductList = productList;
        mTextViewTotalPrice = textViewTotalPrice;
    }

    // funcionalidade para definir a cor do preço em função da avaliação (rating)
    // ESSA ABORDAGEM NÃO É MUITO LEGAL EM TERMOS DE "Código Limpo"
    public String setPriceColor(double vRating){
        if(vRating < 3){
            return "#BF0404"; // vermelho
        } else {
            return "#000000"; // preto
        }

    }

    @Override
    public Filter getFilter() {
        return executeSearchProduct;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        View mItemView = mLayoutInflater.inflate(R.layout.card_item_product_list , parent , false);

        return new ProductViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
          // associar os objetos da tela com o objeto do java
          // usando a lista de produtos
        Product mProductCurrent = mProductList.get(position);
        holder.mTextViewName.setText(mProductCurrent.getName());
        holder.mTextViewPrice.setText("R$"  +  mProductCurrent.getPrice());
        holder.mTextViewPrice.setTextColor( Color.parseColor(  setPriceColor( mProductCurrent.getRating() ) ) );

        holder.mRatingBarStar.setRating(   mProductCurrent.getRating()   );

        holder.mButtonQuantity.setText( "" + mProductCurrent.getUnit() );

        // A imagem use o a biblioteca Glide



    }

    @Override
    public int getItemCount() {
        // proxima aula
        if( mProductList != null  ){
            return mProductList.size();
        }  else {

            return 0;
        }


    }



    public void setProductList(  List<Product>  mProducts  ) {
        mProductList = mProducts;
        mProductListFull = new ArrayList<>(mProducts);
        notifyDataSetChanged();

    }



    public Product getProductPositionAt(int vPosition){
        return mProductList.get(vPosition);
    }

   public void setOnClickListener (View.OnClickListener mOnItemClickListener  ) {
       mOnClickListener = mOnItemClickListener;
   }


   // codigo para fazer uso da BUSCA - só faça se tiver a BUSCA
    private Filter executeSearchProduct = new Filter() {
       @Override
       protected FilterResults performFiltering(CharSequence constraint) {
           List<Product> mFilteredList = new ArrayList<>();
           if( constraint == null ){
               mFilteredList.addAll(mProductListFull);
           } else {
               String mPattern = constraint.toString().toLowerCase();
               for( Product mProduct : mProductListFull ){
                   if(mProduct.getName().toLowerCase() .contains(mPattern) ) {
                       mFilteredList.add(mProduct);
                   }
               }

           }
           FilterResults mFilterResults = new FilterResults();
           mFilterResults.values = mFilteredList;


           return mFilterResults;
       }

       @Override
       protected void publishResults(CharSequence constraint, FilterResults results) {
            mProductList.clear();
            mProductList.addAll(  (List)results.values   );
            notifyDataSetChanged();
       }
   };





    public class ProductViewHolder extends RecyclerView.ViewHolder{
        // criar os objetos que estao no layout do CARDVIEW
//        private final TextView mTextViewItemProductName;
//        private final TextView mTextViewProductPrice;
//        private final RatingBar mRatingBarItemProduct;
//        private final ImageView mImageViewProduct;
//        private final Button mButtonProductAdd;
//        private final Button mButtonProductQuantity;
//        private final Button mButtonProductRemove;

        private final ImageView mImageViewProduct;
        private final TextView mTextViewName;
        private final TextView mTextViewPrice;
        private final RatingBar mRatingBarStar;
        private final Button mButtonQuantity;
        private final Button mButtonAdd;
        private final Button mButtonRemove;

        // variaveis para controlar a quantidade e valor total da compra
        int vQuantity = 0;
        double vTotalPrice = 0.0;

        // funcionalidade/metodo (VOID) responsavel por totalizar minha lista compra
        // AVISO - NÃO É UMA BOA PRÁTICA fazer aqui esse trecho de código
        private void showTotalPrice () {
            vTotalPrice=0;
            for(int i=0 ; i <= mProductList.size() -1 ; i++){
                vTotalPrice += mProductList.get(i).getPrice() * mProductList.get(i).getUnit();
            }

        }

        public class ClickMyButtonAdd implements View.OnClickListener{
            @Override
            public void onClick(View v) {
                vQuantity= mProductList.get(getAdapterPosition()).getUnit() +1;
                mButtonQuantity.setText("" +vQuantity);
                mProductList.get(getAdapterPosition()).setUnit(vQuantity);
                showTotalPrice();
                mTextViewTotalPrice.setText("R$ " + vTotalPrice);
            }
        }
        public class ClickMyButtonRemove implements View.OnClickListener{
            @Override
            public void onClick(View v) {
                vQuantity= mProductList.get(getAdapterPosition()).getUnit() -1;
                if(vQuantity < 0){
                    vQuantity=0;
                }
                mButtonQuantity.setText("" +vQuantity);
                mProductList.get(getAdapterPosition()).setUnit(vQuantity);
                showTotalPrice();
                mTextViewTotalPrice.setText("R$ " + vTotalPrice);
            }
        }




        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewName = itemView.findViewById(R.id.textView_item_product_name);
           mTextViewPrice = itemView.findViewById(R.id.textView_item_product_price);
           mRatingBarStar = itemView.findViewById(R.id.ratingBar_item_product_price_perception);
           mButtonQuantity = itemView.findViewById(R.id.button_product_quantity);

           mButtonAdd = itemView.findViewById(R.id.button_product_add);
           mButtonAdd.setOnClickListener(new ClickMyButtonAdd());

           mButtonRemove = itemView.findViewById(R.id.button_product_remove);
           mButtonRemove.setOnClickListener(new ClickMyButtonRemove());

           mImageViewProduct = itemView.findViewById(R.id.image_item_product_list);
           // Para exibir a imagem será necessario utilizar a biblioteca GLYDE

            itemView.setOnClickListener(mOnClickListener);
            itemView.setTag(this);


            // https://stackoverflow.com/questions/75108707/android-studio-electric-eel-javahome-seems-to-be-invalid
            //03-08 2 aulas
            

        }

    }

}
