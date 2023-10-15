package com.cnt.coding.kotlin.helloworld.service

import com.cnt.coding.kotlin.helloworld.datasource.BankDataSource
import com.cnt.coding.kotlin.helloworld.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService (private val dataSource: BankDataSource) {

    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()

    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)

    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)

    fun updateBank(bank: Bank): Bank = dataSource.updateBank(bank)

    fun delete(accountNumber: String): Unit = dataSource.deleteBank(accountNumber)

}