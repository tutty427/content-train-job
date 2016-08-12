package com.content.train.async.title;

/**
 * Created by shawxy on 8/12/16.
 */
public class AsyncJobWorker {

    private Calculator calculator;

    public AsyncJobWorker(Calculator calculator){

        this.calculator = calculator;
    }


    public void doWork(){


      new Thread(new Runnable() {
            public void run() {
                calculator.excute();
            }
        }).start();
    }
}
