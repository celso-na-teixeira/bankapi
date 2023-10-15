package com.cnt.coding.kotlin.helloworld.datasource.mock

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest {

    private val mockDataSource = MockBankDataSource()

    @Test
    fun `should provide a collection of banks` () {
        //given

        //when
        val banks = mockDataSource.retrieveBanks()

        //then
        assertThat(banks).isNotEmpty
    }

    @Test
    fun `Should provide some mock data` ()  {
        var banks = mockDataSource.retrieveBanks()

        assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        assertThat(banks).anyMatch { it.trust != 0.0 }
        assertThat(banks).anyMatch { it.transactionFee != 0 }
    }
}