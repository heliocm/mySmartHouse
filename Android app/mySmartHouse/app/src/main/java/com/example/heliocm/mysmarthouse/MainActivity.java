package com.example.heliocm.mysmarthouse;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private int[] plantaImg = {R.drawable.planta,R.drawable.planta_sala,R.drawable.planta_cozinha,
                               R.drawable.planta_corredor,R.drawable.planta_banho,
                               R.drawable.planta_escritorio,R.drawable.planta_suite,
                               R.drawable.planta_quarto,};

    private int[] dinamicLayout = {R.layout.activity_main ,R.layout.activity_sala,R.layout.activity_cozinha,
            R.layout.activity_corredor,R.layout.activity_banho,
            R.layout.activity_escritorio,R.layout.activity_suite,
            R.layout.activity_quarto,};

    private int[] layoutID = {R.id.mainLayout, R.id.layoutSala, R.id.layoutCozinha,
            R.id.layoutCorredor, R.id.layoutBanho,
            R.id.layoutEscritorio, R.id.layoutSuite,
            R.id.layoutQuarto};

    //public String[] comodos = {name:}

    //public ViewGroup viewGroup = (ViewGroup) findViewById(R.layout.activity_main);
    public ImageView imageView;
    public Spinner spinner;
    public EditText editText;
    public int actualPosition;

    //final RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        spinner = (Spinner) findViewById(R.id.spinner);
        //final View bedroomLayout = getLayoutInflater().inflate(R.layout.activity_main_bedroom, null);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.selectRoom, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            int previousPosition = 0;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                actualPosition = position;
                imageView.setImageResource(plantaImg[position]);
                //int positionBefore;
                if (position != 0) {
                    /*RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
                    params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);*/
                    RelativeLayout bedroomLayout = (RelativeLayout) findViewById((layoutID[position]));
                    if (bedroomLayout == null) {
                        RelativeLayout addLayout = (RelativeLayout) findViewById(R.id.mainLayout);
                        View roomInfo = getLayoutInflater().inflate(dinamicLayout[position], addLayout, false);
                        addLayout.removeView(findViewById(layoutID[previousPosition]));
                        addLayout.addView(roomInfo);
                        previousPosition = position;
                    }
                }
                else {

                    RelativeLayout addLayout = (RelativeLayout) findViewById(R.id.mainLayout);
                    addLayout.removeView(findViewById(layoutID[previousPosition]));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //
    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    public void onClick (View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();

        String comodo = getResources().getStringArray(R.array.selectRoom)[actualPosition];
        if (buttonText.equals("On")) {
            new MyAsyncTask().execute("On");
            Toast.makeText(getBaseContext(), "Lampada "+comodo+" ligada" , Toast.LENGTH_SHORT).show();
        }
        if (buttonText.equals("Off")) {
            new MyAsyncTask().execute("Off");
            Toast.makeText(getBaseContext(), "Lampada "+comodo+" desligada" , Toast.LENGTH_SHORT).show();
        }

    }
    public void postData(String valueIWantToSend) {
        HttpClient httpclient = new DefaultHttpClient();
        String stringToSend = valueIWantToSend;
        editText = (EditText)findViewById(R.id.editText);
        String hostAddress = editText.getText().toString();
        String url = "http://"+hostAddress+"/mySmartHouse/sendsignal.php";
        // specify the URL you want to post to
        HttpPost httppost = new HttpPost(url);
        try {
            // create a list to store HTTP variables and their values
            List nameValuePairs = new ArrayList();
            // add an HTTP variable and value pair
            nameValuePairs.add(new BasicNameValuePair("myHttpData", stringToSend));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            // send the variable and value, in other words post, to the URL
            HttpResponse response = httpclient.execute(httppost);
        } catch (ClientProtocolException e) {
            // process execption
        } catch (IOException e) {
            // process execption
        }
    }
    private class MyAsyncTask extends AsyncTask<String, Integer, Double> {
        @Override
        protected Double doInBackground(String... params) {
            // TODO Auto-generated method stub
            postData(params[0]);
            return null;
        }

        protected void onPostExecute(Double result){
            //Toast.makeText(getApplicationContext(), "command sent", Toast.LENGTH_LONG).show();
        }

        protected void onProgressUpdate(Integer... progress){
        }
    }
}
