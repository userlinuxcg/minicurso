package br.com.p_minicurso;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class MainActivity extends Activity {

	EditText edtNome, edtDdd, edtNumero, edtMensagem;
	Button btnEnviar;
	String link = "";
	String nome, ddd, numero, mensagem;

	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// associar objetos as suas respectivas views
		edtNome = (EditText) findViewById(R.id.edtNome);
		edtDdd = (EditText) findViewById(R.id.edtDDD);
		edtNumero = (EditText) findViewById(R.id.edtNumero);
		edtMensagem = (EditText) findViewById(R.id.edtMensagem);

	}

	public void enviarMensagem(View view) {


		nome = edtNome.getText().toString();
		ddd = edtDdd.getText().toString();
		numero = edtNumero.getText().toString();
		mensagem = edtMensagem.getText().toString();



		
		URL url = null;
		HttpURLConnection con = null;
		String retorno;

		String link = "http://sms.3ring.com.br/enviar_mensagem?u=renagribeiro@gmail.com&p=mini&"
				+ "n=" + ddd + numero + "&m=" + mensagem + "&r=" + nome;

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		try {

			url = new URL(link);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();



			Toast.makeText(this, retorno, 1000).show();
			Log.i("url ", link);
			
			
		} catch (Exception e) {

			Toast.makeText(this, "erro"+e, 1000).show();

		}

	}
}
