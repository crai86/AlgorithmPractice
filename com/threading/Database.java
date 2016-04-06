package com.threading;

import java.util.concurrent.Semaphore;

public class Database implements RWLock {
	private int readerCount;
	private Semaphore mutex;
	private Semaphore db;

	public Database() {
		super();
		readerCount = 0;
		mutex = new Semaphore(1);
		db = new Semaphore(1);
	}

	@Override
	public void acquireReadLock(int readerNum) {
		try {
			// mutual exclusion for readerCount
			mutex.acquire();
		} catch (InterruptedException e) {
		}
		++readerCount;
		// if I am the first reader tell all others
		// that the database is being read
		if (readerCount == 1) {
			try {
				db.acquire();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Reader " + readerNum
				+ " is reading. Reader count = " + readerCount);
		// mutual exclusion for readerCount
		mutex.release();
	}

	@Override
	public void acquireWriteLock(int writerNum) {
		try {
			db.acquire();
		} catch (InterruptedException e) {
		}
		System.out.println("Writer " + writerNum + " is writing.");
	}

	@Override
	public void releaseReadLock(int readerNum) {
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
		}
		--readerCount;
		// if I am the last reader tell all others
		// that the database is no longer being read
		if (readerCount == 0) {
			db.release();
		}
		System.out.println("Reader " + readerNum
				+ " is done reading. Reader count = " + readerCount);

		// mutual exclusion for readerCount
		mutex.release();
	}

	@Override
	public void releaseWriteLock(int writerNum) {
		System.out.println("Writer " + writerNum + " is done writing.");
		db.release();
	}

}
