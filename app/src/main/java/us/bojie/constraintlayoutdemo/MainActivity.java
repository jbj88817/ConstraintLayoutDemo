package us.bojie.constraintlayoutdemo;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ConstraintSet mConstraintSet1;
    private ConstraintSet mConstraintSet2;
    private ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.root);
        mConstraintSet1 = new ConstraintSet();
        mConstraintSet2 = new ConstraintSet();

        mConstraintSet1.clone(mConstraintLayout);
        mConstraintSet2.clone(mConstraintLayout);
    }

    public void reset(View view) {
        mConstraintSet1.applyTo(mConstraintLayout);
    }

    public void change(View view) {
        mConstraintSet2.setMargin(R.id.button1, ConstraintSet.START, 30);
        mConstraintSet2.applyTo(mConstraintLayout);
    }
}
