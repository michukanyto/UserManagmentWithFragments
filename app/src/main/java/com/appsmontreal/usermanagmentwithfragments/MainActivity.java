package com.appsmontreal.usermanagmentwithfragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.appsmontreal.usermanagmentwithfragments.Connection.FragmentEventListener;
import com.appsmontreal.usermanagmentwithfragments.Dao.UserDao;
import com.appsmontreal.usermanagmentwithfragments.Dao.UserFactory;
import com.appsmontreal.usermanagmentwithfragments.Fragments.AddUserFragment;
import com.appsmontreal.usermanagmentwithfragments.Model.User;

public class MainActivity extends AppCompatActivity implements FragmentEventListener {

    private static final String ADD_USER_FRAGMENT_TAG = "ADD USER FRAGMENT" ;
    private static final String BACK_STACK = "backStack" ;

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDao = UserFactory.getUserDao();
        userDao.addUser(new User("p@u.com","Pedro","Pablo"));//Default users
        userDao.addUser(new User("m@u.com","Martha","Gagnon"));
        userDao.addUser(new User("ma@u.com","Martine","Lepont"));
        connectButtons();
    }

    private void connectButtons() {
        Button addUserButton = findViewById(R.id.addButton);
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddUserFragment addUserFragment = new AddUserFragment();
                addFragment(R.id.containerFragment, addUserFragment, ADD_USER_FRAGMENT_TAG);
                Log.i("Status ======> ", "step 1");
            }
        });

    }


    @Override
    public void onUserAdded(User user) {
        Log.i("Status ======> ", "step 4");
        userDao.addUser(user);
        removeFragment(ADD_USER_FRAGMENT_TAG);
    }

    @Override
    public void onUserUpdated(User newUser) {

    }

    @Override
    public void onUserListClicked(User user) {

    }

    private void addFragment(int containerId, Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//        fragmentTransaction.setCustomAnimations(R.anim.from_left, R.anim.from_left);
        fragmentTransaction.add(containerId, fragment, tag);
        fragmentTransaction.addToBackStack(BACK_STACK);
        fragmentTransaction.commit();
    }


    private void removeFragment(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.remove(fragmentManager.findFragmentByTag(tag));
        fragmentTransaction.commit();
        fragmentManager.popBackStack();
        Log.i("Status ======> ", "step 5");
    }
}
