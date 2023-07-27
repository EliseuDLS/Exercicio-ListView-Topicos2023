package com.example.aulatei;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
   private ListView listLocais;
   private String[] itens = {
           "Filosofia",
           "Biologia",
           "Sociologia",
           "Quimica",
           "História",
           "Fisica",
           "Geografia",
           "Trabalho de Conclusão de Curso",
           "Programação para Internet",
           "Programação Orientada a Objetos",
           "Inglês",
           "Topicos Especiais de Informática",
           "Português",
           "Matemática",
           "Redes de Computadores"
   };

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       listLocais = findViewById(R.id.listLocais);

       ArrayAdapter<String> adapter = new ArrayAdapter<String>(
               getApplicationContext(),
               android.R.layout.simple_list_item_1,
               android.R.id.text1,
               itens
       );

       listLocais.setAdapter(adapter);

       listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String valorSelecionado = listLocais.getItemAtPosition(position).toString();
               dialog(view, valorSelecionado);
           }
       });
   }

   public void dialog(View view, String materia){
       AlertDialog.Builder dialog = new AlertDialog.Builder(this);

       dialog.setTitle("Realizar Matricula em " + materia);
       dialog.setMessage("Deseja realizar a matrícula?");

       dialog.setCancelable(false);

       dialog.setPositiveButton("Realizar", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               Toast.makeText(getApplicationContext(),"Matrícula realizada", Toast.LENGTH_SHORT).show();
           }
       });

       dialog.setNegativeButton("Não realizar", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               Toast.makeText(getApplicationContext(),"Matrícula não realizada", Toast.LENGTH_SHORT).show();
           }
       });

       dialog.create();
       dialog.show();
   }
}
