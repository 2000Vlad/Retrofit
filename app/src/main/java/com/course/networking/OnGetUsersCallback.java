package com.course.networking;

import java.util.List;

public interface OnGetUsersCallback {

    void onSuccess(List<User> users);

    void onError();
}
