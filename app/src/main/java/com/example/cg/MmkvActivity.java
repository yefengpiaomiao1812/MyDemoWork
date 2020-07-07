package com.example.cg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tencent.mmkv.MMKV;

import java.util.HashSet;

/**
 * MMKV替代SP
 */
public class MmkvActivity extends AppCompatActivity {

    SharedPreferences sp;

    private MMKV kv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmkv);

        sp = getSharedPreferences("config",MODE_PRIVATE);


        kv = MMKV.defaultMMKV();

    }


    /**
     * 存储SP数据
     * @param view
     */
    public void onSaveDataToSp(View view) {
        // 存入值
        sp.edit().putString("value", "我是存入的值").commit();
        // 获取显示
        String value = sp.getString("value","空的");

        Log.i("MmkvActivity" , "value = " + value );

    }

    // sp迁移到mmkv
    public void onMMKV(View view) {

        kv.encode("value", "Hello from mmkv");

        String value = kv.decodeString("value");

        Log.i("MmkvActivity" , "value = " + value );

        // sp迁移到mmkv
        testImportSharedPreferences();

    }

    private void testImportSharedPreferences() {
        //SharedPreferences preferences = getSharedPreferences("myData", MODE_PRIVATE);
        MMKV preferences = MMKV.mmkvWithID("config");
        // 迁移旧数据
        {
            SharedPreferences old_man = getSharedPreferences("config", MODE_PRIVATE);
            preferences.importFromSharedPreferences(old_man);
            old_man.edit().clear().commit();
        }
        // 跟以前用法一样
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putBoolean("bool", true);
//        editor.putInt("int", Integer.MIN_VALUE);
//        editor.putLong("long", Long.MAX_VALUE);
//        editor.putFloat("float", -3.14f);
//        editor.putString("string", "hello, imported");
//        HashSet<String> set = new HashSet<String>();
//        set.add("W"); set.add("e"); set.add("C"); set.add("h"); set.add("a"); set.add("t");
//        editor.putStringSet("string-set", set);
        // 无需调用 commit()
        //editor.commit();

        String value = preferences.decodeString("value");

        Log.i("MmkvActivity" , "value = " + value );

    }


}
