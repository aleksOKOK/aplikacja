package com.example.zadanko;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView scoreTextView;
    private int score = 0;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        scoreTextView = findViewById(R.id.scoreTextView);
        random = new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                scoreTextView.setText("Punkty: " + score);

                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) button.getLayoutParams();
                params.leftMargin = random.nextInt(getScreenWidth() - button.getWidth());
                params.topMargin = random.nextInt(getScreenHeight() - button.getHeight());
                button.setLayoutParams(params);
            }
        });
    }

    private int getScreenWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    private int getScreenHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
