package com.cnt.coding.kotlin.helloworld.service

import com.cnt.coding.kotlin.helloworld.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    private val bankDataSource: BankDataSource = mockk(relaxed = true)
    private val bankService = BankService(bankDataSource)

    @Test
    fun `Should call its data source to retrieve banks` () {
        //given
       // every { bankDataSource.retrieveBanks() } returns emptyList()

        val banks = bankService.getBanks()

        verify(exactly = 1) { bankDataSource.retrieveBanks() }
    }
}