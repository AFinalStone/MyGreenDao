package com.example.administrator.mygreendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cloudTop.starshare.greendao.gen.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    UserDao mUserDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                User mUser = new User((long) 2, "anye3");
                mUserDao.insert(mUser);//添加一个
                break;
            case R.id.delete:
//                User mUser_new = new User((long) 2, "anye3");
//                mUserDao.deleteByKey(mUserDao);
                break;
            case R.id.change:
                mUser = new User((long)2,"anye0803");
                mUserDao.update(mUser);
                break;
            case R.id.select:
                List<User> users = mUserDao.loadAll();
                String userName = "";
                for (int i = 0; i < users.size(); i++) {
                    userName += users.get(i).getName()+",";
                }
                Toast.makeText(this,"查询的结果:"+userName,Toast.LENGTH_LONG).show();
                break;
        }
    }

}
