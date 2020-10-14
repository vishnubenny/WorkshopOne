package com.vishnu.workshopone.home.viewstate

import com.vishnu.core.base.BaseViewState
import com.vishnu.core.home.api.ApiUser
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BiUserConverterTest {

    private val apiUser1 = Mockito.mock(ApiUser::class.java)
    private val apiUser2 = Mockito.mock(ApiUser::class.java)

    private lateinit var converter: BiUserConverter

    @Before
    fun setUp() {
        `when`(apiUser2.email).thenReturn("email2")
        converter = BiUserConverter()
    }

    @Test
    fun `should convert 2 apiUser into UserViewState with second user object data`() {
        val expected = BaseViewState.Success(UserViewState("email2"))
        val converted = converter.apply(apiUser1, apiUser2)
        assertEquals(expected, converted)
    }

    @Test
    fun `should return EMPTY UserViewState if email value is null`() {
        `when`(apiUser2.email).thenReturn(null)
        val expected = BaseViewState.Success(UserViewState(""))
        val converted = converter.apply(apiUser1, apiUser2)
        assertEquals(expected, converted)
    }
}
