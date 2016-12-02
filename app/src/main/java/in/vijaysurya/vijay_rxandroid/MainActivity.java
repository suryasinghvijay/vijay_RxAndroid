package in.vijaysurya.vijay_rxandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  }

  public void buttonClick(View view) {

/*
    _getObservable()
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Boolean>() {
      @Override
      public void onCompleted() {
        Log.e("MainActivity","onCompleted");
      }

      @Override
      public void onError(Throwable e) {
        Log.e("MainActivity","onError");
      }

      @Override
      public void onNext(Boolean aBoolean) {
        Log.e("MainActivity","onNext");
      }
    });*/

    _getObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(_getObserver());




  }

  Observable<Boolean> _getObservable(){
    return Observable.just(true).map(new Func1<Boolean, Boolean>() {
      @Override
      public Boolean call(Boolean aBoolean) {
        Log.e("MainActivity","Call");
        someOperationOnMainThread();
        return aBoolean;
      }
    });
  }

  Observer<Boolean> _getObserver(){
    return new Observer<Boolean>() {
      @Override
      public void onCompleted() {
        Log.e("MainActivity","onCompleted");
      }

      @Override
      public void onError(Throwable e) {
        Log.e("MainActivity","onError");

      }

      @Override
      public void onNext(Boolean aBoolean) {
        Log.e("MainActivity","onNext");

      }
    };
  }

  private void someOperationOnMainThread() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.getMessage();
    }
  }
}
