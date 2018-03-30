## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  |  10,000,000        | 0.019987        |
| Using ReentrantLock     |  10,000,000        | 1.756751        |
| Syncronized method      |  10,000,000        | 0.571941        |
| AtomicLong for total    |  10,000,000        | 0.378776        |

## 1. Using unsynchronized counter object
1.1 Yes, The total should be zero however the total is not always the same.

1.2 
Count 1 to 1,000,000 in 0.014595 sec

Count 1 to 1,000,000 in 0.012759 sec
     
Count 1 to 1,000,000 in 0.012528 sec
	
Average = 0.01327733

1.3 The counter total sometimes not zero because the counter sometimes will run two threads at the same time or run in each thread first. This will return to the counter and the total may not be zero.

## 2. Implications for Multi-threaded Applications

How might this affect real applications? 

- the banking application will affect on transference of money. if you deposit and another user withdraw the money at the same time, it will use the same value in the account. In fact, it should run in each activity first.   

## 3. Counter with ReentrantLock


3.1 Yes, the total always zero.

1-1,000,000 average 0.092115 sec

3.2 The results are different from problem 1 because the counter with ReentrantLock will select to lock the thread and total always be zero. 
	
3.3  The counter with ReentrantLock will run one thread first and lock in another thread when the first thread finish, then it will run in another thread.
	
3.4 The code must be run in the finally, so this case always get unlock when finish the thread.
		

## 4. Counter with synchronized method

4.1 Yes, the total always zero.

1 to 1,000,000 average 0.082564 sec

4.2 The results are different from problem 1 because synchronous will lock all the thread and total always be zero.

4.3 "synchronoized" means the method that can not call in the same time. We use it in this program because synchronous will run only one thread and lock other threads, so it will not run the method in the same time.

## 5. Counter with AtomicLong

5.1 Using AtometicLong, the thread will collect the data first. Next, it will calculate the value and then compare the data that we get with the data from the source  whether it is matches or not if it is, then it is ok. If it is not, then calculate in new value. So AtometicLong are not interrupt in other threads.

5.2 AtomicLong will run fast when it is not complicate function.
	 
	

## 6. Analysis of Results

6.1 AtomCounter is the fastest and ReentrantLock is the slowest.

6.2 ReentrantLock because we can select to lock in any threads. For example, if there are many threads to run the program, we just lock only the thread that make affect to the program. So it will help the program run faster.
	

## 7. Using Many Threads (optional)

