package gl.grace.lei.Module.Client;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;


public class Animator extends ValueAnimator{
    @SuppressLint("Recycle")
    public Animator OfInt(int... values) {
        setIntValues(values);
        return this;
    }
    @SuppressLint("Recycle")
    public Animator OfFloat(float... values){
        setFloatValues(values);
        return this;
    }

    public Animator Duration(long d){
        setDuration(d);
        return this;
    }
    public Animator RepeatCount(int value){
        setRepeatCount(value);
        return this;
    }
    public Animator Interpolator(TimeInterpolator value){
        setInterpolator(value);
        return this;
    }
    public Animator Evaluator(TypeEvaluator value){
        setEvaluator(value);
        return this;
    }
    public Animator addUpdateListeners(AnimatorUpdateListener add){
        this.addUpdateListener(add);
        return this;
    }
    public Animator Start(){
        this.start();
        return this;
    }
}
