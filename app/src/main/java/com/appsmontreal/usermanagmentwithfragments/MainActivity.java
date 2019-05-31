package com.appsmontreal.usermanagmentwithfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appsmontreal.usermanagmentwithfragments.Connection.FragmentEventListener;
import com.appsmontreal.usermanagmentwithfragments.Model.User;

public class MainActivity extends AppCompatActivity implements FragmentEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectButtons();
    }

    private void connectButtons() {
    }


    @Override
    public void onUserAdded(User user) {

    }

    @Override
    public void onUserUpdated(User newUser) {

    }

    @Override
    public void onUserListClicked(User user) {

    }
}
