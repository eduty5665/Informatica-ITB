package br.com.inf3em.priceresearch;

public class Product {

    // cada entidade/tabela do banco de dados precisa de classe

    // criando uma tag/marcação para ajudar na pesquisa por erro

    public Product(String name, double price, float rating) {
        mName = name;
        mPrice = price;
        mRating = rating;
    }

    public Product(int id, String name, double price, float rating) {
        mId = id;
        mName = name;
        mPrice = price;
        mRating = rating;
    }

    public static final String TAG = "Product Entity";

    // descrever as colunas da tabela

    private int mId;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public float getRating() {
        return mRating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mPrice=" + mPrice +
                ", mStatus=" + mStatus +
                ", mRating=" + mRating +
                ", mImage=" + mImage +
                ", mAmountConsumption=" + mAmountConsumption +
                ", mConsumptionCycle=" + mConsumptionCycle +
                '}';
    }

    public Product(String name, double price, int status, float rating, long image, int amountConsumption, int consumptionCycle , int unit  ) {
        mUnit = unit;
        mName = name;
        mPrice = price;
        mStatus = status;
        mRating = rating;
        mImage = image;
        mAmountConsumption = amountConsumption;
        mConsumptionCycle = consumptionCycle;
    }

    public void setRating(float rating) {
        mRating = rating;
    }

    public Product(int id, String name, double price, int status, float rating, long image, int amountConsumption, int consumptionCycle  , int unit ) {
        mUnit = unit;
        mId = id;
        mName = name;
        mPrice = price;
        mStatus = status;
        mRating = rating;
        mImage = image;
        mAmountConsumption = amountConsumption;
        mConsumptionCycle = consumptionCycle;
    }

    public long getImage() {
        return mImage;
    }

    public void setImage(long image) {
        mImage = image;
    }

    public int getAmountConsumption() {
        return mAmountConsumption;
    }

    public void setAmountConsumption(int amountConsumption) {
        mAmountConsumption = amountConsumption;
    }

    public int getConsumptionCycle() {
        return mConsumptionCycle;
    }

    public void setConsumptionCycle(int consumptionCycle) {
        mConsumptionCycle = consumptionCycle;
    }

    private String mName;
    private double mPrice;
    private int mStatus;
    private float mRating;
    private long mImage;
    private int mAmountConsumption;
    private int mConsumptionCycle;

    public int getUnit() {
        return mUnit;
    }

    public void setUnit(int unit) {
        mUnit = unit;
    }

    private int mUnit;

}
