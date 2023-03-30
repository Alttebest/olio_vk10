package com.example.vk10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    EditText firstNameInput;
    EditText lastNameInput;
    EditText emailInput;
    private Context context;
    String degreeType = null;
    private int[] checkboxes = {R.id.boxKandi, R.id.boxDI, R.id.boxTohtori, R.id.boxUimamaisteri};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserStorage userstorage = UserStorage.getInstance();
        context = this;
        loadUsers();

        firstNameInput = findViewById(R.id.editFirstName);
        lastNameInput = findViewById(R.id.editLastName);
        emailInput = findViewById(R.id.editEmail);
    }

    public void switchToListUsers(View view){
        Intent intent = new Intent(this, ListUsersActivity.class);
        startActivity(intent);
    }

    public void addUser(View view){
        RadioGroup rgDegreeType = findViewById(R.id.rgDegreeType);
        switch (rgDegreeType.getCheckedRadioButtonId()){
            case R.id.radioTite:
                degreeType = "Tietotekniikka";
                break;
            case R.id.radioTuta:
                degreeType = "Tuotantotalous";
                break;
            case R.id.radioLate:
                degreeType = "Laskennallinen tekniikka";
                break;
            case R.id.radioSäte:
                degreeType = "Sähkötekniikka";
                break;
            default:
                degreeType = "Ei valittu";
                break;
        }

        ArrayList<String> degrees = new ArrayList<>();

        for (int i=0 ; i < checkboxes.length ; i++){
            CheckBox ck = (CheckBox) findViewById(checkboxes[i]);
            if (ck.isChecked()){
                String completedDegree = ck.getText().toString();
                degrees.add(completedDegree);
            }
        }


        User newUser = new User(firstNameInput.getText().toString(), lastNameInput.getText().toString(), emailInput.getText().toString(), degreeType, degrees);
        UserStorage.getInstance().addUser(newUser);
        Collections.sort(UserStorage.getInstance().getUsers());
        saveUsers();
    }

    public void saveUsers(){
        UserStorage.getInstance().saveUsers(context);
    }

    public void loadUsers(){
        UserStorage.getInstance().loadUsers(context);
    }
}