package com.mingrisoft.myguesscard;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    //声明控件
    private TextView outPut;
    private ImageView imageFace;
    private ImageView image_View1;
    private ImageView image_View2;
    private ImageView image_View3;
    private ImageView image_View4;
    private ImageView image_View5;
    private ImageView image_View6;
    private ProgressBar progressBar;
    private Button button_start;
    private Button button_check;
    private MyHandler myHandler;    //进度条线程
    private int i;    //进度条参数
    public static int q;
    public static int c;


    //扑克牌图片数组
    private static int[] poker = {R.drawable.poker_a, R.drawable.poker_2, R.drawable.poker_3, R.drawable.poker_4, R.drawable.poker_5, R.drawable.poker_6};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPreferences.Editor editor = getSharedPreferences("data", MODE_WORLD_READABLE).edit();
        HandlerThread handlerThread = new HandlerThread("thread");//创建实例对象，传入标记当前线程的名字
        handlerThread.start();   //很重要，必须要写 用于启动线程,Thread会先调用run方法，创建Looper对象
        myHandler = new MyHandler(handlerThread.getLooper());
        outPut =  findViewById(R.id.outPut);                        //取得控件实例
        imageFace =  findViewById(R.id.imageface);
        image_View1 = findViewById(R.id.image1);
        image_View2 =  findViewById(R.id.image2);
        image_View3 =  findViewById(R.id.image3);
        image_View4 =  findViewById(R.id.image4);
        image_View5 =  findViewById(R.id.image5);
        image_View6 = findViewById(R.id.image6);
        progressBar =  findViewById(R.id.progressbar);
        button_start =  findViewById(R.id.start);
        button_check = findViewById(R.id.check);
        random();        //洗牌
        image_View1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {            //牌1监听器
                // TODO Auto-generated method stub
                image_View1.setImageDrawable(getResources().getDrawable(poker[0]));
                image_View2.setImageDrawable(getResources().getDrawable(poker[1]));
                image_View3.setImageDrawable(getResources().getDrawable(poker[2]));
                image_View4.setImageDrawable(getResources().getDrawable(poker[3]));
                image_View5.setImageDrawable(getResources().getDrawable(poker[4]));
                image_View6.setImageDrawable(getResources().getDrawable(poker[5]));

                image_View2.setAlpha(100);    //设置没被选中的牌渐隐效果
                image_View3.setAlpha(100);
                image_View4.setAlpha(100);
                image_View5.setAlpha(100);
                image_View6.setAlpha(100);

                if (poker[0] == R.drawable.poker_a) {
                    outPut.setText("WOW，选对了哦，真厉害！你是怎么做到的？");
                    imageFace.setImageDrawable(getResources().getDrawable(R.drawable.qq_suprise));
                    q = q + 1;
                    editor.putInt("q", q);
                    c = c + 1;
                    editor.putInt("c", c);
                    editor.apply();
                } else {
                    outPut.setText("真遗憾~~，这次运气不好，再来一次吧？");
                    imageFace.setImageDrawable(getResources().getDrawable(R.drawable.qq_despise));
                    q = q + 1;
                    editor.putInt("q", q);
                    editor.apply();
                }
            }

        });

        image_View2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {                      //牌2监听器
                // TODO Auto-generated method stub

                image_View1.setImageDrawable(getResources().getDrawable(poker[0]));      //设置图片
                image_View2.setImageDrawable(getResources().getDrawable(poker[1]));
                image_View3.setImageDrawable(getResources().getDrawable(poker[2]));
                image_View4.setImageDrawable(getResources().getDrawable(poker[3]));
                image_View5.setImageDrawable(getResources().getDrawable(poker[4]));
                image_View6.setImageDrawable(getResources().getDrawable(poker[5]));

                image_View1.setAlpha(100);         //设置透明度
                image_View3.setAlpha(100);
                image_View4.setAlpha(100);
                image_View5.setAlpha(100);
                image_View6.setAlpha(100);

                if (poker[1] == R.drawable.poker_a) {                    //判断点击是否是黑桃
                    outPut.setText("WOW，选对了哦，真厉害！你是怎么做到的？");
                    imageFace.setImageDrawable(getResources().getDrawable(R.drawable.qq_suprise));
                    q = q + 1;
                    editor.putInt("q", q);
                    c = c + 1;
                    editor.putInt("c", c);
                    editor.apply();
                } else {
                    outPut.setText("真遗憾~~，这次运气不好，再来一次吧？");
                    imageFace.setImageDrawable(getResources().getDrawable(R.drawable.qq_despise));
                    q = q + 1;
                    editor.putInt("q", q);
                    editor.apply();
                }
            }

        });

        image_View3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {              //牌3监听器
                // TODO Auto-generated method stub

                image_View1.setImageDrawable(getResources().getDrawable(poker[0]));     //设置控件图片
                image_View2.setImageDrawable(getResources().getDrawable(poker[1]));
                image_View3.setImageDrawable(getResources().getDrawable(poker[2]));
                image_View4.setImageDrawable(getResources().getDrawable(poker[3]));
                image_View5.setImageDrawable(getResources().getDrawable(poker[4]));
                image_View6.setImageDrawable(getResources().getDrawable(poker[5]));

                image_View1.setAlpha(100);     //设置透明度
                image_View2.setAlpha(100);
                image_View4.setAlpha(100);
                image_View5.setAlpha(100);
                image_View6.setAlpha(100);

                if (poker[2] == R.drawable.poker_a) {                            //判断点击是否是黑桃
                    outPut.setText("WOW，选对了哦，真厉害！你是怎么做到的？");
                    imageFace.setImageDrawable(getResources().getDrawable(R.drawable.qq_suprise));
                    q = q + 1;
                    editor.putInt("q", q);
                    c = c + 1;
                    editor.putInt("c", c);
                    editor.apply();
                } else {
                    outPut.setText("真遗憾~~，这次运气不好，再来一次吧？");
                    imageFace.setImageDrawable(getResources().getDrawable(R.drawable.qq_despise));
                    q = q + 1;
                    editor.putInt("q", q);
                    editor.apply();
                }
            }

        });



        image_View4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {                //牌4布局

                image_View1.setImageDrawable(getResources().getDrawable(poker[0]));
                image_View2.setImageDrawable(getResources().getDrawable(poker[1]));
                image_View3.setImageDrawable(getResources().getDrawable(poker[2]));
                image_View4.setImageDrawable(getResources().getDrawable(poker[3]));
                image_View5.setImageDrawable(getResources().getDrawable(poker[4]));
                image_View6.setImageDrawable(getResources().getDrawable(poker[5]));

                image_View1.setAlpha(100);
                image_View2.setAlpha(100);
                image_View3.setAlpha(100);
                image_View5.setAlpha(100);
                image_View6.setAlpha(100);
                if (poker[3] == R.drawable.poker_a) {
                    outPut.setText("WOW，选对了哦，真厉害！你是怎么做到的？");
                    imageFace.setImageDrawable(getResources().getDrawable((R.drawable.qq_suprise)));
                    q = q + 1;
                    editor.putInt("q", q);
                    c = c + 1;
                    editor.putInt("c", c);
                    editor.apply();
                } else {
                    outPut.setText("真遗憾~~，这次运气不好，再来一次吧？");
                    imageFace.setImageDrawable(getResources().getDrawable(R.drawable.qq_despise));
                    q = q + 1;
                    editor.putInt("q", q);
                    editor.apply();
                }
            }
        });


        image_View5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {              //牌5布局

                image_View1.setImageDrawable(getResources().getDrawable(poker[0]));
                image_View2.setImageDrawable(getResources().getDrawable(poker[1]));
                image_View3.setImageDrawable(getResources().getDrawable(poker[2]));
                image_View4.setImageDrawable(getResources().getDrawable(poker[3]));
                image_View5.setImageDrawable(getResources().getDrawable(poker[4]));
                image_View6.setImageDrawable(getResources().getDrawable(poker[5]));

                image_View1.setAlpha(100);
                image_View2.setAlpha(100);
                image_View3.setAlpha(100);
                image_View4.setAlpha(100);
                image_View6.setAlpha(100);
                if (poker[4] == R.drawable.poker_a) {
                    outPut.setText("WOW，选对了哦，真厉害！你是怎么做到的？");
                    imageFace.setImageDrawable(getResources().getDrawable((R.drawable.qq_suprise)));
                    q = q + 1;
                    editor.putInt("q", q);
                    c = c + 1;
                    editor.putInt("c", c);
                    editor.apply();
                } else {
                    outPut.setText("真遗憾~~，这次运气不好，再来一次吧？");
                    imageFace.setImageDrawable(getResources().getDrawable(R.drawable.qq_despise));
                    q = q + 1;
                    editor.putInt("q", q);
                    editor.apply();
                }
            }
        });

        image_View6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {                      //牌6布局

                image_View1.setImageDrawable(getResources().getDrawable(poker[0]));
                image_View2.setImageDrawable(getResources().getDrawable(poker[1]));
                image_View3.setImageDrawable(getResources().getDrawable(poker[2]));
                image_View4.setImageDrawable(getResources().getDrawable(poker[3]));
                image_View5.setImageDrawable(getResources().getDrawable(poker[4]));
                image_View6.setImageDrawable(getResources().getDrawable(poker[5]));

                image_View1.setAlpha(100);                                   //修改
                image_View2.setAlpha(100);
                image_View3.setAlpha(100);
                image_View4.setAlpha(100);
                image_View5.setAlpha(100);
                if (poker[5] == R.drawable.poker_a) {
                    outPut.setText("WOW，选对了哦，真厉害！你是怎么做到的？");
                    imageFace.setImageDrawable(getResources().getDrawable((R.drawable.qq_suprise)));
                    q = q + 1;
                    editor.putInt("q", q);
                    c = c + 1;
                    editor.putInt("c", c);
                    editor.apply();
                } else {
                    outPut.setText("真遗憾~~，这次运气不好，再来一次吧？");
                    imageFace.setImageDrawable(getResources().getDrawable(R.drawable.qq_despise));
                    q = q + 1;
                    editor.putInt("q", q);
                    editor.apply();
                }
            }
        });

        button_start.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                outPut.setText("猜猜看黑桃A是 哪一张？");
                progressBar.setVisibility(View.VISIBLE);                               //设置进度条可见
                myHandler.post(progressBarThread);                                   // 启动进度条线程,post将我们传入的接口的对象封装成了一个消息，利用looper传入到消息队列中

                imageFace.setImageDrawable(getResources().getDrawable(R.drawable.qq_laugh));    //初始化控件
                image_View1.setImageDrawable(getResources().getDrawable(R.drawable.poker_back));
                image_View2.setImageDrawable(getResources().getDrawable(R.drawable.poker_back));
                image_View3.setImageDrawable(getResources().getDrawable(R.drawable.poker_back));
                image_View4.setImageDrawable(getResources().getDrawable(R.drawable.poker_back));
                image_View5.setImageDrawable(getResources().getDrawable(R.drawable.poker_back));
                image_View6.setImageDrawable(getResources().getDrawable(R.drawable.poker_back));
                image_View1.setAlpha(255);
                image_View2.setAlpha(255);
                image_View3.setAlpha(255);
                image_View4.setAlpha(255);
                image_View5.setAlpha(255);
                image_View6.setAlpha(255);

                random();  //洗牌
            }
        });

        button_check.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {                            //check键结束当前程序进程
                //TODO Auto-generated method stub
                Intent i = new Intent(MainActivity.this, sat.class);
                startActivity(i);
                finish();
            }
        });
    }


    private void random() {                 //随机洗牌函数
        Random rand = new Random();
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 0; i < 6; i++) {
            temp1 = rand.nextInt(6);
            temp2 = poker[i];
            poker[i] = poker[temp1];
            poker[temp1] = temp2;
        }
    }

    //进度条线程   主线程不做耗时操作，子线程不更新UI
    Runnable progressBarThread = new Runnable() {    //使用Runnable接口为的是实现多线程，jdk知道这是一个线程
        @Override
        public void run() {                           //在Java中我们实现多线程一是继承Thread类，一个就是实现Runnable接口，但是Runnable中只有run方法，无法通过start启动线程
                                                                      //而在Thread类中有一个构造方法，其对象就是Runnable，所以可以用通过Thread类来启动线程，在要启动时就要调用run方法
            // TODO Auto-generated method stub
            i += 10;
            try {                                                 //就是为了让 进度条显示的明显一点
                Thread.sleep(20);                          //将当前线程休眠一定时间，时间单位是毫秒 1000毫秒是1秒，休眠的时间可以让其他线程完成当前工作
                                                                 //异常是指 我们指定了sleep睡眠1000毫秒，但是实际上上可能只是睡眠了500毫秒就被叫醒了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message msg = myHandler.obtainMessage();             //Message有三种获取方法，这种方法性能消耗较少
            msg.arg1 = i;                                        //我们将msg对象的arg1设置为i，系统消耗比较少
            myHandler.sendMessage(msg);                          //将制定的消息发送到一个消息队列列中，所以必须是一个新的Message对象才行
        }
    };


    Runnable progressInvisible = new Runnable() {                        //这个接口的run方法下为的是实现进度条的隐藏
        @Override
        public void run() {
            // TODO Auto-generated method stub
            progressBar.setVisibility(View.INVISIBLE);
        }
    };



    class MyHandler extends Handler {
        MyHandler(Looper looper) {
            super(looper);
        }             //handle直接与传进来的looper以及相关的MessageQueue绑定  循环取出message循环队列中的 message，将取出的message交给handler  专门负责拿消息
        @Override              //重写 handleMessage方法
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            progressBar.setProgress(msg.arg1);             //设置进度条的刻度
            if (i >= 100) {
                i = 0;     //yan                                     // 这里要把i归0，要不然在第一次是正常状态，后面会随着i的增加慢慢的变得特别快，也就是直接显示进度条满状态。
                progressBar.setProgress(i);
                myHandler.removeCallbacks(progressBarThread);    //删除指定的Runnable对象，使线程对象停止运行
                MainActivity.this.runOnUiThread(progressInvisible);  //??????设置进度条不可见，如果直接关闭会因为调用了其他线程的View而报错， 因此采用了runOnUiThread(progressInvisible);
                return;
            }
            myHandler.post(progressBarThread);    //yan                   //循环
        }
    }
}


