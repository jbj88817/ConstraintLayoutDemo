package us.bojie.constraintlayoutdemo;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
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
        TransitionManager.beginDelayedTransition(mConstraintLayout);
        mConstraintSet1.applyTo(mConstraintLayout);
    }

    public void change(View view) {
        TransitionManager.beginDelayedTransition(mConstraintLayout);
//        mConstraintSet2.setMargin(R.id.button1, ConstraintSet.LEFT, 30);
//        mConstraintSet2.setMargin(R.id.button1, ConstraintSet.LEFT, 0);
//        mConstraintSet2.centerHorizontally(R.id.button1, R.id.root);
//        mConstraintSet2.connect(R.id.button1, ConstraintSet.LEFT, R.id.root, ConstraintSet.LEFT, 50);

        mConstraintSet2.clear(R.id.button1);
        mConstraintSet2.clear(R.id.button2);
        mConstraintSet2.clear(R.id.button3);

        mConstraintSet2.connect(R.id.button1, ConstraintSet.LEFT, R.id.root, ConstraintSet.LEFT, 0);
        mConstraintSet2.connect(R.id.button3, ConstraintSet.RIGHT, R.id.root, ConstraintSet.RIGHT, 0);

        mConstraintSet2.connect(R.id.button2, ConstraintSet.LEFT, R.id.button1, ConstraintSet.RIGHT, 0);
        mConstraintSet2.connect(R.id.button2, ConstraintSet.RIGHT, R.id.button3, ConstraintSet.LEFT, 0);

        mConstraintSet2.connect(R.id.button1, ConstraintSet.RIGHT, R.id.button2, ConstraintSet.LEFT, 0);
        mConstraintSet2.connect(R.id.button3, ConstraintSet.LEFT, R.id.button2, ConstraintSet.RIGHT, 0);

        mConstraintSet2.createHorizontalChain(
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                new int[]{R.id.button1, R.id.button2, R.id.button3},
                null,
                ConstraintSet.CHAIN_SPREAD
        );

        mConstraintSet2.constrainHeight(R.id.button1,ConstraintSet.WRAP_CONTENT);
        mConstraintSet2.constrainHeight(R.id.button2,ConstraintSet.WRAP_CONTENT);
        mConstraintSet2.constrainHeight(R.id.button3,ConstraintSet.WRAP_CONTENT);

        mConstraintSet2.constrainWidth(R.id.button1,ConstraintSet.WRAP_CONTENT);
        mConstraintSet2.constrainWidth(R.id.button2,ConstraintSet.WRAP_CONTENT);
        mConstraintSet2.constrainWidth(R.id.button3,ConstraintSet.WRAP_CONTENT);

        mConstraintSet2.applyTo(mConstraintLayout);
    }
}
