package com.example.evgeniy.technotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Evgeniy on 08.03.2017.
 */

public class MainFragment extends Fragment {
    private EditText et1,et2;
    private TextView tView;
    private Button button;

    //  create a textWatcher member
    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // check Fields For Empty Values
            checkFieldsForEmptyValues();
        }
    };

    void checkFieldsForEmptyValues(){
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();
        String s3 = tView.getText().toString();

        if(s1.equals("") || s2.equals("") || s3.equals("")){
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View l = inflater.inflate(R.layout.main_fragment, container, false);
        tView = (TextView) l.findViewById(R.id.data_picker);
        et1 = (EditText) l.findViewById(R.id.edit_first_name);
        et2 = (EditText) l.findViewById(R.id.edit_second_name);
        button = (Button) l.findViewById(R.id.save_button);

        // set listeners
        et1.addTextChangedListener(mTextWatcher);
        et2.addTextChangedListener(mTextWatcher);
        tView.addTextChangedListener(mTextWatcher);

        // run once to disable if empty
        checkFieldsForEmptyValues();

        tView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickFragment();
                newFragment.show(getActivity().getSupportFragmentManager(), "timePicker");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddActivity.class);
                intent.putExtra("name", et1.getText().toString());
                intent.putExtra("sName", et2.getText().toString());
                intent.putExtra("date", tView.getText().toString());
                startActivity(intent);
            }
        });
        return l;
    }
}
