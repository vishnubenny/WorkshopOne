package com.vishnu.workshopone.myaccount

import com.vishnu.workshopone.home.viewstate.UserViewState
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserDataSourceTest {

    private lateinit var dataSource: UserDataSource

    @Before
    fun setUp() {
        dataSource = UserDataSource()
    }

    @Test
    fun `should return saved value when flow subject calling`() {
        runBlocking {
            dataSource.save(UserViewState("email"))
            val flow = dataSource.flowSubject()
            val result = flow.firstOrNull()
            assertEquals(result, UserViewState("email"))
        }
    }

    @Test
    fun `should return last saved value when flow subject calling`() {
        runBlocking {
            dataSource.save(UserViewState("email"))
            dataSource.save(UserViewState("email2"))
            val result = dataSource.flowSubject().single()
            assertEquals(result, UserViewState("email2"))
        }
    }
}
