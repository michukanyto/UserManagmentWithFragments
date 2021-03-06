package com.appsmontreal.usermanagmentwithfragments.Fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.appsmontreal.usermanagmentwithfragments.Connection.FragmentEventListener;
import com.appsmontreal.usermanagmentwithfragments.Dao.UserDao;
import com.appsmontreal.usermanagmentwithfragments.Dao.UserFactory;
import com.appsmontreal.usermanagmentwithfragments.Model.User;
import com.appsmontreal.usermanagmentwithfragments.R;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragment extends Fragment {

    private FragmentEventListener fragmentEventListener;
    UserDao userDao;
    User onUser;
    String email;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentEventListener = (FragmentEventListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userDao = UserFactory.getUserDao();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_user, container, false);
    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText emailSearchEditText = view.findViewById(R.id.emailSearchEditText);
        final TextView emailTextView = view.findViewById(R.id.emailTextView);
        final TextView nameTextView = view.findViewById(R.id.nameTextView);
        Button searchButton = view.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getView().getRootView().getWindowToken(), 0);
                email = emailSearchEditText.getText().toString();
                if(userDao.contains(email)) {
                    onUser = userDao.getUserByEmail(email);
                    Log.i("usr =======> ", userDao.toString());
                    emailTextView.setText(onUser.getEmail());
                    nameTextView.setText(onUser.getLastName() + ", " + onUser.getFirstName());
                }else{
                    Log.i("email =======> ", email + "  not found");
                }
            }
        });



        Button updateButton = view.findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getView().getRootView().getWindowToken(), 0);
                EditText updateEmailEditText = view.findViewById(R.id.updateEmailEditText);
                EditText updateFirstNameEditText = view.findViewById(R.id.updateFirstNameEditText);
                EditText updateLastNameEditText = view.findViewById(R.id.updateLastNameEditText);
                String updatedEmail = updateEmailEditText.getText().toString();
                String firstName = updateFirstNameEditText.getText().toString();
                String lastName = updateLastNameEditText.getText().toString();
                fragmentEventListener.onUserUpdated(email,new User(updatedEmail, firstName, lastName));
            }
        });





    }
}
