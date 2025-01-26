import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun taxFee_MasterCard() {
        val cardType = "Mastercard"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 150_000

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(470, result)
    }

    @Test
    fun taxFee_Visa() {
        val cardType = "Visa"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 150_000

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(1125, result)

    }

    @Test
    fun taxFee_VKPay() {
        val cardType = "VK Pay"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 15_000

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(0, result)

    }

    @Test
    fun taxFee_MasterCardNoFee() {
        val cardType = "Mastercard"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 75_000

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(0, result)
    }

    @Test
    fun taxFee_VKPayCurrentOverflow() {
        val cardType = "VK Pay"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 15_001

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(0, result)

    }

    @Test
    fun taxFee_VKPayMonthOverflow() {
        val cardType = "VK Pay"
        val transactionsPerMonth: Int = 30_000
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 15_000

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(0, result)

    }

    @Test
    fun taxFee_VKPayMonthOverflowOnly() {
        val cardType = "VK Pay"
        val transactionsPerMonth: Int = 40_001
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 0

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(0, result)

    }

    @Test
    fun taxFee_MasterCardMonthOverflowOnly() {
        val cardType = "Mastercard"
        val transactionsPerMonth: Int = 600_001
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 0

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(0, result)
    }

    @Test
    fun taxFee_MasterCardMonthOverflow() {
        val cardType = "Mastercard"
        val transactionsPerMonth: Int = 600_000
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 1

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(0, result)
    }

    @Test
    fun taxFee_MasterCardDayOverflowOnly() {
        val cardType = "Mastercard"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 150_001
        val currentTransaction: Int = 0

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(0, result)
    }

    @Test
    fun taxFee_MasterCardDayOverflow() {
        val cardType = "Mastercard"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 150_000
        val currentTransaction: Int = 1

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(0, result)
    }

    @Test
    fun taxFee_VisaTinyTransaction() {
        val cardType = "Visa"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 4_000

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(35, result)

    }

    @Test
    fun taxFee_Maestro() {
        val cardType = "Maestro"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 150_000

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(470, result)
    }

    @Test
    fun taxFee_MIR() {
        val cardType = "Мир"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 150_000

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(1125, result)
    }

    @Test
    fun taxFee_UnsuportedPaySystem() {
        val cardType = "Swift"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 150_000

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(0, result)
    }

    @Test
    fun taxFee_MasterCardLessThen300() {
        val cardType = "Mastercard"
        val transactionsPerMonth: Int = 0
        val transactionsPerDay: Int = 0
        val currentTransaction: Int = 299

        val result = taxFee(
            cardType,
            transactionsPerMonth,
            transactionsPerDay,
            currentTransaction
        )

        assertEquals(21, result)
    }
}