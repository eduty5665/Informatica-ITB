package br.com.inf3bm.loginregister;
import static android.view.View.GONE;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    TextView mTextViewNewUser, mTextViewForgotPassword;
    Button mButtonLogin;
    EditText mEditTextEmail, mEditTextPassword;
    ProgressBar mProgressBarLogin;
    String mStringUser, mStringPassword, mStringEmail, mStringApiKey;
    SharedPreferences mSharedPreferences;

    private boolean isRequired() {

        return TextUtils.isEmpty(mEditTextPassword.getText());
    }


    private boolean isValidEmail(String mStringEmail) {
        if (mStringEmail == null || mStringEmail.isEmpty()) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(mStringEmail).matches();


    }


    private void verifyLogged() {
        if (mSharedPreferences.getString("logged", "false").equals("true")) {
            showOrder();
        }
    }


    private void showOrder() {
        Intent mIntent = new Intent(getApplicationContext(), OrderActivity.class);
        startActivity(mIntent);
        finish();
    }

    private void postDataUsingVolley() {
        mStringEmail = String.valueOf(mEditTextEmail.getText());
        mStringPassword = String.valueOf(mEditTextPassword.getText());
        if (!isValidEmail(mStringEmail)) {
            String mStringMessage = "Email incorrect";
            Toast.makeText(this, mStringMessage, Toast.LENGTH_SHORT).show();
            return;
        }

        if (isRequired()) {
            String mStringMessage = getString(R.string.text_error_fill_mandatory_information);
            Toast.makeText(this, mStringMessage, Toast.LENGTH_SHORT).show();
            return;

        }

        mProgressBarLogin.setVisibility(View.VISIBLE);

        String mUrl = "http://127.0.0.1/app/login.php";



        /*
        * RequestQueue mRequestQueue = Volley.newRequestQueue(this);
        StringRequest mStringRequest = new StringRequest(Request.Method.POST, mUrl, new Response.Listener<String>() {

* Abaixo na linha 95 erro - preste mais atenção Marcos
        * */

        RequestQueue mRequestQueue = Volley.newRequestQueue(this);

        StringRequest mStringRequest = new StringRequest(Request.Method.POST , mUrl , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mProgressBarLogin.setVisibility(GONE);
                try{
                    JSONObject mJsonObject = new JSONObject(response);
                    String mStatus = mJsonObject.getString("status");
                    String mMessage = mJsonObject.getString("message");
                    if(mStatus.equals("success")){
                      mStringUser = mJsonObject.getString("user");
                      mStringEmail = mJsonObject.getString("email");
                      mStringApiKey = mJsonObject.getString("apiKey");
                      SharedPreferences.Editor mEditor = mSharedPreferences.edit();
                      mEditor.putString("logged" , "true");
                      mEditor.putString("user" , mStringUser);
                      mEditor.putString("apiKey" , mStringApiKey);
                      mEditor.putString("email" ,  mStringEmail);
                      mEditor.apply();
                      showOrder();
                      
                    } else {
                        Toast.makeText(getApplicationContext() , mMessage , Toast.LENGTH_LONG).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                mProgressBarLogin.setVisibility(GONE);
                error.printStackTrace();
                Toast.makeText(getApplicationContext(), "Fail to get response: "+error , Toast.LENGTH_LONG).show();
            }
        }) {
            @Override  //marcos veja o comentario acima
            protected Map<String , String> getParams(){
                Map<String , String> mParams = new HashMap<>();
               mParams.put("email" , mStringEmail);
               mParams.put("password" , mStringPassword);
               return mParams;
            }
        };
        mStringRequest.setRetryPolicy(new DefaultRetryPolicy(30*1000 , 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mRequestQueue.add(mStringRequest);

    }
    public class ClickMyButtonLogin implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            postDataUsingVolley();
        }
    }
    public void showSignUp(){
        Intent mIntent = new Intent(getApplicationContext() , SignUpActivity.class);
        startActivity(mIntent);
        finish();
    }

    public class ClickMyNewUser implements View.OnClickListener{
        @Override
        public void onClick(View v){
            showSignUp();
        }
    }
    private void showForgotPassword(){
        Intent mIntent = new Intent(getApplicationContext() , ResetPasswordActivity.class);
        startActivity(mIntent);
        finish();
    }
    public class ClickMyForgotPassword implements View.OnClickListener{
        @Override
        public void onClick(View v){
            showForgotPassword();
        }
        }
    public class EditTextActionMyKeyboard implements TextView.OnEditorActionListener{
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(actionId == EditorInfo.IME_ACTION_DONE){
                postDataUsingVolley();
            }
            return false;
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mEditTextEmail = findViewById(R.id.editText_email_login);

        mEditTextPassword = findViewById(R.id.editText_password_login);
        mEditTextPassword.setOnEditorActionListener(new EditTextActionMyKeyboard());

        mButtonLogin = findViewById(R.id.button_login);
        mButtonLogin.setOnClickListener(new ClickMyButtonLogin());

        mProgressBarLogin = findViewById(R.id.progressBar_login);

        mTextViewNewUser = findViewById(R.id.textView_new_user_login);
        mTextViewNewUser.setOnClickListener(new ClickMyNewUser());

        mTextViewForgotPassword = findViewById(R.id.textView_forgot_password_login);
        mTextViewForgotPassword.setOnClickListener(new ClickMyForgotPassword());

        mSharedPreferences = getSharedPreferences("MyAppName" , MODE_PRIVATE);

        verifyLogged();
    }
}