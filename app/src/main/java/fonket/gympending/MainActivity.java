package fonket.gympending;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import fonket.gympending.models.Exercise;

public class MainActivity extends AppCompatActivity {

    private List<Exercise> exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameExercise = (EditText) findViewById(R.id.inputEt);
        final EditText timeExercise = (EditText) findViewById(R.id.timeEt);
        Button input = (Button) findViewById(R.id.saveBtn);
        Button startGym = (Button) findViewById(R.id.goBtn);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameExercise.getText().toString();
                String timeEx = timeExercise.getText().toString();
                if (timeEx.trim().length() > 0) {
                    int time = Integer.parseInt(timeExercise.getText().toString());
                    Log.d("Int", "Time");
                    if (name.trim().length() > 0 && time > 0) {
                        Exercise exercise = new Exercise();
                        exercise.setName(name);
                        exercise.setWatched(false);
                        exercise.setTime(time);
                        exercise.save();
                        nameExercise.setText("");
                        Toast.makeText(MainActivity.this, "Ejercicio guardado", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Ingresa algún ejercicio y su tiempo de ejecución", Toast.LENGTH_SHORT).show();
                }
            }
        });

        startGym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = exercises.size();
                if (size > 0) {
                    Exercise exercise = exercises.get(size);
                    long id = exercise.getId();
                    Intent intent = new Intent(MainActivity.this, MainActivityFragment.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "No has ingresado una rutina de ejercicios", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}



