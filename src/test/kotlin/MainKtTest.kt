import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun taxFee_MasterCard(){
        val cardType = "Mastercard"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 150_000

        val result = ru.netology.taxFee(cardType,
                                        transactionsPerMonth,
                                        transactionsPerDay,
                                        currentTransaction
        )

        assertEquals(470, result)
    }

    @Test
    fun taxFee_Visa(){
        val cardType = "Visa"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 150_000

        val result = ru.netology.taxFee(cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(470, result)

    }