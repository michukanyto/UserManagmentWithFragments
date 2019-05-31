package com.appsmontreal.usermanagmentwithfragments.Connection;

import com.appsmontreal.usermanagmentwithfragments.Model.User;

public interface FragmentEventListener {

    void onUserAdded(User user);
    void onUserUpdated(User newUser);
    void onUserListClicked(User user);
}
