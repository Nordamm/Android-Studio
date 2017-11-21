package nordam.ruc.dk.pianoplayer;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    Button  button1, button2, button3, button4, button5, button6, button7,
            black1, black2, black3, black4, black5, drumbutton, stopbutton,
            cmfButton, clearButton;

    TextView timer;

    long start = System.currentTimeMillis();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MediaPlayer instances
        final MediaPlayer mp = new MediaPlayer();
        final MediaPlayer mp2 = new MediaPlayer();
        final MediaPlayer mp3 = new MediaPlayer();
        final MediaPlayer mp4 = new MediaPlayer();
        final MediaPlayer mp5 = new MediaPlayer();
        final MediaPlayer mp6 = new MediaPlayer();
        final MediaPlayer mp7 = new MediaPlayer();
        final MediaPlayer mp8 = new MediaPlayer();
        final MediaPlayer mp9 = new MediaPlayer();
        final MediaPlayer mp10 = new MediaPlayer();
        final MediaPlayer mp11 = new MediaPlayer();
        final MediaPlayer mp12 = new MediaPlayer();
        final MediaPlayer mpD = new MediaPlayer();

        //key buttons
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        black1 = (Button) findViewById(R.id.black1);
        black2 = (Button) findViewById(R.id.black2);
        black3 = (Button) findViewById(R.id.black3);
        black4 = (Button) findViewById(R.id.black4);
        black5 = (Button) findViewById(R.id.black5);

        //controller buttons
        drumbutton = (Button) findViewById(R.id.drumButton);
        stopbutton = (Button) findViewById(R.id.stopButton);
        cmfButton = (Button) findViewById(R.id.cmfButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        timer = (TextView) findViewById(R.id.timer);

        final ArrayList<String> list = new ArrayList<String>();
        final ArrayList<Long> timeList = new ArrayList<Long>();

        //CONTROLLER
        //start a beat with a loop function
        drumbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mpD.isPlaying()) {
                    mpD.stop();
                }
                try {
                    mpD.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("drums.mp3");
                    mpD.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mpD.prepare();
                    mpD.start();
                    mpD.setLooping(true);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //stop the beat
        stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mpD.isPlaying()) {
                    mpD.stop();
                }
            }
        });

        //Play sound if its inside the list
        cmfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (timeList.size() == 0) {
                    timer.setText("NOTHING STORED!");
                } else {
                        for (int i = 0; i < list.size() - 1; i++) {
                            if (list.get(i).contains("c1")) {
                                try {
                                    mp.reset();
                                    AssetFileDescriptor afd;
                                    afd = getAssets().openFd("c1.mp3");
                                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                    mp.prepare();
                                    mp.start();
                                    Thread.sleep(timeList.get(i + 1) - timeList.get(i));
                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                            if (list.get(i).contains("d1")) {
                                try {
                                    mp2.reset();
                                    AssetFileDescriptor afd;
                                    afd = getAssets().openFd("d1.mp3");
                                    mp2.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                    mp2.prepare();
                                    mp2.start();
                                    Thread.sleep(timeList.get(i + 1) - timeList.get(i));
                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }


                            if (list.get(i).contains("e1")) {
                                try {
                                    mp3.reset();
                                    AssetFileDescriptor afd;
                                    afd = getAssets().openFd("e1.mp3");
                                    mp3.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                    mp3.prepare();
                                    mp3.start();
                                    Thread.sleep(timeList.get(i + 1) - timeList.get(i));
                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                            if (list.get(i).contains("f1")) {
                                try {
                                    mp4.reset();
                                    AssetFileDescriptor afd;
                                    afd = getAssets().openFd("f1.mp3");
                                    mp4.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                    mp4.prepare();
                                    mp4.start();
                                    Thread.sleep(timeList.get(i + 1) - timeList.get(i));
                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }

                            if (list.get(i).contains("g1")) {
                                try {
                                    mp5.reset();
                                    AssetFileDescriptor afd;
                                    afd = getAssets().openFd("g1.mp3");
                                    mp5.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                    mp5.prepare();
                                    mp5.start();
                                    Thread.sleep(timeList.get(i + 1) - timeList.get(i));
                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }


                            if (list.get(i).contains("a1")) {
                                try {
                                    mp6.reset();
                                    AssetFileDescriptor afd;
                                    afd = getAssets().openFd("a1.mp3");
                                    mp6.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                    mp6.prepare();
                                    mp6.start();
                                    Thread.sleep(timeList.get(i + 1) - timeList.get(i));

                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                            if (list.get(i).contains("b1")) {
                                try {
                                    mp7.reset();
                                    AssetFileDescriptor afd;
                                    afd = getAssets().openFd("b1.mp3");
                                    mp7.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                    mp7.prepare();
                                    mp7.start();
                                    Thread.sleep(timeList.get(i + 1) - timeList.get(i));
                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                            if (list.get(i).contains("c1s")) {
                                try {
                                    mp8.reset();
                                    AssetFileDescriptor afd;
                                    afd = getAssets().openFd("c1s.mp3");
                                    mp8.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                    mp8.prepare();
                                    mp8.start();
                                    Thread.sleep(timeList.get(i + 1) - timeList.get(i));
                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                            if (list.get(i).contains("d1s")) {
                                try {
                                    mp9.reset();
                                    AssetFileDescriptor afd;
                                    afd = getAssets().openFd("d1s.mp3");
                                    mp9.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                    mp9.prepare();
                                    mp9.start();
                                    Thread.sleep(timeList.get(i + 1) - timeList.get(i));
                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                            if (list.get(i).contains("f1s")) {
                                try {
                                    mp10.reset();
                                    AssetFileDescriptor afd;
                                    afd = getAssets().openFd("f1s.mp3");
                                    mp10.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                    mp10.prepare();
                                    mp10.start();
                                    Thread.sleep(timeList.get(i + 1) - timeList.get(i));
                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                            if (list.get(i).contains("g1s")) {
                                try {
                                    mp11.reset();
                                    AssetFileDescriptor afd;
                                    afd = getAssets().openFd("g1s.mp3");
                                    mp11.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                    mp11.prepare();
                                    mp11.start();
                                    Thread.sleep(timeList.get(i + 1) - timeList.get(i));
                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                            if (list.get(i).contains("a1s")) {
                                try {
                                    mp12.reset();
                                    AssetFileDescriptor afd;
                                    afd = getAssets().openFd("a1s.mp3");
                                    mp12.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                    mp12.prepare();
                                    mp12.start();
                                    Thread.sleep(timeList.get(i + 1) - timeList.get(i));
                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        //ClearButton
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                timeList.clear();
                timer.setText("LIST CLEARED!");
            }
        });

        //KEYS
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying()) {
                        mp.stop();
                }
                try {
                    mp.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("c1.mp3");
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp.prepare();
                    mp.start();
                    list.add("c1");
                    timeList.add(System.currentTimeMillis() - start);
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp2.isPlaying()) {
                    mp2.stop();
                }
                try {
                    mp2.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("d1.mp3");
                    mp2.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp2.prepare();
                    mp2.start();
                    list.add("d1");
                    timeList.add(System.currentTimeMillis()-start);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp3.isPlaying()) {
                    mp3.stop();
                }
                try {
                    mp3.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("e1.mp3");
                    mp3.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp3.prepare();
                    mp3.start();
                    list.add("e1");
                    timeList.add(System.currentTimeMillis()-start);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp4.isPlaying()) {
                    mp4.stop();
                }
                try {
                    mp4.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("f1.mp3");
                    mp4.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp4.prepare();
                    mp4.start();
                    list.add("f1");
                    timeList.add(System.currentTimeMillis()-start);

                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp5.isPlaying()) {
                    mp5.stop();
                }
                try {
                    mp5.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("g1.mp3");
                    mp5.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp5.prepare();
                    mp5.start();
                    list.add("g1");
                    timeList.add(System.currentTimeMillis()-start);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp6.isPlaying()) {
                    mp6.stop();
                }
                try {
                    mp6.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("a1.mp3");
                    mp6.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp6.prepare();
                    mp6.start();
                    list.add("a1");
                    timeList.add(System.currentTimeMillis()-start);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp7.isPlaying()) {
                    mp7.stop();
                }
                try {
                    mp7.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("b1.mp3");
                    mp7.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp7.prepare();
                    mp7.start();
                    list.add("b1");
                    timeList.add(System.currentTimeMillis()-start);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        //black keys
        black1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (mp8.isPlaying()) {
                    mp8.stop();
                }
                try {
                    mp8.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("c1s.mp3");
                    mp8.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp8.prepare();
                    mp8.start();
                    list.add("c1s");
                    timeList.add(System.currentTimeMillis()-start);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        black2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (mp9.isPlaying()) {
                    mp9.stop();
                }
                try {
                    mp9.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("d1s.mp3");
                    mp9.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp9.prepare();
                    mp9.start();
                    list.add("d1s");
                    timeList.add(System.currentTimeMillis()-start);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        black3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (mp10.isPlaying()) {
                    mp10.stop();
                }
                try {
                    mp10.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("f1s.mp3");
                    mp10.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp10.prepare();
                    mp10.start();
                    list.add("f1s");
                    timeList.add(System.currentTimeMillis()-start);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        black4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (mp11.isPlaying()) {
                    mp11.stop();
                }
                try {
                    mp11.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("g1s.mp3");
                    mp11.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp11.prepare();
                    mp11.start();
                    list.add("g1s");
                    timeList.add(System.currentTimeMillis()-start);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        black5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (mp12.isPlaying()) {
                    mp12.stop();
                }
                try {
                    mp12.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("a1s.mp3");
                    mp12.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp12.prepare();
                    mp12.start();
                    list.add("a1s");
                    timeList.add(System.currentTimeMillis()-start);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
