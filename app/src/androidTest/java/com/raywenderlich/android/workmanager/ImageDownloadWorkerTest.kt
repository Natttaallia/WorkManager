package com.raywenderlich.android.workmanager

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.work.testing.TestListenableWorkerBuilder
import com.raywenderlich.android.workmanager.workers.ImageDownloadWorker
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class ImageDownloadWorkerTest {

    // 1
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var workerManagerTestRule = WorkManagerTestRule()

    // 2
    @Test
    fun testDownloadWork() {
        // Create Work Request
        val work = TestListenableWorkerBuilder<ImageDownloadWorker>(workerManagerTestRule.targetContext).build()
        runBlocking {
            val result = work.doWork()
            // Assert
            assertNotNull(result)
        }
    }
}