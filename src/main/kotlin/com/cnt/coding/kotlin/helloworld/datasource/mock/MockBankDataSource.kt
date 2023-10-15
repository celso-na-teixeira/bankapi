package com.cnt.coding.kotlin.helloworld.datasource.mock

import com.cnt.coding.kotlin.helloworld.datasource.BankDataSource
import com.cnt.coding.kotlin.helloworld.model.Bank
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

@Repository
class MockBankDataSource : BankDataSource {

    val banks = mutableListOf(
        Bank("1234", 3.0, 113),
        Bank("4567", 17.0, 11),
        Bank("7890", 1.1, 107)
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists")
        }

        banks.add(bank)

        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull() { it.accountNumber == bank.accountNumber } ?: throw NoSuchElementException("Could not find a bank with account number ${bank.accountNumber}")

        banks.remove(currentBank)
        banks.add(bank)

        return bank
    }

    override fun deleteBank(accountNumber: String) {
        val deletedBank = banks.find { it.accountNumber == accountNumber } ?: throw NoSuchElementException("Could not find a bank with account number ${accountNumber}")

        banks.remove(deletedBank)

    }
}