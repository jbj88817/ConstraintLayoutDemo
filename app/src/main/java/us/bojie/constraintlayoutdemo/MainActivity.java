package us.bojie.constraintlayoutdemo;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ConstraintSet mConstraintSet1;
    private ConstraintSet mConstraintSet2;
    private ConstraintLayout mConstraintLayout;
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.root);
        mConstraintSet1 = new ConstraintSet();
        mConstraintSet2 = new ConstraintSet();

        mConstraintSet1.clone(mConstraintLayout);
        mConstraintSet2.load(this, R.layout.change);
    }

    public void toggle(View view) {
        TransitionManager.beginDelayedTransition(mConstraintLayout);
        flag = !flag;
        if (flag) {
            mConstraintSet2.applyTo(mConstraintLayout);
        } else {
            mConstraintSet1.applyTo(mConstraintLayout);
        }
    }
}
