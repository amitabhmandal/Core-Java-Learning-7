package understanding.executor.framework;
//Scheduling tasks
//we might have to the requirement of 
//1. Scheduling task to be run just once in future OR
//2. multiple times in future

//Threads API provide two API classes to perform the above requirement

// FIRST IMPORTANT CLASS  (Timer)
//java.util.Timer and ->
// spawns a thread for executing all the tasks given to it
// Also contains the scheduling logic for the next run of the tasks
// different methods on this class can be invoked to different kind of scheduling 
// for running tasks
// Some of the important methods
// public void schedule(TimerTask task, long delay)
// public void schedule(TimerTask task, Date time)
// public void schedule(TimerTask task, long delay, long period)
// public void schedule(TimerTask task, Date firstTime, long period)
// public void scheduleAtFixedRate(TimerTask task, long delay, long period)
// public void scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
// public void cancel()
// 
// Second Important Class TimerTask
//java.util.TimerTask -> 
//implements the Runnable Interface
//represents the task
//should be short lived for repeated executions
//
public class SchedulingTaskWithThreads {

    public static void main(String[] args) {

    }

}
