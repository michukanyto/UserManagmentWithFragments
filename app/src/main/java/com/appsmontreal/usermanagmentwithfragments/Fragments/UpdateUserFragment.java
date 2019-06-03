package com.appsmontreal.usermanagmentwithfragments.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsmontreal.usermanagmentwithfragments.Connection.FragmentEventListener;
import com.appsmontreal.usermanagmentwithfragments.Dao.UserDao;
import com.appsmontreal.usermanagmentwithfragments.Dao.UserFactory;
import com.appsmontreal.usermanagmentwithfragments.Model.User;
import com.appsmontreal.usermanagmentwithfragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragment extends Fragment {

    private FragmentEventListener fragmentEventListener;
    private UserDao userDao;


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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentEventListener.onUserUpdated(new User("3333","aaaa","bbbbb"));
    }
}
