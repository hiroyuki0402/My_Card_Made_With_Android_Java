package com.example.my_card_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView profileImageView;
    private ImageView telIconImageView;
    private ImageView mailIconImageView;
    private ImageView jobIconImageView;

    private TextView nameTextView;
    private TextView mailTextView;
    private TextView telTextImageView;
    private TextView jobTextView;
    private TextView dummyView;
    private TextView dummyView_Mail;
    private TextView dummyView_tel;
    private TextView dummyView_job;

    /// View全体
    View rootView;

    /// アクションバー(Androidではアクションバーと言う)
    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureMainActivity();
    }

    /*MainActivityの構築*/
    private void configureMainActivity() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.mainColor));
        }

        /// アクションバー オブジェクト
        actionBar = getSupportActionBar();

        /// ルートビュー
        rootView = getWindow().getDecorView().getRootView();
        rootView.setBackgroundColor(0xFF20C997);

        configureNavigationBar();
        configureImageView();
        configureTextView();
    }

    /*イメージViewの構築*/
    private void configureImageView() {
        /// 各イメージView
        profileImageView = findViewById(R.id.profileIconImageView);
        telIconImageView = findViewById(R.id.telIconImageView);
        mailIconImageView = findViewById(R.id.mailIconImageView);
        jobIconImageView = findViewById(R.id.jobIconImageView);

        profileImageView.setImageResource(R.drawable.job);
        telIconImageView.setImageResource(R.drawable.tell);
        mailIconImageView.setImageResource(R.drawable.mail);
        jobIconImageView.setImageResource(R.drawable.job);
    }

    /*テキストViewの構築*/
    private void configureTextView() {
        nameTextView = findViewById(R.id.nameTextView);
        mailTextView = findViewById(R.id.mailTextView);
        telTextImageView = findViewById(R.id.tellTextView);
        jobTextView = findViewById(R.id.jobTextView);

        dummyView = findViewById(R.id.dummyView);
        dummyView_Mail = findViewById(R.id.dummyView_Mail);
        dummyView_tel = findViewById(R.id.dummyView_tel);
        dummyView_job = findViewById(R.id.dummyView_job);

        setCornerRadius(dummyView, 90);
        setCornerRadius(dummyView_Mail, 35);
        setCornerRadius(dummyView_tel, 35);
        setCornerRadius(dummyView_job, 35);

        nameTextView.setText("HIROYUKI SHIRAISHI");
        mailTextView.setText("hiroyukiText@gmail.com");
        telTextImageView.setText("080-1234-5678");
        jobTextView.setText("iOSエンジニア");

        nameTextView.setTextSize(20);
        nameTextView.setTextColor(Color.WHITE);
        nameTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        nameTextView.setTypeface(null, Typeface.BOLD);

        mailTextView.setTextSize(15);
        mailTextView.setTextColor(Color.WHITE);
        mailTextView.setGravity(Gravity.CENTER_VERTICAL);
        mailTextView.setTypeface(null, Typeface.BOLD);

        telTextImageView.setTextSize(15);
        telTextImageView.setTextColor(Color.WHITE);
        telTextImageView.setGravity(Gravity.CENTER_VERTICAL);
        telTextImageView.setTypeface(null, Typeface.BOLD);

        jobTextView.setTextSize(15);
        jobTextView.setTextColor(Color.WHITE);
        jobTextView.setGravity(Gravity.CENTER_VERTICAL);
        jobTextView.setTypeface(null, Typeface.BOLD);
    }

    /* NavigationBar(アクションバー)の構築 */
    private void configureNavigationBar() {

        if (actionBar != null) {
            /// ActionBarにカスタムビューを表示するオプションを設定
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

            /// カスタムActionBarのレイアウトをセット
            actionBar.setCustomView(R.layout.custom_actionbar);

            /// ActionBarの背景色をダークグレイに設定
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#20C997")));
        }
    }

    /* cornerRadiusをつける
     * view: - 対象View
     * cornerRadiusDp: - 設定する数値
     * */
    private void setCornerRadius(View view, float cornerRadiusDp) {
        /// 丸みの半径をピクセル単位に変換
        float cornerRadiusPx = getResources().getDisplayMetrics().density * cornerRadiusDp;

        /// GradientDrawableを作成
        GradientDrawable gradientDrawable = new GradientDrawable();

        gradientDrawable.setColor(Color.WHITE);

        /// 形状を指定（ここではRECTANGLEを指定）
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);

        /// 丸みの半径を設定
        gradientDrawable.setCornerRadius(cornerRadiusPx);

        /// Viewの背景にGradientDrawableを設定
        view.setBackground(gradientDrawable);
    }


}