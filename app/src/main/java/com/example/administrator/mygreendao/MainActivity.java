package com.example.administrator.mygreendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cloudTop.starshare.greendao.gen.UserDao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    UserDao mUserDao;

    HashSet<User> userHashSet = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
        userHashSet.add(new User(1L,"囚犯1号"));
        userHashSet.add(new User(2L,"囚犯2号"));
        userHashSet.add(new User(3L,"囚犯3号"));
        userHashSet.add(new User(4L,"囚犯4号"));
        userHashSet.add(new User(5L,"囚犯5号"));
        userHashSet.add(new User(6L,"囚犯6号"));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                for ( User user : userHashSet ) {
                    mUserDao.insert(user);
                }
                break;
            case R.id.delete:
                mUserDao.deleteByKey(1L);
                break;
            case R.id.change:
                User mUser = new User(4L,"囚犯4号被修改");
                mUserDao.update(mUser);
                break;
            case R.id.select:
                List<User> users = mUserDao.loadAll();
                String userName = "";
                for (int i = 0; i < users.size(); i++) {
                    userName = users.get(i).getName()+",";
                    Log.d("UserName：",userName);
                }
                break;
        }
    }

}
